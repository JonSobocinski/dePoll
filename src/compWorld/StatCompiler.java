package compWorld;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import compView.MainView;

public class StatCompiler {

	private MainView mv;
	private NCAA nc;
	private static final int AACID = 823;
	private static final int ACCID = 821;
	private static final int B12ID = 25354;
	private static final int B10ID = 827;
	private static final int CUSAID = 24312;
	private static final int INDEPENDENTID = 99001;
	private static final int MACID = 875;
	private static final int MWCID = 5486;
	private static final int PACID = 905;
	private static final int SECID = 911;
	private static final int SUNBID = 818;
	private int teamCounter;
	private HashMap<Conference, Integer> conferencePowerRankings;
	private HashMap<String, Integer> statePowerRankings;
	private int lowestPointValueByConference;
	private int lowestPointValueByState;
	private HashMap<String, Integer> numberOfTeamsByState;
	private ArrayList<Team> teamList;

	public StatCompiler(NCAA nc, MainView mv) {
		this.mv = mv;
		this.nc = nc;
		conferencePowerRankings = new HashMap<Conference, Integer>();
		statePowerRankings = new HashMap<String, Integer>();
		teamList = new ArrayList<Team>();

	}

	public void clearReport() {
		mv.clearReport();
	}

	public void reprintList() {
		listPrint();
	}

	public void printOrderedTeamList() {
		compilePoints();
		listPrint();
	}

	private void compilePoints() {
		teamList = new ArrayList<Team>();
		ArrayList<String> al = nc.getNameKeys();
		for (String s : al) {

			Team team = nc.getTeam(s);
			team.clearPointAllocationMap();
			pointsScoredAllowedUpdate(team);
			yardagePointsUpdate(team);
			ArrayList<Game> gameList = team.getGames();
			Collections.sort(gameList);
			team.setStreaks();
			for (Game g : gameList) {
				winsLossUpdate(team, g);
				shutoutBlowoutUpdate(team, g);
			}
			if (!team.isFcs()) {
				teamList.add(team);
				timeOfPossessionAndTurnoverUpdate(team);
				thirdDownAndPenaltyUpdate(team);
			}
			nc.setRankingList(teamList);

		}
		if (mv.isGenerateStats()) {
			mv.appendText("---------------------------------------\n\n");
		}
	}

	private void listPrint() {
		teamCounter = 1;
		Collections.sort(teamList);
		if (mv.isExcludeGroupOf5InTop25()) {
			removeG5(teamList);
		}
		Collections.sort(teamList);
		printTeamReport();
		conferencePowerRankings.clear();
		statePowerRankings.clear();
		lowestPointValueByConference = 0;
		for (Team t : teamList) {

			if (!t.isFcs()) {
				mv.appendText(teamCounter++ + ") " + t.getTeamName() + ": "
				        + t.getTeamStatPoint() + " \n");

				// Doing the state power rankings here. Power5 conference only
				if (t.getConference().isP5()) {
					if (statePowerRankings.containsKey(t.getTeamLocation())) {
						int inc = statePowerRankings.get(t.getTeamLocation());
						inc = inc + t.getRankingPoints();
						statePowerRankings.put(t.getTeamLocation(), inc);
						if (inc < lowestPointValueByState) {
							lowestPointValueByState = inc;
						}

					}
					else
						statePowerRankings.put(t.getTeamLocation(), t.getRankingPoints());
				}

				// Do the Conference Power Rankings Here. No Independents
				if (t.getConference().getConferenceID() != INDEPENDENTID) {
					if (conferencePowerRankings.containsKey(t.getConference())) {
						int inc = conferencePowerRankings.get(t.getConference());
						inc = inc + t.getRankingPoints();
						if (inc < lowestPointValueByConference)
							lowestPointValueByConference = inc;
						conferencePowerRankings.put(t.getConference(), inc);
					}
					else
						conferencePowerRankings.put(t.getConference(), t.getRankingPoints());

				}
			}
		}
	}

	private void shutoutBlowoutUpdate(Team team, Game g) {

		// If you won will check if you shutout or blewout a team
		if (team.equals(g.getGameWinner())) {
			shutoutBlowoutWinner(g);
			sosWin(team, g);
		}
		else {
			shutoutBlowoutLoser(g);
			sosLoss(team, g);
		}
		// If you lost will check if you got shutout or blownout

	}

	private void sosWin(Team team, Game g) {
		int points = getSosMult(g.getGameLooser().getNumberOfWins(), true);
		team.incTeamStatPoint(points);
		hashPointMap(team, "Strength Of Schedule (Win) Bonus", points);

	}

	private void sosLoss(Team team, Game g) {
		int points = getSosMult(g.getGameWinner().getNumberOfWins(), false);
		team.incTeamStatPoint(points);
		hashPointMap(team, "Strength Of Schedule (Loss) Penalty", points);

	}

	private void shutoutBlowoutWinner(Game g) {
		// You won

		Team us = g.getGameWinner();
		Team loser = g.getGameLooser();

		int ourScore = 0;
		int theirScore = 0;

		if (us.equals(g.getHomeTeam())) {
			ourScore = g.getHomeTeamScore();
			theirScore = g.getAwayTeamScore();

		}
		else {
			theirScore = g.getHomeTeamScore();
			ourScore = g.getAwayTeamScore();
		}

		if (theirScore == 0) {
			int points = mv.getMO().getShutoutRe();
			us.incTeamStatPoint(points);
			points = points + getConfMulti(loser.getConference(), true);
			us.incTeamStatPoint(points);
			hashPointMap(us, "Team Shutout (Win) Bonus", points);

		}

		int diff = ourScore - theirScore;
		if (diff >= mv.getMO().getBlowoutReAmmount()) {
			int points = mv.getMO().getBlowoutRe();
			us.incTeamStatPoint(points);
			points = points + getConfMulti(loser.getConference(), true);
			us.incTeamStatPoint(points);
			hashPointMap(us, "Team Blowout (Win) Bonus", points);
		}

	}

	private void shutoutBlowoutLoser(Game g) {

		Team us = g.getGameLooser();
		Team loser = g.getGameWinner();

		int ourScore = 0;
		int theirScore = 0;

		if (us.equals(g.getHomeTeam())) {
			ourScore = g.getHomeTeamScore();
			theirScore = g.getAwayTeamScore();

		}
		else {
			theirScore = g.getHomeTeamScore();
			ourScore = g.getAwayTeamScore();
		}

		if (ourScore == 0) {
			int points = mv.getMO().getShutoutPe();
			us.incTeamStatPoint(points);
			points = points + getConfMulti(loser.getConference(), false);
			us.incTeamStatPoint(points);
			hashPointMap(us, "Team Shutout (Loss) Penalty", points);

		}

		int diff = theirScore - ourScore;
		if (diff >= mv.getMO().getBlowoutPeAmmount()) {
			int points = mv.getMO().getBlowoutPe();
			us.incTeamStatPoint(points);
			points = points + getConfMulti(loser.getConference(), false);
			us.incTeamStatPoint(points);
			hashPointMap(us, "Team Blowout (Loss) Penalty", points);

		}

	}

	private void thirdDownAndPenaltyUpdate(Team team) {

		// First we will do our own third down %

		// We converted more than we need to
		if (team.getThirdDownEff() >= mv.getMO().getThirdDownTh()) {
			double diff = team.getThirdDownEff() - mv.getMO().getThirdDownTh();
			int points = (int) (diff * (mv.getMO().getThirdDownRe()));
			team.incTeamStatPoint(points);
			hashPointMap(team, "Third Down Conversion Efficiency Bonus", points);

		}
		else {// we don't convert enough
			double diff = mv.getMO().getThirdDownTh() - team.getThirdDownEff();
			int points = (int) (diff * mv.getMO().getThirdDownAllowedPe());
			team.incTeamStatPoint(points);
			hashPointMap(team, "Third Down Conversion Efficiency Penalty", points);

		}

		// Next we will do our opponents third down %
		if (team.getThirdDownEffDef() <= mv.getMO().getThirdDownAllowedTh()) {// Our
			// team
			// has
			// good
			// defense
			double diff = mv.getMO().getThirdDownAllowedTh() - team.getThirdDownEffDef();
			int points = (int) (diff * mv.getMO().getThirdDownAllowedRe());
			team.incTeamStatPoint(points);
			hashPointMap(team, "Third Down Conversion Defensive Bonus", points);

		}
		else {// our team has shitty d
			double diff = team.getThirdDownEffDef() - mv.getMO().getThirdDownAllowedTh();
			int points = (int) (diff * mv.getMO().getThirdDownAllowedPe());
			team.incTeamStatPoint(points);

			hashPointMap(team, "Third Down Conversion Defensive Penalty", points);
		}

		// Then we will do the penalties we've forced
		int penForced = team.getNumberOfPenaltiesForced();
		int penYardForced = team.getNumberOfPenaltiesYardsForced();
		int points = penForced * mv.getMO().getPenaltyForcedRe();
		team.incTeamStatPoint(points);
		hashPointMap(team, "Penalities Forced Bonus", points);

		points = penYardForced * mv.getMO().getPenaltyYardageForcedRe();
		team.incTeamStatPoint(points);
		hashPointMap(team, "Penalty Yardage Forced Bonus", points);

		// Then we will do the penalties we've committed
		int pen = team.getNumberOfPenalties();
		points = pen * mv.getMO().getPenaltyAllowedPe();
		team.incTeamStatPoint(points);

		hashPointMap(team, "Penalities Committed Penalty", points);
		int penYard = team.getPenaltyYards();
		points = penYard * mv.getMO().getPenaltyYardageAllowedPe();
		team.incTeamStatPoint(points);

		hashPointMap(team, "Penalty Yardage Committed Penalty", points);

	}

	private void timeOfPossessionAndTurnoverUpdate(Team team) {

		double teamsTOP = team.getTimeOfPoss();
		double oppTOP = team.getTotalOppTimeOfPoss();
		double totalTimePlayed = oppTOP + teamsTOP;

		double teamsPer = (teamsTOP / totalTimePlayed) * 100;
		double oppPer = (oppTOP / totalTimePlayed) * 100;

		double teamsTh = mv.getMO().getTopTh();
		double oppTh = mv.getMO().getOppTOPTh();

		// my top. first is the reward second is the pen
		if (teamsPer >= teamsTh) {
			double diff = teamsPer - teamsTh;
			int pointsToAward = (int) (mv.getMO().getTopRe() * diff);
			team.incTeamStatPoint(pointsToAward);
			hashPointMap(team, "Time Of Possession Bonus", pointsToAward);

		}
		else {
			double diff = teamsTh - teamsPer;
			int pointsToTake = (int) (mv.getMO().getTopPen() * diff);
			team.incTeamStatPoint(pointsToTake);

			hashPointMap(team, "Time Of Possession Penalty", pointsToTake);
		}
		// opp top. first is the reward, second is the pen
		if (oppPer <= oppTh) {
			double diff = oppTh - oppPer;
			int pointsToAward = (int) (mv.getMO().getOppTOPRe() * diff);
			team.incTeamStatPoint(pointsToAward);

			hashPointMap(team, "Opponents Time Of Possession Bonus", pointsToAward);

		}
		else {
			double diff = oppPer - oppTh;
			int pointsToTake = (int) (mv.getMO().getOppTOPPen() * diff);
			team.incTeamStatPoint(pointsToTake);

			hashPointMap(team, "Opponents Time Of Possession Penalty", pointsToTake);

		}

		// TURNOVER WRITTEN HERE
		int takeaways = team.getTakeaways() * mv.getMO().getTakeAwayMult();
		int picks = team.getInterceptionsGotten() * mv.getMO().getPickMult();
		int fumblesRecovered = team.getFumblesRecovered() * mv.getMO().getFumbleRecoveryMult();

		int turnovers = team.getTurnovers() * mv.getMO().getTurnoverPen();
		int interceptions = team.getInterceptionsThrown() * mv.getMO().getInterceptionPen();
		int fumblesLost = team.getFumblesLost() * mv.getMO().getFumbleLostPen();

		team.incTeamStatPoint(takeaways);
		team.incTeamStatPoint(picks);
		team.incTeamStatPoint(fumblesRecovered);

		team.incTeamStatPoint(turnovers);
		team.incTeamStatPoint(interceptions);
		team.incTeamStatPoint(fumblesLost);

		hashPointMap(team, "Takeaways Bonus", takeaways);

		hashPointMap(team, "Picks Bonus", picks);

		hashPointMap(team, "Fumbles Recovered Bonus", fumblesRecovered);

		hashPointMap(team, "Turnovers Penalty", turnovers);

		hashPointMap(team, "Interceptions Penalty", interceptions);

		hashPointMap(team, "Fumbles Lost Penalty", fumblesLost);

	}

	private void removeG5(ArrayList<Team> teamList) {
		Team team = teamList.get(35);
		int lastPlaceTeamPoints = team.getRankingPoints();

		for (Team t : teamList) {
			if (!t.getConference().isP5()) {
				team = t;
				break;
			}
		}
		int firstNonP5TeamPoints = team.getRankingPoints();
		int diff = (firstNonP5TeamPoints - lastPlaceTeamPoints) + 1;

		for (Team t : teamList) {
			if (!t.getConference().isP5()) {
				t.decrementRankingsPoints(diff);
			}
		}

	}

	private void yardagePointsUpdate(Team team) {

		// Total yards gained

		double yardsGained = team.getAverageYardsGained();
		int r = mv.getMO().getYardsGainedRe();
		int t = mv.getMO().getYardsGainedTh();
		int p = mv.getMO().getYardsGainedPen();

		if (yardsGained >= t) {
			double d = (yardsGained - t);
			int inc = (int) (d * r);
			team.incTeamStatPoint(inc);

			hashPointMap(team, "Yards Gained Reward", inc);

		}
		else {
			double d = (t - yardsGained);
			int inc = (int) (d * p);
			team.incTeamStatPoint(inc);

			hashPointMap(team, "Yards Gained Penalty", inc);
		}

		// total yards allowed

		double yardsAllowed = team.getAverageYardsAllowed();
		int re = mv.getMO().getYardsAllowedRe();
		int th = mv.getMO().getYardsAllowedTh();
		int pe = mv.getMO().getYardsAllowedPen();

		if (yardsAllowed <= th) {
			double d = th - yardsAllowed;
			int inc = (int) (d * re);
			team.incTeamStatPoint(inc);

			hashPointMap(team, "Yards Allowed Reward", inc);
		}
		else {
			double d = yardsAllowed - th;
			int inc = (int) (d * pe);
			team.incTeamStatPoint(inc);

			hashPointMap(team, "Yards Allowed Penalty", inc);

		}

		// rushing yards gained

		double rushingYardsGained = team.getAverageRushingYardsGained();
		int rew = mv.getMO().getYardsCarryRe();
		int the = mv.getMO().getYardsCarryTh();
		int pen = mv.getMO().getYardsCarryPen();

		if (rushingYardsGained >= t) {
			double d = (rushingYardsGained - the);
			int inc = (int) (d * rew);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Rushing Yards Gained Reward", inc);

		}
		else {
			double d = (the - rushingYardsGained);
			int inc = (int) (d * pen);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Rushing Yards Gained Penalty", inc);
		}

		// rushing yards allowed
		double rushingYardsAllowed = team.getAverageRushingYardsAllowed();
		int rewa = mv.getMO().getYardsAllowedCarryRe();
		int thre = mv.getMO().getYardsAllowedCarryTh();
		int pena = mv.getMO().getYardsAllowedCarryPen();

		if (rushingYardsAllowed <= thre) {
			double d = thre - rushingYardsAllowed;
			int inc = (int) (d * rewa);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Rushing Yards Allowed Reward", inc);
		}
		else {
			double d = rushingYardsAllowed - thre;
			int inc = (int) (d * pena);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Rushing Yards Allowed Penalty", inc);
		}

		// passing yards gained

		double passingYardsGained = team.getAveragePassingYardsGained();
		rew = mv.getMO().getYardsCatchRe();
		the = mv.getMO().getYardsCatchTh();
		pen = mv.getMO().getYardsCatchPen();

		if (passingYardsGained >= t) {
			double d = (passingYardsGained - the);
			int inc = (int) (d * rew);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Passing Yards Gained Reward", inc);

		}
		else {
			double d = (the - passingYardsGained);
			int inc = (int) (d * pen);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Passing Yards Gained Penalty", inc);
		}

		// passing yards allowed

		double passingYardsAllowed = team.getAveragePassingYardsAllowed();
		rewa = mv.getMO().getYardsAllowedCatchRe();
		thre = mv.getMO().getYardsAllowedCatchTh();
		pena = mv.getMO().getYardsAllowedCatchPen();

		if (passingYardsAllowed <= thre) {
			double d = thre - rushingYardsAllowed;
			int inc = (int) (d * rewa);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Passing Yards Allowed Reward", inc);
		}
		else {
			double d = passingYardsAllowed - thre;
			int inc = (int) (d * pena);
			team.incTeamStatPoint(inc);
			hashPointMap(team, "Passing Yards Allowed Penalty", inc);
		}

		// YPC & YPCA

		team.incTeamStatPoint((int) (team.getAverageYardsPerCarry() * mv.getMO()
		        .getYpCarryReward()));
		hashPointMap(team, "Yards Per Carry Reward",
		        (int) (team.getAverageYardsPerCarry() * mv.getMO().getYpCarryReward()));

		team.incTeamStatPoint((int) team.getAverageYardsPerCatch()
		        * mv.getMO().getYpCatchReward());
		hashPointMap(team, "Yards Per Catch Reward", (int) team.getAverageYardsPerCatch()
		        * mv.getMO().getYpCatchReward());

		team.incTeamStatPoint((int) team.getAverageYardsAllowedPerCarry()
		        * mv.getMO().getYpCarryAllowedPen());
		hashPointMap(team, "Yards Per Carry Allowed Penalty",
		        (int) team.getAverageYardsAllowedPerCarry()
		                * mv.getMO().getYpCarryAllowedPen());
		team.incTeamStatPoint((int) team.getAverageYardsAllowedPerCatch()
		        * mv.getMO().getYpCatchAllowedPen());
		hashPointMap(team, "Yards Per Catch Allowed Penalty",
		        (int) team.getAverageYardsAllowedPerCatch()
		                * mv.getMO().getYpCatchAllowedPen());

	}

	private void pointsScoredAllowedUpdate(Team team) {

		if (team.isFcs()) {
			return;
		}// Checks if points allowed is above or below the threshold here
		if (team.getPointsAllowedPerGame() > mv.getMO().getPointsAllowedThreshold()) {
			// This is when the team has allowed more points than the threshold
			// which is a penalty. I have declared several variables instead of
			// doing this on one line to make the code easier to read. Get over
			// it asshole
			int threshold = mv.getMO().getPointsAllowedThreshold();
			int pa = mv.getMO().getPointsAllowedPen();
			int pat = (int) team.getPointsAllowedPerGame();
			int pd = pat - threshold;
			int pta = pd * pa;
			team.incTeamStatPoint(pta);
			hashPointMap(team, "Points Allowed Penalty", pta);

		}// and here
		else {// Here the team held an opponent to below the threshold and is
			  // being rewarded.
			int threshold = mv.getMO().getPointsAllowedThreshold();
			int pa = mv.getMO().getPointsAllowedMult();
			int pat = (int) team.getPointsAllowedPerGame();
			int pd = threshold - pat;
			int pta = pd * pa;
			team.incTeamStatPoint(pta);
			hashPointMap(team, "Points Allowed Reward", pta);

		}// Checks if points scored is above or below threshold here
		if (team.getPointsScoredPerGame() < mv.getMO().getPointsScoredThreshold()) {
			// This is if a team hasn't scored enough points. This is a penalty
			int threshold = mv.getMO().getPointsScoredThreshold();
			int pa = mv.getMO().getPointsScoredPen();
			int pat = (int) team.getPointsScoredPerGame();
			int pd = threshold - pat;
			int pta = pd * pa;
			team.incTeamStatPoint(pta);
			hashPointMap(team, "Points Scored Penalty", pta);

		}// and here
		else {
			// Here the team has scored enough points and will be rewarded
			int threshold = mv.getMO().getPointsScoredThreshold();
			int pa = mv.getMO().getPointsScoredMult();
			int pat = (int) team.getPointsScoredPerGame();
			int pd = pat - threshold;
			int pta = pd * pa;
			team.incTeamStatPoint(pta);
			hashPointMap(team, "Points Scored Reward", pta);

		}

	}

	private void winsLossUpdate(Team team, Game g) {
		// WE WON
		if (g.getGameWinner().equals(team)) {
			int confMult = getConfMulti(g.getGameLooser().getConference(), true);
			int siteMult;
			String site = "away";
			String siteTwo = "on the road";
			if (g.getHomeTeam().equals(team)) {
				siteMult = mv.getMO().getHomeWinMulti();
				site = "home";
				siteTwo = "at home";

			}
			else
				siteMult = mv.getMO().getAwayWinMulti();
			int totalPoints = mv.getMO().getWinMulti() + confMult + siteMult;
			team.incTeamStatPoint(totalPoints);
			hashPointMap(team, "Games Won Reward", totalPoints);
			if (mv.isGenerateGameByGameStats() && !team.isFcs()) {
				mv.appendText("\t" + team.getTeamName() + " won.\n They beat "
				        + g.getGameLooser().getTeamName() + " a/an "
				        + g.getGameLooser().getConference().getConferenceName()
				        + " team.\n This was a/an " + site + " game for " + team.getTeamName()
				        + ".\n");
				mv.appendText(" So, this team gets " + siteMult + " for winning " + siteTwo
				        + "." + "\n Plus " + confMult + " for beating this conference\n Plus "
				        + mv.getMO().getWinMulti() + " for winning.\n This totals to "
				        + totalPoints + " points\n\n\n");
			}
		}
		// WE LOST
		else {
			int confMult = getConfMulti(g.getGameWinner().getConference(), false);
			int siteMult;
			String site = "away";
			String siteTwo = "on the road";
			if (g.getHomeTeam().equals(team)) {
				siteMult = mv.getMO().getHomeLossMulti();
				site = "home";
				siteTwo = "at home";
			}
			else
				siteMult = mv.getMO().getAwayLossMulti();
			int totalPoints = mv.getMO().getLossMulti() + confMult + siteMult;
			team.incTeamStatPoint(totalPoints);
			hashPointMap(team, "Games Lost Penalty", totalPoints);
			if (mv.isGenerateGameByGameStats() && !team.isFcs()) {
				mv.appendText("\t" + team.getTeamName() + " lost.\n They lost to "
				        + g.getGameWinner().getTeamName() + " a/an "
				        + g.getGameLooser().getConference().getConferenceName()
				        + " team.\n This was a " + site + " game.\n");
				mv.appendText(" So, this team gets " + siteMult + " for loosing " + siteTwo
				        + "." + "\n Plus " + confMult
				        + " for loosing to this conference. \n Plus "
				        + mv.getMO().getLossMulti() + " for loosing.\n This totals to "
				        + totalPoints + " points\n\n\n");
			}
		}
	}

	private int getSosMult(int win, boolean winner) {

		if (win == 0) {
			if (winner)
				return mv.getMO().getWin0();
			else
				return mv.getMO().getLoss0();

		}
		if (win == 1) {
			if (winner)
				return mv.getMO().getWin1();
			else
				return mv.getMO().getLoss1();

		}
		if (win == 2) {
			if (winner)
				return mv.getMO().getWin2();
			else
				return mv.getMO().getLoss2();

		}
		if (win == 3) {
			if (winner)
				return mv.getMO().getWin3();
			else
				return mv.getMO().getLoss3();

		}
		if (win == 4) {
			if (winner)
				return mv.getMO().getWin4();
			else
				return mv.getMO().getLoss4();

		}
		if (win == 5) {
			if (winner)
				return mv.getMO().getWin5();
			else
				return mv.getMO().getLoss5();

		}
		if (win == 6) {
			if (winner)
				return mv.getMO().getWin6();
			else
				return mv.getMO().getLoss6();

		}
		if (win == 7) {
			if (winner)
				return mv.getMO().getWin7();
			else
				return mv.getMO().getLoss7();

		}
		if (win == 8) {
			if (winner)
				return mv.getMO().getWin8();
			else
				return mv.getMO().getLoss8();

		}
		if (win == 9) {
			if (winner)
				return mv.getMO().getWin9();
			else
				return mv.getMO().getLoss9();

		}
		if (win == 10) {
			if (winner)
				return mv.getMO().getWin10();
			else
				return mv.getMO().getLoss10();

		}
		if (win == 11) {
			if (winner)
				return mv.getMO().getWin11();
			else
				return mv.getMO().getLoss11();

		}
		if (win == 12) {
			if (winner)
				return mv.getMO().getWin12();
			else
				return mv.getMO().getLoss12();

		}
		if (win == 13) {
			if (winner)
				return mv.getMO().getWin13();
			else
				return mv.getMO().getLoss13();

		}
		else {
			System.exit(-1);
			return 0;
		}

	}

	private int getConfMulti(Conference conf, boolean win) {
		if (win) {
			if (conf.isFcs()) {
				return mv.getMO().getFcsMultiWin();
			}
			else if (conf.getConferenceID() == AACID) {
				return mv.getMO().getAacMultiWin();
			}
			else if (conf.getConferenceID() == ACCID) {
				return mv.getMO().getAccMultiWin();
			}
			else if (conf.getConferenceID() == B12ID) {
				return mv.getMO().getB12MultiWin();
			}
			else if (conf.getConferenceID() == B10ID) {
				return mv.getMO().getB10MultiWin();
			}
			else if (conf.getConferenceID() == CUSAID) {
				return mv.getMO().getCusaMultiWin();
			}
			else if (conf.getConferenceID() == INDEPENDENTID) {
				return mv.getMO().getIndMultiWin();
			}
			else if (conf.getConferenceID() == MACID) {
				return mv.getMO().getMacMultiWin();
			}
			else if (conf.getConferenceID() == PACID) {
				return mv.getMO().getPacMultiWin();
			}
			else if (conf.getConferenceID() == SECID) {
				return mv.getMO().getSecMultiWin();
			}
			else if (conf.getConferenceID() == MWCID) {
				return mv.getMO().getMwcMultiWin();
			}
			else if (conf.getConferenceID() == SUNBID) {
				return mv.getMO().getSunBeltMultWin();
			}
			else {
				System.out.println("CONF NOT FOUND!");
				System.exit(-1);
				return 0;
			}
		}
		else {
			if (conf.isFcs()) {
				return mv.getMO().getFcsMultiLoss();
			}
			else if (conf.getConferenceID() == AACID) {
				return mv.getMO().getAacMultiLoss();
			}
			else if (conf.getConferenceID() == ACCID) {
				return mv.getMO().getAccMultiLoss();
			}
			else if (conf.getConferenceID() == B12ID) {
				return mv.getMO().getB12MultiLoss();
			}
			else if (conf.getConferenceID() == B10ID) {
				return mv.getMO().getB10MultiLoss();
			}
			else if (conf.getConferenceID() == CUSAID) {
				return mv.getMO().getCusaMultiLoss();
			}
			else if (conf.getConferenceID() == INDEPENDENTID) {
				return mv.getMO().getIndMultiLoss();
			}
			else if (conf.getConferenceID() == MACID) {
				return mv.getMO().getMacMultiLoss();
			}
			else if (conf.getConferenceID() == PACID) {
				return mv.getMO().getPacMultiLoss();
			}
			else if (conf.getConferenceID() == SECID) {
				return mv.getMO().getSecMultiLoss();
			}
			else if (conf.getConferenceID() == MWCID) {
				return mv.getMO().getMwcMultiLoss();
			}
			else if (conf.getConferenceID() == SUNBID) {
				return mv.getMO().getSunBeltMultLoss();
			}
			else {
				System.out.println("CONF NOT FOUND!");
				System.exit(-1);
				return 0;
			}
		}
	}

	public void printTeamReport() {

		if (mv.isGenerateStats()) {
			DecimalFormat df = new DecimalFormat("###########.##");
			HashMap<Integer, Conference> cl = nc.getConferenceHolder();
			Set<Integer> set = cl.keySet();

			for (Integer i : set) {
				Conference c = cl.get(i);
				if (!c.isFcs()) {
					mv.appendText("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\t\t");
					mv.appendText(c.getConferenceName()
					        + ": \n\t\t      "
					        + c.getTeamList().size()
					        + " members\n++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
					for (Team t : c.getTeamList()) {
						mv.appendText(" " + t.getTeamName() + ":");
						mv.appendText("\n\tRecord: " + t.getNumberOfWins() + "-"
						        + t.getNumberOfLosses());
						mv.appendText("\n\tTotal Points Scored: " + t.getTotalPointsScored());
						mv.appendText("\n\tPoints Scored Per Game: "
						        + df.format(t.getPointsScoredPerGame()));
						mv.appendText("\n\tTotal Points Allowed: " + t.getTotalPointsAllowed());
						mv.appendText("\n\tPoints Allowed Per Game: "
						        + df.format(t.getPointsAllowedPerGame()));
						mv.appendText("\n\tTotal Yards Gained: " + t.getTotalYardsGained());
						mv.appendText("\n\t\tRushing Yards Gained: "
						        + t.getRusingYardsGained());
						mv.appendText("\n\t\tPassing Yards Gained: "
						        + t.getPassingYardsGained());
						mv.appendText("\n\tTotal Yards Allowed: " + t.getTotalYardsAllowed());
						mv.appendText("\n\t\tRushing Yards Allowed: "
						        + t.getRushingYardsAllowed());
						mv.appendText("\n\t\tPasing Yards Allowed: "
						        + t.getPassingYardsAllowed());
						mv.appendText("\n\tTime Of Possession: " + t.getTimeOfPoss() / 60
						        + " minutes");
						mv.appendText("\n\tOpponents Time Of Possession: "
						        + t.getTotalOppTimeOfPoss() / 60 + " minutes");
						mv.appendText("\n\tStreak: " + t.getCurrentStreak());
						// mv.appendText("\t");
						// mv.appendText("\t");
						// mv.appendText("\t");
						// mv.appendText("\t");
						mv.appendText("\n-------------------------------------------------------------------------\n\n");

					}
				}
			}
			mv.appendText("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}

	}

	/**
	 * @return the conferencePowerRankings
	 */
	public HashMap<Conference, Integer> getConferencePowerRankings() {
		return conferencePowerRankings;
	}

	/**
	 * @return the statePowerRankings
	 */
	public HashMap<String, Integer> getStatePowerRankings() {

		return statePowerRankings;
	}

	/**
	 * @return the lowestPointValue
	 */
	public int getLowestPointValueByConference() {
		return lowestPointValueByConference;
	}

	public int getLowestPointValueByState() {
		return lowestPointValueByState;
	}

	/**
	 * @return the numberOfTeamsByState
	 */
	public HashMap<String, Integer> getNumberOfTeamsByState() {
		return numberOfTeamsByState;
	}

	/**
	 * @param numberOfTeamsByState
	 *            the numberOfTeamsByState to set
	 */
	public void setNumberOfTeamsByState(HashMap<String, Integer> numberOfTeamsByState) {
		this.numberOfTeamsByState = numberOfTeamsByState;
	}

	/**
	 * @return the teamList
	 */
	public ArrayList<Team> getTeamList() {
		return teamList;
	}

	private void hashPointMap(Team team, String reason, int points) {

		if (team.getTeamPointAllocationMap().containsKey(reason)) {
			int add = team.getTeamPointAllocationMap().get(reason);
			add = add + points;
			team.getTeamPointAllocationMap().put(reason, add);
		}
		else {
			team.getTeamPointAllocationMap().put(reason, points);
		}
	}

}

package compWorld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Team implements Comparable<Team> {

	private Conference conference;

	private ArrayList<Game> games;
	private ArrayList<Game> losses;
	private ArrayList<Game> wins;
	private HashMap<String, Integer> teamPointAllocation;

	private int numberOfAwayLosses;
	private int numberOfAwayWins;
	private int numberOfHomeLosses;
	private int numberOfHomeWins;
	private int numberOfLosses;
	private int numberOfWins;
	private int gamesPlayed;

	private int firstDowns;
	private int fourthDownAttempts;
	private int fourthDownConversions;
	private int thirdDownAttempts;
	private int thirdDownConversions;
	private double thirdDownEff;
	private double fourthDownEff;

	private int firstDownsAllowed;
	private int fourthDownAttemptsFaced;
	private int fourthDownConvAllowed;
	private int thirdDownAttemptsFaced;
	private int thirdDownConvAllowed;
	private double thirdDownEffDef;
	private double fourthDownEffDef;

	private int fumblesLost;
	private int fumblesRecovered;
	private int interceptionsGotten;
	private int interceptionsThrown;
	private int turnovers;
	private int takeaways;

	private int numberOfPenalties;
	private int numberOfPenaltiesForced;
	private int numberOfPenaltiesYardsForced;
	private int penaltyYards;

	private int passingAttempts;
	private int rushingAttempts;
	private int rushingYardsGained;
	private int passingYardsGained;
	private int passingCompletions;

	private int passingAttemptsFaced;
	private int rushingAttemptsFaced;
	private int rushingYardsAllowed;
	private int passingYardsAllowed;
	private int passingCompletionsAllowed;

	private String teamLocation;
	private String teamName;

	private int timeOfPoss;
	private int totalGameMinsPlayed;
	private int totalOppTimeOfPoss;

	private int totalPointsAllowed;
	private int totalPointsScored;
	private double pointsAllowedPerGame;
	private double pointsScoredPerGame;

	private int totalYardsAllowed;
	private int totalYardsGained;

	private int teamCode;
	private int teamStatPoint;
	private boolean fcs;

	private double averageYardsAllowed;
	private double averageYardsGained;
	private double averageRushingYardsAllowed;
	private double averageRushingYardsGained;
	private double averagePassingYardsAllowed;
	private double averagePassingYardsGained;
	private double averageYardsPerCarry;
	private double averageYardsAllowedPerCarry;
	private double averageYardsPerCatch;
	private double averageYardsAllowedPerCatch;

	private int currentStreak;

	private static int numberOfFBSTeams;

	/**
	 * @return the fcs
	 */
	public boolean isFcs() {
		return fcs;
	}

	// Construct
	public Team(String teamName, Conference teamConference, int teamCode, boolean fcs,
	        String location) {

		super();
		this.fcs = fcs;
		this.teamName = teamName;
		this.conference = teamConference;
		this.teamCode = teamCode;
		games = new ArrayList<Game>();
		losses = new ArrayList<Game>();
		wins = new ArrayList<Game>();
		teamPointAllocation = new HashMap<String, Integer>();
		teamLocation = location;
		if (!fcs)
			numberOfFBSTeams++;

	}

	public void addGameStats(Game game, String[] gameStat, boolean winningTeam) {

		gamesPlayed++;

		if (winningTeam) {
			wins.add(game);
			numberOfWins++;

		}
		else {
			losses.add(game);
			numberOfLosses++;

		}

		games.add(game);

		if (game.getAwayTeam() == this) {

			if (winningTeam) {
				numberOfAwayWins++;
			}
			else {
				numberOfAwayLosses++;
			}

			rushingYardsGained += Integer.valueOf(gameStat[2].trim());
			rushingAttempts += Integer.valueOf(gameStat[3].trim());
			passingYardsGained += Integer.valueOf(gameStat[4].trim());
			passingAttempts += Integer.valueOf(gameStat[5].trim());
			passingCompletions += Integer.valueOf(gameStat[6].trim());
			numberOfPenalties += Integer.valueOf(gameStat[7].trim());
			penaltyYards += Integer.valueOf(gameStat[8].trim());
			fumblesLost += Integer.valueOf(gameStat[9].trim());
			interceptionsThrown += Integer.valueOf(gameStat[10].trim());
			firstDowns += Integer.valueOf(gameStat[11].trim());
			thirdDownAttempts += Integer.valueOf(gameStat[12].trim());
			thirdDownConversions += Integer.valueOf(gameStat[13].trim());
			fourthDownAttempts += Integer.valueOf(gameStat[14].trim());
			fourthDownConversions += Integer.valueOf(gameStat[15].trim());
			timeOfPoss += Integer.valueOf(gameStat[16].trim());
			totalPointsScored += Integer.valueOf(gameStat[17].trim());

			rushingYardsAllowed += Integer.valueOf(gameStat[19].trim());
			rushingAttemptsFaced += Integer.valueOf(gameStat[20].trim());
			passingYardsAllowed += Integer.valueOf(gameStat[21].trim());
			passingAttemptsFaced += Integer.valueOf(gameStat[22].trim());
			passingCompletionsAllowed += Integer.valueOf(gameStat[23].trim());
			numberOfPenaltiesForced += Integer.valueOf(gameStat[24].trim());
			numberOfPenaltiesYardsForced += Integer.valueOf(gameStat[25].trim());
			fumblesRecovered += Integer.valueOf(gameStat[26].trim());
			interceptionsGotten += Integer.valueOf(gameStat[27].trim());
			firstDownsAllowed += Integer.valueOf(gameStat[28].trim());
			thirdDownAttemptsFaced += Integer.valueOf(gameStat[29].trim());
			thirdDownConvAllowed += Integer.valueOf(gameStat[30].trim());
			fourthDownAttemptsFaced += Integer.valueOf(gameStat[31].trim());
			fourthDownConvAllowed += Integer.valueOf(gameStat[32].trim());
			totalOppTimeOfPoss += Integer.valueOf(gameStat[33].trim());
			totalPointsAllowed += Integer.valueOf(gameStat[34].trim());
		}
		else {

			if (winningTeam) {
				numberOfHomeWins++;
			}
			else {
				numberOfHomeLosses++;
			}

			rushingYardsGained += Integer.valueOf(gameStat[19].trim());
			rushingAttempts += Integer.valueOf(gameStat[20].trim());
			passingYardsGained += Integer.valueOf(gameStat[21].trim());
			passingAttempts += Integer.valueOf(gameStat[22].trim());
			passingCompletions += Integer.valueOf(gameStat[23].trim());
			numberOfPenalties += Integer.valueOf(gameStat[24].trim());
			penaltyYards += Integer.valueOf(gameStat[25].trim());
			fumblesLost += Integer.valueOf(gameStat[26].trim());
			interceptionsThrown += Integer.valueOf(gameStat[27].trim());
			firstDowns += Integer.valueOf(gameStat[28].trim());
			thirdDownAttempts += Integer.valueOf(gameStat[29].trim());
			thirdDownConversions += Integer.valueOf(gameStat[30].trim());
			fourthDownAttempts += Integer.valueOf(gameStat[31].trim());
			fourthDownConversions += Integer.valueOf(gameStat[32].trim());
			timeOfPoss += Integer.valueOf(gameStat[33].trim());
			totalPointsScored += Integer.valueOf(gameStat[34].trim());

			rushingYardsAllowed += Integer.valueOf(gameStat[2].trim());
			rushingAttemptsFaced += Integer.valueOf(gameStat[3].trim());
			passingYardsAllowed += Integer.valueOf(gameStat[4].trim());
			passingAttemptsFaced += Integer.valueOf(gameStat[5].trim());
			passingCompletionsAllowed += Integer.valueOf(gameStat[6].trim());
			numberOfPenaltiesForced += Integer.valueOf(gameStat[7].trim());
			numberOfPenaltiesYardsForced += Integer.valueOf(gameStat[8].trim());
			fumblesRecovered += Integer.valueOf(gameStat[9].trim());
			interceptionsGotten += Integer.valueOf(gameStat[10].trim());
			firstDownsAllowed += Integer.valueOf(gameStat[11].trim());
			thirdDownAttemptsFaced += Integer.valueOf(gameStat[12].trim());
			thirdDownConvAllowed += Integer.valueOf(gameStat[13].trim());
			fourthDownAttemptsFaced += Integer.valueOf(gameStat[14].trim());
			fourthDownConvAllowed += Integer.valueOf(gameStat[15].trim());
			totalOppTimeOfPoss += Integer.valueOf(gameStat[16].trim());
			totalPointsAllowed += Integer.valueOf(gameStat[17].trim());

		}

		updateStats();

	}

	private void updateStats() {
		thirdDownEff = (double) thirdDownConversions / (double) thirdDownAttempts;
		thirdDownEff = thirdDownEff * 100;

		fourthDownEff = (double) fourthDownConversions / (double) fourthDownAttempts;
		fourthDownEff = fourthDownEff * 100;

		turnovers = fumblesLost + interceptionsThrown;
		takeaways = fumblesRecovered + interceptionsGotten;

		thirdDownEffDef = (double) thirdDownConvAllowed / (double) thirdDownAttemptsFaced;
		thirdDownEffDef = thirdDownEffDef * 100;
		fourthDownEffDef = (double) fourthDownConvAllowed / (double) fourthDownAttemptsFaced;
		fourthDownEffDef = fourthDownEffDef * 100;

		totalGameMinsPlayed = totalOppTimeOfPoss + timeOfPoss;
		totalYardsAllowed = rushingYardsAllowed + passingYardsAllowed;
		totalYardsGained = rushingYardsGained + passingYardsGained;

		pointsAllowedPerGame = (double) totalPointsAllowed / gamesPlayed;
		pointsScoredPerGame = (double) totalPointsScored / gamesPlayed;

		averageYardsAllowed = (double) totalYardsAllowed / gamesPlayed;
		averageYardsGained = (double) totalYardsGained / gamesPlayed;
		averageRushingYardsAllowed = (double) rushingYardsAllowed / gamesPlayed;
		averageRushingYardsGained = (double) rushingYardsGained / gamesPlayed;
		averagePassingYardsAllowed = (double) passingYardsAllowed / gamesPlayed;
		averagePassingYardsGained = (double) passingYardsGained / gamesPlayed;
		averageYardsPerCarry = (double) rushingYardsGained / rushingAttempts;
		averageYardsAllowedPerCarry = (double) rushingYardsAllowed / passingAttemptsFaced;
		averageYardsPerCatch = (double) passingYardsGained / passingAttempts;
		averageYardsAllowedPerCatch = (double) passingYardsAllowed / passingAttemptsFaced;

	}

	// Getters

	/**
	 * @return the conference
	 */
	public Conference getConference() {
		return conference;
	}

	/**
	 * @return the firstDowns
	 */
	public int getFirstDowns() {
		return firstDowns;
	}

	/**
	 * @return the fourthDownAttempts
	 */
	public int getFourthDownAttempts() {
		return fourthDownAttempts;
	}

	/**
	 * @return the fourthDownConversions
	 */
	public int getFourthDownConversions() {
		return fourthDownConversions;
	}

	/**
	 * @return the fumblesLost
	 */
	public int getFumblesLost() {
		return fumblesLost;
	}

	/**
	 * @return the fumblesRecovered
	 */
	public int getFumblesRecovered() {
		return fumblesRecovered;
	}

	/**
	 * @return the gamesPlayed
	 */
	public int getGamesPlayed() {
		return gamesPlayed;
	}

	/**
	 * @return the interceptionsGotten
	 */
	public int getInterceptionsGotten() {
		return interceptionsGotten;
	}

	/**
	 * @return the interceptionsThrown
	 */
	public int getInterceptionsThrown() {
		return interceptionsThrown;
	}

	/**
	 * @return the losses
	 */
	public ArrayList<Game> getLosses() {
		return losses;
	}

	/**
	 * @return the numberOfAwayLosses
	 */
	public int getNumberOfAwayLosses() {
		return numberOfAwayLosses;
	}

	/**
	 * @return the numberOfAwayWins
	 */
	public int getNumberOfAwayWins() {
		return numberOfAwayWins;
	}

	/**
	 * @return the numberOfHomeLosses
	 */
	public int getNumberOfHomeLosses() {
		return numberOfHomeLosses;
	}

	/**
	 * @return the numberOfHomeWins
	 */
	public int getNumberOfHomeWins() {
		return numberOfHomeWins;
	}

	/**
	 * @return the numberOfLosses
	 */
	public int getNumberOfLosses() {
		return numberOfLosses;
	}

	/**
	 * @return the numberOfPenalties
	 */
	public int getNumberOfPenalties() {
		return numberOfPenalties;
	}

	/**
	 * @return the numberOfPenaltiesForced
	 */
	public int getNumberOfPenaltiesForced() {
		return numberOfPenaltiesForced;
	}

	/**
	 * @return the numberOfPenaltiesYardsForced
	 */
	public int getNumberOfPenaltiesYardsForced() {
		return numberOfPenaltiesYardsForced;
	}

	/**
	 * @return the numberOfWins
	 */
	public int getNumberOfWins() {
		return numberOfWins;
	}

	/**
	 * @return the passingAttempts
	 */
	public int getPassingAttempts() {
		return passingAttempts;
	}

	/**
	 * @return the passingAttemptsFaced
	 */
	public int getPassingAttemptsFaced() {
		return passingAttemptsFaced;
	}

	/**
	 * @return the passingYardsAllowed
	 */
	public int getPassingYardsAllowed() {
		return passingYardsAllowed;
	}

	/**
	 * @return the passingYardsGained
	 */
	public int getPassingYardsGained() {
		return passingYardsGained;
	}

	/**
	 * @return the penaltyYards
	 */
	public int getPenaltyYards() {
		return penaltyYards;
	}

	/**
	 * @return the rushingAttempts
	 */
	public int getRushingAttempts() {
		return rushingAttempts;
	}

	/**
	 * @return the rushingAttemptsFaced
	 */
	public int getRushingAttemptsFaced() {
		return rushingAttemptsFaced;
	}

	/**
	 * @return the rushingYardsAllowed
	 */
	public int getRushingYardsAllowed() {
		return rushingYardsAllowed;
	}

	/**
	 * @return the rusingYardsGained
	 */
	public int getRusingYardsGained() {
		return rushingYardsGained;
	}

	/**
	 * @return the takeaways
	 */
	public int getTakeaways() {
		return takeaways;
	}

	/**
	 * @return the teamLocation
	 */
	public String getTeamLocation() {
		return teamLocation;
	}

	/**
	 * @return the teamName
	 */
	public String getTeamName() {
		return teamName;
	}

	/**
	 * @return the thirdDownAttempts
	 */
	public int getThirdDownAttempts() {
		return thirdDownAttempts;
	}

	/**
	 * @return the thirdDownConversions
	 */
	public int getThirdDownConversions() {
		return thirdDownConversions;
	}

	/**
	 * @return the thirdDownEff
	 */
	public double getThirdDownEff() {
		return thirdDownEff;
	}

	/**
	 * @return the timeOfPoss
	 */
	public int getTimeOfPoss() {
		return timeOfPoss;
	}

	/**
	 * @return the totalGameMinsPlayed
	 */
	public int getTotalGameMinsPlayed() {
		return totalGameMinsPlayed;
	}

	/**
	 * @return the totalOppTimeOfPoss
	 */
	public int getTotalOppTimeOfPoss() {
		return totalOppTimeOfPoss;
	}

	/**
	 * @return the totalPointsAllowed
	 */
	public int getTotalPointsAllowed() {
		return totalPointsAllowed;
	}

	/**
	 * @return the totalPointsScored
	 */
	public int getTotalPointsScored() {
		return totalPointsScored;
	}

	/**
	 * @return the totalYardsAllowed
	 */
	public int getTotalYardsAllowed() {
		return totalYardsAllowed;
	}

	/**
	 * @return the totalYardsGained
	 */
	public int getTotalYardsGained() {
		return totalYardsGained;
	}

	/**
	 * @return the turnovers
	 */
	public int getTurnovers() {
		return turnovers;
	}

	/**
	 * @return the wins
	 */
	public ArrayList<Game> getWins() {
		return wins;
	}

	public int getTeamCode() {
		return teamCode;
	}

	/**
	 * @return the games
	 */
	public ArrayList<Game> getGames() {
		return games;
	}

	/**
	 * @return the fourthDownEff
	 */
	public double getFourthDownEff() {
		return fourthDownEff;
	}

	/**
	 * @return the passingCompletions
	 */
	public int getPassingCompletions() {
		return passingCompletions;
	}

	/**
	 * @return the passingCompletionsAllowed
	 */
	public int getPassingCompletionsAllowed() {
		return passingCompletionsAllowed;
	}

	/**
	 * @return the firstDownsAllowed
	 */
	public int getFirstDownsAllowed() {
		return firstDownsAllowed;
	}

	/**
	 * @return the fourthDownAttemptsFaced
	 */
	public int getFourthDownAttemptsFaced() {
		return fourthDownAttemptsFaced;
	}

	/**
	 * @return the fourthDownConvAllowed
	 */
	public int getFourthDownConvAllowed() {
		return fourthDownConvAllowed;
	}

	/**
	 * @return the thirdDownAttemptsFaced
	 */
	public int getThirdDownAttemptsFaced() {
		return thirdDownAttemptsFaced;
	}

	/**
	 * @return the thirdDownConvAllowed
	 */
	public int getThirdDownConvAllowed() {
		return thirdDownConvAllowed;
	}

	/**
	 * @return the thirdDownEffDef
	 */
	public double getThirdDownEffDef() {
		return thirdDownEffDef;
	}

	/**
	 * @return the fourthDownEffDef
	 */
	public double getFourthDownEffDef() {
		return fourthDownEffDef;
	}

	public int getTeamStatPoint() {
		return teamStatPoint;
	}

	public void incTeamStatPoint(int inc) {
		teamStatPoint += inc;
	}

	public void resetPoints() {
		teamStatPoint = 0;
	}

	/**
	 * @return the pointsAllowedPerGame
	 */
	public double getPointsAllowedPerGame() {
		return pointsAllowedPerGame;
	}

	/**
	 * @return the currentSteak
	 */
	public int getCurrentStreak() {
		return currentStreak;
	}

	/**
	 * @param currentStreak
	 *            the currentStreak to set
	 */
	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
	}

	/**
	 * @return the pointsScoredPerGame
	 */
	public double getPointsScoredPerGame() {
		return pointsScoredPerGame;
	}

	@Override
	public int compareTo(Team o) {

		if (this.getTeamStatPoint() > ((Team) o).getTeamStatPoint()) {
			return -1;
		}
		else if (this.getTeamStatPoint() < ((Team) o).getTeamStatPoint()) {
			return 1;
		}
		else
			return 0;

	}

	public void setStreaks() {

		for (int i = games.size() - 1; i >= 0; i--) {
			if (games.get(i).getGameWinner().equals(this)) {
				if (currentStreak >= 0) {
					currentStreak++;
				}
				else
					break;
			}
			else if (currentStreak <= 0) {
				currentStreak--;
			}
			else
				break;
		}
	}

	/**
	 * @return the averageYardsAllowed
	 */
	public double getAverageYardsAllowed() {
		return averageYardsAllowed;
	}

	/**
	 * @param averageYardsAllowed
	 *            the averageYardsAllowed to set
	 */
	public void setAverageYardsAllowed(double averageYardsAllowed) {
		this.averageYardsAllowed = averageYardsAllowed;
	}

	/**
	 * @return the averageYardsGained
	 */
	public double getAverageYardsGained() {
		return averageYardsGained;
	}

	/**
	 * @param averageYardsGained
	 *            the averageYardsGained to set
	 */
	public void setAverageYardsGained(double averageYardsGained) {
		this.averageYardsGained = averageYardsGained;
	}

	/**
	 * @return the averageRushingYardsAllowed
	 */
	public double getAverageRushingYardsAllowed() {
		return averageRushingYardsAllowed;
	}

	/**
	 * @param averageRushingYardsAllowed
	 *            the averageRushingYardsAllowed to set
	 */
	public void setAverageRushingYardsAllowed(double averageRushingYardsAllowed) {
		this.averageRushingYardsAllowed = averageRushingYardsAllowed;
	}

	/**
	 * @return the averageRushingYardsGained
	 */
	public double getAverageRushingYardsGained() {
		return averageRushingYardsGained;
	}

	/**
	 * @param averageRushingYardsGained
	 *            the averageRushingYardsGained to set
	 */
	public void setAverageRushingYardsGained(double averageRushingYardsGained) {
		this.averageRushingYardsGained = averageRushingYardsGained;
	}

	/**
	 * @return the averagePassingYardsAllowed
	 */
	public double getAveragePassingYardsAllowed() {
		return averagePassingYardsAllowed;
	}

	/**
	 * @param averagePassingYardsAllowed
	 *            the averagePassingYardsAllowed to set
	 */
	public void setAveragePassingYardsAllowed(double averagePassingYardsAllowed) {
		this.averagePassingYardsAllowed = averagePassingYardsAllowed;
	}

	/**
	 * @return the averagePassingYardsGained
	 */
	public double getAveragePassingYardsGained() {
		return averagePassingYardsGained;
	}

	/**
	 * @param averagePassingYardsGained
	 *            the averagePassingYardsGained to set
	 */
	public void setAveragePassingYardsGained(double averagePassingYardsGained) {
		this.averagePassingYardsGained = averagePassingYardsGained;
	}

	/**
	 * @return the averageYardsPerCarry
	 */
	public double getAverageYardsPerCarry() {
		return averageYardsPerCarry;
	}

	/**
	 * @param averageYardsPerCarry
	 *            the averageYardsPerCarry to set
	 */
	public void setAverageYardsPerCarry(double averageYardsPerCarry) {
		this.averageYardsPerCarry = averageYardsPerCarry;
	}

	/**
	 * @return the averageYardsAllowedPerCarry
	 */
	public double getAverageYardsAllowedPerCarry() {
		return averageYardsAllowedPerCarry;
	}

	/**
	 * @param averageYardsAllowedPerCarry
	 *            the averageYardsAllowedPerCarry to set
	 */
	public void setAverageYardsAllowedPerCarry(double averageYardsAllowedPerCarry) {
		this.averageYardsAllowedPerCarry = averageYardsAllowedPerCarry;
	}

	/**
	 * @return the averageYardsPerCatch
	 */
	public double getAverageYardsPerCatch() {
		return averageYardsPerCatch;
	}

	/**
	 * @param averageYardsPerCatch
	 *            the averageYardsPerCatch to set
	 */
	public void setAverageYardsPerCatch(double averageYardsPerCatch) {
		this.averageYardsPerCatch = averageYardsPerCatch;
	}

	/**
	 * @return the averageYardsAllowedPerCatch
	 */
	public double getAverageYardsAllowedPerCatch() {
		return averageYardsAllowedPerCatch;
	}

	/**
	 * @param averageYardsAllowedPerCatch
	 *            the averageYardsAllowedPerCatch to set
	 */
	public void setAverageYardsAllowedPerCatch(double averageYardsAllowedPerCatch) {
		this.averageYardsAllowedPerCatch = averageYardsAllowedPerCatch;
	}

	/**
	 * @return the numberOfFBSTeams
	 */
	public static int getNumberOfFBSTeams() {
		return numberOfFBSTeams;
	}

	public int getRankingPoints() {
		return teamStatPoint;
	}

	public void decrementRankingsPoints(int n) {
		teamStatPoint = (teamStatPoint - n);
	}

	public StringBuilder getTeamReport() {
		StringBuilder sb = new StringBuilder();

		sb.append("\t" + this.getTeamName()
		        + "\n++++++++++++++++++++++++++++++++++++++++++++++\n");

		sb.append("Games Won Reward: " + teamPointAllocation.get("Games Won Reward") + "\t\n");
		sb.append("\t-Strength Of Schedule (Win) Bonus: "
		        + teamPointAllocation.get("Strength Of Schedule (Win) Bonus") + "\t\n");
		sb.append("\t-Team Blowout (Win) Bonus: "
		        + teamPointAllocation.get("Team Blowout (Win) Bonus") + "\t\n");
		sb.append("\t-Team Shutout (Win) Bonus: "
		        + teamPointAllocation.get("Team Shutout (Win) Bonus") + "\t\n");

		sb.append("\n\n");

		sb.append("Games Lost Penalty: " + teamPointAllocation.get("Games Lost Penalty")
		        + "\t\n");
		sb.append("\t-Strength Of Schedule (Loss) Penalty: "
		        + teamPointAllocation.get("Strength Of Schedule (Loss) Penalty") + "\t\n");
		sb.append("\t-Team Blowout (Loss) Penalty: "
		        + teamPointAllocation.get("Team Blowout (Loss) Penalty") + "\t\n");
		sb.append("\t-Team Shutout (Loss) Penalty: "
		        + teamPointAllocation.get("-Team Shutout (Loss) Penalty") + "\t\n");

		sb.append("\n\n");

		sb.append("-Points Scored Reward: " + teamPointAllocation.get("Points Scored Reward")
		        + "\t\n");
		sb.append("-Points Scored Penalty: "
		        + teamPointAllocation.get("Points Scored Penalty") + "\t\n");
		sb.append("-Points Allowed Reward: "
		        + teamPointAllocation.get("Points Allowed Reward") + "\t\n");
		sb.append("-Points Allowed Penalty: "
		        + teamPointAllocation.get("Points Allowed Penalty") + "\t\n");

		return sb;
	}

	public HashMap<String, Integer> getTeamPointAllocationMap() {
		return teamPointAllocation;
	}

	public void clearPointAllocationMap() {
		teamPointAllocation.clear();
	}
}

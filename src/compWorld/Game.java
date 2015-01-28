package compWorld;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game implements Comparable<Game> {

	private Team awayTeam;
	private Team homeTeam;

	private int awayTeamScore;
	private int homeTeamScore;

	private Team gameLooser;
	private Team gameWinner;

	NCAA ncaa;
	Date dateOfGame;

	public Game(String[] gameStat, NCAA ncaa) {

		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		this.ncaa = ncaa;
		try {
			dateOfGame = formatter.parse(gameStat[0]);
		}
		catch (ParseException e) {
			System.out.println("INCORRECT DATE FORMAT!");
			e.printStackTrace();

		}
		String visTeamName = gameStat[1].trim();
		int visTeamScore = Integer.valueOf(gameStat[17].trim());
		String homeTeamName = gameStat[18].trim();
		int homeScore = Integer.valueOf(gameStat[34].trim());

		if (ncaa.containsTeam(homeTeamName) && ncaa.containsTeam(visTeamName)) {

			awayTeam = ncaa.getTeam(visTeamName);
			homeTeam = ncaa.getTeam(homeTeamName);

			awayTeamScore = visTeamScore;
			homeTeamScore = homeScore;

			if (awayTeamScore > homeTeamScore) {
				gameWinner = awayTeam;
				gameLooser = homeTeam;

				awayTeam.addGameStats(this, gameStat, true);
				homeTeam.addGameStats(this, gameStat, false);

			}
			else {
				gameWinner = homeTeam;
				gameLooser = awayTeam;

				awayTeam.addGameStats(this, gameStat, false);
				homeTeam.addGameStats(this, gameStat, true);

			}

		}
		else {
			System.out.println(homeTeamName + " not mapped. System Will Now Exit");
			System.exit(-1);
		}

	}

	/**
	 * @return the awayTeam
	 */
	public Team getAwayTeam() {
		return awayTeam;
	}

	/**
	 * @return the homeTeam
	 */
	public Team getHomeTeam() {
		return homeTeam;
	}

	/**
	 * @return the awayTeamScore
	 */
	public int getAwayTeamScore() {
		return awayTeamScore;
	}

	/**
	 * @return the homeTeamScore
	 */
	public int getHomeTeamScore() {
		return homeTeamScore;
	}

	/**
	 * @return the gameLooser
	 */
	public Team getGameLooser() {
		return gameLooser;
	}

	/**
	 * @return the gameWinner
	 */
	public Team getGameWinner() {
		return gameWinner;
	}

	/**
	 * @return the dateOfGame
	 */
	public Date getDateOfGame() {
		return dateOfGame;
	}

	@Override
	public int compareTo(Game o) {
		return this.getDateOfGame().compareTo(o.getDateOfGame());
	}

}

package compWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFileChooser;

import compView.MainView;

public class NCAA {

	private HashMap<String, Team> teamHolder = new HashMap<String, Team>();
	private HashMap<Integer, Conference> conferenceHolder = new HashMap<Integer, Conference>();
	private ArrayList<String> teamNameKeys = new ArrayList<String>();
	private ArrayList<Integer> conferenceIDKeys = new ArrayList<Integer>();
	private ArrayList<Game> gameHolder = new ArrayList<Game>();
	private MainView mv;
	private StatCompiler st;
	private ArrayList<Team> rankedTeams;

	public NCAA(MainView mainView) {
		mv = mainView;
		rankedTeams = new ArrayList<Team>();
		HashMap<String, Integer> numberOfTeamsByState = new HashMap<String, Integer>();
		st = new StatCompiler(this, mv);
		File confList = new File("conference.csv");
		File teamList = new File("team.csv");
		try {
			Scanner scanner = new Scanner(confList);

			scanner.nextLine();

			while (scanner.hasNextLine()) {
				String[] confArray = scanner.nextLine().split(",");

				boolean fcs;

				if (confArray[2].trim().replaceAll("\"", "").equals("FCS")) {
					fcs = true;
				}
				else
					fcs = false;

				Conference conf = new Conference(confArray[1].trim().replaceAll("\"", ""),
				        Integer.valueOf(confArray[0].trim()), fcs);
				conferenceHolder.put(conf.getConferenceID(), conf);
				conferenceIDKeys.add(conf.getConferenceID());

			}
			scanner.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {

			Scanner scanner = new Scanner(teamList);
			scanner.nextLine();

			while (scanner.hasNextLine()) {
				String[] teamArray = scanner.nextLine().split(",");
				Conference conf = conferenceHolder.get(Integer.valueOf(teamArray[2].trim()));
				boolean fcs;
				String location = "";
				if (teamArray.length == 4) {
					location = teamArray[3].trim();
				}

				if (conf.isFcs())
					fcs = true;
				else
					fcs = false;
				Team team = new Team(teamArray[1].trim().replaceAll("\"", ""), conf,
				        Integer.valueOf(teamArray[0]), fcs, location);
				teamHolder.put(String.valueOf(team.getTeamCode()), team);
				teamHolder.put(team.getTeamName(), team);
				teamHolder.put(
				        team.getTeamName().trim().replaceAll(" ", "").replaceAll("-", "")
				                .toLowerCase(), team);
				teamNameKeys.add(team.getTeamName());
				team.getConference().addTeamToConference(team);
				// Counts how many teams from each state their are.
				if (!location.equals("") && numberOfTeamsByState.containsKey(location)) {
					numberOfTeamsByState.put(location, numberOfTeamsByState.get(location) + 1);
				}
				else
					numberOfTeamsByState.put(location, 1);
			}
			scanner.close();
			st.setNumberOfTeamsByState(numberOfTeamsByState);

		}
		catch (FileNotFoundException e) {

		}

	}

	public boolean containsTeam(String team) {
		if (teamHolder.containsKey(team))
			return true;
		else
			return false;
	}

	public Team getTeam(String teamCode) {
		return teamHolder.get(teamCode);
	}

	public Conference getConference(int confCode) {
		return conferenceHolder.get(confCode);
	}

	public HashMap<Integer, Conference> getConferenceHolder() {
		return conferenceHolder;
	}

	public void addGame(Game game) {
		gameHolder.add(game);
	}

	public void generateReport() {
		st.printOrderedTeamList();

	}

	/**
	 * @return the nameKeys
	 */
	public ArrayList<String> getNameKeys() {
		return teamNameKeys;
	}

	/**
	 * @return the teamHolder
	 */
	public HashMap<String, Team> getTeamHolder() {
		return teamHolder;
	}

	/**
	 * @return the gameHolder
	 */
	public ArrayList<Game> getGameHolder() {
		return gameHolder;
	}

	public void clearTeamPoints() {
		for (String s : teamNameKeys) {
			teamHolder.get(s).resetPoints();
		}
	}

	public void generateTeamReport() {
		st.printTeamReport();

	}

	public void setRankingList(ArrayList<Team> list) {
		rankedTeams = list;
	}

	/**
	 * @return the rankedTeams
	 */
	public ArrayList<Team> getRankedTeams() {
		return rankedTeams;
	}

	/**
	 * @return the conferenceIDKeys
	 */
	public ArrayList<Integer> getConferenceIDKeys() {
		return conferenceIDKeys;
	}

	/**
	 * @return the st
	 */
	public StatCompiler getSt() {
		return st;
	}

	public void regenerateReport() {
		st.reprintList();

	}

	public void parseStats() {

		String userDir = System.getProperty("user.home");
		JFileChooser chooser = new JFileChooser(userDir + "/Desktop");

		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int option = chooser.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			File[] allFiles = file.listFiles();

			for (int i = 0; i < allFiles.length; i++) {
				File newFile = allFiles[i];
				if (newFile.getAbsolutePath().contains(".csv")) {

					try {
						Scanner scanner = new Scanner(newFile);
						scanner.nextLine();
						while (scanner.hasNextLine()) {
							Game game = new Game(scanner.nextLine().split(","), this);
							gameHolder.add(game);
						}
						scanner.close();
					}
					catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}

			}

		}

	}

}

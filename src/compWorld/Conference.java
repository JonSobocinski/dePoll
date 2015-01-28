package compWorld;

import java.util.ArrayList;

public class Conference {

	private ArrayList<Team> teamList;
	private String conferenceName;
	private int conferenceID;
	private boolean fcs;
	private boolean P5;

	public Conference(String conferenceName, int conferenceID, boolean fcs) {
		teamList = new ArrayList<Team>();
		this.conferenceName = conferenceName;
		this.conferenceID = conferenceID;
		this.fcs = fcs;
		P5 = isP5(conferenceID);

	}

	public void addTeamToConference(Team team) {
		teamList.add(team);
	}

	/**
	 * @return the teamList
	 */
	public ArrayList<Team> getTeamList() {
		return teamList;
	}

	/**
	 * @return the conferenceName
	 */
	public String getConferenceName() {
		return conferenceName;
	}

	/**
	 * @return the conferenceID
	 */
	public int getConferenceID() {
		return conferenceID;
	}

	/**
	 * @return the fcs
	 */
	public boolean isFcs() {
		return fcs;
	}

	private boolean isP5(int c) {
		if (c == 821 || c == 25354 || c == 827 || c == 905 || c == 911 || c == 99001) {
			return true;
		}
		else
			return false;
	}

	/**
	 * @return the p5
	 */
	public boolean isP5() {
		return P5;
	}

}

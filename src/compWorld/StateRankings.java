package compWorld;

public class StateRankings implements Comparable<StateRankings> {

	private String location;
	private int rankingPoints;

	public StateRankings(String location, int rankingPoints) {
		this.location = location;
		this.rankingPoints = rankingPoints;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the rankingPoints
	 */
	public int getRankingPoints() {
		return rankingPoints;
	}

	/**
	 * @param rankingPoints
	 *            the rankingPoints to set
	 */
	public void setRankingPoints(int rankingPoints) {
		this.rankingPoints = rankingPoints;
	}

	@Override
	public int compareTo(StateRankings o) {
		if (this.rankingPoints > o.getRankingPoints())
			return -1;
		else if (this.rankingPoints < o.getRankingPoints())
			return 1;
		else
			return 0;
	}

}

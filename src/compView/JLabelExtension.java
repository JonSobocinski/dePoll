package compView;

import javax.swing.JLabel;

public class JLabelExtension extends JLabel {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6654308520189459273L;
	private String rank;

	public JLabelExtension() {
		super();
	}

	/**
	 * @return the rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * @param rank the rank to set
	 */
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	

}

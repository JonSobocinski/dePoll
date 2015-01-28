package compView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import compWorld.Team;

import javax.swing.SwingConstants;

public class IndiViewer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8554119004275057173L;
	private JLabel rankLabel;
	private JTextArea textArea;

	/**
	 * Create the dialog.
	 * 
	 * @param rank
	 */
	public IndiViewer(final Team team, Icon i, final String rank, final MainView m) {

		// setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		setTitle(rank + " " + team.getTeamName() + " (" + team.getNumberOfWins() + " - "
		        + team.getNumberOfLosses() + ")");

		{
			JPanel logoPane = new JPanel();
			logoPane.setBackground(Color.WHITE);
			logoPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			getContentPane().add(logoPane, BorderLayout.EAST);
			logoPane.setLayout(new BorderLayout(0, 0));
			{
				JLabel logo = new JLabel("");
				logo.setHorizontalAlignment(SwingConstants.CENTER);
				logo.setIcon(i);
				logoPane.add(logo);
			}
			{

				rankLabel = new JLabel("\t" + rank + " " + team.getTeamName() + "\n" + " ("
				        + team.getNumberOfWins() + " - " + team.getNumberOfLosses() + ")"
				        + "\t");
				rankLabel.setHorizontalAlignment(SwingConstants.CENTER);
				rankLabel.setFont(new Font("Trajan Pro", Font.BOLD, 30));
				logoPane.add(rankLabel, BorderLayout.SOUTH);
			}
		}
		textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		textArea.setEditable(false);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		textArea.setText(team.getTeamReport().toString());
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(new Color(0, 0, 0)));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				{
					final String sos = "Arbitrary Penalization";
					JButton btnNewButton = new JButton(sos);
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							int points = -(team.getRankingPoints() / 10);
							team.incTeamStatPoint(points);

							if (team.getTeamPointAllocationMap().containsKey(sos)) {
								int add = team.getTeamPointAllocationMap().get(sos);
								add = add + points;
								team.getTeamPointAllocationMap().put(sos, add);
							}
							else {
								team.getTeamPointAllocationMap().put(sos, points);
							}
							m.reDo();
							int newRank = m.getN().getSt().getTeamList().indexOf(team) + 1;
							rankLabel.setText("\t" + newRank + " " + team.getTeamName() + "\n"
							        + " (" + team.getNumberOfWins() + " - "
							        + team.getNumberOfLosses() + ")" + "\t");
							setTitle(rank + " " + team.getTeamName() + " ("
							        + team.getNumberOfWins() + " - "
							        + team.getNumberOfLosses() + ")");
							textArea.setText(team.getTeamReport().toString());
							pack();
						}
					});
					buttonPane.add(btnNewButton);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

		}
		pack();

	}

}

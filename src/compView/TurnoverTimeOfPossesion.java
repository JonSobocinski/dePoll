package compView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TurnoverTimeOfPossesion extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6867473577180406243L;
	private MultiOption multiOption;
	private static final int MAX_REWARD = 100;
	private static final int MIN_PEN = -100;

	private JSpinner takeawayMulti;
	private JSpinner pickMulti;
	private JSpinner fumbleRecoveryMulti;

	private JSpinner topPen;
	private JSpinner topTh;
	private JSpinner topRe;

	private JSpinner oppTOPRe;
	private JSpinner oppTOPTh;
	private JSpinner oppTOPPe;

	private JSpinner turnoverPen;
	private JSpinner interceptionPen;
	private JSpinner fumblesLostPen;

	private JLabel takeawayLabel;
	private JLabel turnoversLabel;
	private JLabel oppTOPLabel;
	private JLabel topLabel;

	/**
	 * Create the panel.
	 */
	public TurnoverTimeOfPossesion(final MultiOption multiOption) {
		setLayout(new GridLayout(2, 2, 0, 0));
		this.multiOption = multiOption;

		JPanel tunroverRewardPanel = new JPanel();
		tunroverRewardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(tunroverRewardPanel);
		tunroverRewardPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblTakeaways = new JLabel("Takeaways");
		lblTakeaways.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTakeaways.setHorizontalAlignment(SwingConstants.CENTER);
		tunroverRewardPanel.add(lblTakeaways, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		tunroverRewardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 5));

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		JLabel lblNewLabel = new JLabel("Takeaway Multiplier");
		panel_4.add(lblNewLabel);

		takeawayMulti = new JSpinner();
		takeawayMulti.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		takeawayMulti.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setTakeAwayMult((int) takeawayMulti.getValue());
				updateLabels();
			}
		});
		panel_4.add(takeawayMulti);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JLabel lblNewLabel_1 = new JLabel("Picks Multiplier");
		panel_5.add(lblNewLabel_1);

		pickMulti = new JSpinner();
		pickMulti.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		pickMulti.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPickMult((int) pickMulti.getValue());
				updateLabels();
			}
		});
		panel_5.add(pickMulti);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		JLabel lblNewLabel_2 = new JLabel("Fumble Recovery Multiplier");
		panel_6.add(lblNewLabel_2);

		fumbleRecoveryMulti = new JSpinner();
		fumbleRecoveryMulti.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		fumbleRecoveryMulti.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setFumbleRecoveryMult((int) fumbleRecoveryMulti.getValue());
				updateLabels();
			}
		});
		panel_6.add(fumbleRecoveryMulti);

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);

		takeawayLabel = new JLabel("");
		takeawayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(takeawayLabel);

		JPanel turnoverPenPanel = new JPanel();
		turnoverPenPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(turnoverPenPanel);
		turnoverPenPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblTurnovers = new JLabel("Turnovers");
		lblTurnovers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTurnovers.setHorizontalAlignment(SwingConstants.CENTER);
		turnoverPenPanel.add(lblTurnovers, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		turnoverPenPanel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_1);

		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);

		JLabel label_3 = new JLabel("Turnover Penalizer");
		panel_8.add(label_3);

		turnoverPen = new JSpinner();
		turnoverPen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setTurnoverPen((int) turnoverPen.getValue());
				updateLabels();
			}
		});
		turnoverPen.setModel(new SpinnerNumberModel(0, -100, 0, 1));
		panel_8.add(turnoverPen);

		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);

		JLabel label_5 = new JLabel("Interception Penilizer");
		panel_9.add(label_5);

		interceptionPen = new JSpinner();
		interceptionPen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setInterceptionPen((int) interceptionPen.getValue());
				updateLabels();
			}
		});
		interceptionPen.setModel(new SpinnerNumberModel(0, -100, 0, 1));
		panel_9.add(interceptionPen);

		JPanel panel_10 = new JPanel();
		panel_1.add(panel_10);

		JLabel label_6 = new JLabel("Fumbles Lost Penilizer");
		panel_10.add(label_6);

		fumblesLostPen = new JSpinner();
		fumblesLostPen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setFumbleLostPen((int) fumblesLostPen.getValue());
				updateLabels();
			}
		});
		fumblesLostPen.setModel(new SpinnerNumberModel(0, -100, 0, 1));
		panel_10.add(fumblesLostPen);

		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);

		turnoversLabel = new JLabel("New label");
		turnoversLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_11.add(turnoversLabel);

		JPanel topRewardPanel = new JPanel();
		topRewardPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(topRewardPanel);
		topRewardPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblTimeOfPoessesion = new JLabel("Time Of Possession");
		lblTimeOfPoessesion.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimeOfPoessesion.setHorizontalAlignment(SwingConstants.CENTER);
		topRewardPanel.add(lblTimeOfPoessesion, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		topRewardPanel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(5, 1, 0, 0));

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel_2.add(rigidArea_2);

		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);

		JLabel lblNewLabel_3 = new JLabel("Reward");
		panel_13.add(lblNewLabel_3);

		topRe = new JSpinner();
		topRe.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		topRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setTopRe((int) topRe.getValue());
				updateLabels();
			}
		});
		panel_13.add(topRe);

		JPanel panel_14 = new JPanel();
		panel_2.add(panel_14);

		JLabel lblNewLabel_4 = new JLabel("Threshold (Pct.)");
		panel_14.add(lblNewLabel_4);

		topTh = new JSpinner();
		topTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setTopTh((int) topTh.getValue());
				updateLabels();
			}
		});
		topTh.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		panel_14.add(topTh);

		JPanel panel_15 = new JPanel();
		panel_2.add(panel_15);

		JLabel lblNewLabel_5 = new JLabel("Penilizer");
		panel_15.add(lblNewLabel_5);

		topPen = new JSpinner();
		topPen.setModel(new SpinnerNumberModel(0, -100, 0, 1));
		topPen.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setTopPen((int) topPen.getValue());
				updateLabels();
			}
		});
		panel_15.add(topPen);

		JPanel panel_16 = new JPanel();
		panel_2.add(panel_16);

		topLabel = new JLabel("New label");
		topLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(topLabel);

		JPanel topPenPanel = new JPanel();
		topPenPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(topPenPanel);
		topPenPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblOpponentsTimeOf = new JLabel("Opponents Time Of Possession");
		lblOpponentsTimeOf.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOpponentsTimeOf.setHorizontalAlignment(SwingConstants.CENTER);
		topPenPanel.add(lblOpponentsTimeOf, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		topPenPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(5, 1, 0, 0));

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		rigidArea_3.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_3.add(rigidArea_3);

		JPanel panel_17 = new JPanel();
		panel_3.add(panel_17);

		JLabel label = new JLabel("Reward");
		panel_17.add(label);

		oppTOPRe = new JSpinner();
		oppTOPRe.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		oppTOPRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setOppTOPRe((int) oppTOPRe.getValue());
				updateLabels();
			}
		});
		panel_17.add(oppTOPRe);

		JPanel panel_18 = new JPanel();
		panel_3.add(panel_18);

		JLabel label_1 = new JLabel("Threshold (Pct.)");
		panel_18.add(label_1);

		oppTOPTh = new JSpinner();
		oppTOPTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setOppTOPTh((int) oppTOPTh.getValue());
				updateLabels();
			}
		});
		oppTOPTh.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		panel_18.add(oppTOPTh);

		JPanel panel_19 = new JPanel();
		panel_3.add(panel_19);

		JLabel label_2 = new JLabel("Penilizer");
		panel_19.add(label_2);

		oppTOPPe = new JSpinner();
		oppTOPPe.setModel(new SpinnerNumberModel(0, -100, 0, 1));
		oppTOPPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setOppTOPPen((int) oppTOPPe.getValue());
				updateLabels();
			}
		});
		panel_19.add(oppTOPPe);

		JPanel panel_20 = new JPanel();
		panel_3.add(panel_20);

		oppTOPLabel = new JLabel("");
		oppTOPLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(oppTOPLabel);
		updateLabels();

	}

	public TurnoverTimeOfPossesion getThis() {
		return this;
	}

	public void updateSpinners() {

		takeawayMulti.setValue(multiOption.getTakeAwayMult());
		pickMulti.setValue(multiOption.getPickMult());
		fumbleRecoveryMulti.setValue(multiOption.getFumbleRecoveryMult());

		topPen.setValue(multiOption.getTopPen());
		topTh.setValue(multiOption.getTopTh());
		topRe.setValue(multiOption.getTopRe());

		oppTOPRe.setValue(multiOption.getOppTOPRe());
		oppTOPTh.setValue(multiOption.getOppTOPTh());
		oppTOPPe.setValue(multiOption.getOppTOPPen());

		turnoverPen.setValue(multiOption.getTurnoverPen());
		interceptionPen.setValue(multiOption.getInterceptionPen());
		fumblesLostPen.setValue(multiOption.getFumbleLostPen());

		updateLabels();

	}

	private void updateLabels() {

		takeawayLabel.setText("<html>This team will receive " + multiOption.getTakeAwayMult()
		        + " points for every takeaway.<br>They will receive "
		        + multiOption.getPickMult()
		        + " points for every pick.<br>Finally they will receive "
		        + multiOption.getFumbleRecoveryMult() + " points for every fumble recovered.");

		turnoversLabel.setText("<html>This team will lose " + multiOption.getTurnoverPen()
		        + " points for every turnover.<br>They will lose "
		        + multiOption.getInterceptionPen()
		        + " points for every pick.<br>Finally they will lose "
		        + multiOption.getFumbleLostPen() + " points for every fumble lost.");

		oppTOPLabel.setText("<html>If an opponents time of possession stays under "
		        + multiOption.getOppTOPTh() + "%,<br> this team will receive "
		        + multiOption.getOppTOPRe()
		        + " points for every percent under.<br> They will lose "
		        + multiOption.getOppTOPPen() + " points for every percent over.");
		topLabel.setText("<html>If this teams time of possession goes over "
		        + multiOption.getTopTh() + "%,<br> they will receive "
		        + multiOption.getTopRe() + " points for every percent over.<br> They will lose "
		        + multiOption.getTopPen() + " points for every percent under.");

	}

	/**
	 * @return the maxReward
	 */
	public static int getMaxReward() {
		return MAX_REWARD;
	}

	/**
	 * @return the minPen
	 */
	public static int getMinPen() {
		return MIN_PEN;
	}

}

package compView;

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

public class YardageGainAllowedPanel extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = -6264134209026528895L;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private MultiOption multiOption;
	private static final int THRESHOLD_MIN = 0;
	private static final int THRESHOLD_MAX = 1000;
	private static final int REWARD_MIN = 0;
	private static final int REWARD_MAX = 10;
	private static final int PEN_MIN = -10;
	private static final int PEN_MAX = 0;
	private static final int YPC_REWARD_MAX = 100;
	private static final int YPC_REWARD_MIN = 0;
	private static final int YPCA_PEN_MIN = -100;
	private static final int YPCA_PEN_MAX = 0;

	private JSpinner totalYardsRe;
	private JSpinner totalYardsTh;
	private JSpinner totalYardsPe;
	private JSpinner totalYardsAllowedRe;
	private JSpinner totalYardsAllowedTh;
	private JSpinner totalYardsAllowedPe;
	private JSpinner rushingYardsRe;
	private JSpinner rushingYardsTh;
	private JSpinner rushingYardsPe;
	private JSpinner rushingYardsAllowedRe;
	private JSpinner rushingYardsAllowedTh;
	private JSpinner rushingYardsAllowedPe;
	private JSpinner passingYardsRe;
	private JSpinner passingYardsTh;
	private JSpinner passingYardsPe;
	private JSpinner passingYardsAllowedRe;
	private JSpinner passingYardsAllowedTh;
	private JSpinner passingYardsAllowedPe;
	private JSpinner ypCatchRe;
	private JSpinner ypCarryRe;
	private JSpinner ypCatchAllowedPe;
	private JSpinner ypCarryAllowedPe;

	/**
	 * Create the panel.
	 */
	public YardageGainAllowedPanel(final MultiOption multiOption) {
		setLayout(new GridLayout(6, 2, 0, 0));
		this.multiOption = multiOption;
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_8);

		JLabel lblNewLabel = new JLabel("Yardage Gained", SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(lblNewLabel);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_9);

		JLabel lblNewLabel_1 = new JLabel("Yardage Allowed", SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblTotalYardsGained = new JLabel("Total Yards Gained", SwingConstants.RIGHT);
		panel.add(lblTotalYardsGained);

		Component rigidArea_4 = Box.createRigidArea(new Dimension(20, 20));
		panel.add(rigidArea_4);

		JLabel label_7 = new JLabel("Reward", SwingConstants.CENTER);
		panel.add(label_7);

		totalYardsRe = new JSpinner(new SpinnerNumberModel(REWARD_MIN, REWARD_MIN, REWARD_MAX,
		        1));
		totalYardsRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsGainedRe((int) totalYardsRe.getValue());
				setYardsGainedText();
			}
		});
		panel.add(totalYardsRe);

		JLabel label_8 = new JLabel("Threshold", SwingConstants.CENTER);
		panel.add(label_8);

		totalYardsTh = new JSpinner(new SpinnerNumberModel(THRESHOLD_MIN, THRESHOLD_MIN,
		        THRESHOLD_MAX, 1));
		totalYardsTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsGainedTh((int) totalYardsTh.getValue());
				setYardsGainedText();
			}
		});
		panel.add(totalYardsTh);

		JLabel label_9 = new JLabel("Penalty", SwingConstants.CENTER);
		panel.add(label_9);

		totalYardsPe = new JSpinner(new SpinnerNumberModel(PEN_MAX, PEN_MIN, PEN_MAX, 1));
		totalYardsPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsGainedPen((int) totalYardsPe.getValue());
				setYardsGainedText();
			}
		});
		panel.add(totalYardsPe);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1);
		panel_1.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblTotalYardsAllowed = new JLabel("Total Yards Allowed", SwingConstants.RIGHT);
		panel_1.add(lblTotalYardsAllowed);

		Component rigidArea_5 = Box.createRigidArea(new Dimension(20, 20));
		panel_1.add(rigidArea_5);

		JLabel label_11 = new JLabel("Reward", SwingConstants.CENTER);
		panel_1.add(label_11);

		totalYardsAllowedRe = new JSpinner(new SpinnerNumberModel(REWARD_MIN, REWARD_MIN,
		        REWARD_MAX, 1));
		totalYardsAllowedRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedRe((int) totalYardsAllowedRe.getValue());
				setYardsAllowedText();
			}
		});
		panel_1.add(totalYardsAllowedRe);

		JLabel label_12 = new JLabel("Threshold", SwingConstants.CENTER);
		panel_1.add(label_12);

		totalYardsAllowedTh = new JSpinner(new SpinnerNumberModel(THRESHOLD_MIN,
		        THRESHOLD_MIN, THRESHOLD_MAX, 1));
		totalYardsAllowedTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedTh((int) totalYardsAllowedTh.getValue());
				setYardsAllowedText();
			}
		});
		panel_1.add(totalYardsAllowedTh);

		JLabel label_13 = new JLabel("Penalty", SwingConstants.CENTER);
		panel_1.add(label_13);

		totalYardsAllowedPe = new JSpinner(
		        new SpinnerNumberModel(PEN_MAX, PEN_MIN, PEN_MAX, 1));
		totalYardsAllowedPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedPen((int) totalYardsAllowedPe.getValue());
				setYardsAllowedText();
			}
		});
		panel_1.add(totalYardsAllowedPe);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_2);
		panel_2.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblYardsPerCarry = new JLabel("Rushing Yards", SwingConstants.RIGHT);
		panel_2.add(lblYardsPerCarry);

		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		panel_2.add(rigidArea);

		JLabel lblReward = new JLabel("Reward", SwingConstants.CENTER);
		panel_2.add(lblReward);

		rushingYardsRe = new JSpinner(new SpinnerNumberModel(REWARD_MIN, REWARD_MIN,
		        REWARD_MAX, 1));
		rushingYardsRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsCarryRe((int) rushingYardsRe.getValue());
				setYardsGainedText();
			}
		});
		panel_2.add(rushingYardsRe);

		JLabel lblThreshold = new JLabel("Threshold", SwingConstants.CENTER);
		panel_2.add(lblThreshold);

		rushingYardsTh = new JSpinner(new SpinnerNumberModel(THRESHOLD_MIN, THRESHOLD_MIN,
		        THRESHOLD_MAX, 1));
		rushingYardsTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsCarryTh((int) rushingYardsTh.getValue());
				setYardsGainedText();
			}
		});
		panel_2.add(rushingYardsTh);

		JLabel lblPenalty = new JLabel("Penalty", SwingConstants.CENTER);
		panel_2.add(lblPenalty);

		rushingYardsPe = new JSpinner(new SpinnerNumberModel(PEN_MAX, PEN_MIN, PEN_MAX, 1));
		rushingYardsPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsCarryPen((int) rushingYardsPe.getValue());
				setYardsGainedText();
			}
		});
		panel_2.add(rushingYardsPe);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_3);
		panel_3.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblYardsAllowedPer = new JLabel("Rushing Yards Allowed", SwingConstants.RIGHT);
		panel_3.add(lblYardsAllowedPer);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
		panel_3.add(rigidArea_1);

		JLabel lblReward_1 = new JLabel("Reward", SwingConstants.CENTER);
		panel_3.add(lblReward_1);

		rushingYardsAllowedRe = new JSpinner(new SpinnerNumberModel(REWARD_MIN, REWARD_MIN,
		        REWARD_MAX, 1));
		rushingYardsAllowedRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedCarryRe((int) rushingYardsAllowedRe.getValue());
				setYardsAllowedText();
			}
		});
		panel_3.add(rushingYardsAllowedRe);

		JLabel lblThreshold_1 = new JLabel("Threshold", SwingConstants.CENTER);
		panel_3.add(lblThreshold_1);

		rushingYardsAllowedTh = new JSpinner(new SpinnerNumberModel(THRESHOLD_MIN,
		        THRESHOLD_MIN, THRESHOLD_MAX, 1));
		rushingYardsAllowedTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedCarryTh((int) rushingYardsAllowedTh.getValue());
				setYardsAllowedText();
			}
		});
		panel_3.add(rushingYardsAllowedTh);

		JLabel lblPenalty_1 = new JLabel("Penalty", SwingConstants.CENTER);
		panel_3.add(lblPenalty_1);

		rushingYardsAllowedPe = new JSpinner(new SpinnerNumberModel(PEN_MAX, PEN_MIN, PEN_MAX,
		        1));
		rushingYardsAllowedPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedCarryPen((int) rushingYardsAllowedPe.getValue());
				setYardsAllowedText();
			}
		});
		panel_3.add(rushingYardsAllowedPe);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_4);
		panel_4.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblYardsPerCatch = new JLabel("Passing Yards", SwingConstants.RIGHT);
		panel_4.add(lblYardsPerCatch);

		Component rigidArea_2 = Box.createRigidArea(new Dimension(20, 20));
		panel_4.add(rigidArea_2);

		JLabel label_1 = new JLabel("Reward", SwingConstants.CENTER);
		panel_4.add(label_1);

		passingYardsRe = new JSpinner(new SpinnerNumberModel(REWARD_MIN, REWARD_MIN,
		        REWARD_MAX, 1));
		passingYardsRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsCatchRe((int) passingYardsRe.getValue());
				setYardsGainedText();
			}
		});
		panel_4.add(passingYardsRe);

		JLabel label_2 = new JLabel("Threshold", SwingConstants.CENTER);
		panel_4.add(label_2);

		passingYardsTh = new JSpinner(new SpinnerNumberModel(THRESHOLD_MIN, THRESHOLD_MIN,
		        THRESHOLD_MAX, 1));
		passingYardsTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsCatchTh((int) passingYardsTh.getValue());
				setYardsGainedText();
			}
		});
		panel_4.add(passingYardsTh);

		JLabel label_3 = new JLabel("Penalty", SwingConstants.CENTER);
		panel_4.add(label_3);

		passingYardsPe = new JSpinner(new SpinnerNumberModel(PEN_MAX, PEN_MIN, PEN_MAX, 1));
		passingYardsPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsCatchPen((int) passingYardsPe.getValue());
				setYardsGainedText();
			}
		});
		panel_4.add(passingYardsPe);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_5);
		panel_5.setLayout(new GridLayout(4, 2, 0, 0));

		JLabel lblYardsAllowedPer_1 = new JLabel("Passing Yards Allowed", SwingConstants.RIGHT);
		panel_5.add(lblYardsAllowedPer_1);

		Component rigidArea_3 = Box.createRigidArea(new Dimension(20, 20));
		panel_5.add(rigidArea_3);

		JLabel label_4 = new JLabel("Reward", SwingConstants.CENTER);
		panel_5.add(label_4);

		passingYardsAllowedRe = new JSpinner(new SpinnerNumberModel(REWARD_MIN, REWARD_MIN,
		        REWARD_MAX, 1));
		passingYardsAllowedRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedCatchRe((int) passingYardsAllowedRe.getValue());
				setYardsAllowedText();
			}
		});
		panel_5.add(passingYardsAllowedRe);

		JLabel label_5 = new JLabel("Threshold", SwingConstants.CENTER);
		panel_5.add(label_5);

		passingYardsAllowedTh = new JSpinner(new SpinnerNumberModel(THRESHOLD_MIN,
		        THRESHOLD_MIN, THRESHOLD_MAX, 1));
		passingYardsAllowedTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedCatchTh((int) passingYardsAllowedTh.getValue());
				setYardsAllowedText();
			}
		});
		panel_5.add(passingYardsAllowedTh);

		JLabel label_6 = new JLabel("Penalty", SwingConstants.CENTER);
		panel_5.add(label_6);

		passingYardsAllowedPe = new JSpinner(new SpinnerNumberModel(PEN_MAX, PEN_MIN, PEN_MAX,
		        1));
		passingYardsAllowedPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYardsAllowedCatchPen((int) passingYardsAllowedPe.getValue());
				setYardsAllowedText();
			}
		});
		panel_5.add(passingYardsAllowedPe);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_11);
		panel_11.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblYpc = new JLabel("YPC", SwingConstants.RIGHT);
		panel_11.add(lblYpc);

		Component rigidArea_7 = Box.createRigidArea(new Dimension(20, 20));
		panel_11.add(rigidArea_7);

		JLabel lblYardsPerCatch_1 = new JLabel("Yards Per Catch Reward", SwingConstants.CENTER);
		panel_11.add(lblYardsPerCatch_1);

		ypCatchRe = new JSpinner(new SpinnerNumberModel(YPC_REWARD_MIN, YPC_REWARD_MIN,
		        YPC_REWARD_MAX, 1));
		ypCatchRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setYpCatchReward((int) ypCatchRe.getValue());
				setYardsGainedText();
			}
		});
		panel_11.add(ypCatchRe);

		JLabel lblYardsPerCarry_1 = new JLabel("Yards Per Carry Reward", SwingConstants.CENTER);
		panel_11.add(lblYardsPerCarry_1);

		ypCarryRe = new JSpinner(new SpinnerNumberModel(YPC_REWARD_MIN, YPC_REWARD_MIN,
		        YPC_REWARD_MAX, 1));
		ypCarryRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYpCarryReward((int) ypCarryRe.getValue());
				setYardsGainedText();
			}
		});
		panel_11.add(ypCarryRe);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_10);
		panel_10.setLayout(new GridLayout(3, 2, 0, 0));

		JLabel lblYapc = new JLabel("YAPC", SwingConstants.RIGHT);
		panel_10.add(lblYapc);

		Component rigidArea_6 = Box.createRigidArea(new Dimension(20, 20));
		panel_10.add(rigidArea_6);

		JLabel lblYardsPerCatch_2 = new JLabel("Yards Per Catch Allowed",
		        SwingConstants.CENTER);
		panel_10.add(lblYardsPerCatch_2);

		ypCatchAllowedPe = new JSpinner(new SpinnerNumberModel(YPCA_PEN_MAX, YPCA_PEN_MIN,
		        YPCA_PEN_MAX, 1));
		;
		ypCatchAllowedPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setYpCatchAllowedPen((int) ypCatchAllowedPe.getValue());
				setYardsAllowedText();
			}
		});
		panel_10.add(ypCatchAllowedPe);

		JLabel lblYardsPerCarry_2 = new JLabel("Yards Per Carry Allowed",
		        SwingConstants.CENTER);
		panel_10.add(lblYardsPerCarry_2);

		ypCarryAllowedPe = new JSpinner(new SpinnerNumberModel(YPCA_PEN_MAX, YPCA_PEN_MIN,
		        YPCA_PEN_MAX, 1));
		;
		ypCarryAllowedPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setYpCarryAllowedPen((int) ypCarryAllowedPe.getValue());
				setYardsAllowedText();
			}
		});
		panel_10.add(ypCarryAllowedPe);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_6);

		lblNewLabel_2 = new JLabel(
		        "<html>This team will be awarded "
		                + multiOption.getYardsGainedRe()
		                + " points for every yard over "
		                + multiOption.getYardsGainedTh()
		                + " , and penalized "
		                + multiOption.getYardsGainedPen()
		                + " for every yard under.<br> They will be awarded "
		                + multiOption.getYardsCarryRe()
		                + " points for every rushing yard over "
		                + multiOption.getYardsCarryTh()
		                + " , and penalized "
		                + multiOption.getYardsCarryPen()
		                + " for every rushing yard under.<br> They will also be awarded "
		                + multiOption.getYardsCatchRe()
		                + " points for every reciving yard over "
		                + multiOption.getYardsCatchTh()
		                + " , and penalized "
		                + multiOption.getYardsCatchPen()
		                + " points for every reciving yard under.<br> They will receive "
		                + multiOption.getYpCarryReward()
		                + " multiplied by their yards per carry average.<br> Finally, they will receive "
		                + multiOption.getYpCatchReward()
		                + " multiplied by their yards per catch average.",
		        SwingConstants.RIGHT);
		panel_6.add(lblNewLabel_2);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_7);

		lblNewLabel_3 = new JLabel(
		        "<html>This team will be  awarded "
		                + multiOption.getYardsAllowedRe()
		                + " points for every yard under "
		                + multiOption.getYardsGainedTh()
		                + " they hold an opponent to, and penalized "
		                + multiOption.getYardsAllowedPen()
		                + " for every yard over.<br> They will be awarded "
		                + multiOption.getYardsAllowedCarryRe()
		                + " points for every rushing yard under "
		                + multiOption.getYardsAllowedCarryTh()
		                + " they hold an opponent to, and penalized "
		                + multiOption.getYardsAllowedCarryPen()
		                + " for every rushing yard over.<br> They will also be awarded "
		                + multiOption.getYardsAllowedCatchRe()
		                + " points for every reciving yard under "
		                + multiOption.getYardsAllowedCatchTh()
		                + " they hold an opponent to, and penalized "
		                + multiOption.getYardsAllowedCatchPen()
		                + " points for every reciving yard over.<br> They will lose "
		                + multiOption.getYpCarryAllowedPen()
		                + " multiplied by their yards per carry allowed average.<br> Finally, they will lose "
		                + multiOption.getYpCatchAllowedPen()
		                + " multiplied by their yards per catch allowed average.",
		        SwingConstants.LEFT);
		panel_7.add(lblNewLabel_3);

	}

	public void updateSpinners() {

		totalYardsRe.setValue(multiOption.getYardsGainedRe());
		totalYardsTh.setValue(multiOption.getYardsGainedTh());
		totalYardsPe.setValue(multiOption.getYardsGainedPen());

		totalYardsAllowedRe.setValue(multiOption.getYardsAllowedRe());
		totalYardsAllowedTh.setValue(multiOption.getYardsAllowedTh());
		totalYardsAllowedPe.setValue(multiOption.getYardsAllowedPen());

		rushingYardsRe.setValue(multiOption.getYardsCarryRe());
		rushingYardsTh.setValue(multiOption.getYardsCarryTh());
		rushingYardsPe.setValue(multiOption.getYardsCarryPen());

		rushingYardsAllowedRe.setValue(multiOption.getYardsAllowedCarryRe());
		rushingYardsAllowedTh.setValue(multiOption.getYardsAllowedCarryTh());
		rushingYardsAllowedPe.setValue(multiOption.getYardsAllowedCarryPen());

		passingYardsRe.setValue(multiOption.getYardsCatchRe());
		passingYardsTh.setValue(multiOption.getYardsCatchTh());
		passingYardsPe.setValue(multiOption.getYardsCatchPen());

		passingYardsAllowedRe.setValue(multiOption.getYardsAllowedCatchRe());
		passingYardsAllowedTh.setValue(multiOption.getYardsAllowedCatchTh());
		passingYardsAllowedPe.setValue(multiOption.getYardsAllowedCatchPen());

		ypCatchRe.setValue(multiOption.getYpCatchReward());
		ypCarryRe.setValue(multiOption.getYpCarryReward());

		ypCatchAllowedPe.setValue(multiOption.getYpCatchAllowedPen());
		ypCarryAllowedPe.setValue(multiOption.getYpCarryAllowedPen());

	}

	private void setYardsGainedText() {

		lblNewLabel_2
		        .setText("<html>This team will be awarded "
		                + multiOption.getYardsGainedRe()
		                + " points for every yard over "
		                + multiOption.getYardsGainedTh()
		                + " , and penalized "
		                + multiOption.getYardsGainedPen()
		                + " for every yard under.<br> They will be awarded "
		                + multiOption.getYardsCarryRe()
		                + " points for every rushing yard over "
		                + multiOption.getYardsCarryTh()
		                + " , and penalized "
		                + multiOption.getYardsCarryPen()
		                + " for every rushing yard under.<br> They will also be awarded "
		                + multiOption.getYardsCatchRe()
		                + " points for every reciving yard over "
		                + multiOption.getYardsCatchTh()
		                + " , and penalized "
		                + multiOption.getYardsCatchPen()
		                + " points for every reciving yard under.<br> They will receive "
		                + multiOption.getYpCarryReward()
		                + " multiplied by their yards per carry average.<br> Finally, they will receive "
		                + multiOption.getYpCatchReward()
		                + " multiplied by their yards per catch average.");
	}

	private void setYardsAllowedText() {
		lblNewLabel_3
		        .setText("<html>This team will be  awarded "
		                + multiOption.getYardsAllowedRe()
		                + " points for every yard under "
		                + multiOption.getYardsGainedTh()
		                + " they hold an opponent to, and penalized "
		                + multiOption.getYardsAllowedPen()
		                + " for every yard over.<br> They will be awarded "
		                + multiOption.getYardsAllowedCarryRe()
		                + " points for every rushing yard under "
		                + multiOption.getYardsAllowedCarryTh()
		                + " they hold an opponent to, and penalized "
		                + multiOption.getYardsAllowedCarryPen()
		                + " for every rushing yard over.<br> They will also be awarded "
		                + multiOption.getYardsAllowedCatchRe()
		                + " points for every reciving yard under "
		                + multiOption.getYardsAllowedCatchTh()
		                + " they hold an opponent to, and penalized "
		                + multiOption.getYardsAllowedCatchPen()
		                + " points for every reciving yard over.<br> They will lose "
		                + multiOption.getYpCarryAllowedPen()
		                + " multiplied by their yards per carry allowed average.<br> Finally, they will lose "
		                + multiOption.getYpCatchAllowedPen()
		                + " multiplied by their yards per catch allowed average.");
	}

	/**
	 * @return the thresholdMin
	 */
	public static int getThresholdMin() {
		return THRESHOLD_MIN;
	}

	/**
	 * @return the thresholdMax
	 */
	public static int getThresholdMax() {
		return THRESHOLD_MAX;
	}

	/**
	 * @return the rewardMin
	 */
	public static int getRewardMin() {
		return REWARD_MIN;
	}

	/**
	 * @return the rewardMax
	 */
	public static int getRewardMax() {
		return REWARD_MAX;
	}

	/**
	 * @return the penMin
	 */
	public static int getPenMin() {
		return PEN_MIN;
	}

	/**
	 * @return the penMax
	 */
	public static int getPenMax() {
		return PEN_MAX;
	}

	/**
	 * @return the ypcRewardMax
	 */
	public static int getYpcRewardMax() {
		return YPC_REWARD_MAX;
	}

	/**
	 * @return the ypcRewardMin
	 */
	public static int getYpcRewardMin() {
		return YPC_REWARD_MIN;
	}

	/**
	 * @return the ypcaPenMin
	 */
	public static int getYpcaPenMin() {
		return YPCA_PEN_MIN;
	}

	/**
	 * @return the ypcaPenMax
	 */
	public static int getYpcaPenMax() {
		return YPCA_PEN_MAX;
	}

	public YardageGainAllowedPanel getThis() {
		return this;
	}

}

package compView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PenaltiesConversions extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = 7021400520270240112L;
	MultiOption multiOption;
	private static final int MAX_REWARD_OR_THRESHOLD = 100;
	private static final int MIN_REWARD = -100;

	private static final int MAX_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER = 25;
	private static final int MIN_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER = -25;

	private static final int MAX_PEN_REWARD_OR_PEN_FOR_PEN_YARDAGE = 10;
	private static final int MIN_PEN_REWARD_OR_PEN_FOR_PEN_YARDAGE = -10;

	private JLabel thirdDownLabel;
	private JLabel thirdDownAllowedLabel;
	private JLabel penaltyAllowedLabel;
	private JLabel penaltyForcedLabel;

	private JSpinner thirdDownRe;
	private JSpinner thirdDownPe;
	private JSpinner thirdDownTh;

	private JSpinner thirdDownAllowedRe;
	private JSpinner thirdDownAllowedTh;
	private JSpinner thirdDownAllowedPe;

	private JSpinner penaltyForcedRe;
	private JSpinner PenaltyYardageForcedRe;

	private JSpinner penaltyAllowedPeSpinner;
	private JSpinner penaltyYardageAllowedPeSpinner;

	/**
	 * Create the panel.
	 * 
	 * @param multiOption
	 */
	public PenaltiesConversions(final MultiOption multiOption) {
		this.multiOption = multiOption;
		setLayout(new GridLayout(0, 2, 0, 0));
		JPanel thirdConversions = new JPanel();
		thirdConversions.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(thirdConversions);
		thirdConversions.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Third Down Conversions");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		thirdConversions.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		thirdConversions.add(panel);
		panel.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		JLabel lblNewLabel_2 = new JLabel("Reward");
		panel_4.add(lblNewLabel_2);

		thirdDownRe = new JSpinner();
		thirdDownRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				multiOption.setThirdDownRe((int) thirdDownRe.getValue());
				updateLabels();
			}
		});
		thirdDownRe.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD_OR_THRESHOLD, 1));
		panel_4.add(thirdDownRe);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JLabel lblNewLabel_3 = new JLabel("Threshold (Pct.)");
		panel_5.add(lblNewLabel_3);

		thirdDownTh = new JSpinner();
		thirdDownTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setThirdDownTh((int) thirdDownTh.getValue());
				updateLabels();
			}
		});
		thirdDownTh.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD_OR_THRESHOLD, 1));
		panel_5.add(thirdDownTh);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		JLabel lblNewLabel_4 = new JLabel("Penalty");
		panel_6.add(lblNewLabel_4);

		thirdDownPe = new JSpinner();
		thirdDownPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setThirdDownPe((int) thirdDownPe.getValue());
				updateLabels();
			}
		});
		thirdDownPe.setModel(new SpinnerNumberModel(0, MIN_REWARD, 0, 1));
		panel_6.add(thirdDownPe);

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);

		thirdDownLabel = new JLabel("");
		panel_7.add(thirdDownLabel);

		JPanel thirdConversionsAllowed = new JPanel();
		thirdConversionsAllowed.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(thirdConversionsAllowed);
		thirdConversionsAllowed.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel("Third Down Conversions Allowed");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		thirdConversionsAllowed.add(lblNewLabel_1, BorderLayout.NORTH);

		JPanel panel_1 = new JPanel();
		thirdConversionsAllowed.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(4, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_1.add(panel_8);

		JLabel label = new JLabel("Reward");
		panel_8.add(label);

		thirdDownAllowedRe = new JSpinner();
		thirdDownAllowedRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setThirdDownAllowedRe((int) thirdDownAllowedRe.getValue());
				updateLabels();
			}
		});
		thirdDownAllowedRe.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD_OR_THRESHOLD, 1));
		panel_8.add(thirdDownAllowedRe);

		JPanel panel_9 = new JPanel();
		panel_1.add(panel_9);

		JLabel lblThresholdpct = new JLabel("Threshold (Pct.)");
		panel_9.add(lblThresholdpct);

		thirdDownAllowedTh = new JSpinner();
		thirdDownAllowedTh.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setThirdDownAllowedTh((int) thirdDownAllowedTh.getValue());
				updateLabels();
			}
		});
		thirdDownAllowedTh.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD_OR_THRESHOLD, 1));
		panel_9.add(thirdDownAllowedTh);

		JPanel panel_10 = new JPanel();
		panel_1.add(panel_10);

		JLabel label_2 = new JLabel("Penalty");
		panel_10.add(label_2);

		thirdDownAllowedPe = new JSpinner();
		thirdDownAllowedPe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setThirdDownAllowedPe((int) thirdDownAllowedPe.getValue());
				updateLabels();
			}
		});
		thirdDownAllowedPe.setModel(new SpinnerNumberModel(0, MIN_REWARD, 0, 1));
		panel_10.add(thirdDownAllowedPe);

		JPanel panel_11 = new JPanel();
		panel_1.add(panel_11);

		thirdDownAllowedLabel = new JLabel("");
		panel_11.add(thirdDownAllowedLabel);

		JPanel penaltiesForced = new JPanel();
		penaltiesForced.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(penaltiesForced);
		penaltiesForced.setLayout(new BorderLayout(0, 0));

		JLabel lblPenaltiesForced = new JLabel("Penalties Forced");
		lblPenaltiesForced.setHorizontalAlignment(SwingConstants.CENTER);
		lblPenaltiesForced.setFont(new Font("Tahoma", Font.BOLD, 16));
		penaltiesForced.add(lblPenaltiesForced, BorderLayout.NORTH);

		JPanel panel_2 = new JPanel();
		penaltiesForced.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_2.add(panel_12);

		JLabel lblNewLabel_6 = new JLabel("Penalties Forced Reward");
		panel_12.add(lblNewLabel_6);

		penaltyForcedRe = new JSpinner();
		penaltyForcedRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPenaltyForcedRe((int) penaltyForcedRe.getValue());
				updateLabels();
			}
		});
		penaltyForcedRe.setModel(new SpinnerNumberModel(0, 0,
		        MAX_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER, 1));
		panel_12.add(penaltyForcedRe);

		JPanel panel_13 = new JPanel();
		panel_2.add(panel_13);

		JLabel lblNewLabel_7 = new JLabel("Penalty Yardage Forced Reward");
		panel_13.add(lblNewLabel_7);

		PenaltyYardageForcedRe = new JSpinner();
		PenaltyYardageForcedRe.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPenaltyYardageForcedRe((int) PenaltyYardageForcedRe.getValue());
				updateLabels();
			}
		});
		PenaltyYardageForcedRe.setModel(new SpinnerNumberModel(0, 0,
		        MAX_PEN_REWARD_OR_PEN_FOR_PEN_YARDAGE, 1));
		panel_13.add(PenaltyYardageForcedRe);

		JPanel panel_14 = new JPanel();
		panel_2.add(panel_14);

		penaltyForcedLabel = new JLabel("");
		panel_14.add(penaltyForcedLabel);

		JPanel penalties = new JPanel();
		penalties.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(penalties);
		penalties.setLayout(new BorderLayout(0, 0));

		JLabel lblPenalties = new JLabel("Penalties");
		lblPenalties.setHorizontalAlignment(SwingConstants.CENTER);
		lblPenalties.setFont(new Font("Tahoma", Font.BOLD, 16));
		penalties.add(lblPenalties, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		penalties.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);

		JLabel lblPenaltiesAllowedPenalty = new JLabel("Penalties Committed Penalty");
		panel_15.add(lblPenaltiesAllowedPenalty);

		penaltyAllowedPeSpinner = new JSpinner();
		penaltyAllowedPeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPenaltyAllowedPe((int) penaltyAllowedPeSpinner.getValue());
				updateLabels();

			}
		});
		penaltyAllowedPeSpinner.setModel(new SpinnerNumberModel(0,
		        MIN_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER, 0, 1));
		panel_15.add(penaltyAllowedPeSpinner);

		JPanel panel_16 = new JPanel();
		panel_3.add(panel_16);

		JLabel lblPenaltyYardageAllowed = new JLabel("Penalty Yardage Committed Penalty");
		panel_16.add(lblPenaltyYardageAllowed);

		penaltyYardageAllowedPeSpinner = new JSpinner();
		penaltyYardageAllowedPeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPenaltyYardageAllowedPe((int) penaltyYardageAllowedPeSpinner
				        .getValue());
				updateLabels();

			}
		});
		penaltyYardageAllowedPeSpinner.setModel(new SpinnerNumberModel(0,
		        MIN_PEN_REWARD_OR_PEN_FOR_PEN_YARDAGE, 0, 1));
		panel_16.add(penaltyYardageAllowedPeSpinner);

		JPanel panel_17 = new JPanel();
		panel_3.add(panel_17);

		penaltyAllowedLabel = new JLabel("");
		panel_17.add(penaltyAllowedLabel);
		updateLabels();

	}

	private void updateLabels() {

		thirdDownLabel.setText("<html>This team will be awarded "
		        + multiOption.getThirdDownRe() + " points, for every percentage over "
		        + multiOption.getThirdDownTh() + "% they convert on.<br> They will lose "
		        + multiOption.getThirdDownPe() + " points for every percentage under.");

		thirdDownAllowedLabel.setText("<html>This team will be awarded "
		        + multiOption.getThirdDownAllowedRe() + " points, for every percentage under "
		        + multiOption.getThirdDownAllowedTh()
		        + "% they hold an opponent to.<br> They will lose "
		        + multiOption.getThirdDownAllowedPe() + " points for every percentage over.");

		penaltyForcedLabel.setText("<html>This team will be awarded "
		        + multiOption.getPenaltyForcedRe()
		        + " points for every penalty they force.<br>They will be awarded "
		        + multiOption.getPenaltyYardageForcedRe()
		        + " points for every penalty yard they force");

		penaltyAllowedLabel.setText("<html>This team will lose "
		        + multiOption.getPenaltyAllowedPe()
		        + " points for every penalty they commit.<br>They will lose "
		        + multiOption.getPenaltyYardageAllowedPe()
		        + " points for every penalty yard they commit");

	}

	public PenaltiesConversions getThis() {
		return this;
	}

	public void updateSpinners() {

		thirdDownRe.setValue(multiOption.getThirdDownRe());
		thirdDownPe.setValue(multiOption.getThirdDownPe());
		thirdDownTh.setValue(multiOption.getThirdDownTh());

		thirdDownAllowedRe.setValue(multiOption.getThirdDownAllowedRe());
		thirdDownAllowedTh.setValue(multiOption.getThirdDownAllowedTh());
		thirdDownAllowedPe.setValue(multiOption.getThirdDownAllowedPe());

		penaltyForcedRe.setValue(multiOption.getPenaltyForcedRe());
		PenaltyYardageForcedRe.setValue(multiOption.getPenaltyYardageForcedRe());

		penaltyAllowedPeSpinner.setValue(multiOption.getPenaltyAllowedPe());
		penaltyYardageAllowedPeSpinner.setValue(multiOption.getPenaltyYardageAllowedPe());

		updateLabels();

	}

	/**
	 * @return the maxRewardOrThreshold
	 */
	public static int getMaxRewardOrThreshold() {
		return MAX_REWARD_OR_THRESHOLD;
	}

	/**
	 * @return the minReward
	 */
	public static int getMinReward() {
		return MIN_REWARD;
	}

	/**
	 * @return the maxPenRewardOrPen
	 */
	public static int getMaxPenRewardOrPen() {
		return MAX_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER;
	}

	/**
	 * @return the minPenRewardOrPen
	 */
	public static int getMinPenRewardOrPen() {
		return MIN_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER;
	}

	/**
	 * @return the maxPenRewardOrPenForPenNumber
	 */
	public static int getMaxPenRewardOrPenForPenNumber() {
		return MAX_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER;
	}

	/**
	 * @return the minPenRewardOrPenForPenNumber
	 */
	public static int getMinPenRewardOrPenForPenNumber() {
		return MIN_PEN_REWARD_OR_PEN_FOR_PEN_NUMBER;
	}

	/**
	 * @return the maxPenRewardOrPenForPenYardage
	 */
	public static int getMaxPenRewardOrPenForPenYardage() {
		return MAX_PEN_REWARD_OR_PEN_FOR_PEN_YARDAGE;
	}

	/**
	 * @return the minPenRewardOrPenForPenYardage
	 */
	public static int getMinPenRewardOrPenForPenYardage() {
		return MIN_PEN_REWARD_OR_PEN_FOR_PEN_YARDAGE;
	}

}

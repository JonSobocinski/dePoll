package compView;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PointsScoredAllowed extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = -546169564875457940L;
	final static int THRESHOLD_MAX = 255;
	final static int THRESHOLD_MIN = 0;
	final static int THRESHOLD_NEGATIVE = -255;

	private JLabel pointsScoredLabel;
	private JLabel pointsAllowedLabel;
	private MultiOption multiOption;

	private final JSpinner aboveScoredSpinner;
	private final JSpinner belowScoredSpinner;
	private final JSpinner thresholdScoredSpinner;

	private final JSpinner aboveAllowedSpinner;
	private final JSpinner belowAllowedSpinner;
	private final JSpinner thresholdAllowedSpinner;

	/**
	 * Create the panel.
	 * 
	 * @param multiOption
	 */
	public PointsScoredAllowed(final MultiOption multiOption) {
		setBorder(null);
		setLayout(new GridLayout(5, 2, 0, 0));
		this.multiOption = multiOption;

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_8);
		JLabel lblPointsScoredMultiplier = new JLabel("Points Scored Multiplier",
		        SwingConstants.CENTER);
		lblPointsScoredMultiplier.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_8.add(lblPointsScoredMultiplier);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_9);

		JLabel lblPointsAllowedMultiplier = new JLabel("Points Allowed Multiplier",
		        SwingConstants.CENTER);
		lblPointsAllowedMultiplier.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_9.add(lblPointsAllowedMultiplier);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);

		JLabel lblAboveThresholdMultiplier = new JLabel("Above Threshold Multiplier");
		panel.add(lblAboveThresholdMultiplier);

		aboveScoredSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getPointsScoredMult(), THRESHOLD_MIN, THRESHOLD_MAX, 1));

		aboveScoredSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPointsScoredMult((int) aboveScoredSpinner.getValue());
				updatePointsScoredLabel();

			}
		});
		panel.add(aboveScoredSpinner);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1);

		JLabel lblBelowThresholdMultiplier = new JLabel("Below Threshold Multiplier");
		panel_1.add(lblBelowThresholdMultiplier);

		belowAllowedSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getPointsAllowedMult(), THRESHOLD_MIN, THRESHOLD_MAX, 1));

		belowAllowedSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setPointsAllowedMult((int) belowAllowedSpinner.getValue());
				updatePointsAllowedLabel();
			}
		});
		panel_1.add(belowAllowedSpinner);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_2);

		JLabel lblThreshold = new JLabel("Threshold");
		panel_2.add(lblThreshold);

		thresholdScoredSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getPointsScoredThreshold(), THRESHOLD_MIN, THRESHOLD_MAX, 1));

		thresholdScoredSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setPointsScoredThreshold((int) thresholdScoredSpinner.getValue());
				updatePointsScoredLabel();
			}
		});
		panel_2.add(thresholdScoredSpinner);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_3);

		JLabel lblThreshold_1 = new JLabel("Threshold");
		panel_3.add(lblThreshold_1);

		thresholdAllowedSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getPointsAllowedThreshold(), THRESHOLD_MIN, THRESHOLD_MAX, 1));

		thresholdAllowedSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setPointsAllowedThreshold((int) thresholdAllowedSpinner.getValue());
				updatePointsAllowedLabel();
			}
		});
		panel_3.add(thresholdAllowedSpinner);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_4);

		JLabel lblBelowThresholdMultiplier_1 = new JLabel("Below Threshold Penalizer");
		panel_4.add(lblBelowThresholdMultiplier_1);

		belowScoredSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getPointsScoredPen(), THRESHOLD_NEGATIVE, THRESHOLD_MIN, 1));

		belowScoredSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				multiOption.setPointsScoredPen((int) belowScoredSpinner.getValue());
				updatePointsScoredLabel();
			}
		});
		panel_4.add(belowScoredSpinner);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_5);

		JLabel lblAboveThresholdPenalizer = new JLabel("Above Threshold Penalizer");
		panel_5.add(lblAboveThresholdPenalizer);

		aboveAllowedSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getPointsAllowedPen(), THRESHOLD_NEGATIVE, THRESHOLD_MIN, 1));
		aboveAllowedSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setPointsAllowedPen((int) aboveAllowedSpinner.getValue());
				updatePointsAllowedLabel();
			}
		});
		panel_5.add(aboveAllowedSpinner);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_6);

		pointsScoredLabel = new JLabel("<html>This team will be awarded "
		        + multiOption.getPointsScoredMult() + " points for every point over "
		        + multiOption.getPointsScoredThreshold()
		        + " that they score.<br>They will lose " + multiOption.getPointsScoredPen()
		        + " points for every point below " + multiOption.getPointsScoredThreshold()
		        + " that they score.<html>", SwingConstants.CENTER);
		panel_6.add(pointsScoredLabel);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_7);

		pointsAllowedLabel = new JLabel("<html>This team will be awarded "
		        + multiOption.getPointsAllowedMult() + " points for every point below "
		        + multiOption.getPointsAllowedThreshold()
		        + " that they allow.<br>They will lose " + multiOption.getPointsAllowedPen()
		        + " points for every point above " + multiOption.getPointsAllowedThreshold()
		        + " that they allow.<html>", SwingConstants.CENTER);
		panel_7.add(pointsAllowedLabel);
	}

	private void updatePointsScoredLabel() {
		pointsScoredLabel.setText("<html>This team will be awarded "
		        + multiOption.getPointsScoredMult() + " points for every point over "
		        + multiOption.getPointsScoredThreshold()
		        + " that they score.<br>They will lose " + multiOption.getPointsScoredPen()
		        + " points for every point below " + multiOption.getPointsScoredThreshold()
		        + " that they score.<html>");
	}

	private void updatePointsAllowedLabel() {
		pointsAllowedLabel.setText("<html>This team will be awarded "
		        + multiOption.getPointsAllowedMult() + " points for every point below "
		        + multiOption.getPointsAllowedThreshold()
		        + " that they allow.<br>They will lose " + multiOption.getPointsAllowedPen()
		        + " points for every point above " + multiOption.getPointsAllowedThreshold()
		        + " that they allow.<html>");

	}

	/**
	 * @return the thresholdMax
	 */
	public static int getThresholdMax() {
		return THRESHOLD_MAX;
	}

	/**
	 * @return the thresholdMin
	 */
	public static int getThresholdMin() {
		return THRESHOLD_MIN;
	}

	/**
	 * @return the thresholdNegative
	 */
	public static int getThresholdNegative() {
		return THRESHOLD_NEGATIVE;
	}

	public PointsScoredAllowed getThis() {
		return this;
	}

	public void updateSpinners() {

		aboveScoredSpinner.setValue(multiOption.getPointsScoredMult());
		belowScoredSpinner.setValue(multiOption.getPointsScoredPen());
		thresholdScoredSpinner.setValue(multiOption.getPointsScoredThreshold());

		aboveAllowedSpinner.setValue(multiOption.getPointsAllowedPen());
		belowAllowedSpinner.setValue(multiOption.getPointsAllowedMult());
		thresholdAllowedSpinner.setValue(multiOption.getPointsAllowedThreshold());

		updatePointsScoredLabel();
		updatePointsAllowedLabel();
	}
}

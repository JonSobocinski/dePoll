package compView;

import java.awt.BorderLayout;
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

public class ShutoutsBlowouts extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8572675151059822963L;
	MultiOption multiOption;
	private static final int MAX_REWARD = 10000;
	private static final int MIN_PEN = -10000;
	private static final int MAX_BLOWOUT_AMMOUNT = 255;

	private JSpinner win0Spinner;
	private JSpinner win1Spinner;
	private JSpinner win2Spinner;
	private JSpinner win3Spinner;
	private JSpinner win4Spinner;
	private JSpinner win5Spinner;
	private JSpinner win6Spinner;
	private JSpinner win7Spinner;
	private JSpinner win8Spinner;
	private JSpinner win9Spinner;
	private JSpinner win10Spinner;
	private JSpinner win11Spinner;
	private JSpinner win12Spinner;
	private JSpinner win13Spinner;

	private JSpinner loss0Spinner;
	private JSpinner loss1Spinner;
	private JSpinner loss2Spinner;
	private JSpinner loss3Spinner;
	private JSpinner loss4Spinner;
	private JSpinner loss5Spinner;
	private JSpinner loss6Spinner;
	private JSpinner loss7Spinner;
	private JSpinner loss8Spinner;
	private JSpinner loss9Spinner;
	private JSpinner loss10Spinner;
	private JSpinner loss11Spinner;
	private JSpinner loss12Spinner;
	private JSpinner loss13Spinner;

	private JSpinner blowoutAmmountSpinner;
	private JSpinner blowoutRewardSpinner;

	private JSpinner blowoutAmmountPeSpinner;
	private JSpinner blowoutPeSpinner;

	private JSpinner shutoutRewardSpinner;
	private JSpinner shutoutPenSpinner;

	private JLabel beingShutoutExplainLabel;
	private JLabel shutoutExplainLabel;

	/**
	 * Create the panel.
	 * 
	 * @param multiOption
	 */
	public ShutoutsBlowouts(final MultiOption multiOption) {
		this.multiOption = multiOption;

		setLayout(new GridLayout(0, 3, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("Blowouts And Shutouts Reward");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.add(panel_6);
		panel_6.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_6.add(panel_8);

		JLabel shutoutRewardLabel = new JLabel("Shutout Reward");
		panel_8.add(shutoutRewardLabel);

		shutoutRewardSpinner = new JSpinner();
		shutoutRewardSpinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		shutoutRewardSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setShutoutRe((int) shutoutRewardSpinner.getValue());
				updateLabels();
			}
		});
		shutoutRewardSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));
		panel_8.add(shutoutRewardSpinner);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_6.add(panel_9);
		panel_9.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_10 = new JPanel();
		panel_9.add(panel_10);

		JLabel blowoutAmountLabel = new JLabel("Blowout Amount");
		panel_10.add(blowoutAmountLabel);
		blowoutAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);

		blowoutAmmountSpinner = new JSpinner();
		blowoutAmmountSpinner.setModel(new SpinnerNumberModel(0, 0, MAX_BLOWOUT_AMMOUNT, 1));
		blowoutAmmountSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setBlowoutReAmmount((int) blowoutAmmountSpinner.getValue());
				updateLabels();
			}
		});
		panel_10.add(blowoutAmmountSpinner);
		blowoutAmmountSpinner.setModel(new SpinnerNumberModel(0, 0, 255, 1));

		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11);

		JLabel blowoutRewardLabel = new JLabel("Blowout Reward");
		panel_11.add(blowoutRewardLabel);
		blowoutRewardLabel.setHorizontalAlignment(SwingConstants.CENTER);

		blowoutRewardSpinner = new JSpinner();
		blowoutRewardSpinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		blowoutRewardSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setBlowoutRe((int) blowoutRewardSpinner.getValue());
				updateLabels();
			}
		});
		panel_11.add(blowoutRewardSpinner);
		blowoutRewardSpinner.setModel(new SpinnerNumberModel(0, 0, 10000, 1));

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_6.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		shutoutExplainLabel = new JLabel("");
		shutoutExplainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_7.add(shutoutExplainLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblBlowoutsAndShutouts = new JLabel("Blowouts And Shutouts Penalties");
		lblBlowoutsAndShutouts.setHorizontalAlignment(SwingConstants.CENTER);
		lblBlowoutsAndShutouts.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_2.add(lblBlowoutsAndShutouts, BorderLayout.NORTH);

		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.add(panel_5);
		panel_5.setLayout(new GridLayout(3, 1, 0, 0));

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_5.add(panel_12);

		JLabel lblShutoutPenalty = new JLabel("Shutout Penalty");
		panel_12.add(lblShutoutPenalty);

		shutoutPenSpinner = new JSpinner();
		shutoutPenSpinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));

		shutoutPenSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setShutoutPe((int) shutoutPenSpinner.getValue());
				updateLabels();

			}
		});
		panel_12.add(shutoutPenSpinner);

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_5.add(panel_13);
		panel_13.setLayout(new GridLayout(2, 1, 0, 0));

		JPanel panel_14 = new JPanel();
		panel_13.add(panel_14);

		JLabel blowouyAmmoutPen = new JLabel("Blowout Amount");
		blowouyAmmoutPen.setHorizontalAlignment(SwingConstants.CENTER);
		panel_14.add(blowouyAmmoutPen);

		blowoutAmmountPeSpinner = new JSpinner();
		blowoutAmmountPeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setBlowoutPeAmmount((int) blowoutAmmountPeSpinner.getValue());
				updateLabels();
			}
		});
		blowoutAmmountPeSpinner.setModel(new SpinnerNumberModel(0, 0, MAX_BLOWOUT_AMMOUNT, 1));
		panel_14.add(blowoutAmmountPeSpinner);

		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15);

		JLabel lblBlowoutPenalty = new JLabel("Blowout Penalty");
		lblBlowoutPenalty.setHorizontalAlignment(SwingConstants.CENTER);
		panel_15.add(lblBlowoutPenalty);

		blowoutPeSpinner = new JSpinner();
		blowoutPeSpinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		blowoutPeSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setBlowoutPe((int) blowoutPeSpinner.getValue());
				updateLabels();
			}
		});
		blowoutPeSpinner.setModel(new SpinnerNumberModel(0, -10000, 0, 1));
		panel_15.add(blowoutPeSpinner);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_5.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));

		beingShutoutExplainLabel = new JLabel("");
		beingShutoutExplainLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_16.add(beingShutoutExplainLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_2 = new JLabel("Strength Of Schedule");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblNewLabel_2, BorderLayout.NORTH);

		JPanel panel_17 = new JPanel();
		panel_1.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_17.add(panel_18);
		panel_18.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_4 = new JLabel("Beating An XX-Win Team Gets You XX Points");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_18.add(lblNewLabel_4, BorderLayout.NORTH);

		JPanel panel_21 = new JPanel();
		panel_18.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new GridLayout(14, 2, 0, 0));

		JLabel lblNewLabel_6 = new JLabel("13 Win Team");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_6);

		win13Spinner = new JSpinner();
		win13Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win13Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setWin13((int) win13Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win13Spinner);

		JLabel lblNewLabel_7 = new JLabel("12 Win Team");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_7);

		win12Spinner = new JSpinner();
		win12Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win12Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin12((int) win12Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win12Spinner);

		JLabel lblNewLabel_8 = new JLabel("11 Win Team");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_8);

		win11Spinner = new JSpinner();
		win11Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win11Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin11((int) win11Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win11Spinner);

		JLabel lblNewLabel_9 = new JLabel("10 Win Team");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_9);

		win10Spinner = new JSpinner();
		win10Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win10Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin10((int) win10Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win10Spinner);

		JLabel lblNewLabel_10 = new JLabel("9 Win Team");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_10);

		win9Spinner = new JSpinner();
		win9Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win9Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin9((int) win9Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win9Spinner);

		JLabel lblNewLabel_11 = new JLabel("8 Win Team");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_11);

		win8Spinner = new JSpinner();
		win8Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win8Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin8((int) win8Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win8Spinner);

		JLabel lblNewLabel_12 = new JLabel("7 Win Team");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_12);

		win7Spinner = new JSpinner();
		win7Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win7Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin7((int) win7Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win7Spinner);

		JLabel lblNewLabel_13 = new JLabel("6 Win Team");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblNewLabel_13);

		win6Spinner = new JSpinner();
		win6Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win6Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin6((int) win6Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win6Spinner);

		JLabel lblWinTeam = new JLabel("5 Win Team");
		lblWinTeam.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblWinTeam);

		win5Spinner = new JSpinner();
		win5Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win5Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin5((int) win5Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win5Spinner);

		JLabel lblWinTeam_1 = new JLabel("4 Win Team");
		lblWinTeam_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblWinTeam_1);

		win4Spinner = new JSpinner();
		win4Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win4Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin4((int) win4Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win4Spinner);

		JLabel lblWinTeam_2 = new JLabel("3 Win Team");
		lblWinTeam_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblWinTeam_2);

		win3Spinner = new JSpinner();
		win3Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win3Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin9((int) win3Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win3Spinner);

		JLabel lblWinTeam_3 = new JLabel("2 Win Team");
		lblWinTeam_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblWinTeam_3);

		win2Spinner = new JSpinner();
		win2Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win2Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setWin2((int) win2Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win2Spinner);

		JLabel lblWinTeam_4 = new JLabel("1 Win Team");
		lblWinTeam_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblWinTeam_4);

		win1Spinner = new JSpinner();
		win1Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win1Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin1((int) win1Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win1Spinner);

		JLabel lblWinlessTeam = new JLabel("Winless Team");
		lblWinlessTeam.setHorizontalAlignment(SwingConstants.CENTER);
		panel_21.add(lblWinlessTeam);

		win0Spinner = new JSpinner();
		win0Spinner.setModel(new SpinnerNumberModel(0, 0, MAX_REWARD, 1));
		win0Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setWin0((int) win0Spinner.getValue());
				updateLabels();
			}
		});
		panel_21.add(win0Spinner);

		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(new Color(192, 192, 192)));
		panel_17.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_5 = new JLabel("Losing To An XX-Win Team Loses You XX Points");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_19.add(lblNewLabel_5, BorderLayout.NORTH);

		JPanel panel_22 = new JPanel();
		panel_19.add(panel_22, BorderLayout.CENTER);
		panel_22.setLayout(new GridLayout(14, 2, 0, 0));

		JLabel label = new JLabel("13 Win Team");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label);

		loss13Spinner = new JSpinner();
		loss13Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss13Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss13((int) loss13Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss13Spinner);

		JLabel label_1 = new JLabel("12 Win Team");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_1);

		loss12Spinner = new JSpinner();
		loss12Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss12Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss12((int) loss12Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss12Spinner);

		JLabel label_2 = new JLabel("11 Win Team");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_2);

		loss11Spinner = new JSpinner();
		loss11Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss11Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss11((int) loss11Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss11Spinner);

		JLabel label_3 = new JLabel("10 Win Team");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_3);

		loss10Spinner = new JSpinner();
		loss10Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss10Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss10((int) loss10Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss10Spinner);

		JLabel label_4 = new JLabel("9 Win Team");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_4);

		loss9Spinner = new JSpinner();
		loss9Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss9Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss9((int) loss9Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss9Spinner);

		JLabel label_5 = new JLabel("8 Win Team");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_5);

		loss8Spinner = new JSpinner();
		loss8Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss8Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss8((int) loss8Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss8Spinner);

		JLabel label_6 = new JLabel("7 Win Team");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_6);

		loss7Spinner = new JSpinner();
		loss7Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss7Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss7((int) loss7Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss7Spinner);

		JLabel label_7 = new JLabel("6 Win Team");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_7);

		loss6Spinner = new JSpinner();
		loss6Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss6Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss6((int) loss6Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss6Spinner);

		JLabel label_8 = new JLabel("5 Win Team");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_8);

		loss5Spinner = new JSpinner();
		loss5Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss5Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss5((int) loss5Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss5Spinner);

		JLabel label_9 = new JLabel("4 Win Team");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_9);

		loss4Spinner = new JSpinner();
		loss4Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss4Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss4((int) loss4Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss4Spinner);

		JLabel label_10 = new JLabel("3 Win Team");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_10);

		loss3Spinner = new JSpinner();
		loss3Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss3Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss3((int) loss3Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss3Spinner);

		JLabel label_11 = new JLabel("2 Win Team");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_11);

		loss2Spinner = new JSpinner();
		loss2Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss2Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss2((int) loss2Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss2Spinner);

		JLabel label_12 = new JLabel("1 Win Team");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_12);

		loss1Spinner = new JSpinner();
		loss1Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss1Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss1((int) loss1Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss1Spinner);

		JLabel label_13 = new JLabel("Winless Team");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		panel_22.add(label_13);

		loss0Spinner = new JSpinner();
		loss0Spinner.setModel(new SpinnerNumberModel(0, MIN_PEN, 0, 1));
		loss0Spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setLoss0((int) loss0Spinner.getValue());
				updateLabels();
			}
		});
		panel_22.add(loss0Spinner);

		updateLabels();
	}

	protected void updateLabels() {
		beingShutoutExplainLabel
		        .setText("<html> This team will lose "
		                + multiOption.getShutoutPe()
		                + " points for being shutout. <br> They will lose "
		                + multiOption.getBlowoutPe()
		                + " points if the lose a game by more than "
		                + multiOption.getBlowoutPeAmmount()
		                + "<br> An additional conference loss penalty will also be added for either of these scenarios.");

		shutoutExplainLabel
		        .setText("<html> This team will be awarded "
		                + multiOption.getShutoutRe()
		                + " points for a shutout. <br> They will be awarded  "
		                + multiOption.getBlowoutRe()
		                + " points if the win a game by more than "
		                + multiOption.getBlowoutReAmmount()
		                + "<br> An additional conference win bonus will also be added for either of these scenarios.");

	}

	public ShutoutsBlowouts getThis() {
		return this;
	}

	public void updateSpinners() {

		win0Spinner.setValue(multiOption.getWin0());
		win1Spinner.setValue(multiOption.getWin1());
		win2Spinner.setValue(multiOption.getWin2());
		win3Spinner.setValue(multiOption.getWin3());
		win4Spinner.setValue(multiOption.getWin4());
		win5Spinner.setValue(multiOption.getWin5());
		win6Spinner.setValue(multiOption.getWin6());
		win7Spinner.setValue(multiOption.getWin7());
		win8Spinner.setValue(multiOption.getWin8());
		win9Spinner.setValue(multiOption.getWin9());
		win10Spinner.setValue(multiOption.getWin10());
		win11Spinner.setValue(multiOption.getWin11());
		win12Spinner.setValue(multiOption.getWin12());
		win13Spinner.setValue(multiOption.getWin13());

		loss0Spinner.setValue(multiOption.getLoss0());
		loss1Spinner.setValue(multiOption.getLoss1());
		loss2Spinner.setValue(multiOption.getLoss2());
		loss3Spinner.setValue(multiOption.getLoss3());
		loss4Spinner.setValue(multiOption.getLoss4());
		loss5Spinner.setValue(multiOption.getLoss5());
		loss6Spinner.setValue(multiOption.getLoss6());
		loss7Spinner.setValue(multiOption.getLoss7());
		loss8Spinner.setValue(multiOption.getLoss8());
		loss9Spinner.setValue(multiOption.getLoss9());
		loss10Spinner.setValue(multiOption.getLoss10());
		loss11Spinner.setValue(multiOption.getLoss11());
		loss12Spinner.setValue(multiOption.getLoss12());
		loss13Spinner.setValue(multiOption.getLoss13());

		blowoutAmmountSpinner.setValue(multiOption.getBlowoutReAmmount());
		blowoutRewardSpinner.setValue(multiOption.getBlowoutRe());

		blowoutAmmountPeSpinner.setValue(multiOption.getBlowoutPeAmmount());
		blowoutPeSpinner.setValue(multiOption.getBlowoutPe());

		shutoutRewardSpinner.setValue(multiOption.getShutoutRe());
		shutoutPenSpinner.setValue(multiOption.getShutoutPe());

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

	/**
	 * @return the maxBlowoutAmmount
	 */
	public static int getMaxBlowoutAmmount() {
		return MAX_BLOWOUT_AMMOUNT;
	}

}

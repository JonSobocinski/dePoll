package compView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Font;

public class WinLossesPanel extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = 6583277496518655933L;
	private final MultiOption multiOption;
	private static final int WIN_MIN_VALUE = 0;
	private static final int WIN_MAX_VALUE = 1000;
	private static final int LOSS_MAX_VALUE = 0;
	private static final int LOSS_MIN_VALUE = -1000;

	private final JSpinner winSpinner;
	private final JSpinner lossSpinner;
	private final JSpinner homeWinSpinner;
	private final JSpinner homeLossSpinner;
	private final JSpinner awayWinSpinner;
	private final JSpinner awayLossSpinner;
	private final JSpinner accWinSpinner;
	private final JSpinner accLossSpinner;
	private final JSpinner big12WinSpinner;
	private final JSpinner big12LossSpinner;
	private final JSpinner big10WinSpinner;
	private final JSpinner big10LossSpinner;
	private final JSpinner pacWinSpinner;
	private final JSpinner pacLossSpinner;
	private final JSpinner secWinSpinner;
	private final JSpinner secLossSpinner;
	private final JSpinner indeWinSpinner;
	private final JSpinner indeLossSpinner;

	private final JSpinner aacWinSpinner;
	private final JSpinner aacLossSpinner;
	private final JSpinner mwcWinSpinner;
	private final JSpinner mwcLossSpinner;
	private final JSpinner cusaWinSpinner;
	private final JSpinner cusaLossSpinner;
	private final JSpinner sunbeltWinSpinner;
	private final JSpinner sunbeltLossSpinner;
	private final JSpinner fcsWinSpinner;
	private final JSpinner fcsLossSpinner;
	private final JSpinner macWinSpinner;
	private final JSpinner macLossSpinner;

	public WinLossesPanel(final MultiOption multiOption) {
		this.multiOption = multiOption;
		setLayout(new BorderLayout(0, 0));

		JPanel panel_17 = new JPanel();
		add(panel_17, BorderLayout.NORTH);
		panel_17.setLayout(new BorderLayout(0, 0));

		JPanel panel_25 = new JPanel();
		panel_17.add(panel_25, BorderLayout.NORTH);

		Component rigidArea_1 = Box.createRigidArea(new Dimension(50, 100));
		panel_25.add(rigidArea_1);

		JLabel lblWinAndLosses = new JLabel("Wins And Losses Multiplier");
		lblWinAndLosses.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_25.add(lblWinAndLosses);

		JPanel panel_8 = new JPanel();
		panel_17.add(panel_8, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel_8.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblWinMultiplier = new JLabel("Win Multiplier");
		panel.add(lblWinMultiplier, BorderLayout.NORTH);

		winSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getWinMulti(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		winSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setWinMulti((int) winSpinner.getValue());
			}
		});
		panel.add(winSpinner, BorderLayout.SOUTH);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_8.add(horizontalStrut);

		JPanel panel_1 = new JPanel();
		panel_8.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblLossMultiplier = new JLabel("Loss Multiplier");
		panel_1.add(lblLossMultiplier, BorderLayout.NORTH);

		lossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getLossMulti(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		lossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setLossMulti((int) lossSpinner.getValue());

			}
		});
		panel_1.add(lossSpinner);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_8.add(horizontalStrut_1);

		JPanel panel_2 = new JPanel();
		panel_8.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JLabel lblHomeWinMultiplier = new JLabel("Home Win Multiplier");
		panel_2.add(lblHomeWinMultiplier, BorderLayout.NORTH);

		homeWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getHomeWinMulti(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		homeWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setHomeWinMulti((int) homeWinSpinner.getValue());
			}
		});
		panel_2.add(homeWinSpinner, BorderLayout.SOUTH);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_8.add(horizontalStrut_2);

		JPanel panel_3 = new JPanel();
		panel_8.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JLabel lblHomeLossMultiplier = new JLabel("Home Loss Multiplier");
		panel_3.add(lblHomeLossMultiplier, BorderLayout.NORTH);

		homeLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getHomeLossMulti(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		homeLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				multiOption.setHomeLossMulti((int) homeLossSpinner.getValue());

			}
		});
		panel_3.add(homeLossSpinner, BorderLayout.SOUTH);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_8.add(horizontalStrut_3);

		JPanel panel_4 = new JPanel();
		panel_8.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JLabel lblAwayWinMultiplier = new JLabel("Away Win Multiplier");
		panel_4.add(lblAwayWinMultiplier, BorderLayout.NORTH);

		awayWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getAwayWinMulti(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		awayWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setAwayWinMulti((int) awayWinSpinner.getValue());
			}
		});
		panel_4.add(awayWinSpinner);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_8.add(horizontalStrut_4);

		JPanel panel_5 = new JPanel();
		panel_8.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JLabel lblAwayLossMultiplier = new JLabel("Away Loss Multiplier");
		panel_5.add(lblAwayLossMultiplier, BorderLayout.NORTH);

		awayLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getAwayLossMulti(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));

		awayLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setAwayLossMulti((int) awayLossSpinner.getValue());
			}
		});
		panel_5.add(awayLossSpinner, BorderLayout.SOUTH);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_8.add(horizontalStrut_5);

		JPanel panel_6 = new JPanel();
		panel_17.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(new BorderLayout(0, 0));

		JPanel panel_18 = new JPanel();
		panel_9.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component rigidArea = Box.createRigidArea(new Dimension(50, 100));
		panel_18.add(rigidArea);

		JLabel lblConferenceWeightMultiplier = new JLabel("Conference Weight Multiplier");
		lblConferenceWeightMultiplier.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblConferenceWeightMultiplier.setVerticalAlignment(SwingConstants.BOTTOM);
		panel_18.add(lblConferenceWeightMultiplier);

		JPanel panel_7 = new JPanel();
		panel_9.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new BorderLayout(0, 0));

		JPanel panel_23 = new JPanel();
		panel_7.add(panel_23, BorderLayout.NORTH);

		JPanel panel_16 = new JPanel();
		panel_23.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));

		JLabel lblAtlanticCoastConference = new JLabel("ACC (Win | Loss)");

		panel_16.add(lblAtlanticCoastConference, BorderLayout.NORTH);

		accWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getAccMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		accWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setAccMultiWin((int) accWinSpinner.getValue());
			}
		});

		accLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getAccMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		accLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setAacMultiLoose((int) accLossSpinner.getValue());
			}
		});
		panel_16.add(accLossSpinner, BorderLayout.EAST);
		panel_16.add(accWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_23.add(horizontalStrut_6);

		JPanel panel_15 = new JPanel();
		panel_23.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));

		JLabel lblBigConference = new JLabel("Big 12 (Win | Loss)");
		panel_15.add(lblBigConference, BorderLayout.NORTH);

		big12WinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getB12MultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		big12WinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setB12MultiWin((int) big12WinSpinner.getValue());
			}
		});

		big12LossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getB12MultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		big12LossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setB12MultiLoss((int) big12LossSpinner.getValue());

			}
		});
		;
		panel_15.add(big12LossSpinner, BorderLayout.EAST);
		panel_15.add(big12WinSpinner, BorderLayout.WEST);

		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_23.add(horizontalStrut_7);

		JPanel panel_13 = new JPanel();
		panel_23.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));

		JLabel lblBigTenConference = new JLabel("Big Ten (Win | Loss)");
		panel_13.add(lblBigTenConference, BorderLayout.NORTH);

		big10WinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getB10MultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		big10WinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setB10MultiWin((int) big10WinSpinner.getValue());
			}
		});

		big10LossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getB10MultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		big10LossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setB10MultiLoss((int) big10LossSpinner.getValue());
			}
		});
		panel_13.add(big10LossSpinner, BorderLayout.EAST);
		panel_13.add(big10WinSpinner, BorderLayout.WEST);

		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panel_23.add(horizontalStrut_8);

		JPanel panel_19 = new JPanel();
		panel_23.add(panel_19);
		panel_19.setLayout(new BorderLayout(0, 0));

		JLabel lblPacConference = new JLabel("Pac-12 (Win | Loss)");
		panel_19.add(lblPacConference, BorderLayout.NORTH);

		pacWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getPacMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		pacWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPacMultiWin((int) pacWinSpinner.getValue());
			}
		});

		pacLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getPacMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		pacLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setPacMultiLoss((int) pacLossSpinner.getValue());

			}
		});
		panel_19.add(pacLossSpinner, BorderLayout.EAST);
		panel_19.add(pacWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		panel_23.add(horizontalStrut_9);

		JPanel panel_20 = new JPanel();
		panel_23.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		JLabel lblSoutheasternConference = new JLabel("SEC (Win | Loss)");
		panel_20.add(lblSoutheasternConference, BorderLayout.NORTH);

		secWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getSecMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		secWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setSecMultiWin((int) secWinSpinner.getValue());
			}
		});

		secLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getSecMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		secLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setSecMultiLoss((int) secLossSpinner.getValue());

			}
		});
		panel_20.add(secLossSpinner, BorderLayout.EAST);
		panel_20.add(secWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_10 = Box.createHorizontalStrut(20);
		panel_23.add(horizontalStrut_10);

		JPanel panel_26 = new JPanel();
		panel_23.add(panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));

		JLabel lblIndependents = new JLabel("Independents (Win | Loss)");
		panel_26.add(lblIndependents, BorderLayout.NORTH);

		indeWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getIndMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		indeWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				multiOption.setIndMultiWin((int) indeWinSpinner.getValue());

			}
		});

		indeLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getIndMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		indeLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setIndMultiLoss((int) indeLossSpinner.getValue());

			}
		});
		panel_26.add(indeLossSpinner, BorderLayout.EAST);
		panel_26.add(indeWinSpinner, BorderLayout.WEST);

		JPanel panel_24 = new JPanel();
		panel_7.add(panel_24, BorderLayout.SOUTH);

		JPanel panel_14 = new JPanel();
		panel_24.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));

		JLabel lblAmericanAthleticConference = new JLabel("AAC (Win | Loss)");
		panel_14.add(lblAmericanAthleticConference, BorderLayout.NORTH);

		aacWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getAacMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		aacWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setAacMultiWin((int) aacWinSpinner.getValue());
			}
		});

		aacLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getAacMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		aacLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setAacMultiLoose((int) aacLossSpinner.getValue());

			}
		});
		panel_14.add(aacLossSpinner, BorderLayout.EAST);
		panel_14.add(aacWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panel_24.add(horizontalStrut_11);

		JPanel panel_10 = new JPanel();
		panel_24.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));

		JLabel lblMountainWestConference = new JLabel("MWC (Win | Loss)");
		panel_10.add(lblMountainWestConference, BorderLayout.NORTH);

		mwcWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getMwcMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		mwcWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setMwcMultiWin((int) mwcWinSpinner.getValue());
			}
		});

		mwcLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getMwcMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		mwcLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {

				multiOption.setMwcMultiLoose((int) mwcLossSpinner.getValue());

			}
		});
		panel_10.add(mwcLossSpinner, BorderLayout.EAST);
		panel_10.add(mwcWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_12 = Box.createHorizontalStrut(20);
		panel_24.add(horizontalStrut_12);

		JPanel panel_11 = new JPanel();
		panel_24.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));

		JLabel lblMidamericanConference = new JLabel("MAC (Win | Loss)");
		panel_11.add(lblMidamericanConference, BorderLayout.NORTH);

		macWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getMacMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		macWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setMacMultiWin((int) macWinSpinner.getValue());
			}
		});
		panel_11.add(macWinSpinner, BorderLayout.WEST);

		macLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getMacMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		macLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setMacMultiLoss((int) macLossSpinner.getValue());

			}
		});
		panel_11.add(macLossSpinner, BorderLayout.EAST);

		Component horizontalStrut_13 = Box.createHorizontalStrut(20);
		panel_24.add(horizontalStrut_13);

		JPanel panel_12 = new JPanel();
		panel_24.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("CUSA (Win | Loss)");
		panel_12.add(lblNewLabel, BorderLayout.NORTH);

		cusaWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getCusaMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		cusaWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setCusaMultiWin((int) cusaWinSpinner.getValue());
			}
		});

		cusaLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getCusaMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		cusaLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setCusaMultiLoss((int) cusaLossSpinner.getValue());

			}
		});
		panel_12.add(cusaLossSpinner, BorderLayout.EAST);
		panel_12.add(cusaWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_14 = Box.createHorizontalStrut(20);
		panel_24.add(horizontalStrut_14);

		JPanel panel_21 = new JPanel();
		panel_24.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));

		JLabel lblSunBeltConference = new JLabel("Sun Belt (Win | Loss)");
		panel_21.add(lblSunBeltConference, BorderLayout.NORTH);

		sunbeltWinSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getSunBeltMultWin(), WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		sunbeltWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setSunBeltMultWin((int) sunbeltWinSpinner.getValue());
			}
		});

		sunbeltLossSpinner = new JSpinner(new SpinnerNumberModel(
		        multiOption.getSecMultiLoss(), LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		sunbeltLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setSunBeltMultLoss((int) sunbeltLossSpinner.getValue());

			}
		});
		panel_21.add(sunbeltLossSpinner, BorderLayout.EAST);
		panel_21.add(sunbeltWinSpinner, BorderLayout.WEST);

		Component horizontalStrut_15 = Box.createHorizontalStrut(20);
		panel_24.add(horizontalStrut_15);

		JPanel panel_22 = new JPanel();
		panel_24.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));

		JLabel lblFcs = new JLabel("FCS (Win | Loss)");
		panel_22.add(lblFcs, BorderLayout.NORTH);

		fcsWinSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getFcsMultiWin(),
		        WIN_MIN_VALUE, WIN_MAX_VALUE, 1));
		fcsWinSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setFcsMultiWin((int) fcsWinSpinner.getValue());
			}
		});

		fcsLossSpinner = new JSpinner(new SpinnerNumberModel(multiOption.getFcsMultiLoss(),
		        LOSS_MIN_VALUE, LOSS_MAX_VALUE, 1));
		fcsLossSpinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				multiOption.setFcsMultiLoss((int) fcsLossSpinner.getValue());

			}
		});
		panel_22.add(fcsLossSpinner, BorderLayout.EAST);
		panel_22.add(fcsWinSpinner, BorderLayout.WEST);

	}

	/**
	 * @return the winMinValue
	 */
	public static int getWinMinValue() {
		return WIN_MIN_VALUE;
	}

	/**
	 * @return the winMaxValue
	 */
	public static int getWinMaxValue() {
		return WIN_MAX_VALUE;
	}

	/**
	 * @return the lossMaxValue
	 */
	public static int getLossMaxValue() {
		return LOSS_MAX_VALUE;
	}

	/**
	 * @return the lossMinValue
	 */
	public static int getLossMinValue() {
		return LOSS_MIN_VALUE;
	}

	public void updateSpinners() {
		winSpinner.setValue(multiOption.getWinMulti());
		lossSpinner.setValue(multiOption.getLossMulti());
		homeWinSpinner.setValue(multiOption.getHomeWinMulti());
		homeLossSpinner.setValue(multiOption.getHomeLossMulti());
		awayWinSpinner.setValue(multiOption.getAwayWinMulti());
		awayLossSpinner.setValue(multiOption.getAwayLossMulti());
		accWinSpinner.setValue(multiOption.getAccMultiWin());
		accLossSpinner.setValue(multiOption.getAccMultiLoss());
		big12WinSpinner.setValue(multiOption.getB12MultiWin());
		big12LossSpinner.setValue(multiOption.getB12MultiLoss());
		big10WinSpinner.setValue(multiOption.getB10MultiWin());
		big10LossSpinner.setValue(multiOption.getB10MultiLoss());
		pacWinSpinner.setValue(multiOption.getPacMultiWin());
		pacLossSpinner.setValue(multiOption.getPacMultiLoss());
		secWinSpinner.setValue(multiOption.getSecMultiWin());
		secLossSpinner.setValue(multiOption.getSecMultiLoss());
		indeWinSpinner.setValue(multiOption.getIndMultiWin());
		indeLossSpinner.setValue(multiOption.getIndMultiLoss());

		aacWinSpinner.setValue(multiOption.getAacMultiWin());
		aacLossSpinner.setValue(multiOption.getAacMultiLoss());
		mwcWinSpinner.setValue(multiOption.getMwcMultiWin());
		mwcLossSpinner.setValue(multiOption.getMwcMultiLoss());
		cusaWinSpinner.setValue(multiOption.getCusaMultiWin());
		cusaLossSpinner.setValue(multiOption.getCusaMultiLoss());
		sunbeltWinSpinner.setValue(multiOption.getSunBeltMultWin());
		sunbeltLossSpinner.setValue(multiOption.getSunBeltMultLoss());
		fcsWinSpinner.setValue(multiOption.getFcsMultiWin());
		fcsLossSpinner.setValue(multiOption.getFcsMultiLoss());
		macWinSpinner.setValue(multiOption.getMacMultiWin());
		macLossSpinner.setValue(multiOption.getMacMultiLoss());
	}

	public WinLossesPanel getThis() {
		return this;
	}

}

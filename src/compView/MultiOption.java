package compView;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MultiOption extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7616294307214282110L;
	private static final int APROX_POINTS_SCORED = 35;
	private static final int APROX_POINTS_ALLOWED = 35;
	private static final int APPROX_GOOD_BLOWOUT = 21;
	private static final int APROX_YARDAGE = 400;

	private final JPanel contentPanel = new JPanel();
	private JDialog dia;
	private WinLossesPanel wlp;
	private PointsScoredAllowed psa;
	private YardageGainAllowedPanel ygap;
	private TurnoverTimeOfPossesion ttop;
	private PenaltiesConversions pcp;
	private ShutoutsBlowouts sobo;
	private JTabbedPane tabbedPane;

	private int winMulti;
	private int lossMulti;
	private int homeWinMulti;
	private int homeLossMulti;
	private int awayWinMulti;
	private int awayLossMulti;

	private int b12MultiWin;
	private int b10MultiWin;
	private int pacMultiWin;
	private int secMultiWin;
	private int accMultiWin;
	private int indMultiWin;

	private int aacMultiWin;
	private int mwcMultiWin;
	private int cusaMultiWin;
	private int sunBeltMultWin;
	private int macMultiWin;
	private int fcsMultiWin;

	private int b12MultiLoss;
	private int b10MultiLoss;
	private int pacMultiLoss;
	private int secMultiLoss;
	private int accMultiLoss;
	private int indMultiLoss;

	private int aacMultiLoss;
	private int mwcMultiLoss;
	private int cusaMultiLoss;
	private int sunBeltMultLoss;
	private int macMultiLoss;
	private int fcsMultiLoss;

	private int pointsScoredMult;
	private int pointsScoredThreshold;
	private int pointsScoredPen;

	private int pointsAllowedPen;
	private int pointsAllowedThreshold;
	private int pointsAllowedMult;

	private int yardsGainedRe;
	private int yardsGainedTh;
	private int yardsGainedPen;
	private int yardsAllowedRe;
	private int yardsAllowedTh;
	private int yardsAllowedPen;
	private int yardsCarryRe;
	private int yardsCarryTh;
	private int yardsCarryPen;
	private int yardsAllowedCarryRe;
	private int yardsAllowedCarryTh;
	private int yardsAllowedCarryPen;
	private int yardsCatchRe;
	private int yardsCatchTh;
	private int yardsCatchPen;
	private int yardsAllowedCatchRe;
	private int yardsAllowedCatchTh;
	private int yardsAllowedCatchPen;
	private int ypCarryReward;
	private int ypCatchReward;
	private int ypCarryAllowedPen;
	private int ypCatchAllowedPen;

	private int takeAwayMult;
	private int pickMult;
	private int fumbleRecoveryMult;

	private int turnoverPen;
	private int interceptionPen;
	private int fumbleLostPen;

	private int topRe;
	private int topTh;
	private int topPen;

	private int oppTOPRe;
	private int oppTOPTh;
	private int oppTOPPen;

	private int thirdDownRe;
	private int thirdDownTh;
	private int thirdDownPe;

	private int thirdDownAllowedRe;
	private int thirdDownAllowedTh;
	private int thirdDownAllowedPe;

	private int penaltyForcedRe;
	private int penaltyYardageForcedRe;

	private int penaltyAllowedPe;
	private int penaltyYardageAllowedPe;

	private int win0;
	private int win1;
	private int win2;
	private int win3;
	private int win4;
	private int win5;
	private int win6;
	private int win7;
	private int win8;
	private int win9;
	private int win10;
	private int win11;
	private int win12;
	private int win13;

	private int loss0;
	private int loss1;
	private int loss2;
	private int loss3;
	private int loss4;
	private int loss5;
	private int loss6;
	private int loss7;
	private int loss8;
	private int loss9;
	private int loss10;
	private int loss11;
	private int loss12;
	private int loss13;

	private int blowoutReAmmount;
	private int blowoutRe;

	private int blowoutPeAmmount;
	private int blowoutPe;

	private int shutoutRe;
	private int shutoutPe;

	/**
	 * Create the dialog.
	 * 
	 * @param frame
	 */
	public MultiOption(final MainView mv) {
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dia = this;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		{
			JMenuBar menuBar = new JMenuBar();
			getContentPane().add(menuBar, BorderLayout.NORTH);
			{
				JMenu mnFile = new JMenu("File");
				menuBar.add(mnFile);
				{
					JMenuItem mntmSavePreference = new JMenuItem("Save Preference");
					mntmSavePreference.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							String userDir = System.getProperty("user.home");
							JFileChooser fc = new JFileChooser(userDir + "/Desktop");

							fc.setDialogTitle("Save Multiplier Preference");

							int selction = fc.showSaveDialog(null);

							if (selction == JFileChooser.APPROVE_OPTION) {

								File fileToSave = new File(fc.getSelectedFile() + ".txt");
								writePreference(fileToSave);
							}
							else {
								fc.setVisible(false);
							}

						}
					});
					mnFile.add(mntmSavePreference);
				}
				{
					JMenuItem mntmLoadPreference = new JMenuItem("Load Preference");
					mntmLoadPreference.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							FileNameExtensionFilter filter = new FileNameExtensionFilter(
							        ".txt", "txt", "text");
							String userDir = System.getProperty("user.home");
							JFileChooser fc = new JFileChooser(userDir + "/Desktop");
							fc.setFileFilter(filter);
							fc.setDialogTitle("Load Multiplier Preference");
							int selction = fc.showOpenDialog(null);
							if (selction == JFileChooser.APPROVE_OPTION) {
								File fileToLoad = fc.getSelectedFile();
								loadPreference(fileToLoad);

							}
							else {
								fc.setVisible(false);
							}
						}
					});
					mnFile.add(mntmLoadPreference);
				}
			}
		}
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			contentPanel.add(tabbedPane, BorderLayout.CENTER);
			{
				WinLossesPanel panel = new WinLossesPanel(this);
				wlp = panel.getThis();
				tabbedPane.addTab("Wins/Losses", null, panel, null);
			}
			{
				PointsScoredAllowed panel = new PointsScoredAllowed(this);
				psa = panel.getThis();
				tabbedPane.addTab("Points Scored/Allowed", null, panel, null);
			}
			{
				YardageGainAllowedPanel panel = new YardageGainAllowedPanel(this);
				ygap = panel.getThis();
				tabbedPane.addTab("Yards Gained/Allowed", null, panel, null);
			}
			{
				TurnoverTimeOfPossesion panel = new TurnoverTimeOfPossesion(this);
				ttop = panel.getThis();
				tabbedPane.addTab("Turnovers and Time Of Possession", null, panel, null);
			}
			{
				PenaltiesConversions panel = new PenaltiesConversions(this);
				pcp = panel.getThis();
				tabbedPane.addTab("Penalties and Conversions", null, panel, null);
			}
			{
				ShutoutsBlowouts panel = new ShutoutsBlowouts(this);
				sobo = panel.getThis();
				tabbedPane.addTab("Shutouts, Blowouts and SOS", null, panel, null);
			}

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dia.setVisible(false);

					}
				});
				{
					JButton btnNewButton = new JButton("Randomize All Multipliers");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							setRandomMultiplierForAllValues();
						}
					});
					buttonPane.add(btnNewButton);
				}
				{
					JButton btnNewButton = new JButton(
					        "Randomize Multipliers For This Category");
					btnNewButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							randomizeOrClearLocal(tabbedPane.getSelectedIndex(), true);
						}

					});
					buttonPane.add(btnNewButton);
				}
				{
					JButton btnNewButton_1 = new JButton("Generate Rankings");
					btnNewButton_1.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							mv.generateRankings();
							dia.dispose();
						}
					});
					{
						JButton btnNewButton_2 = new JButton("Clear All Multipliers");
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								clearAllRankings();
							}
						});
						buttonPane.add(btnNewButton_2);
					}

					{
						JButton btnNewButton_2 = new JButton(
						        "Clear Multipliers For This Category");
						btnNewButton_2.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								randomizeOrClearLocal(tabbedPane.getSelectedIndex(), false);
							}
						});
						buttonPane.add(btnNewButton_2);
					}

					buttonPane.add(btnNewButton_1);
				}
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dia.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		pack();
		this.setLocationRelativeTo(null);
		this.setTitle("Multiplier Options");

	}

	protected void randomizeOrClearLocal(int tab, boolean randomize) {

		if (tab == 0) {

			if (randomize)
				setRandomWin(new Random());
			else
				clearWinRankings();

		}
		else if (tab == 1) {
			if (randomize)
				setRandomPoints(new Random());
			else
				clearPointsRankings();

		}
		else if (tab == 2) {
			if (randomize)
				setRandomYard(new Random());
			else
				clearYardRankings();

		}
		else if (tab == 3) {
			if (randomize)
				setRandomTurnovers(new Random());
			else
				clearTurnoversTOPRankings();

		}
		else if (tab == 4) {
			if (randomize)
				setRandomThirdDown(new Random());
			else
				clearThirdDownRankings();
		}
		else if (tab == 5) {
			if (randomize)
				setRandomShutouts(new Random());
			else
				clearShutoutsRankings();

		}
		else
			System.out.println("TAB NEEDS TO BE ADDED");

	}

	protected void loadPreference(File fileToLoad) {

		try {
			Scanner scanner = new Scanner(fileToLoad);
			String[] input = scanner.next().split(",");

			winMulti = Integer.valueOf(input[0]);
			lossMulti = Integer.valueOf(input[1]);
			homeWinMulti = Integer.valueOf(input[2]);
			homeLossMulti = Integer.valueOf(input[3]);
			awayWinMulti = Integer.valueOf(input[4]);
			awayLossMulti = Integer.valueOf(input[5]);

			b12MultiWin = Integer.valueOf(input[6]);
			b10MultiWin = Integer.valueOf(input[7]);
			pacMultiWin = Integer.valueOf(input[8]);
			secMultiWin = Integer.valueOf(input[9]);
			accMultiWin = Integer.valueOf(input[10]);
			indMultiWin = Integer.valueOf(input[11]);

			aacMultiWin = Integer.valueOf(input[12]);
			mwcMultiWin = Integer.valueOf(input[13]);
			cusaMultiWin = Integer.valueOf(input[14]);
			sunBeltMultWin = Integer.valueOf(input[15]);
			macMultiWin = Integer.valueOf(input[16]);
			fcsMultiWin = Integer.valueOf(input[17]);
			b12MultiLoss = Integer.valueOf(input[18]);
			b10MultiLoss = Integer.valueOf(input[19]);
			pacMultiLoss = Integer.valueOf(input[20]);
			secMultiLoss = Integer.valueOf(input[21]);
			accMultiLoss = Integer.valueOf(input[22]);
			indMultiLoss = Integer.valueOf(input[23]);

			aacMultiLoss = Integer.valueOf(input[24]);
			mwcMultiLoss = Integer.valueOf(input[25]);
			cusaMultiLoss = Integer.valueOf(input[26]);
			sunBeltMultLoss = Integer.valueOf(input[27]);
			macMultiLoss = Integer.valueOf(input[28]);
			fcsMultiLoss = Integer.valueOf(input[29]);

			pointsScoredMult = Integer.valueOf(input[30]);
			pointsScoredThreshold = Integer.valueOf(input[31]);
			pointsScoredPen = Integer.valueOf(input[32]);
			pointsAllowedPen = Integer.valueOf(input[33]);
			pointsAllowedThreshold = Integer.valueOf(input[34]);
			pointsAllowedMult = Integer.valueOf(input[35]);

			yardsGainedRe = Integer.valueOf(input[36]);
			yardsGainedTh = Integer.valueOf(input[37]);
			yardsGainedPen = Integer.valueOf(input[38]);
			yardsAllowedRe = Integer.valueOf(input[39]);
			yardsAllowedTh = Integer.valueOf(input[40]);
			yardsAllowedPen = Integer.valueOf(input[41]);
			yardsCarryRe = Integer.valueOf(input[42]);
			yardsCarryTh = Integer.valueOf(input[43]);
			yardsCarryPen = Integer.valueOf(input[44]);
			yardsAllowedCarryRe = Integer.valueOf(input[45]);
			yardsAllowedCarryTh = Integer.valueOf(input[46]);
			yardsAllowedCarryPen = Integer.valueOf(input[47]);
			yardsCatchRe = Integer.valueOf(input[48]);
			yardsCatchTh = Integer.valueOf(input[49]);
			yardsCatchPen = Integer.valueOf(input[50]);
			yardsAllowedCatchRe = Integer.valueOf(input[51]);
			yardsAllowedCatchTh = Integer.valueOf(input[52]);
			yardsAllowedCatchPen = Integer.valueOf(input[53]);
			ypCarryReward = Integer.valueOf(input[54]);
			ypCatchReward = Integer.valueOf(input[55]);
			ypCarryAllowedPen = Integer.valueOf(input[56]);
			ypCatchAllowedPen = Integer.valueOf(input[57]);

			takeAwayMult = Integer.valueOf(input[58]);
			pickMult = Integer.valueOf(input[59]);
			fumbleRecoveryMult = Integer.valueOf(input[60]);

			turnoverPen = Integer.valueOf(input[61]);
			interceptionPen = Integer.valueOf(input[62]);
			fumbleLostPen = Integer.valueOf(input[63]);

			topRe = Integer.valueOf(input[64]);
			topTh = Integer.valueOf(input[65]);
			topPen = Integer.valueOf(input[66]);

			oppTOPRe = Integer.valueOf(input[67]);
			oppTOPTh = Integer.valueOf(input[68]);
			oppTOPPen = Integer.valueOf(input[69]);

			thirdDownRe = Integer.valueOf(input[70]);
			thirdDownTh = Integer.valueOf(input[71]);
			thirdDownPe = Integer.valueOf(input[72]);

			thirdDownAllowedRe = Integer.valueOf(input[73]);
			thirdDownAllowedTh = Integer.valueOf(input[74]);
			thirdDownAllowedPe = Integer.valueOf(input[75]);

			penaltyForcedRe = Integer.valueOf(input[76]);
			penaltyYardageForcedRe = Integer.valueOf(input[77]);

			penaltyAllowedPe = Integer.valueOf(input[78]);
			penaltyYardageAllowedPe = Integer.valueOf(input[79]);

			win0 = Integer.valueOf(input[80]);
			win1 = Integer.valueOf(input[81]);
			win2 = Integer.valueOf(input[82]);
			win3 = Integer.valueOf(input[83]);
			win4 = Integer.valueOf(input[84]);
			win5 = Integer.valueOf(input[85]);
			win6 = Integer.valueOf(input[86]);
			win7 = Integer.valueOf(input[87]);
			win8 = Integer.valueOf(input[88]);
			win9 = Integer.valueOf(input[89]);
			win10 = Integer.valueOf(input[90]);
			win11 = Integer.valueOf(input[91]);
			win12 = Integer.valueOf(input[92]);
			win13 = Integer.valueOf(input[93]);

			loss0 = Integer.valueOf(input[94]);
			loss1 = Integer.valueOf(input[95]);
			loss2 = Integer.valueOf(input[96]);
			loss3 = Integer.valueOf(input[97]);
			loss4 = Integer.valueOf(input[98]);
			loss5 = Integer.valueOf(input[99]);
			loss6 = Integer.valueOf(input[100]);
			loss7 = Integer.valueOf(input[101]);
			loss8 = Integer.valueOf(input[102]);
			loss9 = Integer.valueOf(input[103]);
			loss10 = Integer.valueOf(input[104]);
			loss11 = Integer.valueOf(input[105]);
			loss12 = Integer.valueOf(input[106]);
			loss13 = Integer.valueOf(input[107]);

			blowoutReAmmount = Integer.valueOf(input[108]);
			blowoutRe = Integer.valueOf(input[109]);

			blowoutPeAmmount = Integer.valueOf(input[110]);
			blowoutPe = Integer.valueOf(input[111]);

			shutoutRe = Integer.valueOf(input[112]);
			shutoutPe = Integer.valueOf(input[113]);

			wlp.updateSpinners();
			psa.updateSpinners();
			ygap.updateSpinners();
			ttop.updateSpinners();
			pcp.updateSpinners();
			sobo.updateSpinners();

			scanner.close();

		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(this, "INVALID SAVE FILE SELECTED", "INVALID FILE",
			        JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		}

	}

	protected void writePreference(File fileToSave) {

		try {
			PrintWriter writer = new PrintWriter(new FileOutputStream(fileToSave));

			writer.write(winMulti + ",");
			writer.write(lossMulti + ",");
			writer.write(homeWinMulti + ",");
			writer.write(homeLossMulti + ",");
			writer.write(awayWinMulti + ",");
			writer.write(awayLossMulti + ",");

			writer.write(b12MultiWin + ",");
			writer.write(b10MultiWin + ",");
			writer.write(pacMultiWin + ",");
			writer.write(secMultiWin + ",");
			writer.write(accMultiWin + ",");
			writer.write(indMultiWin + ",");
			writer.write(aacMultiWin + ",");
			writer.write(mwcMultiWin + ",");
			writer.write(cusaMultiWin + ",");
			writer.write(sunBeltMultWin + ",");
			writer.write(macMultiWin + ",");
			writer.write(fcsMultiWin + ",");

			writer.write(b12MultiLoss + ",");
			writer.write(b10MultiLoss + ",");
			writer.write(pacMultiLoss + ",");
			writer.write(secMultiLoss + ",");
			writer.write(accMultiLoss + ",");
			writer.write(indMultiLoss + ",");

			writer.write(aacMultiLoss + ",");
			writer.write(mwcMultiLoss + ",");
			writer.write(cusaMultiLoss + ",");
			writer.write(sunBeltMultLoss + ",");
			writer.write(macMultiLoss + ",");
			writer.write(fcsMultiLoss + ",");

			writer.write(pointsScoredMult + ",");
			writer.write(pointsScoredThreshold + ",");
			writer.write(pointsScoredPen + ",");

			writer.write(pointsAllowedPen + ",");
			writer.write(pointsAllowedThreshold + ",");
			writer.write(pointsAllowedMult + ",");

			writer.write(yardsGainedRe + ",");
			writer.write(yardsGainedTh + ",");
			writer.write(yardsGainedPen + ",");
			writer.write(yardsAllowedRe + ",");
			writer.write(yardsAllowedTh + ",");
			writer.write(yardsAllowedPen + ",");
			writer.write(yardsCarryRe + ",");
			writer.write(yardsCarryTh + ",");
			writer.write(yardsCarryPen + ",");
			writer.write(yardsAllowedCarryRe + ",");
			writer.write(yardsAllowedCarryTh + ",");
			writer.write(yardsAllowedCarryPen + ",");
			writer.write(yardsCatchRe + ",");
			writer.write(yardsCatchTh + ",");
			writer.write(yardsCatchPen + ",");
			writer.write(yardsAllowedCatchRe + ",");
			writer.write(yardsAllowedCatchTh + ",");
			writer.write(yardsAllowedCatchPen + ",");
			writer.write(ypCarryReward + ",");
			writer.write(ypCatchReward + ",");
			writer.write(ypCarryAllowedPen + ",");
			writer.write(ypCatchAllowedPen + ",");

			writer.write(takeAwayMult + ",");
			writer.write(pickMult + ",");
			writer.write(fumbleRecoveryMult + ",");

			writer.write(turnoverPen + ",");
			writer.write(interceptionPen + ",");
			writer.write(fumbleLostPen + ",");

			writer.write(topRe + ",");
			writer.write(topTh + ",");
			writer.write(topPen + ",");

			writer.write(oppTOPRe + ",");
			writer.write(oppTOPTh + ",");
			writer.write(oppTOPPen + ",");

			writer.write(thirdDownRe + ",");
			writer.write(thirdDownTh + ",");
			writer.write(thirdDownPe + ",");

			writer.write(thirdDownAllowedRe + ",");
			writer.write(thirdDownAllowedTh + ",");
			writer.write(thirdDownAllowedPe + ",");

			writer.write(penaltyForcedRe + ",");
			writer.write(penaltyYardageForcedRe + ",");

			writer.write(penaltyAllowedPe + ",");
			writer.write(penaltyYardageAllowedPe + ",");

			writer.write(win0 + ",");
			writer.write(win1 + ",");
			writer.write(win2 + ",");
			writer.write(win3 + ",");
			writer.write(win4 + ",");
			writer.write(win5 + ",");
			writer.write(win6 + ",");
			writer.write(win7 + ",");
			writer.write(win8 + ",");
			writer.write(win9 + ",");
			writer.write(win10 + ",");
			writer.write(win11 + ",");
			writer.write(win12 + ",");
			writer.write(win13 + ",");

			writer.write(loss0 + ",");
			writer.write(loss1 + ",");
			writer.write(loss2 + ",");
			writer.write(loss3 + ",");
			writer.write(loss4 + ",");
			writer.write(loss5 + ",");
			writer.write(loss6 + ",");
			writer.write(loss7 + ",");
			writer.write(loss8 + ",");
			writer.write(loss9 + ",");
			writer.write(loss10 + ",");
			writer.write(loss11 + ",");
			writer.write(loss12 + ",");
			writer.write(loss13 + ",");

			writer.write(blowoutReAmmount + ",");
			writer.write(blowoutRe + ",");

			writer.write(blowoutPeAmmount + ",");
			writer.write(blowoutPe + ",");

			writer.write(shutoutRe + ",");
			writer.write(shutoutPe + ",");

			writer.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void clearAllRankings() {

		clearWinRankings();
		clearPointsRankings();
		clearYardRankings();
		clearTurnoversTOPRankings();
		clearThirdDownRankings();
		clearShutoutsRankings();

	}

	private void clearShutoutsRankings() {
		win0 = 0;
		win1 = 0;
		win2 = 0;
		win3 = 0;
		win4 = 0;
		win5 = 0;
		win6 = 0;
		win7 = 0;
		win8 = 0;
		win9 = 0;
		win10 = 0;
		win11 = 0;
		win12 = 0;
		win13 = 0;

		loss0 = 0;
		loss1 = 0;
		loss2 = 0;
		loss3 = 0;
		loss4 = 0;
		loss5 = 0;
		loss6 = 0;
		loss7 = 0;
		loss8 = 0;
		loss9 = 0;
		loss10 = 0;
		loss11 = 0;
		loss12 = 0;
		loss13 = 0;

		blowoutReAmmount = 0;
		blowoutRe = 0;

		blowoutPeAmmount = 0;
		blowoutPe = 0;

		shutoutRe = 0;
		shutoutPe = 0;

		sobo.updateSpinners();

	}

	private void clearThirdDownRankings() {
		thirdDownRe = 0;
		thirdDownTh = 0;
		thirdDownPe = 0;

		thirdDownAllowedRe = 0;
		thirdDownAllowedTh = 0;
		thirdDownAllowedPe = 0;

		penaltyForcedRe = 0;
		penaltyYardageForcedRe = 0;

		penaltyAllowedPe = 0;
		penaltyYardageAllowedPe = 0;

		pcp.updateSpinners();

	}

	private void clearTurnoversTOPRankings() {

		takeAwayMult = 0;
		pickMult = 0;
		fumbleRecoveryMult = 0;

		turnoverPen = 0;
		interceptionPen = 0;
		fumbleLostPen = 0;

		topRe = 0;
		topTh = 0;
		topPen = 0;

		oppTOPRe = 0;
		oppTOPTh = 0;
		oppTOPPen = 0;

		ttop.updateSpinners();

	}

	private void clearYardRankings() {

		yardsGainedRe = 0;
		yardsGainedTh = 0;
		yardsGainedPen = 0;
		yardsAllowedRe = 0;
		yardsAllowedTh = 0;
		yardsAllowedPen = 0;
		yardsCarryRe = 0;
		yardsCarryTh = 0;
		yardsCarryPen = 0;
		yardsAllowedCarryRe = 0;
		yardsAllowedCarryTh = 0;
		yardsAllowedCarryPen = 0;
		yardsCatchRe = 0;
		yardsCatchTh = 0;
		yardsCatchPen = 0;
		yardsAllowedCatchRe = 0;
		yardsAllowedCatchTh = 0;
		yardsAllowedCatchPen = 0;
		ypCarryReward = 0;
		ypCatchReward = 0;
		ypCarryAllowedPen = 0;
		ypCatchAllowedPen = 0;

		ygap.updateSpinners();

	}

	private void clearPointsRankings() {
		pointsScoredMult = 0;
		pointsScoredThreshold = 0;
		pointsScoredPen = 0;
		pointsAllowedPen = 0;
		pointsAllowedThreshold = 0;
		pointsAllowedMult = 0;

		psa.updateSpinners();

	}

	private void clearWinRankings() {
		winMulti = 0;
		lossMulti = 0;
		homeWinMulti = 0;
		homeLossMulti = 0;
		awayWinMulti = 0;
		awayLossMulti = 0;

		b12MultiWin = 0;
		b10MultiWin = 0;
		pacMultiWin = 0;
		secMultiWin = 0;
		accMultiWin = 0;
		indMultiWin = 0;

		aacMultiWin = 0;
		mwcMultiWin = 0;
		cusaMultiWin = 0;
		sunBeltMultWin = 0;
		macMultiWin = 0;
		fcsMultiWin = 0;
		b12MultiLoss = 0;
		b10MultiLoss = 0;
		pacMultiLoss = 0;
		secMultiLoss = 0;
		accMultiLoss = 0;
		indMultiLoss = 0;

		aacMultiLoss = 0;
		mwcMultiLoss = 0;
		cusaMultiLoss = 0;
		sunBeltMultLoss = 0;
		macMultiLoss = 0;
		fcsMultiLoss = 0;

		wlp.updateSpinners();

	}

	protected void setRandomMultiplierForAllValues() {
		Random rand = new Random();
		setRandomWin(rand);
		setRandomPoints(rand);
		setRandomYard(rand);
		setRandomTurnovers(rand);
		setRandomThirdDown(rand);
		setRandomShutouts(rand);

	}

	private void setRandomShutouts(Random rand) {

		win0 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win1 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win2 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win3 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win4 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win5 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win6 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win7 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win8 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win9 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win10 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win11 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win12 = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		win13 = rand.nextInt(ShutoutsBlowouts.getMaxReward());

		loss0 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss1 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss2 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss3 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss4 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss5 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss6 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss7 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss8 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss9 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss10 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss11 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss12 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();
		loss13 = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();

		blowoutReAmmount = rand.nextInt(APPROX_GOOD_BLOWOUT) + APPROX_GOOD_BLOWOUT;
		blowoutRe = rand.nextInt(ShutoutsBlowouts.getMaxReward());

		blowoutPeAmmount = rand.nextInt(APPROX_GOOD_BLOWOUT) + APPROX_GOOD_BLOWOUT;
		blowoutPe = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();

		shutoutRe = rand.nextInt(ShutoutsBlowouts.getMaxReward());
		shutoutPe = rand.nextInt(Math.abs(ShutoutsBlowouts.getMinPen()))
		        + ShutoutsBlowouts.getMinPen();

		sobo.updateSpinners();

	}

	private void setRandomThirdDown(Random rand) {
		thirdDownRe = rand.nextInt(PenaltiesConversions.getMaxRewardOrThreshold());
		thirdDownTh = rand.nextInt(PenaltiesConversions.getMaxRewardOrThreshold());
		thirdDownPe = rand.nextInt(Math.abs(PenaltiesConversions.getMinReward()))
		        + PenaltiesConversions.getMinReward();

		thirdDownAllowedRe = rand.nextInt(PenaltiesConversions.getMaxRewardOrThreshold());
		thirdDownAllowedTh = rand.nextInt(PenaltiesConversions.getMaxRewardOrThreshold());
		thirdDownAllowedPe = rand.nextInt(Math.abs(PenaltiesConversions.getMinReward()))
		        + PenaltiesConversions.getMinReward();

		penaltyForcedRe = rand.nextInt(PenaltiesConversions.getMaxPenRewardOrPen());
		penaltyYardageForcedRe = rand.nextInt(PenaltiesConversions
		        .getMaxPenRewardOrPenForPenYardage());

		penaltyAllowedPe = rand.nextInt(Math.abs(PenaltiesConversions.getMinPenRewardOrPen()))
		        + PenaltiesConversions.getMinPenRewardOrPen();
		penaltyYardageAllowedPe = rand.nextInt(Math.abs(PenaltiesConversions
		        .getMinPenRewardOrPenForPenYardage()))
		        + PenaltiesConversions.getMinPenRewardOrPenForPenYardage();

		pcp.updateSpinners();

	}

	private void setRandomWin(Random rand) {
		winMulti = rand.nextInt(WinLossesPanel.getWinMaxValue());

		lossMulti = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		lossMulti = lossMulti + WinLossesPanel.getLossMinValue();

		homeWinMulti = rand.nextInt(WinLossesPanel.getWinMaxValue());
		homeLossMulti = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		homeLossMulti = homeLossMulti + WinLossesPanel.getLossMinValue();

		awayWinMulti = rand.nextInt(WinLossesPanel.getWinMaxValue());
		awayLossMulti = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		awayLossMulti = awayLossMulti + WinLossesPanel.getLossMinValue();

		b12MultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		b10MultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		pacMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		secMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		accMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		indMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());

		aacMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		mwcMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		cusaMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		sunBeltMultWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		macMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());
		fcsMultiWin = rand.nextInt(WinLossesPanel.getWinMaxValue());

		b12MultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		b12MultiLoss = b12MultiLoss + WinLossesPanel.getLossMinValue();

		b10MultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		b10MultiLoss = b10MultiLoss + WinLossesPanel.getLossMinValue();

		pacMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		pacMultiLoss = pacMultiLoss + WinLossesPanel.getLossMinValue();

		secMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		secMultiLoss = secMultiLoss + WinLossesPanel.getLossMinValue();

		accMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		accMultiLoss = accMultiLoss + WinLossesPanel.getLossMinValue();

		indMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		indMultiLoss = indMultiLoss + WinLossesPanel.getLossMinValue();

		aacMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		aacMultiLoss = aacMultiLoss + WinLossesPanel.getLossMinValue();

		mwcMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		mwcMultiLoss = mwcMultiLoss + WinLossesPanel.getLossMinValue();

		cusaMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		cusaMultiLoss = cusaMultiLoss + WinLossesPanel.getLossMinValue();

		sunBeltMultLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		sunBeltMultLoss = sunBeltMultLoss + WinLossesPanel.getLossMinValue();

		macMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		macMultiLoss = macMultiLoss + WinLossesPanel.getLossMinValue();

		fcsMultiLoss = rand.nextInt(Math.abs(WinLossesPanel.getLossMinValue()));
		fcsMultiLoss = fcsMultiLoss + WinLossesPanel.getLossMinValue();

		wlp.updateSpinners();

	}

	private void setRandomPoints(Random rand) {
		pointsScoredMult = rand.nextInt(PointsScoredAllowed.getThresholdMax());
		pointsScoredThreshold = rand.nextInt(APROX_POINTS_SCORED);
		pointsScoredPen = rand.nextInt(Math.abs(PointsScoredAllowed.getThresholdNegative()));
		pointsScoredPen = pointsScoredPen + PointsScoredAllowed.getThresholdNegative();

		pointsAllowedMult = rand.nextInt(PointsScoredAllowed.getThresholdMax());
		pointsAllowedThreshold = rand.nextInt(APROX_POINTS_ALLOWED);
		pointsAllowedPen = rand.nextInt(Math.abs(PointsScoredAllowed.getThresholdNegative()));
		pointsAllowedPen = pointsAllowedPen + PointsScoredAllowed.getThresholdNegative();

		psa.updateSpinners();

	}

	private void setRandomYard(Random rand) {

		yardsGainedRe = rand.nextInt(YardageGainAllowedPanel.getRewardMax());
		yardsGainedTh = rand.nextInt(APROX_YARDAGE);
		yardsGainedPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getPenMin()))
		        + YardageGainAllowedPanel.getPenMin();

		yardsAllowedRe = rand.nextInt(YardageGainAllowedPanel.getRewardMax());
		yardsAllowedTh = rand.nextInt(APROX_YARDAGE);
		yardsAllowedPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getPenMin()))
		        + YardageGainAllowedPanel.getPenMin();

		yardsCarryRe = rand.nextInt(YardageGainAllowedPanel.getRewardMax());
		yardsCarryTh = rand.nextInt(APROX_YARDAGE);
		yardsCarryPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getPenMin()))
		        + YardageGainAllowedPanel.getPenMin();

		yardsAllowedCarryRe = rand.nextInt(YardageGainAllowedPanel.getRewardMax());
		yardsAllowedCarryTh = rand.nextInt(APROX_YARDAGE);
		yardsAllowedCarryPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getPenMin()))
		        + YardageGainAllowedPanel.getPenMin();

		yardsCatchRe = rand.nextInt(YardageGainAllowedPanel.getRewardMax());
		yardsCatchTh = rand.nextInt(APROX_YARDAGE);
		yardsCatchPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getPenMin()))
		        + YardageGainAllowedPanel.getPenMin();

		yardsAllowedCatchRe = rand.nextInt(YardageGainAllowedPanel.getRewardMax());
		yardsAllowedCatchTh = rand.nextInt(APROX_YARDAGE);
		yardsAllowedCatchPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getPenMin()))
		        + YardageGainAllowedPanel.getPenMin();

		ypCarryReward = rand.nextInt(YardageGainAllowedPanel.getYpcRewardMax());
		ypCatchReward = rand.nextInt(YardageGainAllowedPanel.getYpcRewardMax());

		ypCarryAllowedPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getYpcaPenMin()))
		        + YardageGainAllowedPanel.getYpcaPenMin();
		ypCatchAllowedPen = rand.nextInt(Math.abs(YardageGainAllowedPanel.getYpcaPenMin()))
		        + YardageGainAllowedPanel.getYpcaPenMin();

		ygap.updateSpinners();

	}

	private void setRandomTurnovers(Random rand) {

		takeAwayMult = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());
		pickMult = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());
		fumbleRecoveryMult = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());

		turnoverPen = rand.nextInt(Math.abs(TurnoverTimeOfPossesion.getMinPen()))
		        + TurnoverTimeOfPossesion.getMinPen();
		interceptionPen = rand.nextInt(Math.abs(TurnoverTimeOfPossesion.getMinPen()))
		        + TurnoverTimeOfPossesion.getMinPen();
		fumbleLostPen = rand.nextInt(Math.abs(TurnoverTimeOfPossesion.getMinPen()))
		        + TurnoverTimeOfPossesion.getMinPen();

		topRe = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());
		topTh = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());
		topPen = rand.nextInt(Math.abs(TurnoverTimeOfPossesion.getMinPen()))
		        + TurnoverTimeOfPossesion.getMinPen();

		oppTOPRe = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());
		oppTOPTh = rand.nextInt(TurnoverTimeOfPossesion.getMaxReward());
		oppTOPPen = rand.nextInt(Math.abs(TurnoverTimeOfPossesion.getMinPen()))
		        + TurnoverTimeOfPossesion.getMinPen();

		ttop.updateSpinners();

	}

	public void makeVisible() {
		dia.setVisible(true);
	}

	/**
	 * @return the winMulti
	 */
	public int getWinMulti() {
		return winMulti;
	}

	/**
	 * @param winMulti
	 *            the winMulti to set
	 */
	public void setWinMulti(int winMulti) {
		this.winMulti = winMulti;
	}

	/**
	 * @return the lossMulti
	 */
	public int getLossMulti() {
		return lossMulti;
	}

	/**
	 * @param lossMulti
	 *            the lossMulti to set
	 */
	public void setLossMulti(int lossMulti) {
		this.lossMulti = lossMulti;
	}

	/**
	 * @return the homeWinMulti
	 */
	public int getHomeWinMulti() {
		return homeWinMulti;
	}

	/**
	 * @param homeWinMulti
	 *            the homeWinMulti to set
	 */
	public void setHomeWinMulti(int homeWinMulti) {
		this.homeWinMulti = homeWinMulti;
	}

	/**
	 * @return the homeLossMulti
	 */
	public int getHomeLossMulti() {
		return homeLossMulti;
	}

	/**
	 * @param homeLossMulti
	 *            the homeLossMulti to set
	 */
	public void setHomeLossMulti(int homeLossMulti) {
		this.homeLossMulti = homeLossMulti;
	}

	/**
	 * @return the awayWinMulti
	 */
	public int getAwayWinMulti() {
		return awayWinMulti;
	}

	/**
	 * @param awayWinMulti
	 *            the awayWinMulti to set
	 */
	public void setAwayWinMulti(int awayWinMulti) {
		this.awayWinMulti = awayWinMulti;
	}

	/**
	 * @return the awayLossMulti
	 */
	public int getAwayLossMulti() {
		return awayLossMulti;
	}

	/**
	 * @param awayLossMulti
	 *            the awayLossMulti to set
	 */
	public void setAwayLossMulti(int awayLossMulti) {
		this.awayLossMulti = awayLossMulti;
	}

	/**
	 * @return the b12MultiWin
	 */
	public int getB12MultiWin() {
		return b12MultiWin;
	}

	/**
	 * @return the b10MultiWin
	 */
	public int getB10MultiWin() {
		return b10MultiWin;
	}

	/**
	 * @return the pacMultiWin
	 */
	public int getPacMultiWin() {
		return pacMultiWin;
	}

	/**
	 * @return the secMultiWin
	 */
	public int getSecMultiWin() {
		return secMultiWin;
	}

	/**
	 * @return the accMultiWin
	 */
	public int getAccMultiWin() {
		return accMultiWin;
	}

	/**
	 * @return the indMultiWin
	 */
	public int getIndMultiWin() {
		return indMultiWin;
	}

	/**
	 * @return the aacMultiWin
	 */
	public int getAacMultiWin() {
		return aacMultiWin;
	}

	/**
	 * @return the mwcMultiWin
	 */
	public int getMwcMultiWin() {
		return mwcMultiWin;
	}

	/**
	 * @return the cusaMultiWin
	 */
	public int getCusaMultiWin() {
		return cusaMultiWin;
	}

	/**
	 * @return the sunBeltMultWin
	 */
	public int getSunBeltMultWin() {
		return sunBeltMultWin;
	}

	/**
	 * @return the macMultiWin
	 */
	public int getMacMultiWin() {
		return macMultiWin;
	}

	/**
	 * @return the fcsMultiWin
	 */
	public int getFcsMultiWin() {
		return fcsMultiWin;
	}

	/**
	 * @return the contentPanel
	 */
	public JPanel getContentPanel() {
		return contentPanel;
	}

	/**
	 * @param b12MultiWin
	 *            the b12MultiWin to set
	 */
	public void setB12MultiWin(int b12MultiWin) {
		this.b12MultiWin = b12MultiWin;
	}

	/**
	 * @param b10MultiWin
	 *            the b10MultiWin to set
	 */
	public void setB10MultiWin(int b10MultiWin) {
		this.b10MultiWin = b10MultiWin;
	}

	/**
	 * @param pacMultiWin
	 *            the pacMultiWin to set
	 */
	public void setPacMultiWin(int pacMultiWin) {
		this.pacMultiWin = pacMultiWin;
	}

	/**
	 * @param secMultiWin
	 *            the secMultiWin to set
	 */
	public void setSecMultiWin(int secMultiWin) {
		this.secMultiWin = secMultiWin;
	}

	/**
	 * @param accMultiWin
	 *            the accMultiWin to set
	 */
	public void setAccMultiWin(int accMultiWin) {
		this.accMultiWin = accMultiWin;
	}

	/**
	 * @param indMultiWin
	 *            the indMultiWin to set
	 */
	public void setIndMultiWin(int indMultiWin) {
		this.indMultiWin = indMultiWin;
	}

	/**
	 * @param aacMultiWin
	 *            the aacMultiWin to set
	 */
	public void setAacMultiWin(int aacMultiWin) {
		this.aacMultiWin = aacMultiWin;
	}

	/**
	 * @param mwcMultiWin
	 *            the mwcMultiWin to set
	 */
	public void setMwcMultiWin(int mwcMultiWin) {
		this.mwcMultiWin = mwcMultiWin;
	}

	/**
	 * @param cusaMultiWin
	 *            the cusaMultiWin to set
	 */
	public void setCusaMultiWin(int cusaMultiWin) {
		this.cusaMultiWin = cusaMultiWin;
	}

	/**
	 * @param sunBeltMultWin
	 *            the sunBeltMultWin to set
	 */
	public void setSunBeltMultWin(int sunBeltMultWin) {
		this.sunBeltMultWin = sunBeltMultWin;
	}

	/**
	 * @param macMultiWin
	 *            the macMultiWin to set
	 */
	public void setMacMultiWin(int macMultiWin) {
		this.macMultiWin = macMultiWin;
	}

	/**
	 * @param fcsMultiWin
	 *            the fcsMultiWin to set
	 */
	public void setFcsMultiWin(int fcsMultiWin) {
		this.fcsMultiWin = fcsMultiWin;
	}

	/**
	 * @return the b12MultiLoose
	 */
	public int getB12MultiLoss() {
		return b12MultiLoss;
	}

	/**
	 * @param b12MultiLoss
	 *            the b12MultiLoose to set
	 */
	public void setB12MultiLoss(int b12MultiLoss) {
		this.b12MultiLoss = b12MultiLoss;
	}

	/**
	 * @return the b10MultiLoose
	 */
	public int getB10MultiLoss() {
		return b10MultiLoss;
	}

	/**
	 * @param b10MultiLoss
	 *            the b10MultiLoose to set
	 */
	public void setB10MultiLoss(int b10MultiLoss) {
		this.b10MultiLoss = b10MultiLoss;
	}

	/**
	 * @return the pacMultiLoose
	 */
	public int getPacMultiLoss() {
		return pacMultiLoss;
	}

	/**
	 * @param pacMultiLoss
	 *            the pacMultiLoose to set
	 */
	public void setPacMultiLoss(int pacMultiLoss) {
		this.pacMultiLoss = pacMultiLoss;
	}

	/**
	 * @return the secMultiLoose
	 */
	public int getSecMultiLoss() {
		return secMultiLoss;
	}

	/**
	 * @param secMultiLoss
	 *            the secMultiLoose to set
	 */
	public void setSecMultiLoss(int secMultiLoss) {
		this.secMultiLoss = secMultiLoss;
	}

	/**
	 * @return the accMultiLoose
	 */
	public int getAccMultiLoss() {
		return accMultiLoss;
	}

	/**
	 * @param accMultiLoss
	 *            the accMultiLoose to set
	 */
	public void setAccMultiLoose(int accMultiLoss) {
		this.accMultiLoss = accMultiLoss;
	}

	/**
	 * @return the indMultiLoose
	 */
	public int getIndMultiLoss() {
		return indMultiLoss;
	}

	/**
	 * @param indMultiLoss
	 *            the indMultiLoose to set
	 */
	public void setIndMultiLoss(int indMultiLoss) {
		this.indMultiLoss = indMultiLoss;
	}

	/**
	 * @return the aacMultiLoose
	 */
	public int getAacMultiLoss() {
		return aacMultiLoss;
	}

	/**
	 * @param aacMultiLoss
	 *            the aacMultiLoose to set
	 */
	public void setAacMultiLoose(int aacMultiLoss) {
		this.aacMultiLoss = aacMultiLoss;
	}

	/**
	 * @return the mwcMultiLoose
	 */
	public int getMwcMultiLoss() {
		return mwcMultiLoss;
	}

	/**
	 * @param mwcMultiLoss
	 *            the mwcMultiLoose to set
	 */
	public void setMwcMultiLoose(int mwcMultiLoss) {
		this.mwcMultiLoss = mwcMultiLoss;
	}

	/**
	 * @return the cusaMultiLoose
	 */
	public int getCusaMultiLoss() {
		return cusaMultiLoss;
	}

	/**
	 * @param cusaMultiLoss
	 *            the cusaMultiLoose to set
	 */
	public void setCusaMultiLoss(int cusaMultiLoss) {
		this.cusaMultiLoss = cusaMultiLoss;
	}

	/**
	 * @return the sunBeltMultLoose
	 */
	public int getSunBeltMultLoss() {
		return sunBeltMultLoss;
	}

	/**
	 * @param sunBeltMultLoss
	 *            the sunBeltMultLoose to set
	 */
	public void setSunBeltMultLoss(int sunBeltMultLoss) {
		this.sunBeltMultLoss = sunBeltMultLoss;
	}

	/**
	 * @return the macMultiLoose
	 */
	public int getMacMultiLoss() {
		return macMultiLoss;
	}

	/**
	 * @param macMultiLoss
	 *            the macMultiLoose to set
	 */
	public void setMacMultiLoss(int macMultiLoss) {
		this.macMultiLoss = macMultiLoss;
	}

	/**
	 * @return the fcsMultiLoose
	 */
	public int getFcsMultiLoss() {
		return fcsMultiLoss;
	}

	/**
	 * @param fcsMultiLoss
	 *            the fcsMultiLoose to set
	 */
	public void setFcsMultiLoss(int fcsMultiLoss) {
		this.fcsMultiLoss = fcsMultiLoss;
	}

	/**
	 * @return the pointsScoredMult
	 */
	public int getPointsScoredMult() {
		return pointsScoredMult;
	}

	/**
	 * @param pointsScoredMult
	 *            the pointsScoredMult to set
	 */
	public void setPointsScoredMult(int pointsScoredMult) {
		this.pointsScoredMult = pointsScoredMult;
	}

	/**
	 * @return the pointsScoredThreshold
	 */
	public int getPointsScoredThreshold() {
		return pointsScoredThreshold;
	}

	/**
	 * @param pointsScoredThreshold
	 *            the pointsScoredThreshold to set
	 */
	public void setPointsScoredThreshold(int pointsScoredThreshold) {
		this.pointsScoredThreshold = pointsScoredThreshold;
	}

	/**
	 * @return the pointsScoredPen
	 */
	public int getPointsScoredPen() {
		return pointsScoredPen;
	}

	/**
	 * @param pointsScoredPen
	 *            the pointsScoredPen to set
	 */
	public void setPointsScoredPen(int pointsScoredPen) {
		this.pointsScoredPen = pointsScoredPen;
	}

	/**
	 * @return the pointsAllowedPen
	 */
	public int getPointsAllowedPen() {
		return pointsAllowedPen;
	}

	/**
	 * @param pointsAllowedPen
	 *            the pointsAllowedPen to set
	 */
	public void setPointsAllowedPen(int pointsAllowedPen) {
		this.pointsAllowedPen = pointsAllowedPen;
	}

	/**
	 * @return the pointsAllowedThreshold
	 */
	public int getPointsAllowedThreshold() {
		return pointsAllowedThreshold;
	}

	/**
	 * @param pointsAllowedThreshold
	 *            the pointsAllowedThreshold to set
	 */
	public void setPointsAllowedThreshold(int pointsAllowedThreshold) {
		this.pointsAllowedThreshold = pointsAllowedThreshold;
	}

	/**
	 * @return the pointsAllowedMult
	 */
	public int getPointsAllowedMult() {
		return pointsAllowedMult;
	}

	/**
	 * @param pointsAllowedMult
	 *            the pointsAllowedMult to set
	 */
	public void setPointsAllowedMult(int pointsAllowedMult) {
		this.pointsAllowedMult = pointsAllowedMult;
	}

	/**
	 * @return the yardsGainedRe
	 */
	public int getYardsGainedRe() {
		return yardsGainedRe;
	}

	/**
	 * @return the yardsGainedTh
	 */
	public int getYardsGainedTh() {
		return yardsGainedTh;
	}

	/**
	 * @return the yardsGainedPen
	 */
	public int getYardsGainedPen() {
		return yardsGainedPen;
	}

	/**
	 * @return the yardsAllowedRe
	 */
	public int getYardsAllowedRe() {
		return yardsAllowedRe;
	}

	/**
	 * @return the yardsAllowedTh
	 */
	public int getYardsAllowedTh() {
		return yardsAllowedTh;
	}

	/**
	 * @return the yardsAllowedPen
	 */
	public int getYardsAllowedPen() {
		return yardsAllowedPen;
	}

	/**
	 * @return the yardsCarryRe
	 */
	public int getYardsCarryRe() {
		return yardsCarryRe;
	}

	/**
	 * @return the yardsCarryTh
	 */
	public int getYardsCarryTh() {
		return yardsCarryTh;
	}

	/**
	 * @return the yardsCarryPen
	 */
	public int getYardsCarryPen() {
		return yardsCarryPen;
	}

	/**
	 * @return the yardsAllowedCarryRe
	 */
	public int getYardsAllowedCarryRe() {
		return yardsAllowedCarryRe;
	}

	/**
	 * @return the yardsAllowedCarryTh
	 */
	public int getYardsAllowedCarryTh() {
		return yardsAllowedCarryTh;
	}

	/**
	 * @return the yardsAllowedCarryPen
	 */
	public int getYardsAllowedCarryPen() {
		return yardsAllowedCarryPen;
	}

	/**
	 * @return the yardsCatchRe
	 */
	public int getYardsCatchRe() {
		return yardsCatchRe;
	}

	/**
	 * @return the yardsCatchTh
	 */
	public int getYardsCatchTh() {
		return yardsCatchTh;
	}

	/**
	 * @return the yardsCatchPen
	 */
	public int getYardsCatchPen() {
		return yardsCatchPen;
	}

	/**
	 * @return the yardsAllowedCatchRe
	 */
	public int getYardsAllowedCatchRe() {
		return yardsAllowedCatchRe;
	}

	/**
	 * @return the yardsAllowedCatchTh
	 */
	public int getYardsAllowedCatchTh() {
		return yardsAllowedCatchTh;
	}

	/**
	 * @return the yardsAllowedCatchPen
	 */
	public int getYardsAllowedCatchPen() {
		return yardsAllowedCatchPen;
	}

	/**
	 * @return the ypCarryReward
	 */
	public int getYpCarryReward() {
		return ypCarryReward;
	}

	/**
	 * @param ypCarryReward
	 *            the ypCarryReward to set
	 */
	public void setYpCarryReward(int ypCarryReward) {
		this.ypCarryReward = ypCarryReward;
	}

	/**
	 * @return the ypCatchReward
	 */
	public int getYpCatchReward() {
		return ypCatchReward;
	}

	/**
	 * @param ypCatchReward
	 *            the ypCatchReward to set
	 */
	public void setYpCatchReward(int ypCatchReward) {
		this.ypCatchReward = ypCatchReward;
	}

	/**
	 * @return the ypCarryAllowedPen
	 */
	public int getYpCarryAllowedPen() {
		return ypCarryAllowedPen;
	}

	/**
	 * @param ypCarryAllowedPen
	 *            the ypCarryAllowedPen to set
	 */
	public void setYpCarryAllowedPen(int ypCarryAllowedPen) {
		this.ypCarryAllowedPen = ypCarryAllowedPen;
	}

	/**
	 * @return the ypCatchAllowedPen
	 */
	public int getYpCatchAllowedPen() {
		return ypCatchAllowedPen;
	}

	/**
	 * @param ypCatchAllowedPen
	 *            the ypCatchAllowedPen to set
	 */
	public void setYpCatchAllowedPen(int ypCatchAllowedPen) {
		this.ypCatchAllowedPen = ypCatchAllowedPen;
	}

	/**
	 * @param yardsGainedRe
	 *            the yardsGainedRe to set
	 */
	public void setYardsGainedRe(int yardsGainedRe) {
		this.yardsGainedRe = yardsGainedRe;
	}

	/**
	 * @param yardsGainedTh
	 *            the yardsGainedTh to set
	 */
	public void setYardsGainedTh(int yardsGainedTh) {
		this.yardsGainedTh = yardsGainedTh;
	}

	/**
	 * @param yardsGainedPen
	 *            the yardsGainedPen to set
	 */
	public void setYardsGainedPen(int yardsGainedPen) {
		this.yardsGainedPen = yardsGainedPen;
	}

	/**
	 * @param yardsAllowedRe
	 *            the yardsAllowedRe to set
	 */
	public void setYardsAllowedRe(int yardsAllowedRe) {
		this.yardsAllowedRe = yardsAllowedRe;
	}

	/**
	 * @param yardsAllowedTh
	 *            the yardsAllowedTh to set
	 */
	public void setYardsAllowedTh(int yardsAllowedTh) {
		this.yardsAllowedTh = yardsAllowedTh;
	}

	/**
	 * @param yardsAllowedPen
	 *            the yardsAllowedPen to set
	 */
	public void setYardsAllowedPen(int yardsAllowedPen) {
		this.yardsAllowedPen = yardsAllowedPen;
	}

	/**
	 * @param yardsCarryRe
	 *            the yardsCarryRe to set
	 */
	public void setYardsCarryRe(int yardsCarryRe) {
		this.yardsCarryRe = yardsCarryRe;
	}

	/**
	 * @param yardsCarryTh
	 *            the yardsCarryTh to set
	 */
	public void setYardsCarryTh(int yardsCarryTh) {
		this.yardsCarryTh = yardsCarryTh;
	}

	/**
	 * @param yardsCarryPen
	 *            the yardsCarryPen to set
	 */
	public void setYardsCarryPen(int yardsCarryPen) {
		this.yardsCarryPen = yardsCarryPen;
	}

	/**
	 * @param yardsAllowedCarryRe
	 *            the yardsAllowedCarryRe to set
	 */
	public void setYardsAllowedCarryRe(int yardsAllowedCarryRe) {
		this.yardsAllowedCarryRe = yardsAllowedCarryRe;
	}

	/**
	 * @param yardsAllowedCarryTh
	 *            the yardsAllowedCarryTh to set
	 */
	public void setYardsAllowedCarryTh(int yardsAllowedCarryTh) {
		this.yardsAllowedCarryTh = yardsAllowedCarryTh;
	}

	/**
	 * @param yardsAllowedCarryPen
	 *            the yardsAllowedCarryPen to set
	 */
	public void setYardsAllowedCarryPen(int yardsAllowedCarryPen) {
		this.yardsAllowedCarryPen = yardsAllowedCarryPen;
	}

	/**
	 * @param yardsCatchRe
	 *            the yardsCatchRe to set
	 */
	public void setYardsCatchRe(int yardsCatchRe) {
		this.yardsCatchRe = yardsCatchRe;
	}

	/**
	 * @param yardsCatchTh
	 *            the yardsCatchTh to set
	 */
	public void setYardsCatchTh(int yardsCatchTh) {
		this.yardsCatchTh = yardsCatchTh;
	}

	/**
	 * @param yardsCatchPen
	 *            the yardsCatchPen to set
	 */
	public void setYardsCatchPen(int yardsCatchPen) {
		this.yardsCatchPen = yardsCatchPen;
	}

	/**
	 * @param yardsAllowedCatchRe
	 *            the yardsAllowedCatchRe to set
	 */
	public void setYardsAllowedCatchRe(int yardsAllowedCatchRe) {
		this.yardsAllowedCatchRe = yardsAllowedCatchRe;
	}

	/**
	 * @param yardsAllowedCatchTh
	 *            the yardsAllowedCatchTh to set
	 */
	public void setYardsAllowedCatchTh(int yardsAllowedCatchTh) {
		this.yardsAllowedCatchTh = yardsAllowedCatchTh;
	}

	/**
	 * @param yardsAllowedCatchPen
	 *            the yardsAllowedCatchPen to set
	 */
	public void setYardsAllowedCatchPen(int yardsAllowedCatchPen) {
		this.yardsAllowedCatchPen = yardsAllowedCatchPen;
	}

	/**
	 * @return the takeAwayMult
	 */
	public int getTakeAwayMult() {
		return takeAwayMult;
	}

	/**
	 * @param takeAwayMult
	 *            the takeAwayMult to set
	 */
	public void setTakeAwayMult(int takeAwayMult) {
		this.takeAwayMult = takeAwayMult;
	}

	/**
	 * @return the pickMult
	 */
	public int getPickMult() {
		return pickMult;
	}

	/**
	 * @param pickMult
	 *            the pickMult to set
	 */
	public void setPickMult(int pickMult) {
		this.pickMult = pickMult;
	}

	/**
	 * @return the fumbleRecoveryMult
	 */
	public int getFumbleRecoveryMult() {
		return fumbleRecoveryMult;
	}

	/**
	 * @param fumbleRecoveryMult
	 *            the fumbleRecoveryMult to set
	 */
	public void setFumbleRecoveryMult(int fumbleRecoveryMult) {
		this.fumbleRecoveryMult = fumbleRecoveryMult;
	}

	/**
	 * @return the turnoverPen
	 */
	public int getTurnoverPen() {
		return turnoverPen;
	}

	/**
	 * @param turnoverPen
	 *            the turnoverPen to set
	 */
	public void setTurnoverPen(int turnoverPen) {
		this.turnoverPen = turnoverPen;
	}

	/**
	 * @return the interceptionPen
	 */
	public int getInterceptionPen() {
		return interceptionPen;
	}

	/**
	 * @param interceptionPen
	 *            the interceptionPen to set
	 */
	public void setInterceptionPen(int interceptionPen) {
		this.interceptionPen = interceptionPen;
	}

	/**
	 * @return the fumbleLostPen
	 */
	public int getFumbleLostPen() {
		return fumbleLostPen;
	}

	/**
	 * @param fumbleLostPen
	 *            the fumbleLostPen to set
	 */
	public void setFumbleLostPen(int fumbleLostPen) {
		this.fumbleLostPen = fumbleLostPen;
	}

	/**
	 * @return the oppTOPRe
	 */
	public int getOppTOPRe() {
		return oppTOPRe;
	}

	/**
	 * @param oppTOPRe
	 *            the oppTOPRe to set
	 */
	public void setOppTOPRe(int oppTOPRe) {
		this.oppTOPRe = oppTOPRe;
	}

	/**
	 * @return the oppTOPTh
	 */
	public int getOppTOPTh() {
		return oppTOPTh;
	}

	/**
	 * @param oppTOPTh
	 *            the oppTOPTh to set
	 */
	public void setOppTOPTh(int oppTOPTh) {
		this.oppTOPTh = oppTOPTh;
	}

	/**
	 * @return the oppTOPPen
	 */
	public int getOppTOPPen() {
		return oppTOPPen;
	}

	/**
	 * @param oppTOPPen
	 *            the oppTOPPen to set
	 */
	public void setOppTOPPen(int oppTOPPen) {
		this.oppTOPPen = oppTOPPen;
	}

	/**
	 * @param accMultiLoss
	 *            the accMultiLoss to set
	 */
	public void setAccMultiLoss(int accMultiLoss) {
		this.accMultiLoss = accMultiLoss;
	}

	/**
	 * @param aacMultiLoss
	 *            the aacMultiLoss to set
	 */
	public void setAacMultiLoss(int aacMultiLoss) {
		this.aacMultiLoss = aacMultiLoss;
	}

	/**
	 * @param mwcMultiLoss
	 *            the mwcMultiLoss to set
	 */
	public void setMwcMultiLoss(int mwcMultiLoss) {
		this.mwcMultiLoss = mwcMultiLoss;
	}

	/**
	 * @return the topRe
	 */
	public int getTopRe() {
		return topRe;
	}

	/**
	 * @param topRe
	 *            the topRe to set
	 */
	public void setTopRe(int topRe) {
		this.topRe = topRe;
	}

	/**
	 * @return the topTh
	 */
	public int getTopTh() {
		return topTh;
	}

	/**
	 * @param topTh
	 *            the topTh to set
	 */
	public void setTopTh(int topTh) {
		this.topTh = topTh;
	}

	/**
	 * @return the topPen
	 */
	public int getTopPen() {
		return topPen;
	}

	/**
	 * @param topPen
	 *            the topPen to set
	 */
	public void setTopPen(int topPen) {
		this.topPen = topPen;
	}

	/**
	 * @return the thirdDownRe
	 */
	public int getThirdDownRe() {
		return thirdDownRe;
	}

	/**
	 * @param thirdDownRe
	 *            the thirdDownRe to set
	 */
	public void setThirdDownRe(int thirdDownRe) {
		this.thirdDownRe = thirdDownRe;
	}

	/**
	 * @return the thirdDownTh
	 */
	public int getThirdDownTh() {
		return thirdDownTh;
	}

	/**
	 * @param thirdDownTh
	 *            the thirdDownTh to set
	 */
	public void setThirdDownTh(int thirdDownTh) {
		this.thirdDownTh = thirdDownTh;
	}

	/**
	 * @return the thirdDownPe
	 */
	public int getThirdDownPe() {
		return thirdDownPe;
	}

	/**
	 * @param thirdDownPe
	 *            the thirdDownPe to set
	 */
	public void setThirdDownPe(int thirdDownPe) {
		this.thirdDownPe = thirdDownPe;
	}

	/**
	 * @return the thirdDownAllowedRe
	 */
	public int getThirdDownAllowedRe() {
		return thirdDownAllowedRe;
	}

	/**
	 * @param thirdDownAllowedRe
	 *            the thirdDownAllowedRe to set
	 */
	public void setThirdDownAllowedRe(int thirdDownAllowedRe) {
		this.thirdDownAllowedRe = thirdDownAllowedRe;
	}

	/**
	 * @return the thirdDownAllowedTh
	 */
	public int getThirdDownAllowedTh() {
		return thirdDownAllowedTh;
	}

	/**
	 * @param thirdDownAllowedTh
	 *            the thirdDownAllowedTh to set
	 */
	public void setThirdDownAllowedTh(int thirdDownAllowedTh) {
		this.thirdDownAllowedTh = thirdDownAllowedTh;
	}

	/**
	 * @return the thirdDownAllowedPe
	 */
	public int getThirdDownAllowedPe() {
		return thirdDownAllowedPe;
	}

	/**
	 * @param thirdDownAllowedPe
	 *            the thirdDownAllowedPe to set
	 */
	public void setThirdDownAllowedPe(int thirdDownAllowedPe) {
		this.thirdDownAllowedPe = thirdDownAllowedPe;
	}

	/**
	 * @return the penaltyForcedRe
	 */
	public int getPenaltyForcedRe() {
		return penaltyForcedRe;
	}

	/**
	 * @param penaltyForcedRe
	 *            the penaltyForcedRe to set
	 */
	public void setPenaltyForcedRe(int penaltyForcedRe) {
		this.penaltyForcedRe = penaltyForcedRe;
	}

	/**
	 * @return the penaltyYardageForcedRe
	 */
	public int getPenaltyYardageForcedRe() {
		return penaltyYardageForcedRe;
	}

	/**
	 * @param penaltyYardageForcedRe
	 *            the penaltyYardageForcedRe to set
	 */
	public void setPenaltyYardageForcedRe(int penaltyYardageForcedRe) {
		this.penaltyYardageForcedRe = penaltyYardageForcedRe;
	}

	/**
	 * @return the penaltyAllowedPe
	 */
	public int getPenaltyAllowedPe() {
		return penaltyAllowedPe;
	}

	/**
	 * @param penaltyAllowedPe
	 *            the penaltyAllowedPe to set
	 */
	public void setPenaltyAllowedPe(int penaltyAllowedPe) {
		this.penaltyAllowedPe = penaltyAllowedPe;
	}

	/**
	 * @return the penaltyYardageAllowedPe
	 */
	public int getPenaltyYardageAllowedPe() {
		return penaltyYardageAllowedPe;
	}

	/**
	 * @param penaltyYardageAllowedPe
	 *            the penaltyYardageAllowedPe to set
	 */
	public void setPenaltyYardageAllowedPe(int penaltyYardageAllowedPe) {
		this.penaltyYardageAllowedPe = penaltyYardageAllowedPe;
	}

	/**
	 * @return the win0
	 */
	public int getWin0() {
		return win0;
	}

	/**
	 * @param win0
	 *            the win0 to set
	 */
	public void setWin0(int win0) {
		this.win0 = win0;
	}

	/**
	 * @return the win1
	 */
	public int getWin1() {
		return win1;
	}

	/**
	 * @param win1
	 *            the win1 to set
	 */
	public void setWin1(int win1) {
		this.win1 = win1;
	}

	/**
	 * @return the win2
	 */
	public int getWin2() {
		return win2;
	}

	/**
	 * @param win2
	 *            the win2 to set
	 */
	public void setWin2(int win2) {
		this.win2 = win2;
	}

	/**
	 * @return the win3
	 */
	public int getWin3() {
		return win3;
	}

	/**
	 * @param win3
	 *            the win3 to set
	 */
	public void setWin3(int win3) {
		this.win3 = win3;
	}

	/**
	 * @return the win4
	 */
	public int getWin4() {
		return win4;
	}

	/**
	 * @param win4
	 *            the win4 to set
	 */
	public void setWin4(int win4) {
		this.win4 = win4;
	}

	/**
	 * @return the win5
	 */
	public int getWin5() {
		return win5;
	}

	/**
	 * @param win5
	 *            the win5 to set
	 */
	public void setWin5(int win5) {
		this.win5 = win5;
	}

	/**
	 * @return the win6
	 */
	public int getWin6() {
		return win6;
	}

	/**
	 * @param win6
	 *            the win6 to set
	 */
	public void setWin6(int win6) {
		this.win6 = win6;
	}

	/**
	 * @return the win7
	 */
	public int getWin7() {
		return win7;
	}

	/**
	 * @param win7
	 *            the win7 to set
	 */
	public void setWin7(int win7) {
		this.win7 = win7;
	}

	/**
	 * @return the win8
	 */
	public int getWin8() {
		return win8;
	}

	/**
	 * @param win8
	 *            the win8 to set
	 */
	public void setWin8(int win8) {
		this.win8 = win8;
	}

	/**
	 * @return the win9
	 */
	public int getWin9() {
		return win9;
	}

	/**
	 * @param win9
	 *            the win9 to set
	 */
	public void setWin9(int win9) {
		this.win9 = win9;
	}

	/**
	 * @return the win10
	 */
	public int getWin10() {
		return win10;
	}

	/**
	 * @param win10
	 *            the win10 to set
	 */
	public void setWin10(int win10) {
		this.win10 = win10;
	}

	/**
	 * @return the win11
	 */
	public int getWin11() {
		return win11;
	}

	/**
	 * @param win11
	 *            the win11 to set
	 */
	public void setWin11(int win11) {
		this.win11 = win11;
	}

	/**
	 * @return the win12
	 */
	public int getWin12() {
		return win12;
	}

	/**
	 * @param win12
	 *            the win12 to set
	 */
	public void setWin12(int win12) {
		this.win12 = win12;
	}

	/**
	 * @return the win13
	 */
	public int getWin13() {
		return win13;
	}

	/**
	 * @param win13
	 *            the win13 to set
	 */
	public void setWin13(int win13) {
		this.win13 = win13;
	}

	/**
	 * @return the loss0
	 */
	public int getLoss0() {
		return loss0;
	}

	/**
	 * @param loss0
	 *            the loss0 to set
	 */
	public void setLoss0(int loss0) {
		this.loss0 = loss0;
	}

	/**
	 * @return the loss1
	 */
	public int getLoss1() {
		return loss1;
	}

	/**
	 * @param loss1
	 *            the loss1 to set
	 */
	public void setLoss1(int loss1) {
		this.loss1 = loss1;
	}

	/**
	 * @return the loss2
	 */
	public int getLoss2() {
		return loss2;
	}

	/**
	 * @param loss2
	 *            the loss2 to set
	 */
	public void setLoss2(int loss2) {
		this.loss2 = loss2;
	}

	/**
	 * @return the loss3
	 */
	public int getLoss3() {
		return loss3;
	}

	/**
	 * @param loss3
	 *            the loss3 to set
	 */
	public void setLoss3(int loss3) {
		this.loss3 = loss3;
	}

	/**
	 * @return the loss4
	 */
	public int getLoss4() {
		return loss4;
	}

	/**
	 * @param loss4
	 *            the loss4 to set
	 */
	public void setLoss4(int loss4) {
		this.loss4 = loss4;
	}

	/**
	 * @return the loss5
	 */
	public int getLoss5() {
		return loss5;
	}

	/**
	 * @param loss5
	 *            the loss5 to set
	 */
	public void setLoss5(int loss5) {
		this.loss5 = loss5;
	}

	/**
	 * @return the loss6
	 */
	public int getLoss6() {
		return loss6;
	}

	/**
	 * @param loss6
	 *            the loss6 to set
	 */
	public void setLoss6(int loss6) {
		this.loss6 = loss6;
	}

	/**
	 * @param loss7
	 *            the loss7 to set
	 */
	public void setLoss7(int loss7) {
		this.loss7 = loss7;
	}

	/**
	 * @return the loss7
	 */
	public int getLoss7() {
		return loss7;
	}

	/**
	 * @return the loss8
	 */
	public int getLoss8() {
		return loss8;
	}

	/**
	 * @param loss8
	 *            the loss8 to set
	 */
	public void setLoss8(int loss8) {
		this.loss8 = loss8;
	}

	/**
	 * @return the loss9
	 */
	public int getLoss9() {
		return loss9;
	}

	/**
	 * @param loss9
	 *            the loss9 to set
	 */
	public void setLoss9(int loss9) {
		this.loss9 = loss9;
	}

	/**
	 * @return the loss10
	 */
	public int getLoss10() {
		return loss10;
	}

	/**
	 * @param loss10
	 *            the loss10 to set
	 */
	public void setLoss10(int loss10) {
		this.loss10 = loss10;
	}

	/**
	 * @return the loss11
	 */
	public int getLoss11() {
		return loss11;
	}

	/**
	 * @param loss11
	 *            the loss11 to set
	 */
	public void setLoss11(int loss11) {
		this.loss11 = loss11;
	}

	/**
	 * @return the loss12
	 */
	public int getLoss12() {
		return loss12;
	}

	/**
	 * @param loss12
	 *            the loss12 to set
	 */
	public void setLoss12(int loss12) {
		this.loss12 = loss12;
	}

	/**
	 * @return the loss13
	 */
	public int getLoss13() {
		return loss13;
	}

	/**
	 * @param loss13
	 *            the loss13 to set
	 */
	public void setLoss13(int loss13) {
		this.loss13 = loss13;
	}

	/**
	 * @return the blowoutReAmmount
	 */
	public int getBlowoutReAmmount() {
		return blowoutReAmmount;
	}

	/**
	 * @param blowoutReAmmount
	 *            the blowoutReAmmount to set
	 */
	public void setBlowoutReAmmount(int blowoutReAmmount) {
		this.blowoutReAmmount = blowoutReAmmount;
	}

	/**
	 * @return the blowoutRe
	 */
	public int getBlowoutRe() {
		return blowoutRe;
	}

	/**
	 * @param blowoutRe
	 *            the blowoutRe to set
	 */
	public void setBlowoutRe(int blowoutRe) {
		this.blowoutRe = blowoutRe;
	}

	/**
	 * @return the blowoutPeAmmount
	 */
	public int getBlowoutPeAmmount() {
		return blowoutPeAmmount;
	}

	/**
	 * @param blowoutPeAmmount
	 *            the blowoutPeAmmount to set
	 */
	public void setBlowoutPeAmmount(int blowoutPeAmmount) {
		this.blowoutPeAmmount = blowoutPeAmmount;
	}

	/**
	 * @return the blowoutPe
	 */
	public int getBlowoutPe() {
		return blowoutPe;
	}

	/**
	 * @param blowoutPe
	 *            the blowoutPe to set
	 */
	public void setBlowoutPe(int blowoutPe) {
		this.blowoutPe = blowoutPe;
	}

	/**
	 * @return the shutoutRe
	 */
	public int getShutoutRe() {
		return shutoutRe;
	}

	/**
	 * @param shutoutRe
	 *            the shutoutRe to set
	 */
	public void setShutoutRe(int shutoutRe) {
		this.shutoutRe = shutoutRe;
	}

	/**
	 * @return the shutoutPe
	 */
	public int getShutoutPe() {
		return shutoutPe;
	}

	/**
	 * @param shutoutPe
	 *            the shutoutPe to set
	 */
	public void setShutoutPe(int shutoutPe) {
		this.shutoutPe = shutoutPe;
	}

	/**
	 * @return the aproxPointsScored
	 */
	public static int getAproxPointsScored() {
		return APROX_POINTS_SCORED;
	}

	/**
	 * @return the aproxPointsAllowed
	 */
	public static int getAproxPointsAllowed() {
		return APROX_POINTS_ALLOWED;
	}

	/**
	 * @return the aproxYardage
	 */
	public static int getAproxYardage() {
		return APROX_YARDAGE;
	}

}

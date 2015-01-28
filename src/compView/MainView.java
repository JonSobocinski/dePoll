package compView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import compWorld.NCAA;

public class MainView {

	private JFrame frame;
	private NCAA n;
	private MultiOption mc;
	private boolean repeatRankings;
	private int numberOfTimesToSimulateRankings;
	private boolean excludeGroupOf5InTop25;

	private JTextArea fullRankingsList;
	private boolean generateStats;
	protected boolean generateGameByGameStats;
	private TeamLogoPanel teamLogoPanel;
	private ChartMaker chartPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainView window = new MainView();
					window.frame.setVisible(true);

				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public MainView() {
		n = new NCAA(this);
		repeatRankings = false;
		generateStats = false;
		generateGameByGameStats = false;
		excludeGroupOf5InTop25 = true;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel taskBarPanel = new JPanel();
		frame.getContentPane().add(taskBarPanel, BorderLayout.NORTH);
		taskBarPanel.setLayout(new BorderLayout(0, 0));

		JMenuBar menuBar = new JMenuBar();
		taskBarPanel.add(menuBar, BorderLayout.NORTH);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmLoadFolder = new JMenuItem("Load Folder");
		mntmLoadFolder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				n.parseStats();
			}
		});
		mnFile.add(mntmLoadFolder);

		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);

		JCheckBoxMenuItem chckbxmntmGenerateStatBreakdown = new JCheckBoxMenuItem(
		        "Generate Stat Breakdown With Rankings");
		chckbxmntmGenerateStatBreakdown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AbstractButton b = (AbstractButton) e.getSource();
				generateStats = b.getModel().isSelected();

			}
		});
		mnOptions.add(chckbxmntmGenerateStatBreakdown);

		JCheckBoxMenuItem chckbxmntmGenerateGameBy = new JCheckBoxMenuItem(
		        "Generate Game By Game Reports With Rankings");
		chckbxmntmGenerateGameBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractButton b = (AbstractButton) arg0.getSource();
				generateGameByGameStats = b.getModel().isSelected();
			}
		});
		mnOptions.add(chckbxmntmGenerateGameBy);

		JMenu mnRandomGenerationOptions = new JMenu("Random Generation Options");
		mnOptions.add(mnRandomGenerationOptions);

		StayOpenCheckBoxMenuItem chckbxmntmLoopRandomGeneration = new StayOpenCheckBoxMenuItem(
		        "Run Multiple Random Ranking Generations");
		chckbxmntmLoopRandomGeneration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractButton b = (AbstractButton) arg0.getSource();
				repeatRankings = b.getModel().isSelected();

			}
		});
		mnRandomGenerationOptions.add(chckbxmntmLoopRandomGeneration);

		final JSpinner randomGenerationRepeater = new JSpinner(new SpinnerNumberModel(0, 0,
		        10000, 10));
		randomGenerationRepeater
		        .setToolTipText("This number will determine how many times random rankings are generated. This may take awhile");
		randomGenerationRepeater.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				numberOfTimesToSimulateRankings = (int) randomGenerationRepeater.getValue();
			}
		});
		mnRandomGenerationOptions.add(randomGenerationRepeater);

		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Penalize G5 Teams");
		chckbxmntmNewCheckItem
		        .setToolTipText("Selecting This Option Will Prevent G5 Teams From Entering Into The Top 20. G5 Teams Might Still Be Ranking In Spots 21-25");
		chckbxmntmNewCheckItem.setSelected(true);
		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractButton b = (AbstractButton) arg0.getSource();
				excludeGroupOf5InTop25 = b.getModel().isSelected();
			}
		});
		mnOptions.add(chckbxmntmNewCheckItem);

		JMenu mnNewMenu = new JMenu("About");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Video Demonstration");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

				if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						URI url = new URI(
						        "https://www.youtube.com/channel/UC9ks5NtrK3aDyLEPb4piqow/videos");
						desktop.browse(url);
					}
					catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("Buy Me A Beer");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("Or Help Me Pay Off My Student Loans Lol");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

				if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
					try {
						URI url = new URI(
						        "https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=uhelioone%40gmail%2ecom&lc=US&item_name=%2fu%2fHelioOne%20CFB%20Poll%20Donations&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHosted");
						desktop.browse(url);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		JPanel statPanel = new JPanel();
		frame.getContentPane().add(statPanel, BorderLayout.EAST);
		statPanel.setLayout(new BorderLayout(0, 0));

		fullRankingsList = new JTextArea();
		JScrollPane scrollPane = new JScrollPane();
		statPanel.add(scrollPane, BorderLayout.EAST);

		Dimension preferredSize = new Dimension(frame.getWidth(), frame.getHeight());
		scrollPane.setPreferredSize(preferredSize);

		fullRankingsList.setFont(new Font("TimesRoman", 14, 14));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportView(fullRankingsList);

		JPanel generatePanel = new JPanel();
		frame.getContentPane().add(generatePanel, BorderLayout.SOUTH);

		JButton btnGenerateRankings = new JButton("Generate Rankings");
		btnGenerateRankings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				generateRankings();
			}
		});

		JButton btnSetMultipliers = new JButton("Set Multipliers");

		btnSetMultipliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mc.makeVisible();

			}
		});
		generatePanel.add(btnSetMultipliers);

		JButton btnNewButton_1 = new JButton("Randomize Multipliers And Generate");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mc.setRandomMultiplierForAllValues();
				generateRankings();
			}
		});
		generatePanel.add(btnNewButton_1);
		generatePanel.add(btnGenerateRankings);

		JButton btnExportRankings = new JButton("Export Rankings");
		btnExportRankings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		generatePanel.add(btnExportRankings);

		JButton btnGenerateTeamReports = new JButton("Generate Team Reports");
		btnGenerateTeamReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clearReport();
				boolean temp = generateStats;
				generateStats = true;
				n.generateTeamReport();
				generateStats = temp;
				fullRankingsList.setCaretPosition(0);
			}
		});
		generatePanel.add(btnGenerateTeamReports);

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		generatePanel.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

		teamLogoPanel = new TeamLogoPanel(this, n);

		tabbedPane.addTab("Rankings", null, teamLogoPanel, null);
		tabbedPane.setBackground(Color.WHITE);

		chartPanel = new ChartMaker(n.getSt());
		chartPanel.validate();
		tabbedPane.addTab("Charts", null, chartPanel, null);

		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setTitle("dePoll");
		mc = new MultiOption(this);

	}

	public void generateRankings() {

		if (!repeatRankings) {
			clearReport();
			n.clearTeamPoints();
			n.generateReport();
			fullRankingsList.setCaretPosition(0);
			addTeamLogos();
			chartPanel.setDatasets();
			chartPanel.generateGraphs();
		}
		else {
			n.clearTeamPoints();
			for (int i = 0; i < numberOfTimesToSimulateRankings; i++) {
				clearReport();
				mc.setRandomMultiplierForAllValues();
				n.generateReport();
			}
			fullRankingsList.setCaretPosition(0);
			addTeamLogos();
			chartPanel.setDatasets();
			chartPanel.generateGraphs();

		}

	}

	public void reDo() {
		clearReport();
		n.regenerateReport();
		addTeamLogos();
		fullRankingsList.setCaretPosition(0);
		chartPanel.setDatasets();
		chartPanel.generateGraphs();
	}

	public void appendText(String string) {
		fullRankingsList.append(string);
	}

	public void clearReport() {
		fullRankingsList.setText("");

	}

	public MultiOption getMO() {
		return mc;
	}

	/**
	 * @return the generateStats
	 */
	public boolean isGenerateStats() {
		return generateStats;
	}

	/**
	 * @return the generateGameByGameStats
	 */
	public boolean isGenerateGameByGameStats() {
		return generateGameByGameStats;
	}

	private void addTeamLogos() {
		teamLogoPanel.updateRankingsImage();
	}

	/**
	 * @return the includeGroupOf5InTop25
	 */
	public boolean isExcludeGroupOf5InTop25() {
		return excludeGroupOf5InTop25;
	}

	/**
	 * @return the n
	 */
	public NCAA getN() {
		return n;
	}

}

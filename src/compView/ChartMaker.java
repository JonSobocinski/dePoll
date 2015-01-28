package compView;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import compWorld.Conference;
import compWorld.StatCompiler;
import compWorld.StateRankings;

import javax.swing.border.LineBorder;

import java.awt.Color;

public class ChartMaker extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = -4799925826304935080L;

	private static final int NUMBER_OF_STATES_ON_GRAPH = 10;

	private DefaultPieDataset allConferencePowerRankings;
	private DefaultPieDataset p5conferencePowerRankings;
	private DefaultPieDataset statePowerRankings;
	private HashMap<Conference, Integer> cfp;
	private HashMap<String, Integer> stateMap;
	private StatCompiler sp;

	private JFreeChart topLeftChart;
	private JPanel topLeft;
	private ChartPanel topLeftCP;

	private JFreeChart topRightChart;
	private JPanel topRight;
	private ChartPanel topRightCP;

	private JFreeChart bottomLeftChart;
	private JPanel bottomLeft;
	private ChartPanel bottomLeftCP;

	private JFreeChart bottomRightChart;
	private JPanel bottomRight;
	private ChartPanel bottomRightCP;

	public ChartMaker(StatCompiler sp) {
		this.sp = sp;
		cfp = sp.getConferencePowerRankings();
		stateMap = sp.getStatePowerRankings();
		setLayout(new GridLayout(2, 2, 0, 0));

		topLeft = new JPanel();
		topLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(topLeft);

		topRight = new JPanel();
		topRight.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(topRight);

		bottomLeft = new JPanel();
		bottomLeft.setBorder(new LineBorder(new Color(0, 0, 0)));
		bottomLeft
		        .setToolTipText("This Graph Shows The Average Number Of \"Ranking Points\" each team has per state. This number only includes Power 5 schools");
		add(bottomLeft);

		bottomRight = new JPanel();
		bottomRight.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(bottomRight);

	}

	public void setDatasets() {
		allConferencePowerRankings = new DefaultPieDataset();
		p5conferencePowerRankings = new DefaultPieDataset();
		// Doing conferences here
		Set<Conference> s = cfp.keySet();
		for (Conference c : s) {
			int value = cfp.get(c);
			value = value + Math.abs(sp.getLowestPointValueByConference());
			value = value / c.getTeamList().size();
			allConferencePowerRankings.setValue(c.getConferenceName(), value);
			if (c.isP5()) {
				p5conferencePowerRankings.setValue(c.getConferenceName(), value);
			}
		}

		// Doing states here
		statePowerRankings = new DefaultPieDataset();
		Set<String> states = stateMap.keySet();
		ArrayList<StateRankings> stateList = new ArrayList<StateRankings>();
		// First I add every state (location) and their point values (plus the
		// offset) to an arraylist, using the staterankings class
		for (String location : states) {
			int value = stateMap.get(location);
			value = value + Math.abs(sp.getLowestPointValueByState());
			// If you want to find average values instead of total points,
			// uncomment the below line out
			// value = value / sp.getNumberOfTeamsByState().get(location);
			StateRankings sr = new StateRankings(location, value);
			stateList.add(sr);
		}
		// I then sort this list based on the ranking points so the state with
		// the most ranking points is at the top of the list
		Collections.sort(stateList);
		// I then loop through the list, the number of times that has
		// predetermined and add that data to the dataset
		for (int i = 0; i < NUMBER_OF_STATES_ON_GRAPH; i++) {
			if (stateList.get(i).getRankingPoints() > 0) {
				statePowerRankings.setValue(stateList.get(i).getLocation(), stateList.get(i)
				        .getRankingPoints());
			}
		}

	}

	private JFreeChart generateStatePowerRankings() {
		JFreeChart chart = ChartFactory.createPieChart(
		        "Power Rankings Of Power 5 Teams By State (Top " + NUMBER_OF_STATES_ON_GRAPH
		                + " States)", statePowerRankings, true, true, false);

		return chart;
	}

	private JFreeChart generateAllConferencePowerRankings() {
		JFreeChart chart = ChartFactory.createPieChart("Conference Power Rankings",
		        allConferencePowerRankings, true, true, false);

		return chart;
	}

	private JFreeChart generateP5PowerRankings() {
		JFreeChart chart = ChartFactory.createPieChart("P5 Conference Power Rankings",
		        p5conferencePowerRankings, true, true, false);

		return chart;
	}

	public void generateGraphs() {

		// top Left Panel
		topLeft.removeAll();
		topLeft.setLayout(new BorderLayout(0, 0));
		topLeftChart = generateAllConferencePowerRankings();
		topLeftCP = new ChartPanel(topLeftChart);
		topLeft.add(topLeftCP, BorderLayout.CENTER);

		// Top Right Panel
		topRight.removeAll();
		topRight.setLayout(new BorderLayout(0, 0));
		topRightChart = generateP5PowerRankings();
		topRightCP = new ChartPanel(topRightChart);
		topRight.add(topRightCP, BorderLayout.CENTER);

		// Bottom Left Panel
		bottomLeft.removeAll();
		bottomLeft.setLayout(new BorderLayout(0, 0));
		bottomLeftChart = generateStatePowerRankings();
		bottomLeftCP = new ChartPanel(bottomLeftChart);
		bottomLeft.add(bottomLeftCP, BorderLayout.CENTER);

		// Bottom Right Panel
		bottomRight.removeAll();
		bottomRight.setLayout(new BorderLayout(0, 0));
		bottomRightChart = generateAllConferencePowerRankings();
		bottomRightCP = new ChartPanel(bottomRightChart);
		bottomRight.add(bottomRightCP, BorderLayout.CENTER);
		validate();

	}

}
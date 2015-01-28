package compView;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import compWorld.MouseActions;
import compWorld.NCAA;

public class TeamLogoPanel extends JPanel {

	/**
	 * 
	 */
    private static final long serialVersionUID = 5896905016012990719L;
	private JLabelExtension number1;
	private JLabelExtension number2;
	private JLabelExtension number3;
	private JLabelExtension number4;
	private JLabelExtension number5;
	private JLabelExtension number6;
	private JLabelExtension number7;
	private JLabelExtension number8;
	private JLabelExtension number9;
	private JLabelExtension number10;
	private JLabelExtension number11;
	private JLabelExtension number12;
	private JLabelExtension number13;
	private JLabelExtension number14;
	private JLabelExtension number15;
	private JLabelExtension number16;
	private JLabelExtension number17;
	private JLabelExtension number18;
	private JLabelExtension number19;
	private JLabelExtension number20;
	private JLabelExtension number21;
	private JLabelExtension number22;
	private JLabelExtension number23;
	private JLabelExtension number24;
	private JLabelExtension number25;

	private ArrayList<JLabelExtension> al;
	private NCAA n;
	private MouseActions ma;

	// Individual labels where created so they could be added to the panels.
	// And I used 25 panels so I could add the ranking number if I choose to add
	// it later

	public TeamLogoPanel(MainView mainView, NCAA n) {
		this.setBackground(Color.white);
		this.n = n;
		ma = new MouseActions(n, mainView);
		al = new ArrayList<JLabelExtension>();
		addImagesToList();
		setLayout(new GridLayout(5, 5, 0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel);
		panel.add(number1);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_1);
		panel_1.add(number2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_2);
		panel_2.add(number3);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_3);
		panel_3.add(number4);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_4);
		panel_4.add(number5);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_5);
		panel_5.add(number6);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_6);
		panel_6.add(number7);

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_7);
		panel_7.add(number8);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_8);
		panel_8.add(number9);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_9);
		panel_9.add(number10);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_10);
		panel_10.add(number11);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_11);
		panel_11.add(number12);

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_12);
		panel_12.add(number13);

		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_13);
		panel_13.add(number14);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_14);
		panel_14.add(number15);

		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_15);
		panel_15.add(number16);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_16);
		panel_16.add(number17);

		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_17);
		panel_17.add(number18);

		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_18);
		panel_18.add(number19);

		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_19);
		panel_19.add(number20);

		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_20);
		panel_20.add(number21);

		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_21);
		panel_21.add(number22);

		JPanel panel_22 = new JPanel();
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_22);
		panel_22.add(number23);

		JPanel panel_23 = new JPanel();
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_23);
		panel_23.add(number24);

		JPanel panel_24 = new JPanel();
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		add(panel_24);
		panel_24.add(number25);

	}

	private void addImagesToList() {

		number1 = new JLabelExtension();
		number2 = new JLabelExtension();
		number3 = new JLabelExtension();
		number4 = new JLabelExtension();
		number5 = new JLabelExtension();
		number6 = new JLabelExtension();
		number7 = new JLabelExtension();
		number8 = new JLabelExtension();
		number9 = new JLabelExtension();
		number10 = new JLabelExtension();
		number11 = new JLabelExtension();
		number12 = new JLabelExtension();
		number13 = new JLabelExtension();
		number14 = new JLabelExtension();
		number15 = new JLabelExtension();
		number16 = new JLabelExtension();
		number17 = new JLabelExtension();
		number18 = new JLabelExtension();
		number19 = new JLabelExtension();
		number20 = new JLabelExtension();
		number21 = new JLabelExtension();
		number22 = new JLabelExtension();
		number23 = new JLabelExtension();
		number24 = new JLabelExtension();
		number25 = new JLabelExtension();

		al.add(number1);
		al.add(number2);
		al.add(number3);
		al.add(number4);
		al.add(number5);
		al.add(number6);
		al.add(number7);
		al.add(number8);
		al.add(number9);
		al.add(number10);
		al.add(number11);
		al.add(number12);
		al.add(number13);
		al.add(number14);
		al.add(number15);
		al.add(number16);
		al.add(number17);
		al.add(number18);
		al.add(number19);
		al.add(number20);
		al.add(number21);
		al.add(number22);
		al.add(number23);
		al.add(number24);
		al.add(number25);

	}

	public void updateRankingsImage() {

		int width = this.getWidth() / 5;
		int height = this.getHeight() / 5;
		for (int i = 0; i < al.size(); i++) {
			al.get(i).removeMouseListener(ma);
			String s = n.getRankedTeams().get(i).getTeamName().toLowerCase().trim()
			        .replaceAll(" ", "").replaceAll("-", "");
			ImageIcon icon = new ImageIcon("Logos\\" + s + ".png");
			Image image = icon.getImage();
			Image newimg = image.getScaledInstance(width - 10, height - 10,
			        java.awt.Image.SCALE_FAST);
			icon = new ImageIcon(newimg);
			al.get(i).setIcon(icon);
			al.get(i).setName(s);
			al.get(i).addMouseListener(ma);
			al.get(i).setRank(String.valueOf(i + 1));

		}
	}
}

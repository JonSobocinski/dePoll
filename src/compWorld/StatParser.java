package compWorld;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class StatParser {

	private File path;
	private File[] fileList;
	private JFileChooser chooser;
	private NCAA ncaa;
	

	public StatParser(NCAA ncaa) {

		this.ncaa = ncaa;
		chooser = new JFileChooser(System.getProperty("user.home") + "/Desktop");
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setDialogTitle("Select The Folder Containing Your Parsable Stat Files");
		int returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {

			path = chooser.getSelectedFile();

			loadFiles();
		}
		if (returnVal == JFileChooser.CANCEL_OPTION) {
			chooser.setVisible(false);
		}

	}

	private void loadFiles() {

		fileList = path.listFiles();

		for (int i = 0; i < path.listFiles().length; i++) {

			File file = fileList[i];

			if (file.getName().contains(".csv")) {

				readStats(file);
			}

		}
	}

	private void readStats(File file) {

		try {
			Scanner scanner = new Scanner(file);

			scanner.nextLine();// This skips the first line which should just be
			// category titles

			while (scanner.hasNextLine()) {

				try {
					String[] gameStat = scanner.nextLine().split(",");
					Game game = new Game(gameStat, ncaa);
					ncaa.addGame(game);

				}
				catch (NumberFormatException e) {
					JOptionPane
					        .showMessageDialog(
					                null,
					                file.getName()
					                        + " is an invalid file. It does not meet the parsing format. Please delete this file from the directory, and try again",
					                "File error", JOptionPane.ERROR_MESSAGE);
					System.exit(0);

				}

			}
			scanner.close();

		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

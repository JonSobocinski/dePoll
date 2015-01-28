package compWorld;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import compView.IndiViewer;
import compView.JLabelExtension;
import compView.MainView;

public class MouseActions implements MouseListener {	
	private NCAA n;
	private MainView m;

	public MouseActions(NCAA n, MainView m) {
		this.m = m;
		this.n = n;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		JLabelExtension label = (JLabelExtension) e.getSource();
		String rank = label.getRank();
		Team t = n.getTeamHolder().get(label.getName());
		new IndiViewer(t, label.getIcon(), rank, m);

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

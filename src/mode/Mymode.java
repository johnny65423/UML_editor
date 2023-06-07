package mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import show.Mypenel;

public abstract class Mymode implements MouseListener, MouseMotionListener {
    public String name ;
	protected Mypenel mypenel ;

	public Mymode() {
		mypenel = Mypenel.getMyPenel() ;
	}

    public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
	}
	public void mouseClicked(MouseEvent e) {
	}
	public void mouseMoved(MouseEvent e) {
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
}

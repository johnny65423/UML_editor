package mode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import shows.MyPenel;

public abstract class Mymode implements MouseListener, MouseMotionListener {
    public String name ;
	protected MyPenel mypenel ;

	public Mymode() {
		mypenel = MyPenel.getMyPenel() ;
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

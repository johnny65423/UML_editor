package mode;

import java.awt.event.MouseEvent;

import objects.Classobject;
import show.Mypenel;

public class Createclass extends Mymode {

	public Createclass() {
		this.name = "Class" ;
	}

    public void mousePressed( MouseEvent e ) {
        System.out.println("create class");
		Mypenel.addobject(new Classobject(e.getX(), e.getY()));
		
	}
    public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
	}
    
}

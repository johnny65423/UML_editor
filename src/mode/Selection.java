package mode;

import java.awt.event.MouseEvent;

public class Selection extends Mymode {

    public Selection() {
		this.name = "Selection" ;
	}

    public void mousePressed( MouseEvent e ) {
        System.out.println("selection");
	}
    public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
	}
    
} 

package mode;

import java.awt.event.MouseEvent;

import objects.ObjectFactory;
import show.Mypenel;

public class CreateBasicObject extends Mymode {

	public CreateBasicObject(String type) {
		this.name = type ;
	}

    public void mousePressed( MouseEvent e ) {
        System.out.println("create " + this.name);
		Mypenel.addobject( ObjectFactory.createObject( this.name, e.getPoint(), e.getPoint() ) );
		
	}
    public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
	}
    
}

package mode;

import java.awt.event.MouseEvent;
import objects.Usecaseobject;
import show.Mypenel;

public class Createusecase extends Mymode {

    public Createusecase() {
		this.name = "Usecase" ;
	}

    public void mousePressed( MouseEvent e ) {
        System.out.println("create usecase");
		Mypenel.addobject(new Usecaseobject(e.getX(), e.getY()));
	}
    public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
	}
    
} 
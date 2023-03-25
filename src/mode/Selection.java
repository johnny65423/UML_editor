package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import objects.Myobject;
import show.Mypenel;

public class Selection extends Mymode {
	private Point start ;
	private Point gap ;

    public Selection() {
		this.name = "Selection" ;
	}

    public void mousePressed( MouseEvent e ) {
		start = e.getPoint() ;
		
		List<Myobject> temp = Mypenel.getobjlist() ;
		boolean find = false ;

        System.out.println("selection list size:"+ temp.size());
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).isin( start )  ;
			if ( result != "out" ) {
				int[] arr = temp.get(i).getloc() ;
				System.out.println(result);
				find = true ;
				gap = new Point( start.x-arr[0], start.y-arr[1] ) ;
				Mypenel.setselectobj(temp.get(i));
			}
			if (!find) 
				Mypenel.setselectobj(null);
			Mypenel.refresh() ;
		}
	}
    public void mouseReleased(MouseEvent e) {
	}
	public void mouseDragged(MouseEvent e) {
		
		Myobject temp = Mypenel.getselectobj() ;
		if ( temp != null ) {
			
			temp.move( new Point(e.getX()- gap.x, e.getY()- gap.y) ) ;

		}

		Mypenel.refresh();
	}
    
} 

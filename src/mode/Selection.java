package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import objects.Myobject;

public class Selection extends Mymode {
	private Point start ;
	private Point gap ;
	private Myobject selectarea ;

    public Selection() {
		super() ;
		this.name = "Selection" ;
	}

    public void mousePressed( MouseEvent e ) {
		start = e.getPoint() ;
		
		List<Myobject> temp = mypenel.getobjlist() ;
		boolean find = false ;
		mypenel.popselectobj();
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).ison( start )  ;
			if ( result != "out" ) {
				int[] arr = temp.get(i).getloc() ;
				System.out.println(result);
				find = true ;
				gap = new Point( start.x -arr[0], start.y - arr[1] ) ;
				start = null ;
				mypenel.addselectobj(temp.get(i));
			}

			mypenel.refresh() ;
		}
	}
	
    public void mouseReleased(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		
		if ( start == null ) {
			List<Myobject> templist = mypenel.getselectobj() ;
			if ( templist.size() > 0 ) {
				Myobject temp = templist.get(0) ;
				temp.setposition( new Point( e.getX() - gap.x, e.getY() - gap.y) ) ;
			}
		} 
		else {
			Point end = e.getPoint() ; 
			mypenel.setselectarea( new Point( start ), new Point( end ) ) ;
			mypenel.multiselect() ;
		}


		mypenel.refresh();
	}
    
} 

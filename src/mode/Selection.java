package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import objects.Myobject;
import objects.ObjectFactory;

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
		
		List<Myobject> temp = mypenel.getobjectList() ;
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
		mypenel.removeobject(selectarea);
		mypenel.refresh() ;
		start = null ;
		selectarea = null ;
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

			if ( selectarea == null ) {
				selectarea = ObjectFactory.createObject( "Area", start,  end) ;
				mypenel.addobject( selectarea ) ;
			}
			else 
				selectarea.setposition(end);

			// mypenel.setselectarea( new Point( start ), new Point( end ) ) ;
			// mypenel.multiselect() ;
			multipleSelect();
		}


		mypenel.refresh();
	}

	private void multipleSelect() {
		List<Myobject> objectList = mypenel.getobjectList() ;
		List<Myobject> selectObjectList = mypenel.getselectobj() ;
		int[] arr = selectarea.getloc() ;
		Point start = new Point(arr[0], arr[1]);
		Point end = new Point(arr[2], arr[3]);
		for ( int i = 0 ; i < objectList.size() ; i++ ) {
            if ( !selectObjectList.contains(objectList.get(i)) && objectList.get(i).inside(start, end) )
                mypenel.addselectobj(objectList.get(i)) ; 
            else if ( selectObjectList.contains(objectList.get(i)) && !objectList.get(i).inside(start, end) )
                mypenel.removeselectobject(objectList.get(i) ) ;
        }
	}
    
} 

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
		
		List<Myobject> temp = mypenel.getObjectList() ;
		boolean find = false ;
		mypenel.clearSelectObject();
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).isOn( start )  ;
			if ( result != "out" ) {
				int[] arr = temp.get(i).getloc() ;
				System.out.println(result);
				find = true ;
				gap = new Point( start.x -arr[0], start.y - arr[1] ) ;
				start = null ;
				mypenel.addSelectObject(temp.get(i));
			}

			mypenel.refresh() ;
		}
	}
	
    public void mouseReleased(MouseEvent e) {
		mypenel.removeObject(selectarea);
		start = null ;
		selectarea = null ;
		mypenel.refresh() ;
	}

	public void mouseDragged(MouseEvent e) {
		
		if ( start == null ) {
			List<Myobject> templist = mypenel.getSelectObject() ;
			if ( templist.size() > 0 ) {
				Myobject temp = templist.get(0) ;
				temp.setPosition( new Point( e.getX() - gap.x, e.getY() - gap.y) ) ;
			}
		} 
		else {
			Point end = e.getPoint() ;

			if ( selectarea == null ) {
				selectarea = ObjectFactory.createObject( "Area", start,  end) ;
				mypenel.addObject( selectarea ) ;
			}
			else 
				selectarea.setPosition(end);
				
			multipleSelect();
		}


		mypenel.refresh();
	}

	private void multipleSelect() {
		List<Myobject> objectList = mypenel.getObjectList() ;
		List<Myobject> selectObjectList = mypenel.getSelectObject() ;
		int[] arr = selectarea.getloc() ;
		Point start = new Point(arr[0], arr[1]);
		Point end = new Point(arr[2], arr[3]);
		for ( int i = 0 ; i < objectList.size() ; i++ ) {
            if ( !selectObjectList.contains(objectList.get(i)) && objectList.get(i).inside(start, end) )
                mypenel.addSelectObject(objectList.get(i)) ; 
            else if ( selectObjectList.contains(objectList.get(i)) && !objectList.get(i).inside(start, end) )
                mypenel.removesSelectObject(objectList.get(i) ) ;
        }
	}
    
} 

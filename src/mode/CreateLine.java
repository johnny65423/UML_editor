package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import object.Myobject;
import object.ObjectFactory;


public class CreateLine extends Mymode {
    private Point start, end ;
    private int thisindex ;
	private Myobject tempLine ;
    
    public CreateLine( String type ) {
		super();
		this.name = type ;
	}

    public void mousePressed( MouseEvent e ) {
		List<Myobject> temp = mypenel.getObjectList() ;
		boolean find = false ;

        
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).isOn( e.getPoint() )  ;
			if ( result != "out" && result != "group" ) {
				System.out.println(result);
				find = true ;
				start = temp.get(i).getPort(result) ;
				thisindex = i ;
				System.out.println("GET START");
			}
			if (!find) 
				start = null ;
			mypenel.refresh() ;
		}
	}

    public void mouseReleased(MouseEvent e) {

		if ( start != null ) {
			List<Myobject> temp = mypenel.getObjectList() ;
			boolean find = false ;
	
			for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
				String result = temp.get(i).isOn( e.getPoint() )  ;
				if ( i != thisindex && result != "out" && result != "group" ) {
					System.out.println(result);
					find = true ;
					end = temp.get(i).getPort(result) ;
				}
			}
	
			mypenel.removeObject(tempLine);
			if ( find ) 
				mypenel.addObject( ObjectFactory.createObject( this.name, start, end ) );
			mypenel.refresh() ;
			start = null ;
			end = null ;
			tempLine = null ;
		}
		
	}
	public void mouseDragged(MouseEvent e) {
		if (start != null) {
			if ( tempLine == null ) {
				tempLine = ObjectFactory.createObject( this.name, start,  e.getPoint()) ;
				mypenel.addObject( tempLine ) ;
			}
			else 
				tempLine.setPosition(e.getPoint());
			
			mypenel.refresh();
		}

	}

    
}

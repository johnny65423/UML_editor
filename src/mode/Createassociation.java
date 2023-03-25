package mode;

import java.awt.event.MouseEvent;
import java.util.List;

import objects.Associationline;
import objects.Myobject;
import show.Mypenel;

public class Createassociation extends Createline {
	int thisindex ;
	public Createassociation() {
		this.name = "Association" ;
	}

    public void mousePressed( MouseEvent e ) {
        // System.out.println("create association");
		List<Myobject> temp = Mypenel.getobjlist() ;
		boolean find = false ;

        
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).isin( e.getPoint() )  ;
			if ( result != "out" ) {
				System.out.println(result);
				find = true ;
				start = getport(temp.get(i), result) ;
				thisindex = i ;
				System.out.println("GET START");
			}
			if (!find) 
				start = null ;
			Mypenel.refresh() ;
		}
	}
    public void mouseReleased(MouseEvent e) {
		List<Myobject> temp = Mypenel.getobjlist() ;
		boolean find = false ;

        
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).isin( e.getPoint() )  ;
			if ( i != thisindex && result != "out" ) {
				System.out.println(result);
				find = true ;
				
				end = getport(temp.get(i), result) ;
			}
			
			
		}

		Mypenel.settempline(null);
		if (find) 
			Mypenel.addobject(new Associationline(start, end));
		Mypenel.refresh() ;
		start = null ;
		end = null ;
	}
	public void mouseDragged(MouseEvent e) {
		if (start != null) {
			// System.out.println("drag...");
			Associationline temp = new Associationline(start, e.getPoint()) ;
			Mypenel.settempline(temp);
			Mypenel.refresh();
		}

	}
    
}

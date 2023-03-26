package mode;

import java.awt.event.MouseEvent;
import java.util.List;
import objects.Generalizationline;
import objects.Myobject;
import show.Mypenel;

public class Creategeneralization extends Createline {
	int thisindex ;
    public Creategeneralization() {
		this.name = "Generalization" ;
	}

    public void mousePressed( MouseEvent e ) {
        // System.out.println("create association");
		List<Myobject> temp = Mypenel.getobjlist() ;
		boolean find = false ;

        
		for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
			String result = temp.get(i).ison( e.getPoint() )  ;
			if ( result != "out" && result != "group" ) {
				System.out.println(result);
				find = true ;
				start = temp.get(i).getport(result) ;
				thisindex = i ;
				System.out.println("GET START");
			}
			if (!find) 
				start = null ;
			Mypenel.refresh() ;
		}
	}
    public void mouseReleased(MouseEvent e) {

		if ( start != null ) {
			List<Myobject> temp = Mypenel.getobjlist() ;
			boolean find = false ;
	
			
			for ( int i = temp.size()-1 ; i >= 0 && !find ; i-- ) {
				String result = temp.get(i).ison( e.getPoint() )  ;
				if ( i != thisindex && result != "out" && result != "group" ) {
					System.out.println(result);
					find = true ;
					end = temp.get(i).getport(result) ;
				}
				
				
			}
	
			Mypenel.settempline(null);
			if (find) 
				Mypenel.addobject(new Generalizationline(start, end));
			Mypenel.refresh() ;
			start = null ;
			end = null ;
		}
		
	}
	public void mouseDragged(MouseEvent e) {
		if (start != null) {
			// System.out.println("drag...");
			Generalizationline temp = new Generalizationline(start, e.getPoint()) ;
			Mypenel.settempline(temp);
			Mypenel.refresh();
		}

	}
    
} 

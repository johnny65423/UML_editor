package objects;

import java.awt.Graphics;
import java.util.List;
import java.awt.Point;
import java.util.ArrayList;

public class Composite extends Myobject {
    private List<Myobject> groupobjlist = new ArrayList<Myobject>() ;

    public Composite() {
        this.name = "composite" ;
    }
    
    public void setposition( Point p ) {
        this.x1 = p.x - 10 ;
        this.x2 = p.x + w + 10 ;
        this.y1 = p.y - 10 ;
        this.y2 = p.y + h + 10 ;

    }

    public void move( Point p ) {
        this.x1 = p.x - 10 ;
        this.x2 = p.x + w + 10 ;
        this.y1 = p.y - 10 ;
        this.y2 = p.y + h + 10 ;
    }

    public void paintobj(Graphics g) {
        ;
    }

    public void paintselect( Graphics g ) {
        System.out.println("group select.");
    }

    public Point getport( String direction ){
        return null ;
    };
}

package objects;

import java.awt.Graphics2D;
import java.awt.Point;

public abstract class Connectionline extends Myobject {
    public Point[] port = new Point[2] ;


    public abstract void paintObject(Graphics2D g) ;
    public void setPosition( Point p ) {
        port[1].x = p.x ;
        port[1].y = p.y ;
    }
    
    public String isOn(Point p){
        return "out" ;
    }

    public boolean inside( Point p1, Point p2 ) {
        // System.out.println("line not inside.");
        return false ;
    }

    public Connectionline( Point start, Point end ) {
        this.name = "line" ;
        this.port[0] = start ;
        this.port[1] = end ;
        this.x1 = (int) port[0].getX() ;
        this.y1 = (int) port[0].getY() ;
        this.x2 = (int) port[1].getX() ;
        this.y2 = (int) port[1].getY() ;
        this.w = x2 - x1 ;
        this.h = y2 - y1 ;
    }

    public void updateloc() {
        this.x1 = port[0].x ;
        this.y1 = port[0].y ;
        this.x2 = port[1].x ;
        this.y2 = port[1].y ;
        this.w = x2 - x1 ;
        this.h = y2 - y1 ;
    }

    public Point getPort( String direction ){
        
        return null ;
    };

    public void paintSelect(Graphics2D g) {
        ;
    }
    
}

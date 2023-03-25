package objects;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Connectionline extends Myobject {
    public Point[] port = new Point[2] ;


    public abstract void paintobj(Graphics g) ;
    public abstract void paintselect(Graphics g);
    public void setposition( Point p ) {
        ;
    }

    public void move( Point p ) {
        ;
    }

    public String ison(Point p){
        return "out" ;

    }

    public boolean inside( Point p1, Point p2 ) {
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

    public Point getport(int i){
        return port[i] ;
    };
    
}

package objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Basicobject extends Myobject {
    public Point[] port = new Point[4] ;
    
    protected Point center ;
    protected List<Connectionline> linelist = new ArrayList<Connectionline>() ;
    public void setposition( Point p ) {
        this.x1 = p.x ;
        this.x2 = p.x + w ;
        this.y1 = p.y ;
        this.y2 = p.y + h ;
        this.port[0] = new Point( (x1+x2)/2, y1 - 5 ) ;
        this.port[1] = new Point( (x1+x2)/2, y2 + 5 ) ;
        this.port[2] = new Point( x1 - 5, (y1+y2)/2 ) ;
        this.port[3] = new Point( x2 + 5, (y1+y2)/2 ) ;
        this.center = new Point( (x1+x2)/2, (y1+y2)/2 ) ;
    }

    public void move( Point p ) {

        this.x1 = p.x ;
        this.x2 = p.x + w ;
        this.y1 = p.y ;
        this.y2 = p.y + h ;
        this.port[0].x = (x1+x2)/2 ;
        this.port[0].y = y1 - 5 ;
        this.port[1].x = (x1+x2)/2 ;
        this.port[1].y = y2 + 5 ;
        this.port[2].x = x1 - 5 ;
        this.port[2].y = (y1+y2)/2 ;
        this.port[3].x = x2 + 5 ;
        this.port[3].y = (y1+y2)/2 ;


        this.center = new Point( (x1+x2)/2, (y1+y2)/2 ) ;
    }

    public Point getport( int i ) {
        return port[i];
    }

    public abstract void paintobj( Graphics g ) ;
    
    public void paintselect( Graphics g ) {
        for ( int i = 0 ; i < 4 ; i++ ) {
            g.fillRect( this.port[i].x-5, this.port[i].y-5, 10, 10);
        }
    }
    
    public String ison( Point p ) {
        if ( getarea(x1, y1, x2, y1).contains(p) )
            return "up" ;
        else if ( getarea(x1, y2, x2, y2).contains(p) )
            return "down" ;
        else if ( getarea(x1, y1, x1, y2).contains(p) )
            return "left" ;
        else if ( getarea(x2, y1, x2, y2).contains(p) )
            return "right" ;

        return "out" ;
    }

    public boolean inside( Point p1, Point p2 ) {
        if ( p1.x <= x1 && p2.x >= x2 && p1.y <= y1 && p2.y >= y2 )
            return true ;
        return false ;

    } 

    private Area getarea(int px1, int py1, int px2, int py2) {
        Path2D path = new Path2D.Double();
        path.moveTo(center.getX(), center.getY());
        path.lineTo(px1, py1);
        path.lineTo(px2, py2);

        return new Area(path);
    }

}

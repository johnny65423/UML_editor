package objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

public abstract class Basicobject extends Myobject {
    public Point[] port = new Point[4] ;
    
    
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
        //System.out.println(""+x1+" "+y1);
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

    public Point getport( String direction ) {
        int i = -1 ;
        if ( direction == "up" )
            i = 0 ;
        else if ( direction == "down" )
            i = 1 ;
        else if ( direction == "left" )
            i = 2 ;
        else if ( direction == "right" )
            i = 3 ;
        
        return port[i];
    }

    public abstract void paintobj( Graphics g ) ;
    
    public void paintselect( Graphics g ) {
        for ( int i = 0 ; i < 4 ; i++ ) {
            g.fillRect( this.port[i].x-5, this.port[i].y-5, 10, 10);
        }
    }

    



}

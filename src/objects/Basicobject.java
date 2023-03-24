package objects;

import java.awt.Point;

public class Basicobject extends Object {
    // private Port[] p = new Port[4] ;
    protected int w, h ;
    protected void setposition( Point p ) {
        this.x1 = p.x ;
        this.x2 = p.x + w ;
        this.y1 = p.y ;
        this.y2 = p.y + h ;
    }

    /*
    public void setport() {
        this.p[0] = new Port( (x1+x2)/2, y1 ) ;
        this.p[1] = new Port( (x1+x2)/2, y2 ) ;
        this.p[2] = new Port( x1, (y1+y2)/2 ) ;
        this.p[3] = new Port( x2, (y1+y2)/2 ) ;
    } 
     */
    
}

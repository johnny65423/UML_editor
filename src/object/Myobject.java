package object;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Myobject {
    protected int x1, x2, y1, y2 ;
    protected int w, h ;
    protected String name ;
    public boolean undergroup = false ;
    public abstract void paintObject( Graphics g ) ;
    public abstract void paintSelect( Graphics g ) ;
    public abstract Point getPort( String direction ) ;
    public boolean unGroup() {
        return false;
    }
    public int getindex() {
        return -1 ;
    }
    public abstract String isOn( Point p ) ; 

    public abstract boolean inside( Point p1, Point p2 );
    public abstract void setPosition(Point point) ;
    public abstract void reName() ;
    public int[] getloc() {
        int[] arr = new int[4];
        arr[0] = x1 ;
        arr[1] = y1 ;
        arr[2] = x2 ;
        arr[3] = y2 ;
        return arr;
    }
}

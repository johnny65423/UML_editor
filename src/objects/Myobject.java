package objects;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Myobject {
    protected int x1, x2, y1, y2 ;
    protected int w, h ;
    public String name ;
    protected Point center ;
    public boolean undergroup = false ;
    public abstract void paintobj( Graphics g ) ;
    public abstract void paintselect( Graphics g ) ;
    public abstract Point getport( String direction ) ;
    public boolean ungroup() {
        return false;
    }
    public int getindex() {
        return -1 ;
    }
    public abstract String ison( Point p ) ; 

    public abstract boolean inside( Point p1, Point p2 );
    public abstract void setposition(Point point) ;
    public int[] getloc() {
        int[] arr = new int[4];
        arr[0] = x1 ;
        arr[1] = y1 ;
        arr[2] = x2 ;
        arr[3] = y2 ;
        return arr;
    }
}

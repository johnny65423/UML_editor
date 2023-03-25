package objects;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Myobject {
    protected int x1, x2, y1, y2 ;
    protected int w, h ;
    public String name ;
    public abstract void paintobj( Graphics g ) ;
    public abstract void paintselect( Graphics g ) ;
    public abstract Point getport( int i ) ;
    public abstract String isin( Point p );
    public abstract void setposition(Point point) ;
    public abstract void move(Point point) ;
    public int[] getloc() {
        int[] arr = new int[4];
        arr[0] = x1 ;
        arr[1] = y1 ;
        arr[2] = x2 ;
        arr[3] = y2 ;
        return arr;
    }
}

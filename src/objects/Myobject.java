package objects;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

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
        if ( p1.x <= x1 && p2.x >= x2 && p1.y <= y1 && p2.y >= y2 && !undergroup )
            return true ;
        return false ;

    } 
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

    private Area getarea(int px1, int py1, int px2, int py2) {
        Path2D path = new Path2D.Double();
        path.moveTo(center.getX(), center.getY());
        path.lineTo(px1, py1);
        path.lineTo(px2, py2);

        return new Area(path);
    }
}

package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import show.Mypenel;

import java.awt.Point;
import java.util.ArrayList;

public class Area extends Myobject {
    private Mypenel mypenel ;
    Point start, end ;
    public Area( Point start, Point end ) {
        this.mypenel = Mypenel.getmypenel();
        this.name = "Area" ;
        x1 = Math.min(start.x, end.x);
        x2 = Math.max(start.x, end.x);
        y1 = Math.min(start.y, end.y);
        y2 = Math.max(start.y, end.y);
        w = x2 - x1;
        h = y2 - y1;
    }

    public void paintobj(Graphics g) {
        

        g.setColor(new Color(168, 167, 255, 102));
        g.fillRect(x1, y1, w, h);
        g.setColor(new Color(168, 167, 255, 205));
        g.drawRect(x1, y1, w, h);
    }

    public void paintselect(Graphics g) {
        ;
    }

    public Point getport(String direction) {
        return null ;
    }

    public String ison(Point p) {
        return "out" ;
    }

    public boolean inside(Point p1, Point p2) {
        return false ;
    }

    public void setposition(Point point) {
        x1 = Math.min(start.x, point.x);
        x2 = Math.max(start.x, point.x);
        y1 = Math.min(start.y, point.y);
        y2 = Math.max(start.y, point.y);
        w = x2 - x1;
        h = y2 - y1;
    }
    


}

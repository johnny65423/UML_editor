package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Area extends Myobject {
    Point start, end ;
    public Area( Point start, Point end ) {
        this.name = "Area" ;
        this.start = new Point(start);
        x1 = Math.min(start.x, end.x);
        x2 = Math.max(start.x, end.x);
        y1 = Math.min(start.y, end.y);
        y2 = Math.max(start.y, end.y);
        w = x2 - x1;
        h = y2 - y1;
    }

    public void paintObject(Graphics g) {
        

        g.setColor(new Color(168, 167, 255, 102));
        g.fillRect(x1, y1, w, h);
        g.setColor(new Color(168, 167, 255, 205));
        g.drawRect(x1, y1, w, h);
    }

    public void paintSelect(Graphics g) {
        ;
    }

    public Point getPort(String direction) {
        return null ;
    }

    public String isOn(Point p) {
        return "out" ;
    }

    public boolean inside(Point p1, Point p2) {
        return false ;
    }

    public void setPosition(Point point) {
        x1 = Math.min(start.x, point.x);
        x2 = Math.max(start.x, point.x);
        y1 = Math.min(start.y, point.y);
        y2 = Math.max(start.y, point.y);
        w = x2 - x1;
        h = y2 - y1;
    }
    
    public void reName() {
        System.out.println("Can not rename a Area.");
    }

}

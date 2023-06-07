package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Associationline extends Connectionline {

    public Associationline( Point start, Point end ) {
        super(start, end);
    }

    public void paintObject(Graphics g) {
        updateloc();
        
        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);

        double len = Math.sqrt( w*w + h*h ) ;

        double angle = 3 * Math.PI / 4;
        double vx = w/len, vy = h/len ;
        double rvx = vx * Math.cos(angle) - vy* Math.sin(angle) ;
        double rvy = vx * Math.sin(angle) + vy * Math.cos(angle) ;
        g.drawLine(x2, y2, (int)(x2 + 20*rvx), (int)(y2 + 20*rvy));

        angle = - 3 * Math.PI / 4;
        vx = w/len;
        vy = h/len ;
        rvx = vx * Math.cos(angle) - vy* Math.sin(angle) ;
        rvy = vx * Math.sin(angle) + vy * Math.cos(angle) ;
        g.drawLine(x2, y2, (int)(x2 + 20*rvx), (int)(y2 + 20*rvy));

    }

}

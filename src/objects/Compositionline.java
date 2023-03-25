package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Compositionline extends Connectionline {
    int[] pointx, pointy ;

    public Compositionline( Point start, Point end ) {
        super(start, end);
        pointx = new int[4];
        pointy = new int[4];
    }

    public void paintobj(Graphics g) {
        updateloc();

        g.setColor(Color.BLACK);
        g.drawLine(x1, y1, x2, y2);
        double len = Math.sqrt( w*w + h*h ) ;

        double angle = 3 * Math.PI / 4;
        double vx = w/len, vy = h/len ;
        double rvx = vx * Math.cos(angle) - vy* Math.sin(angle) ;
        double rvy = vx * Math.sin(angle) + vy * Math.cos(angle) ;
        //g.drawLine(x2, y2, (int)(x2 + 20*rvx), (int)(y2 + 20*rvy));
        pointx[0] = (int)(x2 + 20*rvx) ;
        pointy[0] = (int)(y2 + 20*rvy) ;

        angle = - 3 * Math.PI / 4;
        vx = w/len;
        vy = h/len ;
        rvx = vx * Math.cos(angle) - vy* Math.sin(angle) ;
        rvy = vx * Math.sin(angle) + vy * Math.cos(angle) ;
        //g.drawLine(x2, y2, (int)(x2 + 20*rvx), (int)(y2 + 20*rvy));
        pointx[1] = pointx[0] + (int)(20*rvx) ;
        pointy[1] = pointy[0] + (int)(20*rvy) ;
        pointx[2] = (int)(x2 + 20*rvx) ;
        pointy[2] = (int)(y2 + 20*rvy) ;
        pointx[3] = (int)x2 ;
        pointy[3] = (int)y2 ;

        g.setColor(Color.WHITE);
        g.fillPolygon(pointx, pointy, 4 );
        g.setColor(Color.BLACK);
        g.drawPolygon(pointx, pointy, 4 );

    }


    public void paintselect(Graphics g) {
        ;
    }

}
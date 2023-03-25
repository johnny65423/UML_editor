package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Usecaseobject extends Basicobject {

    public Usecaseobject(int x, int y){
		this.name = "UsecaseObj";
		this.w = 120;
		this.h = 75;
		this.setposition(new Point(x,y));

	}

	public void paintobj( Graphics g ) {
		//super.paintobj(g);
        g.setColor(Color.WHITE);
		g.fillOval(x1, y1, w, h);
		g.setColor(Color.BLACK);
		g.drawOval(x1, y1, w, h);
		g.drawString(name, x1+18, y1+40);
	}
}

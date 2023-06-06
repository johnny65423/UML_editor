package objects;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Usecaseobject extends Basicobject {

    public Usecaseobject(int x, int y){
		super();
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

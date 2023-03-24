package objects;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class Classobject extends Basicobject {

    public Classobject(int x, int y){
		this.w = 90;
		this.h = 90;
		this.setposition(new Point(x,y));

	}

	public void paintobj( Graphics g ) {
		//super.paintobj(g);
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, w, h);
	}
}

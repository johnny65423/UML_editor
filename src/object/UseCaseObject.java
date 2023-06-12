package object;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class UseCaseObject extends BasicObject {

    public UseCaseObject(int x, int y){
		super();
		this.name = "UsecaseObj";
		this.w = 120;
		this.h = 75;
		this.setPosition(new Point(x,y));

	}

	public void paintObject( Graphics g ) {
		//super.paintObject(g);
		g.setColor(Color.WHITE);
		g.fillOval(x1, y1, w, h);
		g.setColor(Color.BLACK);
		g.drawOval(x1, y1, w, h);
		g.drawString(name, x1+18, y1+40);
	}
}

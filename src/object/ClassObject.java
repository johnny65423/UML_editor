package object;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

public class ClassObject extends BasicObject {

	private int gridsize ;

    public ClassObject(int x, int y){
		super();
		this.name = "ClassObj";
		this.w = 90;
		this.h = 90;
		this.gridsize = 30 ;
		this.setPosition(new Point(x,y));

	}

	public void paintObject( Graphics g ) {
		//super.paintObject(g);
		g.setColor(Color.WHITE);
		g.fillRect(x1, y1, w, h);
		g.setColor(Color.BLACK);
		g.drawRect(x1, y1, w, h);
		g.drawLine(x1, y1+gridsize, x2, y1+gridsize);
		g.drawLine(x1, y1+2*gridsize, x2, y1+2*gridsize);
		g.drawString(name, x1+5, y1+20);
		//paintport(g);
	}
}

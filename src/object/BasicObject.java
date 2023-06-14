package object;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public abstract class BasicObject extends Myobject {
    public Point[] port = new Point[4] ;
    protected Point center ;
    
    public BasicObject() {
        for ( int i = 0 ; i < port.length ; i++ )
            port[i] = null ;
    }
    
    protected List<ConnectionLine> linelist = new ArrayList<ConnectionLine>() ;
    public boolean inside( Point p1, Point p2 ) {
        if ( p1.x <= x1 && p2.x >= x2 && p1.y <= y1 && p2.y >= y2 && !undergroup )
            return true ;
        return false ;

    } 
    public void setPosition( Point p ) {
        this.x1 = p.x ;
        this.x2 = p.x + w ;
        this.y1 = p.y ;
        this.y2 = p.y + h ;
        if (this.port[0] == null ) {
            System.out.println("new point");
            this.port[0] = new Point( (x1+x2)/2, y1 - 5 ) ;
            this.port[1] = new Point( (x1+x2)/2, y2 + 5 ) ;
            this.port[2] = new Point( x1 - 5, (y1+y2)/2 ) ;
            this.port[3] = new Point( x2 + 5, (y1+y2)/2 ) ;
        }
        else {
            this.port[0].x = (x1+x2)/2 ;
            this.port[0].y = y1 - 5 ;
            this.port[1].x = (x1+x2)/2 ;
            this.port[1].y = y2 + 5 ;
            this.port[2].x = x1 - 5 ;
            this.port[2].y = (y1+y2)/2 ;
            this.port[3].x = x2 + 5 ;
            this.port[3].y = (y1+y2)/2 ;
        }

        this.center = new Point( (x1+x2)/2, (y1+y2)/2 ) ;
    }

    public Point getPort( String direction ) {
        int i = -1 ;
        if ( direction == "up" )
            i = 0 ;
        else if ( direction == "down" )
            i = 1 ;
        else if ( direction == "left" )
            i = 2 ;
        else if ( direction == "right" )
            i = 3 ;
        
        return port[i];
    }

    public String isOn( Point p ) {
        if ( getArea(x1, y1, x2, y1).contains(p) )
            return "up" ;
        else if ( getArea(x1, y2, x2, y2).contains(p) )
            return "down" ;
        else if ( getArea(x1, y1, x1, y2).contains(p) )
            return "left" ;
        else if ( getArea(x2, y1, x2, y2).contains(p) )
            return "right" ;

        return "out" ;
    }

    public abstract void paintObject( Graphics g ) ;
    
    public void paintSelect( Graphics g ) {
        for ( int i = 0 ; i < 4 ; i++ ) {
            g.fillRect( this.port[i].x-5, this.port[i].y-5, 10, 10);
        }
    }

    private Area getArea(int px1, int py1, int px2, int py2) {
        Path2D path = new Path2D.Double();
        path.moveTo(center.getX(), center.getY());
        path.lineTo(px1, py1);
        path.lineTo(px2, py2);

        return new Area(path);
    }

    public void reName() {
        JTextField textArea = new JTextField(name);
        JScrollPane scrollPane = new JScrollPane(textArea);
        Object[] options = {"OK", "Cancel"};
        int choice = JOptionPane.showOptionDialog(null, scrollPane, "Enter your text",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
        if (choice == JOptionPane.OK_OPTION) {
            name = textArea.getText();
            System.out.println("Change to: " + name);
        }
    }

}

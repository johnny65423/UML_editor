package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import show.Mypenel;

import java.awt.Point;
import java.util.ArrayList;

public class Composite extends Myobject {
    private List<Myobject> groupobjlist = new ArrayList<Myobject>() ;
    private List<Point> objgaplist = new ArrayList<Point>() ;
    private int target ; 
    public Composite() {
        this.name = "_composite***" ;
        this.target = -1 ;
        this.collectobj();
        this.initPosition(null);
    }
    
    private void initPosition( Point p ) {
        this.x1 = groupobjlist.get(0).x1 ;
        this.x2 = groupobjlist.get(0).x2 ;
        this.y1 = groupobjlist.get(0).y1 ;
        this.y2 = groupobjlist.get(0).y2 ;

        for( int i = 0 ; i < groupobjlist.size() ; i++ ) {
            Myobject temp = groupobjlist.get(i) ;
            this.x1 = Math.min(this.x1, temp.x1) ;
            this.x2 = Math.max(this.x2, temp.x2) ;
            this.y1 = Math.min(this.y1, temp.y1) ;
            this.y2 = Math.max(this.y2, temp.y2) ;
        }

        this.x1 -= 10 ;
        this.x2 += 10 ;
        this.y1 -= 10 ;
        this.y2 += 10 ;
        this.w = this.x2 - this.x1 ;
        this.h = this.y2 - this.y1 ;


        for( int i = 0 ; i < groupobjlist.size() ; i++ ) {
            Myobject temp = groupobjlist.get(i) ;
            Point gap = new Point( temp.x1 -x1, temp.y1 - y1 ) ;
            System.out.println("gap:"+gap.x+" "+gap.y);
            objgaplist.add(gap);
        }

    }

    public String ison( Point p ) {
        if ( x1 <= p.x && p.x <= x2 && y1 <= p.y && p.y <= y2 )
            return "group" ;
        return "out" ;
    }

    public boolean inside( Point p1, Point p2 ) {
        if ( p1.x <= x1 && p2.x >= x2 && p1.y <= y1 && p2.y >= y2 && !undergroup )
            return true ;
        return false ;

    } 

    public void setposition( Point p ) {
        this.x1 = p.x ;
        this.x2 = p.x + w ;
        this.y1 = p.y ;
        this.y2 = p.y + h ;

        for( int i = 0 ; i < groupobjlist.size() ; i++ ) {
            Myobject temp = groupobjlist.get(i) ;
            // int[] arr = temp.getloc() ;
            // Point gap = new Point(this.x1 -arr[0] , this.y1 - arr[1] ) ;
            // System.out.println(""+( gap.x)+" "+(gap.y));
            temp.setposition(new Point( this.x1+objgaplist.get(i).x, this.y1+objgaplist.get(i).y ));
        }


    }

    public void paintobj(Graphics g) {
        ;
    }

    public void paintselect( Graphics g ) {
        g.setColor(new Color(227, 235, 152, 150));
        g.fillRect(x1, y1, w, h);
        g.setColor(new Color(227, 235, 152, 255));
        g.drawRect(x1, y1, w, h);
        g.setColor(Color.BLACK);
        for( int i = 0 ; i < groupobjlist.size() ; i++ ) {
            groupobjlist.get(i).paintselect(g);
        }
    }

    public Point getport( String direction ){
        return null ;
    };

    public int getindex() {
        return target ;
    }

    private void collectobj() {
        List<Myobject> temp = Mypenel.getselectobj() ;
        for( int i = 0 ; i < temp.size() ; i++ ) {
            temp.get(i).undergroup = true ;
            groupobjlist.add(temp.get(i));
            target = Math.max(target, Mypenel.getobjlist().indexOf(temp.get(i)));
        }

    }

    public boolean ungroup() {
        System.out.println("ungroup");

        for( int i = 0 ; i < groupobjlist.size() ; i++ ) {
            groupobjlist.get(i).undergroup = false ;
        }
        while ( groupobjlist.size() > 0 )
            groupobjlist.remove( groupobjlist.size() - 1 ) ;
        while ( objgaplist.size() > 0 )
        objgaplist.remove( objgaplist.size() - 1 ) ;
        return true ;
    }
    
}

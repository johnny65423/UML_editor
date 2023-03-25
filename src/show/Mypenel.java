package show;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import mode.*;
import objects.*;

public class Mypenel extends JPanel {
    private static Mypenel mypenel ;
    private static Mymode choosemode ;
    private static List<Myobject> objlist = new ArrayList<Myobject>() ;
    private static List<Myobject> selectobj = new ArrayList<Myobject>() ;
    private static Myobject templine = null ;
    private static boolean selectarea = false ;
    private static Point[] selectareapoint = new Point[2] ;

    private Mypenel() { // from ChatGPT
        // this.setToolTipText("penel"); 
    }
    
    public static Mypenel getmypenel() {
        if (mypenel == null) {
            mypenel = new Mypenel();
        }
        return mypenel;
    }

    public static void setmode(Mymode mode){
        System.out.println("change Mode");
        mypenel.removeMouseListener((MouseListener) choosemode);
        mypenel.removeMouseMotionListener((MouseMotionListener) choosemode);
        choosemode = mode ;
        mypenel.addMouseListener((MouseListener) choosemode);
        mypenel.addMouseMotionListener((MouseMotionListener) choosemode);
        
    } 

    public static void addobject( Myobject obj ) {
        // System.out.println("add" + objlist.size());
        objlist.add(obj);
        mypenel.repaint();
        // System.out.println("added" + objlist.size());
    }

    public void paint( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        // System.out.println("123"+objlist.size());
        g2d.setColor(Color.LIGHT_GRAY);
		g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.setColor(Color.BLACK);
        

        for ( int i = 0 ; i < objlist.size() ; i++ ) {
            objlist.get(i).paintobj(g2d);
            // for ( int j = 0 ; j < selectobj.size() ; j++ )
                if ( selectobj.contains(objlist.get(i)) )
                    objlist.get(i).paintselect(g2d);
        }
        //if (selectobj != null)
        //    selectobj.paintselect(g2d);
        if (templine !=  null)
            templine.paintobj(g2d);

        if (selectarea)
            paintselectarea(g2d);
        System.out.println(selectobj.size());
        
    }

    public static void refresh() {
        mypenel.revalidate();
        mypenel.repaint();
    }

    public static void addselectobj( Myobject obj ) {
        Mypenel.selectobj.add(obj) ;
    }

    public static void popselectobj() {
        while ( Mypenel.selectobj.size() > 0 )
            Mypenel.selectobj.remove( Mypenel.selectobj.size() - 1 ) ;
        
        selectarea = false ;
    }

    public static List<Myobject> getselectobj() {
        return Mypenel.selectobj ;
    }

    public static void settempline( Myobject l ) {
        Mypenel.templine = l ;
    }

    public static List<Myobject> getobjlist() {
        return objlist ;
    }

    public static void setselectarea( Point p1, Point p2 ) {
        selectarea = true ;
        int x1, y1, x2, y2 ;
        x1 = Math.min(p1.x, p2.x);
        x2 = Math.max(p1.x, p2.x);
        y1 = Math.min(p1.y, p2.y);
        y2 = Math.max(p1.y, p2.y);
        selectareapoint[0] = new Point(x1, y1) ;
        selectareapoint[1] = new Point(x2, y2) ;
    }

    public static void multiselect() {
        for ( int i = 0 ; i < objlist.size() ; i++ ) {
            if ( !selectobj.contains(objlist.get(i)) && objlist.get(i).inside(selectareapoint[0], selectareapoint[1]) )
                selectobj.add( objlist.get(i) ) ;
            else if ( selectobj.contains(objlist.get(i)) && !objlist.get(i).inside(selectareapoint[0], selectareapoint[1]) )
                selectobj.remove(objlist.get(i) ) ;
                

        }
    }

    private void paintselectarea( Graphics2D g ) {

        int w = selectareapoint[1].x - selectareapoint[0].x;
        int h = selectareapoint[1].y - selectareapoint[0].y;

        g.setColor(new Color(168, 167, 255, 102));
        g.fillRect(selectareapoint[0].x, selectareapoint[0].y, w, h);
        g.setColor(new Color(168, 167, 255, 205));
        g.drawRect(selectareapoint[0].x, selectareapoint[0].y, w, h);
    }
}

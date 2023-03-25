package show;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
    private static Myobject selectobj = null, templine = null ;
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
        if (selectobj != null)
            selectobj.paintselect(g2d);

        for ( int i = 0 ; i < objlist.size() ; i++ ) {
            objlist.get(i).paintobj(g2d);
            /* 
            if (objlist.get(i).name == "line") {
                System.out.print(objlist.get(i).getport(0));
                System.out.println(" " + objlist.get(i).getport(1));
            } 
            */
            //System.out.println(i);
        }
        //if (selectobj != null)
        //    selectobj.paintselect(g2d);
        if (templine !=  null)
            templine.paintobj(g2d);
    }

    public static void refresh() {
        mypenel.revalidate();
        mypenel.repaint();
    }

    public static void setselectobj( Myobject obj ) {
        Mypenel.selectobj = obj ;
    }

    public static Myobject getselectobj() {
        return Mypenel.selectobj ;
    }

    public static void settempline( Myobject l ) {
        Mypenel.templine = l ;
    }

    public static List<Myobject> getobjlist() {
        return objlist ;
    }

}

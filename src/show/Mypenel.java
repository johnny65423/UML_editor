package show;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
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
        System.out.println("add" + objlist.size());
        objlist.add(obj);
        mypenel.repaint();
        System.out.println("added" + objlist.size());
    }

    public void paint( Graphics g ) {
        System.out.println("123"+objlist.size());
        g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0,0,getSize().width,getSize().height);

        for ( int i = 0 ; i < objlist.size() ; i++ ) {
            objlist.get(i).paintobj(g);
            System.out.println(i);
        }
    }
}

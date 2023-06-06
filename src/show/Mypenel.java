package show;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
    private Mymode choosemode ;
    private List<Myobject> objlist = new ArrayList<Myobject>() ;
    private List<Myobject> selectobj = new ArrayList<Myobject>() ;
    private boolean selectarea = false ;
    private Point[] selectareapoint = new Point[2] ;

    private Mypenel() {

    }
    
    public static Mypenel getmypenel() {
        if (mypenel == null) {
            mypenel = new Mypenel();
        }
        return mypenel;
    }

    public void setmode(Mymode mode){
        System.out.println("change Mode");
        mypenel.removeMouseListener((MouseListener) choosemode);
        mypenel.removeMouseMotionListener((MouseMotionListener) choosemode);
        choosemode = mode ;
        mypenel.addMouseListener((MouseListener) choosemode);
        mypenel.addMouseMotionListener((MouseMotionListener) choosemode);
        
    } 

    public void addobject( Myobject obj ) {
        if ( !objlist.contains( obj ) )
            objlist.add(obj);
        mypenel.repaint();
    }

    public void addobject( Myobject obj, int index ) {
        if ( !objlist.contains( obj ) )
            objlist.add(index + 1, obj);
        mypenel.repaint();

    }

    public void removeobject( Myobject obj ) {
        objlist.remove(obj);
        mypenel.repaint();
    }

    public void paint( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
        // System.out.println("123"+objlist.size());
        g2d.setColor(new Color( 200, 200, 200 ));
		g2d.fillRect(0,0,getSize().width,getSize().height);
        g2d.setColor(Color.BLACK);
        

        for ( int i = 0 ; i < objlist.size() ; i++ ) {
            objlist.get(i).paintobj(g2d);
            if ( selectobj.contains(objlist.get(i)) )
                objlist.get(i).paintselect(g2d);
        }

        if (selectarea)
            paintselectarea(g2d);
        
        
    }

    public void refresh() {
        mypenel.revalidate();
        mypenel.repaint();
    }

    public void addselectobj( Myobject obj ) {
        selectobj.add(obj) ;
    }

    public void popselectobj() {
        while ( selectobj.size() > 0 )
            selectobj.remove( selectobj.size() - 1 ) ;
        
        selectarea = false ;
    }

    public List<Myobject> getselectobj() {
        return selectobj ;
    }

    public List<Myobject> getobjlist() {
        return objlist ;
    }

    public void setselectarea( Point p1, Point p2 ) {
        selectarea = true ;
        int x1, y1, x2, y2 ;
        x1 = Math.min(p1.x, p2.x);
        x2 = Math.max(p1.x, p2.x);
        y1 = Math.min(p1.y, p2.y);
        y2 = Math.max(p1.y, p2.y);
        selectareapoint[0] = new Point(x1, y1) ;
        selectareapoint[1] = new Point(x2, y2) ;
    }

    public void multiselect() {
        for ( int i = 0 ; i < objlist.size() ; i++ ) {
            if ( !selectobj.contains(objlist.get(i)) && objlist.get(i).inside(selectareapoint[0], selectareapoint[1]) )
                selectobj.add( objlist.get(i) ) ;
            else if ( selectobj.contains(objlist.get(i)) && !objlist.get(i).inside(selectareapoint[0], selectareapoint[1]) )
                selectobj.remove(objlist.get(i) ) ;
                

        }
    }

    private void paintselectarea( Graphics g ) {

        int w = selectareapoint[1].x - selectareapoint[0].x;
        int h = selectareapoint[1].y - selectareapoint[0].y;

        g.setColor(new Color(168, 167, 255, 102));
        g.fillRect(selectareapoint[0].x, selectareapoint[0].y, w, h);
        g.setColor(new Color(168, 167, 255, 205));
        g.drawRect(selectareapoint[0].x, selectareapoint[0].y, w, h);
    }

    public void rename() {
        if (selectobj.get(0).name != "_composite***" ) {
            JTextField textArea = new JTextField(selectobj.get(0).name);
            JScrollPane scrollPane = new JScrollPane(textArea);
            Object[] options = {"OK", "Cancel"};
            int choice = JOptionPane.showOptionDialog(null, scrollPane, "Enter your text",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            if (choice == JOptionPane.OK_OPTION) {
                selectobj.get(0).name = textArea.getText();
                System.out.println("Change to: " + selectobj.get(0).name);
                refresh();
            }
        }

    }

}

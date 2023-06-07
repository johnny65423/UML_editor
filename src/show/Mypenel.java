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
    private Mymode chooseMode ;
    private List<Myobject> objectList = new ArrayList<Myobject>() ;
    private List<Myobject> selectObject = new ArrayList<Myobject>() ;
    private Myobject selectArea ;
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
        mypenel.removeMouseListener((MouseListener) chooseMode);
        mypenel.removeMouseMotionListener((MouseMotionListener) chooseMode);
        chooseMode = mode ;
        mypenel.addMouseListener((MouseListener) chooseMode);
        mypenel.addMouseMotionListener((MouseMotionListener) chooseMode);
        
    } 

    public void addobject( Myobject obj ) {
        if ( !objectList.contains( obj ) )
            objectList.add(obj);
        mypenel.repaint();
    }

    public void addobject( Myobject obj, int index ) {
        if ( !objectList.contains( obj ) )
            objectList.add(index + 1, obj);
        mypenel.repaint();

    }

    public void removeobject( Myobject obj ) {
        objectList.remove(obj);
        mypenel.repaint();
    }

    public void paint( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        g2d.setColor(new Color( 200, 200, 200 ));
		g2d.fillRect(0,0,getSize().width,getSize().height);
        
        g2d.setColor(Color.BLACK);

        for ( int i = 0 ; i < objectList.size() ; i++ ) {
            objectList.get(i).paintobj(g2d);
            if ( selectObject.contains(objectList.get(i)) )
                objectList.get(i).paintselect(g2d);
        }

        if (selectarea)
            paintselectarea(g2d);
        
        
    }

    public void refresh() {
        mypenel.revalidate();
        mypenel.repaint();
    }

    public void addselectobj( Myobject obj ) {
        selectObject.add(obj) ;
    }

    public void removeselectobject( Myobject obj ) {
        selectObject.remove(obj);
        mypenel.repaint();
    }

    public void popselectobj() {
        while ( selectObject.size() > 0 )
            selectObject.remove( selectObject.size() - 1 ) ;
        
        selectarea = false ;
    }

    public List<Myobject> getselectobj() {
        return selectObject ;
    }

    public List<Myobject> getobjectList() {
        return objectList ;
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
        for ( int i = 0 ; i < objectList.size() ; i++ ) {
            if ( !selectObject.contains(objectList.get(i)) && objectList.get(i).inside(selectareapoint[0], selectareapoint[1]) )
                selectObject.add( objectList.get(i) ) ;
            else if ( selectObject.contains(objectList.get(i)) && !objectList.get(i).inside(selectareapoint[0], selectareapoint[1]) )
                selectObject.remove(objectList.get(i) ) ;
                

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
        if (selectObject.get(0).name != "_composite***" ) {
            JTextField textArea = new JTextField(selectObject.get(0).name);
            JScrollPane scrollPane = new JScrollPane(textArea);
            Object[] options = {"OK", "Cancel"};
            int choice = JOptionPane.showOptionDialog(null, scrollPane, "Enter your text",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
            if (choice == JOptionPane.OK_OPTION) {
                selectObject.get(0).name = textArea.getText();
                System.out.println("Change to: " + selectObject.get(0).name);
                refresh();
            }
        }

    }

}

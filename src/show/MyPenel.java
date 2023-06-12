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

import mode.Mymode;
import object.Myobject;

public class MyPenel extends JPanel {
    private static MyPenel myPenel ;
    private Mymode chooseMode ;
    private List<Myobject> objectList = new ArrayList<Myobject>() ;
    private List<Myobject> selectObjectList = new ArrayList<Myobject>() ;

    private MyPenel() {
    }
    
    public static MyPenel getMyPenel() {
        if (myPenel == null)
            myPenel = new MyPenel();
        return myPenel;
    }

    public void setMode(Mymode mode){
        System.out.println("change Mode");
        removeMouseListener((MouseListener) chooseMode);
        removeMouseMotionListener((MouseMotionListener) chooseMode);
        chooseMode = mode ;
        addMouseListener((MouseListener) chooseMode);
        addMouseMotionListener((MouseMotionListener) chooseMode);

    } 

    public void addObject( Myobject obj ) {
        if ( !objectList.contains( obj ) )
            objectList.add(obj);
        repaint();
    }

    public void addObject( Myobject obj, int index ) {
        if ( !objectList.contains( obj ) )
            objectList.add(index + 1, obj);
        repaint();
    }

    public void removeObject( Myobject obj ) {
        objectList.remove(obj);
        repaint();
    }

    public void addSelectObject( Myobject obj ) {
        if ( !selectObjectList.contains( obj ) )
            selectObjectList.add(obj) ;
        repaint();
    }

    public void removesSelectObject( Myobject obj ) {
        selectObjectList.remove(obj);
        repaint();
    }

    public void paint( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        g2d.setColor(new Color( 200, 200, 200 ));
		g2d.fillRect(0,0,getSize().width,getSize().height);
        
        g2d.setColor(Color.BLACK);
        
        for ( int i = 0 ; i < objectList.size() ; i++ ) {
            objectList.get(i).paintObject(g2d);
            if ( selectObjectList.contains(objectList.get(i)) )
                objectList.get(i).paintSelect(g2d);

        }

    }

    public void refresh() {
        revalidate();
        repaint();
    }

    public void clearSelectObject() {
        while ( selectObjectList.size() > 0 )
            selectObjectList.remove( selectObjectList.size() - 1 ) ;
    }

    public List<Myobject> getSelectObject() {
        return selectObjectList ;
    }

    public List<Myobject> getObjectList() {
        return objectList ;
    }

}

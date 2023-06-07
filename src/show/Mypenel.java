package show;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import mode.Mymode;
import objects.Myobject;

public class Mypenel extends JPanel {
    private static Mypenel myPenel ;
    private Mymode chooseMode ;
    private List<Myobject> objectList = new ArrayList<Myobject>() ;
    private List<Myobject> selectObjectList = new ArrayList<Myobject>() ;

    private Mypenel() {
    }
    
    public static Mypenel getMyPenel() {
        if (myPenel == null)
            myPenel = new Mypenel();
        return myPenel;
    }

    public void setMode(Mymode mode){
        System.out.println("change Mode");
        myPenel.removeMouseListener((MouseListener) chooseMode);
        myPenel.removeMouseMotionListener((MouseMotionListener) chooseMode);
        chooseMode = mode ;
        myPenel.addMouseListener((MouseListener) chooseMode);
        myPenel.addMouseMotionListener((MouseMotionListener) chooseMode);

    } 

    public void addObject( Myobject obj ) {
        if ( !objectList.contains( obj ) )
            objectList.add(obj);
        myPenel.repaint();
    }

    public void addObject( Myobject obj, int index ) {
        if ( !objectList.contains( obj ) )
            objectList.add(index + 1, obj);
            myPenel.repaint();
    }

    public void removeObject( Myobject obj ) {
        objectList.remove(obj);
        myPenel.repaint();
    }

    public void addSelectObject( Myobject obj ) {
        if ( !selectObjectList.contains( obj ) )
            selectObjectList.add(obj) ;
        myPenel.repaint();
    }

    public void removesSelectObject( Myobject obj ) {
        selectObjectList.remove(obj);
        myPenel.repaint();
    }

    public void paint( Graphics2D g ) {

        g.setStroke(new BasicStroke(2));
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        g.setColor(new Color( 200, 200, 200 ));
		g.fillRect(0,0,getSize().width,getSize().height);
        
        g.setColor(Color.BLACK);

        System.out.println(objectList.size());
        for ( int i = 0 ; i < objectList.size() ; i++ ) {
            System.out.println(objectList.size());
            if ( selectObjectList.contains(objectList.get(i)) )
                objectList.get(i).paintSelect(g);
            else 
                objectList.get(i).paintObject(g);
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

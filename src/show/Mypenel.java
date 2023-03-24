package show;

import javax.swing.JPanel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import mode.Mymode;

public class Mypenel extends JPanel {
    private static Mypenel mypenel ;
    private static Mymode choosemode ;
    
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
}

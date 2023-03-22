package show;

import javax.swing.JPanel;

public class Mypenel extends JPanel {
    private static Mypenel mypenel ;
    
    
    private Mypenel() { // from ChatGPT
        // this.setToolTipText("penel");
    }
    
    public static Mypenel getmypenel() {
        if (mypenel == null) {
            mypenel = new Mypenel();
        }
        return mypenel;
    }
}

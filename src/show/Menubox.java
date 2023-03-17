package show;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class Menubox extends JMenuBar{
    public Menubox() {
        this.add( new JMenu("file") );
        this.add( new JMenu("edit") );
        

    }
}

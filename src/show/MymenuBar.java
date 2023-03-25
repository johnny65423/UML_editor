package show;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MymenuBar extends JMenuBar{
    public MymenuBar() {
        JMenu file = new JMenu("file") ;
        JMenu edit = new JMenu("edit") ;
        JMenuItem temp = new JMenuItem("Group") ;
        temp.addActionListener(null);
        edit.add(temp);

        temp = new JMenuItem("Ungroup") ;
        temp.addActionListener(null);
        edit.add(temp);

        temp = new JMenuItem("change object name") ;
        temp.addActionListener(null);
        edit.add(temp);

        this.add( file );
        this.add( edit );
        

    }

}

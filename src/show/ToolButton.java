package show ;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
public class ToolButton extends JButton {
    // Mytoolbar toolbar ;
    ToolButton( String imgname ) {
        // this.toolbar = Mytoolbar.getmytoolbar() ;
        String path = "src/images/" + imgname + ".png" ;
        System.out.println("Get image from : " + path);
        ImageIcon icon = new ImageIcon(path);
        setIcon(icon);
        setToolTipText(imgname);
        setFocusable(false);
        setBackground(new Color(255, 255, 255));
        setBorderPainted(false);
        setRolloverEnabled(true);

        this.addActionListener(new ToolbtnOnclick());
    }

    private class ToolbtnOnclick implements ActionListener {
        //private int index;

        public ToolbtnOnclick() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ToolButton temp = (ToolButton) e.getSource() ;
            Mytoolbar.setclickbtn( temp ) ;

        }
    }

}
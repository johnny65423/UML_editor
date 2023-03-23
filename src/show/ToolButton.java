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
    private static ToolButton clickedbtn ;

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

    public static void setclickbtn( ToolButton temp ) {
        if ( clickedbtn != null ) 
            clickedbtn.setBackground(Color.WHITE); 

        clickedbtn = temp ;
        temp.setBackground(Color.GRAY);
        System.out.println("setselectbtn");
        
    }

    private class ToolbtnOnclick implements ActionListener {
        //private int index;

        public ToolbtnOnclick() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            ToolButton temp = (ToolButton) e.getSource() ;
            setclickbtn( temp ) ;

        }


    }

}
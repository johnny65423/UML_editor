package show ;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;



import mode.*;
import javax.swing.ImageIcon;
public class ToolButton extends JButton {
    // Mytoolbar toolbar ;
    private static ToolButton clickedbtn ;
    private static Mypenel mypenel ;
    protected Mymode buttonmode ;

    ToolButton( String imgname, Mymode mode ) {
        this.buttonmode = mode ;
        // this.toolbar = Mytoolbar.getmytoolbar() ;
        String path = "src/images/" + imgname + ".png" ;
        System.out.println("Get image from : " + path);
        ImageIcon icon = new ImageIcon(path);

        mypenel = Mypenel.getmypenel() ;
        this.setIcon(icon);
        this.setToolTipText(imgname);
        this.setFocusable(false);
        this.setBackground(new Color(255, 255, 255));
        this.setBorderPainted(false);
        this.setRolloverEnabled(true);

        this.addActionListener(new ToolbtnOnclick());
    }

    public static void setclickbtn( ToolButton temp ) {
        // System.out.println("setselectbtn");
        if ( clickedbtn != null ) 
            clickedbtn.setBackground(Color.WHITE); 

        clickedbtn = temp ;
        temp.setBackground(Color.GRAY);

        mypenel.setmode(clickedbtn.buttonmode);
        mypenel.popselectobj();
        mypenel.refresh();
    }


    private class ToolbtnOnclick implements ActionListener {
        //private int index;

        public ToolbtnOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setclickbtn( (ToolButton) e.getSource() ) ;
        }


    }

}
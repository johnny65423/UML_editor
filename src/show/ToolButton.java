package show ;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import mode.Mymode;

public class ToolButton extends JButton {
    private static ToolButton clickedButton ;
    private static MyPenel mypenel ;
    protected Mymode buttonMode ;

    ToolButton( String imageName, Mymode mode ) {
        this.buttonMode = mode ;
        String path = "src/image/" + imageName + ".png" ;
        System.out.println("Get image from : " + path);
        ImageIcon icon = new ImageIcon(path);

        mypenel = MyPenel.getMyPenel() ;
        this.setIcon(icon);
        this.setToolTipText(imageName);
        this.setFocusable(false);
        this.setBackground(new Color(255, 255, 255));
        this.setBorderPainted(false);
        this.setRolloverEnabled(true);

        this.addActionListener(new ToolbtnOnclick());
    }

    public static void setclickbtn( ToolButton temp ) {
        if ( clickedButton != null ) 
            clickedButton.setBackground(Color.WHITE); 

        clickedButton = temp ;
        temp.setBackground(Color.GRAY);

        mypenel.setMode(clickedButton.buttonMode);
        mypenel.clearSelectObject();
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
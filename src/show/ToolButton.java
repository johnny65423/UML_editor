package show ;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
public class ToolButton extends JButton {

    ToolButton( String imgname ) {
        String path = "src/images/" + imgname + ".png" ;
        System.out.print(path);
        ImageIcon icon = new ImageIcon(path);
        setIcon(icon);
        setToolTipText(imgname);
        setFocusable(false);
        setBackground(new Color(255, 255, 255));
        setBorderPainted(false);
        setRolloverEnabled(true);
}

}
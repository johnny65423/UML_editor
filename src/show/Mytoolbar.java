package show;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JToolBar;
public class Mytoolbar extends JToolBar {

    private static Mytoolbar mytoolbar ;
    

    Mytoolbar() {
        //clickedbtn = null ;

        this.setLayout(new GridLayout(6, 1));
        this.add(new ToolButton("select"));
        this.add(new ToolButton("association"));
        this.add(new ToolButton("generalization"));
        this.add(new ToolButton("composition"));
        this.add(new ToolButton("class"));
        this.add(new ToolButton("use_case"));
        this.setFloatable( false);
    }

    public static Mytoolbar getmytoolbar() {
        if (mytoolbar == null) {
            System.out.println("new mytoolbar()");
            mytoolbar = new Mytoolbar();
        }
        System.out.println("return mytoolbar()");
        
        return mytoolbar;
    }

    

}

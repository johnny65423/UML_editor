package show;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JToolBar;

import mode.*;

public class Mytoolbar extends JToolBar {

    private static Mytoolbar mytoolbar ;
    

    Mytoolbar() {
        //clickedbtn = null ;

        this.setLayout(new GridLayout(6, 1));
        this.add( new ToolButton("select", new Selection()));
        this.add(new ToolButton("association", new Createassociation()));
        this.add(new ToolButton("generalization", new Creategeneralization()));
        this.add(new ToolButton("composition", new Createcomposition()));
        this.add(new ToolButton("class", new Createclass()));
        this.add(new ToolButton("use_case", new Createusecase()));
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

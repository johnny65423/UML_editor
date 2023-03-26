package show;

import java.awt.GridLayout;

import javax.swing.JToolBar;

import mode.*;

public class Mytoolbar extends JToolBar {

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

    

}

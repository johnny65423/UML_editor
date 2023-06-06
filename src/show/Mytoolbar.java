package show;

import java.awt.GridLayout;

import javax.swing.JToolBar;

import mode.*;

public class Mytoolbar extends JToolBar {

    Mytoolbar() {
        //clickedbtn = null ;

        this.setLayout(new GridLayout(6, 1));
        this.add( new ToolButton("select", new Selection()));
        this.add(new ToolButton("association", new CreateLine( "Association" ) ) );
        this.add(new ToolButton("generalization", new CreateLine("Generalization")));
        this.add(new ToolButton("composition", new CreateLine("Composition")));
        this.add(new ToolButton("Class", new CreateBasicObject("Class")));
        this.add(new ToolButton("UseCase", new CreateBasicObject("UseCase")));
        this.setFloatable( false);
    }

    

}

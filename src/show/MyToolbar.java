package show;

import java.awt.GridLayout;

import javax.swing.JToolBar;

import mode.*;

public class MyToolbar extends JToolBar {

    MyToolbar() {
        //clickedbtn = null ;

        this.setLayout(new GridLayout(6, 1));
        this.add( new ToolButton("Select", new Selection()));
        this.add(new ToolButton("Association", new CreateLine( "Association" ) ) );
        this.add(new ToolButton("Generalization", new CreateLine("Generalization")));
        this.add(new ToolButton("Composition", new CreateLine("Composition")));
        this.add(new ToolButton("Class", new CreateBasicObject("Class")));
        this.add(new ToolButton("UseCase", new CreateBasicObject("UseCase")));
        this.setFloatable( false);
    }

    

}

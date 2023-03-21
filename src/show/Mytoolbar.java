package show;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JToolBar;
public class Mytoolbar extends JToolBar {
    Mytoolbar() {
        this.setLayout(new GridLayout(6, 1));
        this.add(new ToolButton("select"));
        this.add(new ToolButton("association"));
        this.add(new ToolButton("generalization"));
        this.add(new ToolButton("composition"));
        this.add(new ToolButton("class"));
        this.add(new ToolButton("use_case"));
        this.setFloatable( false);
    }
}

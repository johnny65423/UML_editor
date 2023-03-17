package show;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class UML_editor extends JFrame {
    private Menubox menu;


    public UML_editor(){
        System.out.println("UML_editor constructor.");

    
        this.menu = new Menubox();
        this.setJMenuBar(menu);

		this.setLayout(new BorderLayout());
        this.setTitle("UML_Editor_111522050");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
    public static void main(String[] args) throws Exception {
        UML_editor form = new UML_editor();
    }
}

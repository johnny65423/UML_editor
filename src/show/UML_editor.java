package show;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UML_editor extends JFrame {
    private Menubox menu;
    private JButton[] tbtn ;

    public UML_editor(){
        System.out.println("UML_editor constructor.");
    
        this.menu = new Menubox();
        this.setJMenuBar(menu);

		this.setLayout(new BorderLayout());

        this.tbtn[0] = new JButton("Button") ;
        this.setBounds(0, 0, 100, 100);
        this.add(this.tbtn[0],BorderLayout.EAST);


        this.setTitle("UML_Editor_111522050");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

        

	}
    public static void main(String[] args) throws Exception {
        UML_editor form = new UML_editor();
    }
}

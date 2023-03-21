package show;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UML_editor extends JFrame {
    private MyenuBar menu ;
    private Mytoolbar toolbar ;

    public UML_editor(){
        System.out.println("UML_editor constructor.");
    
        this.menu = new MyenuBar();
        this.setJMenuBar(menu);

		this.setLayout(new BorderLayout());

        this.toolbar = new Mytoolbar() ;
        this.getContentPane().add(this.toolbar, BorderLayout.WEST);

        this.setTitle("UML_Editor");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

        

	}
    public static void main(String[] args) throws Exception {
        UML_editor form = new UML_editor();
    }
}

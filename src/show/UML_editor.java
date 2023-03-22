package show;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UML_editor extends JFrame {
    private MymenuBar menu ;
    private Mytoolbar toolbar ;
    private Mypenel penel ;

    public UML_editor() {
        System.out.println("UML_editor constructor.");
    
        this.setLayout(new BorderLayout());
        
        this.menu = new MymenuBar();
        this.setJMenuBar(menu);

        this.penel = Mypenel.getmypenel() ;
        getContentPane().add(this.penel, BorderLayout.CENTER);

        this.toolbar = Mytoolbar.getmytoolbar() ;
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

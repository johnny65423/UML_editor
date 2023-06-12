package shows;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class UML_editor extends JFrame {
    private MyMenuBar menu ;
    private MyToolbar toolbar ;
    private MyPenel penel ;

    public UML_editor() {
        System.out.println("UML_editor constructor.");
    
        this.setLayout(new BorderLayout());
        
        this.menu = new MyMenuBar();
        this.setJMenuBar(menu);

        this.toolbar = new MyToolbar() ;
        this.getContentPane().add(this.toolbar, BorderLayout.WEST);

        this.penel = MyPenel.getMyPenel() ;
        this.getContentPane().add(this.penel, BorderLayout.CENTER);

        this.setTitle("UML_Editor_111522050");
		this.setSize(1000, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}
    public static void main(String[] args) throws Exception {
        new UML_editor();
    }
}

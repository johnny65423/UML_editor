package show;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MymenuBar extends JMenuBar{
    public MymenuBar() {
        JMenu file = new JMenu("file") ;
        JMenu edit = new JMenu("edit") ;
        JMenuItem temp = new JMenuItem("Group") ;
        temp.addActionListener( new GroupOnclick() );
        edit.add(temp);

        temp = new JMenuItem("Ungroup") ;
        temp.addActionListener(new UngroupOnclick() );
        edit.add(temp);

        temp = new JMenuItem("change object name") ;
        temp.addActionListener( new RenameOnclick() );
        edit.add(temp);

        this.add( file );
        this.add( edit );
        

    }

    private class GroupOnclick implements ActionListener {
        //private int index;

        public GroupOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("GroupOnclick");
        }


    }

    private class UngroupOnclick implements ActionListener {
        //private int index;

        public UngroupOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("UngroupOnclick");
        }


    }

    private class RenameOnclick implements ActionListener {
        //private int index;

        public RenameOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( Mypenel.getselectobj().size() == 1 )
                Mypenel.rename();
            else 
                System.out.println( "select more then one" ) ;
                
        }


    }

}

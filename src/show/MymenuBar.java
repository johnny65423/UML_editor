package show;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import objects.Composite;
import objects.Myobject;



public class MymenuBar extends JMenuBar{
    private Mypenel mypenel ;

    public MymenuBar() {
        mypenel = Mypenel.getmypenel();

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
            if ( mypenel.getselectobj().size() > 1 ) {
                System.out.println("GroupOnclick");
                Myobject group = new Composite() ;
                mypenel.addobject(group, group.getindex() );
            }

        }


    }

    private class UngroupOnclick implements ActionListener {
        //private int index;

        public UngroupOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( mypenel.getselectobj().size() == 1 ) {
                System.out.println("UngroupOnclick");
                if ( mypenel.getselectobj().get(0).ungroup() )
                    mypenel.getobjlist().remove(mypenel.getselectobj().get(0));
                mypenel.refresh();
            }
            
        }


    }

    private class RenameOnclick implements ActionListener {
        //private int index;

        public RenameOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( mypenel.getselectobj().size() == 1 )
                mypenel.rename();
                
        }


    }

}

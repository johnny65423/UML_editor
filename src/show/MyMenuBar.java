package show;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import object.Myobject;
import object.ObjectFactory;


public class MyMenuBar extends JMenuBar{
    private MyPenel mypenel ;

    public MyMenuBar() {
        mypenel = MyPenel.getMyPenel();

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
            if ( mypenel.getSelectObject().size() > 1 ) {
                Myobject group = ObjectFactory.createObject("Composite", null, null) ;
                mypenel.addObject(group, group.getindex() );
                mypenel.addSelectObject(group);
            }

        }


    }

    private class UngroupOnclick implements ActionListener {
        //private int index;

        public UngroupOnclick() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if ( mypenel.getSelectObject().size() == 1 ) {
                if ( mypenel.getSelectObject().get(0).unGroup() )
                    mypenel.getObjectList().remove(mypenel.getSelectObject().get(0));
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

            if ( mypenel.getSelectObject().size() == 1 )
                mypenel.getSelectObject().get(0).reName();
            mypenel.refresh();
                
        }

    }

}

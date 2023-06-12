package shows;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

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
                System.out.println("GroupOnclick");
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
                System.out.println("UngroupOnclick");
                if ( mypenel.getSelectObject().get(0).ungroup() )
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
                rename( mypenel.getSelectObject().get(0) );
                
        }

        private void rename( Myobject object ) {
            if ( object.name != "_composite***" ) {
                JTextField textArea = new JTextField(object.name);
                JScrollPane scrollPane = new JScrollPane(textArea);
                Object[] options = {"OK", "Cancel"};
                int choice = JOptionPane.showOptionDialog(null, scrollPane, "Enter your text",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                if (choice == JOptionPane.OK_OPTION) {
                    object.name = textArea.getText();
                    System.out.println("Change to: " + object.name);
                    mypenel.refresh();
                }
            }
    
        }


    }

}

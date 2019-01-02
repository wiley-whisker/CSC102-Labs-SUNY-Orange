package lab6;

import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author Wiley
 */
public class UserInterface extends JFrame
{
    // Backend Stuff
    private StorageApp backend;
    
    // GUI Stuff
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 400;
    
    private static final int AREA_ROWS = 10;
    private static final int AREA_COLUMNS = 30;
    
    private JLabel inLabel;
    private JButton addBtn;;
    private JButton saveBtn;
    private JButton searchBtn;
    private JButton rmvBtn;
    private JTextArea lstArea;
    private JTextField inField;
    
    public UserInterface()
    {
        //Backend Stuff
        backend = new StorageApp();
        
        // GUI Stuff
        lstArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
        lstArea.setText(backend.asString());
        lstArea.setEditable(false);
        
        createTextField();
        createBtns();
        createPanel();
        
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
    }

    private void createTextField()
    {
        inLabel = new JLabel("New Element: ");
        final int FIELD_WIDTH = 10;
        inField = new JTextField(FIELD_WIDTH);
        // No default
    }
    
    private void createBtns()
    {
        addBtn = new JButton("Add to List");
        saveBtn = new JButton("Save Changes");
        searchBtn = new JButton("Search");
        rmvBtn = new JButton("Remove");
        
        ActionListener addListener = new AddListener();
        ActionListener saveListener = new SaveListener();
        ActionListener searchListener = new SearchListener();
        ActionListener rmvListener = new RmvListener();
        
        addBtn.addActionListener(addListener);
        saveBtn.addActionListener(saveListener);
        searchBtn.addActionListener(searchListener);
        rmvBtn.addActionListener(rmvListener);
    }
    
    class AddListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String input = inField.getText();
            if(input.equals("")) {return;}
            backend.add(input);
            lstArea.setText(backend.asString());
            inField.setText("");
        }
    }
    
    class SaveListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            backend.saveState();
        }
    }
    
    class SearchListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String input = inField.getText();
            if(input.equals("")) {return;}
            int status = backend.searchFor(input);
            if(status == -1)// The element is not in the list
            {
                JOptionPane.showMessageDialog(lstArea,"That element is not in the list.");
            }
            else// The element is in the list.
            {
                JOptionPane.showMessageDialog(lstArea,"That is element #" + (status+1) + " in the list.");
            }
        }
    }
    
    class RmvListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String input = inField.getText();
            if(input.equals("")) {return;}
            backend.remove(input);
            lstArea.setText(backend.asString());
            inField.setText("");
        }
    }
    
    private void createPanel()
    {
        JPanel panel = new JPanel();
        panel.add(inLabel);
        panel.add(inField);
        panel.add(addBtn);
        panel.add(rmvBtn);
        panel.add(searchBtn);
        JScrollPane scrollPane = new JScrollPane(lstArea);
        panel.add(scrollPane);
        panel.add(saveBtn);
        setTitle("List Application");
        add(panel);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject extends JFrame implements ActionListener{

    public void addComponentToPane(Container pane){
	JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel main=new JPanel(){
		public Dimension getPreferredSize() {
		    Dimension size = super.getPreferredSize();
		    size.width += extraWindowWidth;
		    return size;
		}
	    };
	main.add(new JButton("Manage Inventory"));
	main.add(new JButton("Sale Orders"));
	main.add(new JButton("Restock Orders"));
	main.add(new JButton("Finance"));
    }

    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
    }
}
	
	
	

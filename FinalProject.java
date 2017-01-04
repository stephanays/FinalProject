import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject extends JFrame{
    final static String main="Home";
    final static String inventory="Inventory";
    final static String sale="Sales";
    final static String restock="Restock";
    final static String finance="Finance";
    final static int extraWindowWidth=100;

    public void addComponentToPane(Container pane){
	JTabbedPane tabbedPane = new JTabbedPane();

	JPanel homePage=new JPanel(){
		public Dimension getPreferredSize() {
		    Dimension size = super.getPreferredSize();
		    size.width += extraWindowWidth;
		    return size;
                                  		}
	    };
	homePage.add(new JLabel("Welcome Stranger!"));

	JPanel manageInventory=new JPanel();
	manageInventory.add(new JButton("Add Product"));   
	manageInventory.add(new JButton("Remove Product"));

	JPanel saleOrders=new JPanel(new GridLayout(0,1));
	saleOrders.add(new JLabel("Product ID: "));
	saleOrders.add(new JTextField("",15));
	saleOrders.add(new JLabel("Quantity: "));
	saleOrders.add(new JTextField("",15));
	saleOrders.add(new JButton("Submit"));

	JPanel restockOrders=new JPanel(new GridLayout(0,1));
	restockOrders.add(new JLabel("Product ID: "));
	restockOrders.add(new JTextField("",15));
	restockOrders.add(new JLabel("Quantity: "));
	restockOrders.add(new JTextField("",15));
	restockOrders.add(new JLabel("Buy Price: "));
	restockOrders.add(new JTextField("",15));
	restockOrders.add(new JButton("Submit"));

	JPanel financePage=new JPanel();
	financePage.add(new JLabel("Under Construction"));

	tabbedPane.addTab(main,homePage);
 	tabbedPane.addTab(inventory, manageInventory);
	tabbedPane.addTab(sale,saleOrders);
	tabbedPane.addTab(restock,restockOrders);
	tabbedPane.addTab(finance,financePage);
			

	pane.add(tabbedPane, BorderLayout.CENTER);
        
    }

    private static void createAndShowGUI(){
	JFrame frame=new JFrame("Inventory Management System");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	FinalProject start=new FinalProject();
	start.addComponentToPane(frame.getContentPane());

	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args){
	createAndShowGUI();
    }
}
	
	
	

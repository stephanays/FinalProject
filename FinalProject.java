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
	JLabel greetLabel=new JLabel("Welcome Stranger!");
	homePage.add(greetLabel);

	JPanel manageInventory=new JPanel();
	JButton addProduct=new JButton("Add Product");
	JButton removeProduct=new JButton("Remove Product");
	manageInventory.add(addProduct);   
	manageInventory.add(removeProduct);

	JPanel saleOrders=new JPanel(new GridLayout(0,1));
	JLabel productIDLabelSale=new JLabel("Product ID: ");
	JTextField productIDSale=new JTextField("",15);
	JLabel quantityLabelSale=new JLabel("Quantity: ");
	JTextField quantitySale=new JTextField("",15);
	JButton submitSale=new JButton("Submit");
	saleOrders.add(productIDLabelSale);
	saleOrders.add(productIDSale);
	saleOrders.add(quantityLabelSale);
	saleOrders.add(quantitySale);
	saleOrders.add(submitSale);

	JPanel restockOrders=new JPanel(new GridLayout(0,1));
	JLabel productIDLabelRestock=new JLabel("Product ID: ");
	JTextField productIDRestock=new JTextField("",15);
	JLabel quantityLabelRestock=new JLabel("Quantity: ");
	JTextField quantityRestock=new JTextField("",15);
	JLabel buyPriceLabelRestock=new JLabel("Buy Price: ");
	JTextField buyPriceRestock=new JTextField("",15);
	JButton submitRestock=new JButton("Submit");
	restockOrders.add(productIDLabelRestock);
	restockOrders.add(productIDRestock);
	restockOrders.add(quantityLabelRestock);
	restockOrders.add(quantityRestock);
	restockOrders.add(buyPriceLabelRestock);
	restockOrders.add(buyPriceRestock);
	restockOrders.add(submitRestock);

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
	
	
	

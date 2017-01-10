import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FinalProject extends JFrame implements ActionListener{
    final static String main="Home";
    final static String inventory="Inventory";
    final static String sale="Sales";
    final static String restock="Restock";
    final static String finance="Finance";
    final static int extraWindowWidth=100;
    private JButton addProduct;
    private JButton removeProduct;
    private JTextField productIDSale;
    private JTextField quantitySale;
    private JButton submitSale;
    private JLabel resultSale;
    private JTextField productIDRestock;
    private JTextField quantityRestock;
    private JTextField buyPriceRestock;
    private JButton submitRestock;
    private JLabel resultRestock;

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
	addProduct=new JButton("Add Product");
	removeProduct=new JButton("Remove Product");
	manageInventory.add(addProduct);   
	manageInventory.add(removeProduct);

	JPanel saleOrders=new JPanel(new GridLayout(0,1));
	JLabel productIDLabelSale=new JLabel("Product ID: ");
	productIDSale=new JTextField("",15);
	productIDSale.addActionListener(this);
	JLabel quantityLabelSale=new JLabel("Quantity: ");
	quantitySale=new JTextField("",15);
	quantitySale.addActionListener(this);
	submitSale=new JButton("Submit");
	submitSale.addActionListener(this);
	submitSale.setActionCommand("sale");
	resultSale=new JLabel("");
	saleOrders.add(productIDLabelSale);
	saleOrders.add(productIDSale);
	saleOrders.add(quantityLabelSale);
	saleOrders.add(quantitySale);
	saleOrders.add(submitSale);
	saleOrders.add(resultSale);

	JPanel restockOrders=new JPanel(new GridLayout(0,1));
	JLabel productIDLabelRestock=new JLabel("Product ID: ");
	productIDRestock=new JTextField("",15);
	productIDRestock.addActionListener(this);
	JLabel quantityLabelRestock=new JLabel("Quantity: ");
	quantityRestock=new JTextField("",15);
	quantityRestock.addActionListener(this);
	JLabel buyPriceLabelRestock=new JLabel("Buy Price: ");
	buyPriceRestock=new JTextField("",15);
	buyPriceRestock.addActionListener(this);
	submitRestock=new JButton("Submit");
	submitRestock.addActionListener(this);
	submitRestock.setActionCommand("restock");
	resultRestock=new JLabel("");
	restockOrders.add(productIDLabelRestock);
	restockOrders.add(productIDRestock);
	restockOrders.add(quantityLabelRestock);
	restockOrders.add(quantityRestock);
	restockOrders.add(buyPriceLabelRestock);
	restockOrders.add(buyPriceRestock);
	restockOrders.add(submitRestock);
	restockOrders.add(resultRestock);

	JPanel financePage=new JPanel();
	financePage.add(new JLabel("Under Construction"));

	tabbedPane.addTab(main,homePage);
 	tabbedPane.addTab(inventory, manageInventory);
	tabbedPane.addTab(sale,saleOrders);
	tabbedPane.addTab(restock,restockOrders);
	tabbedPane.addTab(finance,financePage);
			

	pane.add(tabbedPane, BorderLayout.CENTER);
        
    }

    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
	if(event.equals("sale")){
	    String productIDSaleText=productIDSale.getText();
	    String quantitySaleText=quantitySale.getText();
	    resultSale.setText("Product ID: "+productIDSaleText+"\nQuantity: "+quantitySaleText+"\n All Done!");
	}
	if(event.equals("restock")){
	    String productIDRestockText=productIDRestock.getText();
	    String quantityRestockText=quantityRestock.getText();
	    String buyPriceRestockText=buyPriceRestock.getText();
	    resultRestock.setText("Product ID: "+productIDRestockText+"\nQuantity: "+quantityRestockText+"\nBuy Price: "+buyPriceRestockText+"\n All Done!");
	}
	if(event.equals("addProduct")){
	}
	if(event.equals("removeProduct")){
	}
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
	
	
	

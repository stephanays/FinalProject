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
    private JTextField productNameNew;
    private JLabel productNameNewLabel;
    private JTextField sellPriceNew;
    private JLabel sellPriceNewLabel;
    private JTextField purchasePriceNew;
    private JLabel purchasePriceNewLabel;
    private JTextField quantityNew;
    private JLabel quantityNewLabel;
    private JTextField productIDTrash;
    private JLabel productIDTrashLabel;
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
    private JLabel inventoryStatus;
    private Account admin = new Account();
    

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

	JPanel manageInventory=new JPanel(new GridLayout(0,1));
	addProduct=new JButton("Add Product");
	addProduct.addActionListener(this);
	addProduct.setActionCommand("addProduct");
	removeProduct=new JButton("Remove Product");
	removeProduct.addActionListener(this);
	removeProduct.setActionCommand("removeProduct");
	productNameNewLabel= new JLabel("Product Name: ");
	productNameNew=new JTextField("",15);
	sellPriceNewLabel= new JLabel("Sell Price: ");
	sellPriceNew=new JTextField("",15);
	purchasePriceNewLabel= new JLabel("Purchase Price: ");
	purchasePriceNew=new JTextField("",15);
	quantityNewLabel=new JLabel("Quantity: ");
	quantityNew=new JTextField("",15);
	productIDTrashLabel= new JLabel("Product ID: ");
	productIDTrash=new JTextField("",15);
	inventoryStatus= new JLabel("");
	manageInventory.add(productNameNewLabel);
	manageInventory.add(productNameNew);
	manageInventory.add(sellPriceNewLabel);
	manageInventory.add(sellPriceNew);
	manageInventory.add(purchasePriceNewLabel);
	manageInventory.add(purchasePriceNew);
	manageInventory.add(quantityNewLabel);
	manageInventory.add(quantityNew);
	manageInventory.add(addProduct);
	manageInventory.add(productIDTrashLabel);
	manageInventory.add(productIDTrash);
	manageInventory.add(removeProduct);
	manageInventory.add(inventoryStatus);

	JPanel saleOrders=new JPanel(new GridLayout(0,1));
	JLabel productIDLabelSale=new JLabel("Product ID: ");
	productIDSale=new JTextField("",15);;
	JLabel quantityLabelSale=new JLabel("Quantity: ");
	quantitySale=new JTextField("",15);
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
	JLabel quantityLabelRestock=new JLabel("Quantity: ");
	quantityRestock=new JTextField("",15);
	JLabel buyPriceLabelRestock=new JLabel("Buy Price: ");
	buyPriceRestock=new JTextField("",15);
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
	    int productIDSaleInt=Integer.parseInt(productIDSale.getText());
	    int quantitySaleInt=Integer.parseInt(quantitySale.getText());
	    SaleOrder adding=new SaleOrder(productIDSaleInt, quantitySaleInt, admin.nextSaleId());
	    admin.newSaleOrder(adding, productIDSaleInt, quantitySaleInt);
	    resultSale.setText("Product ID: "+productIDSaleInt+"\nQuantity: "+quantitySaleInt+"\n All Done!");
	    System.out.println(admin.toStringSaleHistory());
	    System.out.println(admin.toStringInventory());
	}
	if(event.equals("restock")){
	    int productIDRestockInt=Integer.parseInt(productIDRestock.getText());
	    int quantityRestockInt=Integer.parseInt(quantityRestock.getText());
	    double buyPriceRestockDouble=Double.parseDouble(buyPriceRestock.getText());
	    resultRestock.setText("Product ID: "+productIDRestockInt+"\nQuantity: "+quantityRestockInt+"\nBuy Price: "+buyPriceRestockDouble+"\n All Done!");
	}
	if(event.equals("addProduct")){
	    String productNameNewText=productNameNew.getText();
	    double sellPriceNewDouble=Double.parseDouble(sellPriceNew.getText());
	    double purchasePriceNewDouble=Double.parseDouble(purchasePriceNew.getText());
	    int quantityNewInt=Integer.parseInt(quantityNew.getText());
	    Product adding=new Product(productNameNewText, sellPriceNewDouble, purchasePriceNewDouble, admin.nextId(), quantityNewInt);
	    admin.newProduct(adding);
	    inventoryStatus.setText(admin.toStringInventory());
	    System.out.println(admin.toStringInventory());
	    

	}
	if(event.equals("removeProduct")){
	    int productIDTrashText=Integer.parseInt(productIDTrash.getText());
	    admin.removeProduct(admin.findProduct(productIDTrashText));
	    inventoryStatus.setText(admin.toStringInventory());
	    System.out.println(admin.toStringInventory());
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
	
	
	

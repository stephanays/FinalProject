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
    private JLabel profitLabel;
    private JFrame frame=new JFrame("Inventory Management System");
    private static String username;
    private Account admin=new Account();
    

    public FinalProject(String name){
	username=name;
	Helper.updateAccount(name,admin);
	System.out.println(admin.toStringInventory());
    }
    
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
	profitLabel=new JLabel("Profit: ");
	financePage.add(profitLabel);

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
	    if(admin.checkSaleOrder(productIDSaleInt, quantitySaleInt)){
		SaleOrder adding=new SaleOrder(productIDSaleInt, quantitySaleInt, admin.nextSaleId());
		admin.newSaleOrder(adding, productIDSaleInt, quantitySaleInt);
		String id = ""+ adding.getOrderID();
		Helper.newAction(username, "sale,"+productIDSaleInt+","+quantitySaleInt+","+id);
	    
		resultSale.setText("Product ID: "+productIDSaleInt+"\nQuantity: "+quantitySaleInt+"\n All Done!");
		profitLabel.setText("Profit: "+admin.getProfit());
	    }else{
		resultSale.setText("Invalid Product ID or not enough in stock");
	    }
	    System.out.println(admin.toStringSaleHistory());
	    System.out.println(admin.toStringInventory());
	}
	if(event.equals("restock")){
	    int productIDRestockInt=Integer.parseInt(productIDRestock.getText());
	    int quantityRestockInt=Integer.parseInt(quantityRestock.getText());
	    double buyPriceRestockDouble=Double.parseDouble(buyPriceRestock.getText());
	    if(checkRestockOrder(productIDRestockInt, quantityRestockInt,buyPriceRestockDouble){
		    RestockOrder adding=new RestockOrder(productIDRestockInt, quantityRestockInt, admin.nextRestockId());
		    admin.newRestockOrder(adding, productIDRestockInt, quantityRestockInt, buyPriceRestockDouble);
		    String id = ""+adding.getOrderID();
		    Helper.newAction(username, "restock,"+productIDRestockInt+","+quantityRestockInt+","+id+","+buyPriceRestockDouble);
		    resultRestock.setText("Product ID: "+productIDRestockInt+"\nQuantity: "+quantityRestockInt+"\nBuy Price: "+buyPriceRestockDouble+"\n All Done!");
		    profitLabel.setText("Profit: "+admin.getProfit());
		}else{
		    resultRestock.setText("Invalid Product ID or not enough money");
	    System.out.println(admin.toStringRestockHistory());
	    System.out.println(admin.toStringInventory());
	}
	if(event.equals("addProduct")){
	    String productNameNewText=productNameNew.getText();
	    double sellPriceNewDouble=Double.parseDouble(sellPriceNew.getText());
	    double purchasePriceNewDouble=Double.parseDouble(purchasePriceNew.getText());
	    int quantityNewInt=Integer.parseInt(quantityNew.getText());
	    Product adding=new Product(productNameNewText, sellPriceNewDouble, purchasePriceNewDouble, admin.nextId(), quantityNewInt);
	    admin.newProduct(adding);
	    String name = adding.getName();
	    String sell = ""+ adding.getSellPrice();
	    String buy = ""+ adding.getPurchasePrice();
	    String id = ""+adding.getID();
	    String quantity = ""+adding.getQuantity();
	    Helper.newAction(username, "product,"+name+","+sell+","+buy+","+id+","+quantity);
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
	
    

    public void createAndShowGUI(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.addComponentToPane(frame.getContentPane());

	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args){
	FinalProject start=new FinalProject(username);
	start.createAndShowGUI();
    }
}
	
	
	

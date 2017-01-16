import java.util.ArrayList;

public class Account{
    private ArrayList<Product> inventory = new ArrayList<Product>();
    private ArrayList<SaleOrder> saleHistory = new ArrayList<SaleOrder>();
    private ArrayList<RestockOrder> restockHistory = new ArrayList<RestockOrder>();
    private int profit;
    private String username;
    private String password;

    public int getProfit(){
	return profit;
    }
    public void setProfit(int number){
	profit = number;
    }
    public ArrayList getInventory(){
	return inventory;
    }
    public ArrayList getSaleHistory(){
	return saleHistory;
    }
    public ArrayList getRestockHistory(){
	return restockHistory;
    }
    public String getUsername(){
	return username;
    }
    public void setUsername(String name){
	username = name;
    }
    public void setPassword(String pass){
	password = pass;
    }

	
    public void newProduct(Product a){
	inventory.add(a);
	// String name = a.getName();
	// String sell = ""+ a.getSellPrice();
	// String buy = ""+ a.getPurchasePrice();
	// String id = ""+a.getID();
	// String quantity = ""+a.getQuantity();
	// Helper.newAction(username, "product,"+name+","+sell+","+buy+","+id+","+quantity);
    }
    public void removeProduct(Product a){
	for (int index = 0; index < inventory.size(); index++){
	    if(inventory.get(index).getID()==a.getID()){
		Product invalid = new Product("null", 0, 0, 0, 0);
		inventory.set(index, invalid);
	    }
	}
    }

    public boolean checkSaleOrder(int productID, int quantity){
	if (productID > inventory.size()){
	    return false;
	}
	else if (quantity > inventory.get((productID-1)).getQuantity()){
	    return false;
	}
	else{
	    return true;
	}
    }

    public boolean checkRestockOrder(int productID, int quantity, double buyPrice){
	if (productID > inventory.size()){
	    return false;
	}
	else if (Helper.cost(quantity, buyPrice) > profit){
	    return false;
	}
	else{
	    return true;
	}
    }
    
    public void newSaleOrder(SaleOrder a, int productID, int quantity){
	saleHistory.add(a);
	int oldQuantity=inventory.get((productID-1)).getQuantity();
	inventory.get(productID-1).setQuantity(oldQuantity - quantity);
	profit += Helper.cost(quantity, findProduct(productID).getSellPrice());
	// String id = ""+ a.getOrderID();
	// Helper.newAction(username, "sale,"+productID+","+quantity+","+id);
    }
    public void newRestockOrder(RestockOrder a, int productID, int quantity, double buyPrice){
	restockHistory.add(a);
	int oldQuantity=inventory.get((productID-1)).getQuantity();
	inventory.get(productID-1).setQuantity(oldQuantity + quantity);
	profit -= Helper.cost(quantity, buyPrice);
	// String id = ""+a.getOrderID();
	// Helper.newAction(username, "restock,"+productID+","+quantity+","+id+","+buyPrice);
    }

    public int nextId(){
	return getInventory().size()+1;
    }
    public int nextSaleId(){
	return getSaleHistory().size()+1;
    }
    public int nextRestockId(){
	return getRestockHistory().size()+1;
    }
    public Product findProduct(int Id){
	return inventory.get(Id-1);
	}
			     
    public String toStringInventory(){
	String output = "";
	for (int index = 0; index < inventory.size(); index++){
	    output+=inventory.get(index)+"\n";
	}
	return output;
    }

    public String toStringSaleHistory(){
	String output = "";
	for (int index = 0; index < saleHistory.size(); index++){
	    output+=saleHistory.get(index)+"\n";
	}
	return output;
    }

    public String toStringRestockHistory(){
	String output = "";
	for (int index = 0; index < restockHistory.size(); index++){
	    output+=restockHistory.get(index)+"\n";
	}
	return output;
    }
    
    public static void main(String[]args){
	Account a = new Account();
	Product p = new Product("pizza", 5, 4.50, 1, 10);
	Product s = new Product("scallions", 10, 7.50, 2, 10);
	a.newProduct(p);
	a.newProduct(s);
	System.out.println(a.toStringInventory());
	Product r = new Product("radish", 9.23, 4.20, 3, 10);
	a.newProduct(r);
	System.out.println(a.toStringInventory());
	System.out.println(a.nextId());
	a.removeProduct(s);
	System.out.println(a.toStringInventory());
    }
}

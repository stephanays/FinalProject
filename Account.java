import java.util.ArrayList;

public class Account{
    private  ArrayList<Product> inventory = new ArrayList<Product>();
    private int profit;

    public int getProfit(){
	return profit;
    }
    public void setProfit(int number){
	profit = number;
    }
    public ArrayList getInventory(){
	return inventory;
    }
    public void newProduct(Product a){
	inventory.add(a);
    }
    public void removeProduct(Product a){
	for (int index = 0; index < inventory.size(); index++){
	    if(inventory.get(index).getID()==a.getID()){
		inventory.remove(index);
	    }
	}
    }

    public int nextId(){
	return getInventory().size() +1;
    }

    public String toString(){
	String output = "";
	for (int index = 0; index < inventory.size(); index++){
	    output+=inventory.get(index)+"\n";
	}
	return output;
    }
   
    public static void main(String[]args){
	Account a = new Account();
	Product p = new Product("pizza", 5, 4.50, 1);
	Product s = new Product("scallions", 10, 7.50, 2);
	a.newProduct(p);
	a.newProduct(s);
	System.out.println(a);
	Product r = new Product("radish", 9.23, 4.20, 3);
	a.newProduct(r);
	System.out.println(a);
	System.out.println(a.nextId());
	a.removeProduct(s);
	System.out.println(a);
    }
    


}

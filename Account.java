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

    


}

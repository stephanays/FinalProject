import java.util.ArrayList;

public class Product{
    private int id;
    private String name;
    private int quantity;
    private double sellPrice;
    private double purchasePrice;

    public Product (String inputName, double inputSell, double inputPurchase){
	name = inputName;
	sellPrice = inputSell;
	id = (Account.getInventory().length)+1; 

    }

    public int getID (){
	return id;
    }
    public String getName (){
	return name;
    }
    public int getQuantity(){
	return quantity;
    }
    public int getSellPrice(){
	return sellPrice;
    }
    public int getPurchasePrice(){
	return purchasePrice;
    }

    public void setQuantity(int number){
	quantity = number;
    }
    public void setSellPrice(int price){
	sellPrice = price;
    }
    public void setPurchasePrice(int price){
	purchasePrice = price;
    }


}

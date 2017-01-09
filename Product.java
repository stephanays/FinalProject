import java.util.ArrayList;

public class Product{
    private int id;
    private String name;
    private int quantity;
    private double sellPrice;
    private double purchasePrice;

    public Product (String inputName, double inputSell, double inputPurchase, int inputID){
	name = inputName;
	sellPrice = inputSell;
	purchasePrice = inputPurchase;
	id = inputID; 

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
    public double getSellPrice(){
	return sellPrice;
    }
    public double getPurchasePrice(){
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

    public String toString(){
	return id + ", " + name + ", " + sellPrice + ", " + purchasePrice;
    }


}

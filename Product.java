public class Product{
    private int id;
    private String name;
    private int quantity;
    private int sellPrice;
    private int purchasePrice;

    public Product (String inputName, int inputSell, int inputPurchase){
	name = inputName;
	sellPrice = inputSell;
	purchasePrice = inputPurchase;
	id = 1; //CHANGE THIS ONCE INVENTORY IS CODED
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

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

    public static void main(String[]args){
	Product a = new Product("Pizza",3, 5);
	System.out.println(a.getName());
	System.out.println(a.getID());
	System.out.println(a.getSellPrice());
	System.out.println(a.getPurchasePrice());
	a.setQuantity(8);
	System.out.println(a.getQuantity());
    }

}

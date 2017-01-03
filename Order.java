public class Order{
    private int orderID;
    private int productID;
    private int quantity;

    public Order(int productNum, int quant){
	orderID=001;
	productID=productNum;
	quantity=quant;
    }

    public int getOrderID(){
	int x=orderID;
	return x;
    }

     public int getProductID(){
	int x=productID;
	return x;
    }

     public int getQuantity(){
	int x=quantity;
	return x;
    }

     public void setOrderID(int x){
	orderID=x;
    }

    public void setProductID(int x){
	productID=x;
    }

    public void setQuantity(int x){
	quantity=x;
    }
}

    

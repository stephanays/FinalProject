public class SaleOrder{
    private int saleOrderID;
    private int productID;
    private int quantity;

    public SaleOrder(int productNum, int quant, int orderNum){
	saleOrderID=orderNum;
	productID=productNum;
	quantity=quant;
    }

    public int getOrderID(){
	int x=saleOrderID;
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
	saleOrderID=x;
    }

    public void setProductID(int x){
	productID=x;
    }

    public void setQuantity(int x){
	quantity=x;
    }

    public String toString(){
	return saleOrderID + ", "+productID+", "+quantity;
    }
}

    

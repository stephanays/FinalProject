epublic class RestockOrder{
    private int restockOrderID;
    private int productID;
    private int quantity;

    public RestockOrder(int productNum, int quant, int orderNum){
	restockOrderID=orderNum;
	productID=productNum;
	quantity=quant;
    }

    public int getOrderID(){
	int x=restockOrderID;
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
	restockOrderID=x;
    }

    public void setProductID(int x){
	productID=x;
    }

    public void setQuantity(int x){
	quantity=x;
    }

    public String toString(){
	return restockOrderID + ", "+productID+", "+quantity;
    }
}


public class Helper{
    
    public static void addProfit(int x){
	Account.setProfit(Account.getProfit()+x);
    }

    public static void subtractProfit(int x){
	Account.setProfit(Account.getProfit()-x);
    }

    public static double cost(int quantity, double price){
	double cost=quantity*price;
	return cost;
    }

    
}
   

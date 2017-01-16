import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.lang.Integer;
import java.lang.Double;

public class Helper{

    public static ArrayList<String> readUsers(){
	ArrayList <String> usernames = new ArrayList <String>();
	try{
	    Scanner sc = new Scanner(new File("usernames.txt"));
	    while (sc.hasNext()){
		usernames.add(sc.next());
	    }
	}catch (FileNotFoundException e){
	    System.out.println ("Invalid file name or path");
	    System.exit(1);
	}
	return usernames;
    }

    public static ArrayList<String> readAccount(String username){
	ArrayList<String> account= new ArrayList<String>();
	String filename = username+".txt";
	try{
	    Scanner sc = new Scanner(new File(filename));
	    while (sc.hasNext()){
		account.add(sc.next());
	    }
	}catch (FileNotFoundException e){
	    System.out.println ("Invalid file name or path");
	    System.exit(1);
	}
	return account;
    }



    public static boolean userExist(String username){
	ArrayList <String> users = new ArrayList <String>();
	users = readUsers();
	for(int index = 0; index < users.size(); index++){
	    if(users.get(index).equals(username)){
		return true;
	    }
	}
	return false;
    }

    public static boolean verifyPass(String user, String pass){
       	ArrayList<ArrayList<String>> account = new ArrayList<ArrayList<String>>
    	    (processAccount(user));
        return account.get(0).get(0).equals(pass);
    }


    public static void newUser(String username){
	boolean run= true;
	for (int index = 0; index < username.length(); index++){
	    if (Character.isWhitespace(username.charAt(index))){
		System.out.println("Usernames cannot have spaces");
		run = false;
	    }
	}
	if (run){
	    try{
		String filename= "usernames.txt";
		FileWriter writer = new FileWriter(filename,true);
		writer.write("\n"+ username);
		writer.close();
	    }
	    catch(IOException e){
		System.err.println("IOException: " + e.getMessage());
	    }
	}
    }

    public static void newAction(String username, String action){
	    try{
		String filename= username+".txt";
		FileWriter writer = new FileWriter(filename,true);
		writer.write("\n"+action);
		writer.close();
	    }
	    catch(IOException e){
		System.err.println("IOException: " + e.getMessage());
	    }
    }

    public static ArrayList<ArrayList<String>> processAccount(String accountName){
	ArrayList<String> account = new ArrayList<String>(readAccount(accountName));
        ArrayList<ArrayList<String>> actions = new ArrayList<ArrayList<String>>();
        for (int index = 0; index < account.size(); index++){
    	    ArrayList<String> oneAction = new ArrayList<String>
    		(Arrays.asList(account.get(index).split(",")));
    	    actions.add(oneAction);
    	}
    	return actions;
    }

    public static void updateAccount(String username){
    	ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>
    	    (processAccount(username));
	Account user = new Account();
    	for (int action = 0; action < info.size(); action++){
    	    if (info.get(action).get(0).equals("product")){
		double sell = Double.parseDouble(info.get(action).get(2));
	       	double buy = Double.parseDouble(info.get(action).get(3));
	        int id = Integer.parseInt(info.get(action).get(4));
		int quantity = Integer.parseInt(info.get(action).get(5));
		Product a = new Product(info.get(action).get(1), sell, buy, id, quantity);
	        user.newProduct(a);
	    }
	    if (info.get(action).get(0).equals("sale")){
		int id = Integer.parseInt(info.get(action).get(1));
		int quantity = Integer.parseInt(info.get(action).get(2));
		int orderNum = Integer.parseInt(info.get(action).get(3));
		SaleOrder a = new SaleOrder(id, quantity, orderNum);
		user.newSaleOrder(a, id, quantity);
	    }
	    // if (info.get(action).get(0).equals("restock")){
	    // 	int id = Integer.parseInt(info.get(action).get(1));
	    // 	int quantity = Integer.parseInt(info.get(action).get(2));
	    // 	int orderNum = Integer.parseInt(info.get(action).get(3));
	    // 	double price = Double.parseDouble(info.get(action).get(4));
	    // 	RestockOrder a = new RestockOrder(id, quantity, orderNum, price);
	    // 	user.newRestockOrder(a, id, quantity, price);
	    // }
	}
	System.out.println(user.toStringInventory());
	System.out.println(user.toStringSaleHistory());
    }
		    
			
			
	
	

    public static double cost(int quantity, double price){
	double cost=quantity*price;
	return cost;
    }

    public static void main(String[]args){
	Helper a = new Helper();
	// System.out.println(a.readUsers());
	// System.out.println(a.userExist("pizza"));
	// a.newUser("Mr. K");
	// System.out.println(a.readUsers());
	// a.newAction("tester","hi");
	// a.newAction("tester","pizza,5,5,1,4");
	// a.newAction("tester","pasta,5,5,2,3");
	// a.newAction("tester","chili,5,5,3,5");
	// System.out.println(a.verifyPass("tester","hi"));
	// System.out.println(a.readAccount("tester"));
	// System.out.println(a.processAccount("tester"));
	a.newAction("tester", "sale,1,2,1");
	a.updateAccount("tester");
	
    }
	

    
}
   

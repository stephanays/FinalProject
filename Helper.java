import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.util.Arrays;

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

    // public static void updateAccount(String username){
    // 	ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>>
    // 	    (readAccount(username));
    // 	for (int action = 0; action < info.size(); action++){
    // 	    for (int index = 0; index < info.get(action).size(); index++){
    // 		if (info.get(action).get(index).equals("product"){
			
	
	

    public static double cost(int quantity, double price){
	double cost=quantity*price;
	return cost;
    }

    public static void main(String[]args){
	Helper a = new Helper();
	System.out.println(a.readUsers());
	System.out.println(a.userExist("pizza"));
	a.newUser("Mr. K");
	System.out.println(a.readUsers());
	a.newAction("tester","hi");
	a.newAction("tester","pizza,5,5,5");
	a.newAction("tester","pasta,5,5,5");
	a.newAction("tester","chili,5,5,5");
	System.out.println(a.verifyPass("tester","hi"));
	System.out.println(a.readAccount("tester"));
	System.out.println(a.processAccount("tester"));
    }
	

    
}
   

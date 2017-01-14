import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.nio.file.Files;

public class Helper{

    public static ArrayList<String> readAccounts(){
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

    public static boolean userExist(String username){
	ArrayList <String> users = new ArrayList <String>();
	users = readAccounts();
	for(int index = 0; index < users.size(); index++){
	    if(users.get(index).equals(username)){
		return true;
	    }
	}
	return false;
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

    public static double cost(int quantity, double price){
	double cost=quantity*price;
	return cost;
    }

    public static void main(String[]args){
	Helper a = new Helper();
	System.out.println(a.readAccounts());
	System.out.println(a.userExist("pizza"));
	a.newUser("Mr. K");
	System.out.println(a.readAccounts());
    }
	

    
}
   

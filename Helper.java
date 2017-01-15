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

    public static ArrayList<ArrayList<String>> readAccount(String accountName){
	String filename= accountName+".txt";
	try{
	    BufferedReader reader = new BufferedReader
		(new FileReader(filename));
	    try{
	    String accountInfo = reader.readLine();
	    ArrayList<String> actions = new ArrayList<String>
		(Arrays.asList(accountInfo.split("/")));
	    ArrayList<ArrayList<String>> actionsArray = new ArrayList<ArrayList<String>>();
	    for (int index = 0; index < actions.size(); index++){
		ArrayList<String> oneAction = new ArrayList<String>
		    (Arrays.asList(actions.get(index).split(",")));
		actionsArray.add(oneAction);
	    }
	    return actionsArray;
	    }
	    catch(IOException e){
		System.err.println("Input/Output Exception");
		ArrayList<ArrayList<String>> error = new ArrayList<ArrayList<String>>();
		return error;
	    }
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found");
	    ArrayList<ArrayList<String>> error = new ArrayList<ArrayList<String>>();
	    return error;
	}
    }
	

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
	System.out.println(a.readAccount("tester"));
    }
	

    
}
   

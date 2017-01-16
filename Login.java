import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    private JLabel userNameLabel;
    private JTextField userName;
    private JLabel passwordLabel;
    private JTextField password;
    private JButton submitLogin;
    private JFrame frame=new JFrame("Login");

    public void addComponentToPane(Container pane){
	pane.setLayout(new GridLayout(0,1));

	userNameLabel = new JLabel("Username: ");
	userName = new JTextField("",15);
	passwordLabel = new JLabel("Password: ");
	password = new JTextField("",15);
	submitLogin = new JButton("Login");
	submitLogin.addActionListener(this);
	submitLogin.setActionCommand("login");
        
        pane.add(userNameLabel);
	pane.add(userName);
	pane.add(passwordLabel);
	pane.add(password);
	pane.add(submitLogin);
    }

    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
	if(event.equals("login")){
	    String userNameString=userName.getText();
	    String passwordString=password.getText();
	    frame.setVisible(false);
	    Account loginAccount=new Account();
	    FinalProject initiateLogin=new FinalProject(loginAccount);
	    initiateLogin.createAndShowGUI();
	}
    }

    public void createAndShowGUI(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.addComponentToPane(frame.getContentPane());
	
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args){
	Login start=new Login();
	start.createAndShowGUI();
    }
	
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{
    private JLabel userNameSignUpLabel;
    private JTextField userNameSignUp;
    private JLabel passwordSignUpLabel;
    private JTextField passwordSignUp;
    private JButton submitSignUp;
    private JFrame frame=new JFrame("Sign Up");

    public void addComponentToPane(Container pane){
	pane.setLayout(new GridLayout(0,1));

	userNameSignUpLabel = new JLabel("Username: ");
	userNameSignUp = new JTextField("",15);
	passwordSignUpLabel = new JLabel("Password: ");
	passwordSignUp = new JTextField("",15);
	submitSignUp = new JButton("Sign Up");
	submitSignUp.addActionListener(this);
	submitSignUp.setActionCommand("signup");
        
        pane.add(userNameSignUpLabel);
	pane.add(userNameSignUp);
	pane.add(passwordSignUpLabel);
	pane.add(passwordSignUp);
	pane.add(submitSignUp);
    }

    public void actionPerformed(ActionEvent e){
	String event=e.getActionCommand();
	if(event.equals("signup")){
	    String userNameSignUpString=userNameSignUp.getText();
	    String passwordSignUpString=passwordSignUp.getText();
	    //if statement for whether the username is available
	    //if its: code that add the username to the text
	    frame.setVisible(false);
	    Login toLogin=new Login();
	    toLogin.createAndShowGUI();
	    
	}
    }

    private void createAndShowGUI(){
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	this.addComponentToPane(frame.getContentPane());
	
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args){
	SignUp start=new SignUp();
	start.createAndShowGUI();
    }
}
    

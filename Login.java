import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField; 


public class Login extends JFrame implements ActionListener
        {
    static Scanner sc = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);
    JFrame frame = new JFrame("Login");
    JLabel label = new JLabel("Username : "); //student username
    JTextField UsernameText = new JTextField();      //input student username
    JLabel label2 = new JLabel("Password : "); //student password
    JPasswordField password = new JPasswordField();     //input student password
    JButton Loginbutton = new JButton("Login");      //button to login
    JButton Resetbutton = new JButton("Reset"); // reset button
    JTextArea output = new JTextArea(10,15);    //login succesful or failed
    JCheckBox showPassword=new JCheckBox("Show Password");    //Password checkbox
    String username;

        public static void main(String[] args){

        new Login();

    }
public Login(){
         label.setBounds(10,-20, 100,100);
         UsernameText.setBounds(80,20,190,20);
         label2.setBounds(10,50,190,20);
         password.setBounds(80,50,190,20);
         Loginbutton.setBounds(50,110,80,30);
         Resetbutton.setBounds(170,110,80,30);
         output.setBounds(20,160,230,150);
         showPassword.setBounds(85,70,150,30);

         
         
         frame.add(label);
         frame.add(label2);
         frame.add(UsernameText);
         frame.add(password);
         frame.add(Loginbutton);
         frame.add(output);
         frame.add(showPassword);
         frame.add(Resetbutton);
         
        Loginbutton.addActionListener(this); //login button
         Loginbutton.setFocusable(false);
         
         Resetbutton.addActionListener(this); //reset button
         Resetbutton.setFocusable(false);
         
         showPassword.addActionListener(this); //check password box
         frame.setSize(300,400);
         frame.setLayout(null);
         frame.setVisible(true);
         frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

}

@Override
public void actionPerformed(ActionEvent evt){          
        if (evt.getActionCommand().equalsIgnoreCase("Reset")) {
            UsernameText.setText("");
            password.setText("");
        }
        if (evt.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                password.setEchoChar((char) 0);
            } else {
                password.setEchoChar('*');
            }
        }
        if(evt.getActionCommand().equalsIgnoreCase("Login")){
            if(password.getText().equalsIgnoreCase("student")) {
                frame.dispose();
                MainMenu mainMenu = new MainMenu();
            }
        else{
            output.setForeground(Color.red);
            output.setText("Login Failed.....") ;
            }
        }
    }
}



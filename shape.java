import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.util.Random;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class shape extends JFrame implements ActionListener {
	
	JFrame frame = new JFrame("shapes");
	
	
JLabel label = new JLabel("Answer : ");
JTextField input = new JTextField(10);
JButton button = new JButton("submit");
JTextArea output = new JTextArea(10,15);
int wmax = 10;
int wmin = 6;
int hmax = 5;
int hmin = 1;
 int widthNumber = new Random().nextInt(wmax - wmin + 1) + wmin;
 int heightNumber = new Random().nextInt(hmax - hmin + 1) + hmin;

JLabel shapeWidth =  new JLabel();
JLabel shapeHeight =  new JLabel();
JLabel managinglbl = new JLabel(); // correct/wrong feedback.
JLabel hint = new JLabel("Hint: Perimeter = 2 times (width + height)");
JLabel question = new JLabel("**Calculate the Perimeter**");
JLabel exH = new JLabel("                                                ");
JButton mainmenub = new JButton("Back");
//
boolean close = false;
//circumference right answer
int rightAnswer = 2 * (widthNumber + heightNumber);

//JLabel shapeHeight = new JLabel(heightNumber);
public  void newnumbers(){
	widthNumber = new Random().nextInt(wmax - wmin + 1) + wmin;
	heightNumber = new Random().nextInt(hmax - hmin + 1) + hmin;
	
	rightAnswer = 2 * (widthNumber + heightNumber);
	
	shapeWidth.setText(String.valueOf(widthNumber));
	shapeHeight.setText(String.valueOf(heightNumber));
}
 
 
 //image  
 
  ImageIcon icon = new ImageIcon("due.png");
  JLabel label20 = new JLabel(icon);
 
 
  
  public static void main(String[] args){
   /*
   trial tryme = new trial();
	
	tryme.window();
	*/
 }

	
	public /*static*/ class trial extends shape{
	
	public void window()
	{ 
		
	//frame
	
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    frame.setPreferredSize(new Dimension(450, 400));
    frame.pack();
	
	
	//Layout 
	managinglbl.setBounds(10,300,20,20);
	
	shapeWidth.setText(String.valueOf(widthNumber));
	shapeHeight.setText(String.valueOf(heightNumber));
		shapeWidth.setBounds(290,20,20,20);	// immovable 
		shapeHeight.setBounds(170,110,20,20); // right number status: movable 
		
		label.setBounds(10,70,90,30);
		input.setBounds(10,100,90,20);
		button.setBounds(10,130,90,30);
		hint.setBounds(10,310,300,20);
		label20.setBounds(200,50,200,140);
    	question.setBounds(10,40,250,20);
		exH.setBounds(10,290,300,20);
		mainmenub.setBounds(10,1,30,30);
	
	
		frame.add(shapeHeight);
		frame.add(shapeWidth);
        frame.add(button);
		frame.add(input);
        frame.add(label);
		frame.add(hint);
		frame.add(question);
		 frame.add(label20);
		 frame.add(mainmenub);
		 frame.add(exH);
		
		frame.add(managinglbl);
		
		
        button.addActionListener(this);
		mainmenub.addActionListener(this);
	 frame.setVisible(true);
	
	 
	
		}
	
	}
	
	// get number from textfield store it in a variable/ convert, then output
	 //Action Listener

    public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Back")){
					 
					MainMenu mainMenu = new MainMenu();
					close = true;
					System.out.print(" working");
					frame.dispose();
					
				}
		//change this to fit shape class
		String rightAnswertxt = String.valueOf(rightAnswer); // right answer 
		String answertxt = input.getText(); // user input
		   	try{  //handle exception 
						int userAnswer = Integer.valueOf(answertxt);
				String f = String.valueOf(userAnswer);
				int ff = Integer.parseInt(f);
				}catch (NumberFormatException ex) {
					
					exH.setText("##invalid input: please answer with a number##");
					
					}
			
					
				if(answertxt.equals(rightAnswertxt)){
					managinglbl.setText("Correct !!");
					//change numbers if correct
				    dispose();
						newnumbers();
					//
					
				
				}
				
				else{
					managinglbl.setText("Wrong, Try Again.");
				}
				
				
	  
	 
	  
    }
	
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.util.Random;
import java.util.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

 abstract class hintchoice{
	abstract void showhint();
}
 class additionhint extends hintchoice{
	void showhint(){
		System.out.print("addition hint created");
	}
}
class multiplicationhint extends hintchoice{
	void showhint(){
		System.out.print("multiplication hint created");
	}
}
class subtractionhint extends hintchoice{
		void showhint(){
		System.out.print("subtraction hint created");
	}
}
class divisionhint extends hintchoice{
		void showhint(){
		System.out.print("division hint created");
	}
}

public class simpleMath extends JFrame implements ActionListener {
	//hints
	additionhint hint1 = new additionhint();
	multiplicationhint hint3 = new multiplicationhint();
	subtractionhint hint2 = new subtractionhint();
	divisionhint hint4 = new divisionhint();
	JLabel hintlbl = new JLabel();
	
	//
      static int randomNum1;
      static int randomNum2;
      static int operation;
      static int answer;
      static Random randomNums = new Random();
      int min = 1;
      int max = 10;
      JFrame frame = new JFrame("Simple Maths");
      JTextField input = new JTextField(10);
      JButton button = new JButton("Go");
      JButton Hintbutton = new JButton("Hint");
      JLabel feedback = new JLabel();
      JLabel first = new JLabel();
      JLabel second = new JLabel();
      JLabel op = new JLabel();
      JLabel equals = new JLabel("=");
      JButton Backbutton = new JButton("Back");
      JLabel labelHint = new JLabel("Round to the nearest whole number");
    public void calculation(){
      randomNum1 = randomNums.nextInt(max + min) + 1;
      randomNum2 = randomNums.nextInt(max + min) + 1;
      operation = randomNums.nextInt(3 + 1) + 1;
      System.out.println(operation);

      input.setText("");
      if(operation == 1){
        op.setText("+");
        answer = randomNum1 + randomNum2;
      }
      if(operation == 2){
        op.setText("-");
        if(randomNum1 < randomNum2){
          int temp;
          temp = randomNum1;
          randomNum1 = randomNum2;
          randomNum2 = temp;
        }
        answer = randomNum1 - randomNum2;


      }
      if(operation == 3){
        op.setText("/");
        if(randomNum1 < randomNum2){
          int temp;
          temp = randomNum1;
          randomNum1 = randomNum2;
          randomNum2 = temp;
          answer = randomNum1 / randomNum2;
        }

      if(randomNum2 != 0)
          answer = randomNum1 / randomNum2;
      }
      if(operation == 4){
        op.setText("X");
        answer = randomNum1 * randomNum2;
      }

      first.setText(Integer.toString(randomNum1));
      second.setText(Integer.toString(randomNum2));

    }

    public void swapValues(int a, int b){

    }
    public simpleMath(){
      frame.setLayout(null);
      frame.setSize(300,420);
      frame.add(labelHint);
      first.setBounds(120,150,190,10);
      second.setBounds(160,150,190,10);
      op.setBounds(140,150,190,10);
      equals.setBounds(180,150,190,10);
      input.setBounds(50,170,190,30);
      button.setBounds(50, 210, 190,15);
      Hintbutton.setBounds(50, 230, 190, 15);
      labelHint.setBounds(48,250,190,10);
      labelHint.setFont(new Font("TimesRoman", Font.PLAIN,12));
      feedback.setBounds(90,230,190,10);
      Backbutton.setBounds(10,10,20,20);
      Backbutton.setFont(new Font("TimesRoman", Font.PLAIN,15));

      frame.add(equals);
      frame.add(input);
      frame.add(button);
      frame.add(Hintbutton);
      frame.add(first);
      frame.add(second);
      frame.add(op);
      frame.add(feedback);
      frame.add(Backbutton);
	  
	  //
	     frame.setSize(300,420);
      first.setBounds(120,150,190,10);
      second.setBounds(160,150,190,10);
      op.setBounds(140,150,190,10);
      equals.setBounds(180,150,190,10);
      input.setBounds(50,170,190,30);
      button.setBounds(50, 210, 190,15);
      Hintbutton.setBounds(50, 230, 190, 15);
      feedback.setBounds(90,300,190,10);
      Backbutton.setBounds(10,10,20,20);
      Backbutton.setFont(new Font("TimesRoman", Font.PLAIN,15));
	  //
	 //frame.add(hintlbl); // hint label
      Backbutton.setFocusable(false);
      Backbutton.addActionListener(this);
      
      Hintbutton.addActionListener(this);
      Hintbutton.setFocusable(false);
      button.setFocusable(false);
      button.addActionListener(this);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      calculation();

    }

    @Override
   public void actionPerformed(ActionEvent e1){
        if (e1.getActionCommand().equals("Go")){
          try{
            String ans = input.getText();
            int userAns = Integer.parseInt(ans.trim());
            if(answer == userAns){
              System.out.println("working!");
              feedback.setText("");

              calculation();

            }else{
              feedback.setText("Incorrect Answer!");
              input.setText("");
              System.out.println("Wrong!");
            }
          }catch (NumberFormatException ex) {
            feedback.setText("Must be a number");
          }
        }
        if (e1.getActionCommand().equals("Back")){
                frame.dispose();
                MainMenu mainMenu = new MainMenu();
        }
        if(e1.getActionCommand().equals("Hint")){// hint button action
		if(operation == 1){// addition hint 
		JFrame frame1 = new JFrame("addition table");
		ImageIcon icon = new ImageIcon("additionTable1.png");
			hintlbl = new JLabel(icon);
		frame1.add(hintlbl);
		frame1.setPreferredSize(new Dimension(460, 460));
			frame1.pack();
            
			hint1.showhint();
			frame1.setVisible(true);
		}
		if(operation == 2){// subtraction hint 
		JFrame frame2 = new JFrame("subtraction table");
		 ImageIcon icon = new ImageIcon("subtractionTable.png");
			hintlbl = new JLabel(icon);
		frame2.add(hintlbl);
		frame2.setPreferredSize(new Dimension(460, 460));
			frame2.pack();
           
			hint3.showhint();
			frame2.setVisible(true);
		}
		
		if(operation == 3){ // division hint
			JFrame frame3 = new JFrame("division table");
			 ImageIcon icon = new ImageIcon("divisionTable.png");
			hintlbl = new JLabel(icon);
			frame3.add(hintlbl);
			frame3.setPreferredSize(new Dimension(700, 600));
			frame3.pack();
			
           
			hint4.showhint();
			frame3.setVisible(true);
			
		}
			if(operation == 4){// multiplication hint
			JFrame frame4 = new JFrame("multiplication table");
			ImageIcon icon = new ImageIcon("multiplicationTable.png");
			hintlbl = new JLabel(icon);
			frame4.add(hintlbl);
			frame4.setPreferredSize(new Dimension(700, 500));
			frame4.pack();
            
			hint2.showhint();
			frame4.setVisible(true);
		}
            
            
      }
      }

      public static void main(String[] args){
        new simpleMath();
     }
    }

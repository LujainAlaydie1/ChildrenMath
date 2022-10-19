import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;



public class MainMenu extends shape implements ActionListener{
    JFrame frame = new JFrame("Main Menu");
    JLabel label = new JLabel("Hi"); //student username
    JButton Mathbutton = new JButton("Simple Math");      // button to go to simple math
    JButton Shapesbutton = new JButton("Shape Questions");      //button to go to shapes questions
    JButton Converterbutton = new JButton("Converter");      //button to go to converter
    JButton ExitButton = new JButton ("Exit");            //exit button
    



   public MainMenu(){

    label.setBounds(30,-20,200,100);
    Mathbutton.setBounds(70,80,150,50);
    Shapesbutton.setBounds(70,140,150,50);
    Converterbutton.setBounds(70,200,150,50);
    ExitButton.setBounds(70,260,150,50);
    label.setText("Hello, What do you want to do? ");

    frame.add(label);
    frame.add(Mathbutton);
    Mathbutton.setFocusable(false);
    frame.add(Shapesbutton);
    Shapesbutton.setFocusable(false);
    frame.add(Converterbutton);
    Converterbutton.setFocusable(false);
    frame.add(ExitButton);
    ExitButton.setFocusable(false);


    Mathbutton.addActionListener(this);
    Shapesbutton.addActionListener(this);
    Converterbutton.addActionListener(this);
    ExitButton.addActionListener(this);
    frame.setSize(300,400);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }



    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equalsIgnoreCase("Shape questions")) {
			frame.dispose();
             shape shapepage = new shape();

			trial tryme = new trial();

			tryme.window();
					if(close == true){

		 System.out.print("works");
	 }


        }
        if (evt.getActionCommand().equalsIgnoreCase("Converter")){
            frame.dispose();
            MathConverter mathConveter = new MathConverter();

        }
        if (evt.getActionCommand().equalsIgnoreCase("Simple Math")){
            frame.dispose();
            simpleMath maths = new simpleMath();
        }
        if (evt.getActionCommand().equalsIgnoreCase("Exit")){
            frame.dispose();
        }
        }
       public static void main(String[] args){
    }
}

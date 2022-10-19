import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MathConverter extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Converter");
    JLabel label = new JLabel("Length : ");
    JTextField input = new JTextField(10);
    JButton button = new JButton("Convert");
    JButton Backbutton = new JButton("Back");
    JTextArea output = new JTextArea(10,15);
    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox cb1 = new Checkbox("Convert cm to m", cbg, true);
    Checkbox cb2 = new Checkbox("Convert m to cm", cbg, false);


    
public MathConverter(){
    cb1.setBounds(70,20,190,10);
    cb2.setBounds(70,30,190,50);
    label.setBounds(10,50, 100,100);
    input.setBounds(70,90,190,20);
    button.setBounds(90,120,80,30);
    Backbutton.setBounds(10,10,20,20);
    output.setBounds(20,160,230,150);
    Backbutton.setFont(new Font("TimesRoman", Font.PLAIN,15));
    
        frame.add(cb1);
        cb1.setFocusable(false);
        frame.add(cb2);
        cb2.setFocusable(false);
        frame.add(label);
        frame.add(input);
        frame.add(button);
        button.setFocusable(false);
        frame.add(Backbutton);
        Backbutton.setFocusable(false);
        frame.add(output);
        
    button.addActionListener(this);
    Backbutton.addActionListener(this);
    frame.setSize(300,420);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
   public void actionPerformed(ActionEvent e1){
        if (e1.getActionCommand().equals("Convert")){
            try{
            if(cb1.getState()){
            double l = Double.parseDouble(input.getText());
            double cmtom = 0;
            cmtom = l / 100;
            output.setText(String.valueOf(cmtom));
            }
                else if(cb2.getState()){
            double l = Double.parseDouble(input.getText());
            double mtocm = 0;
             mtocm = l * 100;
            output.setText(String.valueOf(mtocm));
            }
            }catch(NumberFormatException ex) {
            output.setForeground(Color.red);
            output.setText("Must be a number!!");
          }
            }
        if (e1.getActionCommand().equals("Back")){
                frame.dispose();
                MainMenu mainMenu = new MainMenu();
            }
     }
    public static void main(String[] args){
        new MathConverter();
        }
    }
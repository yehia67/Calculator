/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Sony
 */
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.*;

public class Calculator extends JFrame  {

    JPanel zarayr;
    JTextArea display;
     JMenuBar menuBar;
     JMenu file;
     JMenu edit;
     JMenu help;
     JMenuItem close;
     JMenuItem copy;
     JMenuItem view;
     JMenuItem about;
     
     JButton clear,equals,zero,decimal,poseneg,one,two,three,four,five,six,seven,eight,nine;
     JButton divison,multiplication,substraction,addition;
     int i = 0; 
    String q ;
    double tempfirst = 0.0,tempsecond = 0.0;
    boolean[] operation = new boolean[4];
    public Calculator() {
        //setLayout(new GridLayout());
         setLayout(null);
  sendDisplay();      
  sendMenuBar();
  sendButton();
    }
    private void sendDisplay(){
        display = new JTextArea("0");//maybe bug
       display.setVisible(true);
        display.setBounds(10,10,280,50);
       display.setEditable(false);
      // display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
       display.setFont(new Font("Arial",Font.PLAIN,32));
       add(display);
    }
private void sendMenuBar(){
    menuBar = new JMenuBar();
    file = new JMenu("File");
    edit = new JMenu ("Menu");
    help = new JMenu("Help");
    copy = new JMenuItem("copy");
    view = new JMenuItem("view hepl");
    about = new JMenuItem("about");
    close = new JMenuItem("close");
    setJMenuBar(menuBar);
    menuBar.add(file);
    menuBar.add(edit);
    menuBar.add(help);
    close.addActionListener(new ActionListener(){
       
        public void actionPerformed(ActionEvent e) {
             System.exit(0);//To change body of generated methods, choose Tools | Templates.
        }
    });
    copy.addActionListener(new ActionListener(){
       
        public void actionPerformed(ActionEvent e) {
             String tempdisplay = display.getText();
             StringSelection string = new StringSelection(tempdisplay); 
             Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
             system.setContents(string, string);
        
        }
    });
    view.addActionListener(new ActionListener(){
       
        public void actionPerformed(ActionEvent e) {
           JOptionPane.showMessageDialog(null, "ok ok  ", "yarab",JOptionPane.OK_OPTION);
        }
    });
    about.addActionListener(new ActionListener(){
       
        public void actionPerformed(ActionEvent e) {
             JOptionPane.showMessageDialog(null, "mafysh 7aga ", "moshkla",JOptionPane.OK_OPTION);//To change body of generated methods, choose Tools | Templates.
        }
    });
    file.add(close);
    edit.add(copy);
    help.add(view);
    help.add(about);
            
}
 private void sendButton() {
     
      divison = new JButton("/");
     divison.setBounds(226,70,65,55);
     divison.addActionListener(new ActionListener () {
         @Override
         public void actionPerformed(ActionEvent e) {
             
             tempfirst = Double.parseDouble(display.getText());
             display.setText("0");
             operation[0] = true;
             //System.out.println(tempfirst);
         }
         });
        
    add( divison);
     multiplication = new JButton("*");
     multiplication.setBounds(226,132,65,55);
      multiplication.addActionListener(new ActionListener () {
         @Override
         public void actionPerformed(ActionEvent e) {
             
             tempfirst = Double.parseDouble(display.getText());
             display.setText("0");
             operation[1] = true;
             //System.out.println(tempfirst);
         }
         });
     
     add(multiplication);
     substraction = new JButton("-");
     substraction.setBounds(226,194,65,55);
      substraction.addActionListener(new ActionListener () {
         @Override
         public void actionPerformed(ActionEvent e) {
             
             tempfirst = Double.parseDouble(display.getText());
             display.setText("0");
             operation[2] = true;
             //System.out.println(tempfirst);
         }
         });

     add(substraction);
     addition= new JButton("+");        
     addition.setBounds(226,256,65,55);
      addition.addActionListener(new ActionListener () {
         @Override
         public void actionPerformed(ActionEvent e) {
             
             tempfirst = Double.parseDouble(display.getText());
             display.setText("0");
             operation[3] = true;
             //System.out.println(tempfirst);
         }
         });

     add(addition);
     equals = new JButton("=");
     equals.setBounds(10,318,137,55);
     equals.addActionListener(new ActionListener () {
         @Override
         public void actionPerformed(ActionEvent e) {
             if(operation[0] == true)
             {
                 tempsecond = Double.parseDouble(display.getText());
            display.setText(Double.toString(tempfirst / tempsecond));
         }     
             if(operation[1] == true)
             {
                 tempsecond = Double.parseDouble(display.getText());
            display.setText(Double.toString(tempfirst * tempsecond));
         }    
             if(operation[2] == true)
             {
                 tempsecond = Double.parseDouble(display.getText());
            display.setText(Double.toString(tempfirst - tempsecond));
         }    
             if(operation[3] == true)
             {
                 tempsecond = Double.parseDouble(display.getText());
            display.setText(Double.toString(tempfirst + tempsecond));
         }    
             if(display.getText().endsWith(".0"))
             {
                 display.setText(display.getText().replace(".0", ""));
             }
         }
         });
        
     add(equals);
     clear = new JButton("clear");
      clear.setBounds(154,318,137,55);
      clear.addActionListener(new ActionListener () {
         @Override
         public void actionPerformed(ActionEvent e) {
             display.setText("0");
             tempfirst = 0.0;
             for(int j = 0; j < 4; j++)
             {
                 operation[j] = false;
             }
         }
         });
        
      add(clear);     
     
       zero = new JButton("0");
       zero.setBounds(10,256,65,55);
       zero.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 13)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("0");
                return;
                }
           display.append("0");
           }
       });
       add(zero);
       decimal = new JButton(".");
       decimal.setBounds(82,256,65,55);
       decimal.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
              if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase(".")){
                display.setText(".");
                return;
                }
           display.append(".");
           }
       });
       add(decimal);
       poseneg = new JButton("+/-");
       poseneg.setBounds(154,256,65,55);
      add(poseneg);
       poseneg.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
          if(display.getText().equalsIgnoreCase("0"))
          return;
              display.setText(Double.toString(Double.parseDouble(display.getText())*(-1)));
          if(display.getText().endsWith(".0"))
              display.setText(display.getText().replaceAll(".0", ""));
           }
       });
          
     one = new JButton("1");
       one.setBounds(10,194,65,55);
       one.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("1");
                return;
                }
           display.append("1");
           }
       });
       add(one);
     
     two = new JButton("2");
       two.setBounds(82,194,65,55);
       two.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("2");
                return;
                }
           display.append("2");
           }
           
       });
       add(two);
       three = new JButton("3");
       three.setBounds(154,195,65,55);
       three.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
                if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("3");
                return;
                }
           display.append("3");
           }
       });
       add(three);
       four = new JButton("4");
       four.setBounds(10,132,65,55);
       four.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("4");
                return;
                }
           display.append("4");
           }
       });
       add(four);
     five = new JButton("5");
       five.setBounds(82,132,65,55);
       five.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
                if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("5");
                return;
                }
           display.append("5");
           }
       });
       add(five);
       seven = new JButton("7");
       seven.setBounds(10,70,65,55);
       seven.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("7");
                return;
                }
           display.append("7");
           }
       });
       add(seven);
     six = new JButton("6");
       six.setBounds(154,132,65,55);
       six.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
                if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("6");
                return;
                }
           display.append("6");
           }
       });
       add(six);
       eight = new JButton("8");
          eight.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
              if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("8");
                return;
                }
           display.append("8");
           }
       });
       eight.setBounds(82,70,65,55);
       add(eight);
       nine = new JButton("9");
           nine.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
             if(display.getText().length() > 10)
               return;
                if(display.getText().equalsIgnoreCase("0")){
                display.setText("9");
                return;
                }
           display.append("9");
           }
       });
       nine.setBounds(154,70,65,55);
       add(nine);
    }
   
    public static void main(String[] args) {
        Calculator  x = new Calculator();
        try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  
        //JFrame.setDefaultLookAndFeelDecorated(true); malhash lazma f program zy da
        } catch(Exception e){
            System.out.println("could not load bayzz");
        } 
        x.setVisible(true);
        x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       x.setLocationRelativeTo(null);
       x.setSize(308,430);
       x.setResizable(false);
       x.setTitle("Calculator");
    
    }

   
}

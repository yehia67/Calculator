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
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.util.*;

public class Calculator extends JFrame  {

    JPanel zarayr;
    JTextField display;
    JButton operation;
     JMenuBar menuBar;
     JMenu file;
     JMenu edit;
     JMenu help;
     JMenuItem close;
     JMenuItem copy;
     JMenuItem view;
     JMenuItem about;
     
     JButton seven,eight,nine;
      int i = 0; 
    String q ;
    public Calculator() {
        //setLayout(new GridLayout());
         setLayout(null);
  sendDisplay();      
  sendMenuBar();
  sendButton();
    }
    private void sendDisplay(){
        display = new JTextField("0");//maybe bug
       display.setVisible(true);
        display.setBounds(10,10,324,50);
       display.setEditable(false);
       display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
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
   
     seven = new JButton("7");
       seven.setBounds(10,70,65,55);
       seven.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 13)
               {   return;}
            if(i == 0) 
                
            { 
                q = "7";
                display.setText(q);
             //display.append("7");
            i = 1;
            }
              else
            {
                q = q+"7";
                display.setText(q);
            }
           }
       });
       add(seven);
       eight = new JButton("8");
          eight.addActionListener(new ActionListener(){
           
           @Override
           public void actionPerformed(ActionEvent e) {
            
               if(display.getText().length() > 13)
               {   return;}
            if(i == 0) 
            {
                q = "8";
                display.setText(q);
             //display.append("7");
            i = 1;
            }
              else
            {
                q = q+"8";
                display.setText(q);
            }
           }
       });
       eight.setBounds(82,70,65,55);
       add(eight);
       nine = new JButton("9");
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
       x.setSize(350,400);
       x.setResizable(false);
       x.setTitle("Calculator");
    
    }

   
}

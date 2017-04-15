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
    public Calculator() {
        //setLayout(new GridLayout());
  sendDisplay();      
  sendMenuBar();
    }
    private void sendDisplay(){
        display = new JTextField("0");//return b3din
       display.setVisible(true);
        display.setBounds(10,10,340,40);
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
             String display = "";
             StringSelection string = new StringSelection(display); 
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
       x.setLayout(null);
    }

}

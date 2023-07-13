package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JTextField tfusername ,tfpassword;               //As we have to use the username and password given by the user  in different method to hence we have declare it Globally. 
    
    Login()
    {
        //To set The color of the Login Page
     //   getContentPane().setBackground(Color.LIGHT_GRAY);
        setLayout(null);   //To create our own Layout
        
        
        
        // Background Image
        
        ImageIcon bac = new ImageIcon(ClassLoader.getSystemResource("icons/mov1.gif"));
        Image bac1 = bac.getImage().getScaledInstance(1000,500,Image.SCALE_DEFAULT);
        ImageIcon nbac = new ImageIcon(bac1);
        JLabel gifbac = new JLabel(nbac);
        gifbac.setBounds(0,0,1000,500);
        add(gifbac);
        
        
        
         // To put User name on the Login Page
        
        JLabel lblusername = new JLabel("USER NAME : ");    
        lblusername.setBounds(40,130,300,50);
        lblusername.setFont(new Font("serif",Font.BOLD,30));
        gifbac.add(lblusername);
        
          //This is to create a text field to take the user name from the user
        
         tfusername = new JTextField();                         //This is to take user input (i.e Username)
        tfusername.setBounds(250,130,250,50);
        tfusername.setFont(new Font("serif",Font.PLAIN,25));
        gifbac.add(tfusername);
        
        
        //To set Password  n the login Page
        
         JLabel lblpassword = new JLabel("PASSWORD : ");
         lblpassword.setBounds(40,190,200,50);
         lblpassword.setFont(new Font("serif",Font.BOLD,30));
         gifbac.add(lblpassword);
        
          //This is to create a text field to take the user name from the user
          
          tfpassword = new JTextField();                         //This is to take user input (i.e Password)
         tfpassword.setBounds(250,190,250,50);
         tfpassword.setFont(new Font("serif",Font.PLAIN,25));
         gifbac.add(tfpassword);
         
       
         
        //To Create a Login Button and decorate it
        
        JButton login =new JButton("LOGIN");
        login.setBounds(380,380,200,50);
        login.setFont(new Font("serif",Font.BOLD,25));
        login.setBackground(Color.yellow);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);                     //Inorder to  take the input from the username and password text field  we have created an action Listener
        gifbac.add(login);
            
        //Set Image on the Right side Of the Frame
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(320,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logimg = new JLabel(i3);
        logimg.setBounds(490,50,500,300);
        gifbac.add(logimg);
        
        
        // Create the Frame of the Login Page
        
        setSize(1000,500);    
        setLocation(480,250);
        setVisible(true);
    }
    
    
      @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            String username =tfusername.getText();                     //gettext() Function is used to take the value inside the textfield 
            String password = tfpassword.getText();                    // same for password
        
            
             Conn c = new Conn();                                       
                                           //Using these to datas we are going to create a  query
            
            String query = "select * from login where username = '"+username+"'and password = '"+password+"'";     //We have created a Query which will fetch the  username and password from the database. 
             
             ResultSet rs = c.s.executeQuery(query);    //To execute the query  we will use the executeQuery function  // we have to store the returned value  in rs which is the object reference of Result Object.
               
             if(rs.next())                                       // This statement is used to check what is the value inside rs, If there is value it will open next class.
             {
                 setVisible(false);
                 new Home();
             }
             else                                               // If there there is no value present inside  it will open a popup
             {
                 JOptionPane.showMessageDialog(null, "Invalid user name and Password");
                 setVisible(false);
             }
             
        }
        catch(Exception ae)           //As we are using MySql and it is an exteranal entity and there will be chances of error so we have to use try catch block  in order handel the error.
            {
              ae.printStackTrace();          
            }
    }
            
    
    
    public static void main(String[] args)
    {
       new Login();
    }

  
}
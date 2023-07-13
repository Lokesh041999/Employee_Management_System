package employee.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener
{
      JButton View ,Add,Update,Remove;                                 //We have declared the JButton Instance as Global Varivale as it  is being used in more than one function
       
    Home()
    {    
        setLayout(null);     //As we don't want to use swing's Layout
         
        // Inorder to set the Image in the frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
         Image i2 =i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);     //This is to scale the Image
         ImageIcon i3 =new ImageIcon(i2);  
         JLabel image = new JLabel(i3);  
         image.setBounds(0,0,1120,630);  
         add(image);       
        
         JLabel label =new JLabel("Employee Management System");        //This is to set the name on the right side above the tabs. 
         label.setBounds(620,20,400,40);
         label.setForeground(Color.BLACK);
         label.setFont(new Font("serif",Font.BOLD,40));
         image.add(label);
        
         
         
          Add =new JButton("ADD EMPLOYEE");
         Add.setBounds(650, 80, 150, 40);
         Add.setFont(new Font("serif",Font.BOLD,25));
          Add.addActionListener(this);                                        //When button is clicked a new tab will open
         image.add(Add);   
        
         
         
          View = new JButton("VIEW EMPLOYEES");
          View.setBounds(820, 80, 150, 40);
          View.setFont(new Font("serif",Font.BOLD,25));
          View.addActionListener(this);                                      //When button is clicked a new tab will open
          image.add(View);
         
         
         Update = new JButton("UPDATE RECORD");
         Update.setBounds(650, 140, 150, 40);
         Update.setFont(new Font("serif",Font.BOLD,25));
         Update.addActionListener(this);                                  //When button is clicked a new tab will open
         image.add(Update);
           
         Remove =new JButton("REMOVE EMPLOYEE");
         Remove.setBounds(820, 140, 150, 40);
         Remove.setFont(new Font("serif",Font.BOLD,25));
         Remove.addActionListener(this);                              //When button is clicked a new tab will open
         image.add(Remove);
         
         
        //This is to create the frame of the Home Page
        setSize(1120,630);
        setLocation(100,50);
        setBackground(Color.GRAY);
        setVisible(true);
         
    }
    @Override
   public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== View)                      // getSource will check, what is the source of the click event if it is Add it will execute this block
        {
             setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == Add)
        {
            setVisible(false);
           new AddEmployee();
           
        }
        else if(ae.getSource() == Update)
        {
            setVisible(false);
            new ViewEmployee();
        }
        else if(ae.getSource() == Remove)
        {
            setVisible(false);
            new RemoveEmployee();
        }
    }

    public static void main(String[] args)
     {
        new Home();
     }

    
}
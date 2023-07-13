package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.sql.*;  
import java.awt.event.*;// Using this pacakage we can  execute the sql query.  

public class RemoveEmployee extends JFrame  implements ActionListener
{
    Choice cempid;
    JButton delete,back;
    
    RemoveEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/HOMEPAGE.png"));
        Image i2 = i1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel logimg = new JLabel(i3);
        logimg.setBounds(500,80,800,500);
        add(logimg);

        JLabel labelempID =new JLabel("Employee ID");
        labelempID.setBounds(100,80,150,60);
        labelempID.setFont(new Font("serif",Font.PLAIN,25));
        add(labelempID);
        
        cempid = new Choice();
        cempid.setBounds(270,90,200,60);
       cempid.setFont(new Font("serif",Font.PLAIN,25));
        add(cempid);
       
        try
       {
           Conn con = new Conn();                                                                 //Created an Object Reference
           ResultSet rs = con.s.executeQuery("select * from employee");                     // This is to Execute the Query as it is a DDL Command hence ececute and we are storing it in ResultSet rs. 
           while(rs.next())                                                                      //Inorder to add the EmpID to the Choice we  1st have to loop it using while loop and then one by one 
           {                                                                                     //It will add the empid to the choice ,(rs.getString("empID"); will take the emp ID and put it in the choice box.
            cempid.add(rs.getString("empid"));                             
           }
           
       }   
       catch(Exception ee)
       {
           ee.printStackTrace();
       }
        
        
         
        JLabel lblname =new JLabel("Name :");
        lblname.setBounds(100,150,300,60);
        lblname.setFont(new Font("serif",Font.PLAIN,25));
        add(lblname);
        
        JLabel selectname =new JLabel();
        selectname.setBounds(190,150,300,60);
        selectname.setFont(new Font("serif",Font.PLAIN,25));
        add(selectname);
        
        JLabel lblfname =new JLabel("Father's Name :");
        lblfname.setBounds(100,230,300,60);
        lblfname.setFont(new Font("serif",Font.PLAIN,25));
        add(lblfname);
        
        JLabel selectfname =new JLabel();
        selectfname.setBounds(270,230,300,60);
        selectfname.setFont(new Font("serif",Font.PLAIN,25));
        add(selectfname);
        
         JLabel lbldob =new JLabel("DOB :");
         lbldob.setBounds(100,310,300,60);
         lbldob.setFont(new Font("serif",Font.PLAIN,25));
        add(lbldob);
        
        JLabel selectdob =new JLabel();
        selectdob.setBounds(190,310,300,60);
        selectdob.setFont(new Font("serif",Font.PLAIN,25));
        add(selectdob);
        
         JLabel lblsalary =new JLabel("Salary :");
        lblsalary.setBounds(100,390,300,60);
        lblsalary.setFont(new Font("serif",Font.PLAIN,25));
        add(lblsalary);
        
         JLabel selectsalary = new JLabel();
         selectsalary.setBounds(190,390,300,60);
         selectsalary.setFont(new Font("serif",Font.PLAIN,25));
        add(selectsalary);
        
         try
       {
           Conn con = new Conn();                                                                 //Created an Object Reference
           String query ="select * from employee where empid ='"+ cempid.getSelectedItem()+"'";                     // This is to Execute the Query as it is a DDL Command hence ececute and we are storing it in ResultSet rs. 
           ResultSet rs = con.s.executeQuery(query);
           
           while(rs.next())                                                                      //Inorder to add the EmpID to the Choice we  1st have to loop it using while loop and then one by one 
           {                                                                                     //It will add the empid to the choice ,(rs.getString("empID"); will take the emp ID and put it in the choice box.
              selectname.setText(rs.getString("name"));
              selectfname.setText(rs.getString("fathername"));
              selectdob.setText(rs.getString("dob"));
              selectsalary.setText(rs.getString("salary"));
                                       
           }
           
       }   
       catch(Exception pp)
       {
           pp.printStackTrace();
       }
        
         cempid.addItemListener(new ItemListener(){
                 public void itemStateChanged(ItemEvent ie){
                      try
       {
           Conn con = new Conn();                                                                 //Created an Object Reference
           String query ="select * from employee where empID ='"+ cempid.getSelectedItem()+"'";                     // This is to Execute the Query as it is a DDL Command hence ececute and we are storing it in ResultSet rs. 
           ResultSet rs = con.s.executeQuery(query);
           
           while(rs.next())                                                                      //Inorder to add the EmpID to the Choice we  1st have to loop it using while loop and then one by one 
           {                                                                                     //It will add the empid to the choice ,(rs.getString("empID"); will take the emp ID and put it in the choice box.
              selectname.setText(rs.getString("name"));
              selectfname.setText(rs.getString("fathername"));
              selectdob.setText(rs.getString("DOB"));
              selectsalary.setText(rs.getString("salary"));
                                       
           }
           
       }   
       catch(Exception pp)
       {
           pp.printStackTrace();
       }
                     
                 }});
           
         delete =new JButton("DELETE RECORD");
         delete.setBounds(355,650,300,60);
         delete.setForeground(Color.GREEN);
         delete.setFont(new Font("serif",Font.BOLD,25));
         delete.addActionListener(this);
         add(delete);
         
         back = new JButton("BACK");
         back.setBounds(700,650,300,60);
         back.setForeground(Color.RED);
         back.setFont(new Font("serif",Font.BOLD,25));
         back.addActionListener(this);
         add(back);
         
        setSize(1400,800);
        setLocation(250,100);
        setVisible(true);
        
    }
    public static void main(String[] args)
    {
      new RemoveEmployee();    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()== delete)
       {
         try
         {
             Conn con =new Conn();
             String query ="delete from employee where empID ='"+cempid.getSelectedItem()+"'";                     // This is to Execute the Query as it is a DDL Command hence ececute and we are storing it in ResultSet rs. 
             con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Employee Info Deleted Sucessfully");
            setVisible(false);
            new Home();
         }
         catch(Exception xx)
         {
             xx.printStackTrace();
         }
       }
       else
       {
             new Home();
           setVisible(false);
           
       }
       
    }
}

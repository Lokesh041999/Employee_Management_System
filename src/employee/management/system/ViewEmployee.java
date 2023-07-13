package employee.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;                                                // Using this pacaksge we can  execute the sql query.  
import net.proteanit.sql.DbUtils;                                 //This is the package used to insert the data into the table created by JTable
public class ViewEmployee extends JFrame implements ActionListener
{
    
    JTable table;              //This is to create a table on the frame 
    Choice cemployeeid;
    JButton search,print,update,back;
    ViewEmployee()
    {
       getContentPane().setBackground(Color.WHITE);             // getcontentpane selects the table  and after that i have put some background color .
       setLayout(null);                                    // setLayout  is null as we want to use our own layout.
        
       JLabel searchlbl = new JLabel("Search by Employee ID:");      //This is to searc the employee by id.
       searchlbl.setBounds(20,80,250,50);
       searchlbl.setFont(new Font("serif",Font.PLAIN,25));
       add(searchlbl);
       
       
       JLabel emp = new JLabel("LIST OF ALL EMPLOYEES");
       emp.setBounds(400,25,1100,50);
       emp.setFont(new Font("serif",Font.BOLD,40));
       add(emp);
       
       cemployeeid = new  Choice();                                      // We can create a drop down menus by using choice as well as combo box
       cemployeeid.setBounds(300,85,150,50);             // seting the box size.
       cemployeeid.setFont(new Font("serif",Font.PLAIN,25));
       add(cemployeeid);
       
       
       try
       {
           Conn con = new Conn();                                                                 //Created an Object Reference
           ResultSet rs = con.s.executeQuery("select * from employee");                     // This is to Execute the Query as it is a DDL Command hence ececute and we are storing it in ResultSet rs. 
           while(rs.next())                                                                      //Inorder to add the EmpID to the Choice we  1st have to loop it using while loop and then one by one 
           {                                                                                     //It will add the empid to the choice ,(rs.getString("empID"); will take the emp ID and put it in the choice box.
            cemployeeid.add(rs.getString("empID"));                             
           }
           
       }   
       catch(Exception ee)
       {
           ee.printStackTrace();
       }
       
       
       
       
       table = new JTable();
       
       try
       {
           Conn con = new Conn();                                                                 //   Created an Object Reference
           ResultSet rs = con.s.executeQuery("select * from employee");                     // This is to Execute the Query as it is a DDL Command hence ececute and we are storing it in ResultSet rs.
           
           table.setModel(DbUtils.resultSetToTableModel(rs));                            // This statement will add the data into the result set(This statement will automatically insert the data into the result table).      
         
           while(rs.next())                                                                      //Inorder to add the EmpID to the Choice we  1st have to loop it using while loop and then one by one 
           {                                                                                     //It will add the empid to the choice ,(rs.getString("empID"); will take the emp ID and put it in the choice box.
            cemployeeid.add(rs.getString("empID"));                             
           }
           
       }   
       catch(Exception ee)
       {
           ee.printStackTrace();
       }
       
        JScrollPane jsp = new JScrollPane(table);                                             //This statement will create a scroll bar(In java we have to manually create a scrool bar ,it is not like HTML where if the data is out of the page it will automatically create a  scroll bar).
        jsp.setBounds(0,150,1400,800);
        add(jsp);
        
         search = new JButton("Search");
        search.setBounds(470,80,200,50);
        search.setFont(new Font("serif",Font.PLAIN,25));
        search.addActionListener(this);
        add(search);
        
         print = new JButton("Print");
         print.setBounds(700,80,200,50);
         print.setFont(new Font("serif",Font.PLAIN,25));
         print.addActionListener(this);
        add(print);
        
         update = new JButton("Update");
         update.setBounds(925,80,200,50);
         update.setFont(new Font("serif",Font.PLAIN,25));
          update.addActionListener(this);
        add(update);
        
         back = new JButton("Back");
         back.setBounds(1150,80,200,50);
         back.setFont(new Font("serif",Font.PLAIN,25));
          back.addActionListener(this);
        add(back);
        
        setSize(1400,800);
        setLocation(250,100);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== search)
        {
            String query ="select * from employee where empid ='"+cemployeeid.getSelectedItem()+"'";             // As we want to search for a particular employee by its empID  hence we have written a query and  then we are storing it in the query variable.
        try{
            Conn con = new Conn();                                                                 //Created an Object Reference
           ResultSet rs = con.s.executeQuery(query);  
           table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
             e.printStackTrace();
        }
        }
        
        else if(ae.getSource()== print)
        {
            try 
            {
               table.print();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else if(ae.getSource()== update)
        {
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
        }
        else
        {
             setVisible(false);
             new Home();
        }
    }
    
    
    public static void main(String[] args)
    {
      new ViewEmployee();    
    }

    
}
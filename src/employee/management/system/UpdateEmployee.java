package employee.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateEmployee extends JFrame implements ActionListener
{
    
    
    JTextField hieduinput,nameinput,fatnameinput,salinput,addressinput,phoneinput,emailinput,designationinput,aadharinput;
    JLabel empidinput;
    JButton updatedetails,back;
    String emp;
    UpdateEmployee(String emp )
    {
        this.emp =emp;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("UPDATE EMLPLOYEE DETAILS");
        heading.setBounds(400,25,1100,50);
        heading.setFont(new Font("serif",Font.BOLD,40));
        add(heading);
        
            //EMPLOYEE NAME
        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(160,100,300,60);
        labelname.setFont(new Font("serif",Font.PLAIN,25));
        add(labelname);
        
        JLabel nameinput = new JLabel();                                                   //This is to make the name un editable
        nameinput.setBounds(300,105,250,50);
        nameinput.setFont(new Font("serif",Font.PLAIN,25));
        add(nameinput);
        
           // EMPLOYEE FATHER NAME       
        JLabel labelfatname = new JLabel("Father's Name :");
        labelfatname.setBounds(700,100,300,60);
        labelfatname.setFont(new Font("serif",Font.PLAIN,25));
        add(labelfatname);
        
        JLabel fatnameinput = new JLabel();                                                   //This is to make the fathers name un editable
        fatnameinput.setBounds(900,105,250,50);
        fatnameinput.setFont(new Font("serif",Font.PLAIN,25));
        add(fatnameinput);
        
        // EMPLOYEE DATE OF BIRTH 
        JLabel labeldob = new JLabel("DOB :");
        labeldob.setBounds(160,175,300,60);
        labeldob.setFont(new Font("serif",Font.PLAIN,25));
        add(labeldob);
         
        //Calendar Format of Input(JDateChooser)   
         JLabel dcdob =new JLabel();                                                         //This is to make the date of Birth name un editable
        dcdob.setBounds(300,180,250,50);
        dcdob.setFont(new Font("serif",Font.PLAIN,25));
        add(dcdob);
        
         // SALARY 
         JLabel labelsal = new JLabel("Salary :");
        labelsal.setBounds(700,175,300,60);
        labelsal.setFont(new Font("serif",Font.PLAIN,25));
        add(labelsal);
        
        salinput = new JTextField();
        salinput.setBounds(900,180,250,50);
        salinput.setFont(new Font("serif",Font.PLAIN,25));
        add(salinput);
         
         //ADDRESS
         
         JLabel labeladdress = new JLabel("Address :");
        labeladdress.setBounds(160,250,300,60);
        labeladdress.setFont(new Font("serif",Font.PLAIN,25));
        add(labeladdress);
        
         addressinput = new JTextField();
        addressinput.setBounds(300,260,250,50);
        addressinput.setFont(new Font("serif",Font.PLAIN,25));
        add(addressinput);
         
         //PHONE NUMBER
          JLabel labelphone = new JLabel("Phone Number :");
        labelphone.setBounds(700,250,300,60);
        labelphone.setFont(new Font("serif",Font.PLAIN,25));
        add(labelphone);
        
         phoneinput = new JTextField();
        phoneinput.setBounds(900,260,250,50);
        phoneinput.setFont(new Font("serif",Font.PLAIN,25));
        add(phoneinput);
        
         //EMAIL
         
         JLabel labelemail = new JLabel("Email :");
        labelemail.setBounds(160,330,300,60);
        labelemail.setFont(new Font("serif",Font.PLAIN,25));
        add(labelemail);
        
        emailinput = new JTextField();
        emailinput.setBounds(300,335,250,50);
        emailinput.setFont(new Font("serif",Font.PLAIN,25));
        add(emailinput);
         
         //HIGEST EDUCATION
          JLabel labelhiedu = new JLabel("Higest Education :");
        labelhiedu.setBounds(700,330,300,60);
        labelhiedu.setFont(new Font("serif",Font.PLAIN,25));
        add(labelhiedu);
        
        String courses[]={"Qualification","M.Tech","MSC","BA","B.COM","B.Tech","BSC","BBA","BCA","MBA","MCA","MA"};   //This Array is to 
        
         hieduinput = new JTextField();                                  // This Class JComboBox is to  create a drop down menu  and it takes  String of Array as the Argument
        hieduinput.setBounds(900,335,250,50);
        hieduinput.setFont(new Font("serif",Font.PLAIN,25));
        add(hieduinput);
         //DESIGNATION
         
          JLabel labeldesignation = new JLabel("Designation :");
       labeldesignation.setBounds(160,400,300,60);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,25));
        add(labeldesignation);
        
        designationinput = new JTextField();
        designationinput.setBounds(300,405,250,50);
        designationinput.setFont(new Font("serif",Font.PLAIN,25));
        add(designationinput);
         
         //AADHAR NUMBER
          JLabel labelhaadhar = new JLabel("Aadhar Number :");
        labelhaadhar.setBounds(700,400,300,60);
        labelhaadhar.setFont(new Font("serif",Font.PLAIN,25));
        add(labelhaadhar);
        
        JLabel aadharinput = new JLabel();                                  // This Class JComboBox is to  create a drop down menu  and it takes  String of Array as the Argument
       aadharinput.setBounds(900,405,250,50);
       aadharinput.setFont(new Font("serif",Font.PLAIN,25));
        aadharinput.setBackground(Color.WHITE);
        add(aadharinput);
         //EMPLOYEE ID
         
         JLabel labelempid = new JLabel("Employee ID :");
       labelempid.setBounds(160,465,300,60);
        labelempid.setFont(new Font("serif",Font.PLAIN,25));
        add(labelempid);
        
         empidinput = new  JLabel();
         empidinput.setFont(new Font("serif",Font.PLAIN,25));
        empidinput.setBounds(320,470,250,50);
        add(empidinput);
        
        
        try
        {
          Conn c =new Conn();
          String query = "select * from employee where empid ='"+emp+"'";
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next())
          {
             nameinput.setText(rs.getString("name")); 
             fatnameinput.setText(rs.getString("fathername")); 
             dcdob.setText(rs.getString("dob")); 
             salinput.setText(rs.getString("salary")); 
             addressinput.setText(rs.getString("address")); 
             phoneinput.setText(rs.getString("phonenum")); 
             emailinput.setText(rs.getString("email")); 
             hieduinput.setText(rs.getString("higestedu")); 
             designationinput.setText(rs.getString("designation")); 
             aadharinput.setText(rs.getString("aadharno")); 
               empidinput.setText(rs.getString("empid"));     
          }
        }
        catch(Exception aa)
        {
          aa.printStackTrace();
        }
        
        // ADD Details and Back Button
        
        updatedetails = new JButton("UPDATE DETAILS");
        updatedetails.setBounds(355,650,300,60);
         updatedetails.setForeground(Color.GREEN);
         updatedetails.setFont(new Font("serif",Font.BOLD,25));
         updatedetails.addActionListener(this);
        add(updatedetails);
        
        
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
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource() == updatedetails)
        {   
            String salary = salinput.getText();
            String address = addressinput.getText();
            String phonenum = phoneinput.getText();
            String email = emailinput.getText();
            String higestedu = (String) hieduinput.getText();                        // As  the combo box stores the file in form of object hence we have to typecast it ,and then we have choose the selected item hence we used getSelectedItem.
            String designation = designationinput.getText();
            String empid = empidinput.getText();    
            
            
         try 
         {
             Conn conn = new Conn();
             String query = "update  employee set salary = '"+salary+"',address = '"+address+"', phonenum = '"+phonenum+"',email = '"+email+"', higestedu = '"+higestedu+"',designation = '"+designation+"'  where empid = '"+empid+"'" ;
             conn.s.executeUpdate(query);                                                           // In the Login Page line 84 as that was to execute the query(that is a DDL Command), but here we are updating the table which is a DML Command language hence(we use executeUpdate(query));       
             JOptionPane.showMessageDialog(null,"Details Updated successfully");        //This will show a message the details added sucessfully.
             setVisible(false);
             new Home();
         }
         catch(Exception e)                                                                   //As database is an External entity so there are some chances of error  hence we are using try catch
         {
            e.printStackTrace();
         }
            
        }
        else
        {
            setVisible(false);
            new Home();
        }
       
    }
    public static void main(String[] args) 
    {
        new UpdateEmployee("");
    }

    
}

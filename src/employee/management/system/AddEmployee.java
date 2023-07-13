package employee.management.system;

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;
public class AddEmployee extends JFrame implements ActionListener
{
    
    Random ran =new Random();
    int number =ran.nextInt(999999);
    JTextField nameinput,fatnameinput,salinput,addressinput,phoneinput,emailinput,designationinput,aadharinput;
    JComboBox hieduinput;
    JLabel empidinput;
    JDateChooser dcdob;
    JButton adddetails,back;
    AddEmployee()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("ADD EMLPLOYEE DETAILS");
        heading.setBounds(400,25,1100,50);
        heading.setFont(new Font("serif",Font.BOLD,40));
        add(heading);
        
            //EMPLOYEE NAME
        JLabel labelname = new JLabel("Name :");
        labelname.setBounds(160,100,300,60);
        labelname.setFont(new Font("serif",Font.PLAIN,25));
        add(labelname);
        
         nameinput = new JTextField();
        nameinput.setBounds(300,105,250,50);
        nameinput.setFont(new Font("serif",Font.PLAIN,25));
        add(nameinput);
        
           // EMPLOYEE FATHER NAME       
        JLabel labelfatname = new JLabel("Father's Name :");
        labelfatname.setBounds(700,100,300,60);
        labelfatname.setFont(new Font("serif",Font.PLAIN,25));
        add(labelfatname);
        
        fatnameinput = new JTextField();
        fatnameinput.setBounds(900,105,250,50);
        fatnameinput.setFont(new Font("serif",Font.PLAIN,25));
        add(fatnameinput);
        
        // EMPLOYEE DATE OF BIRTH 
        JLabel labeldob = new JLabel("DOB :");
        labeldob.setBounds(160,175,300,60);
        labeldob.setFont(new Font("serif",Font.PLAIN,25));
        add(labeldob);
         
        //Calendar Format of Input(JDateChooser)   
         dcdob =new JDateChooser();                               // JDateChooser class object is being made here as the input we want to take will be in date format and it will open up a calendar format.
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
        
         hieduinput = new JComboBox(courses);                                  // This Class JComboBox is to  create a drop down menu  and it takes  String of Array as the Argument
        hieduinput.setBounds(900,335,250,50);
        hieduinput.setBackground(Color.WHITE);
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
        
        aadharinput = new JTextField();                                  // This Class JComboBox is to  create a drop down menu  and it takes  String of Array as the Argument
       aadharinput.setBounds(900,405,250,50);
        aadharinput.setBackground(Color.WHITE);
        aadharinput.setFont(new Font("serif",Font.PLAIN,25));
        add(aadharinput);
         //EMPLOYEE ID
         
         JLabel labelempid = new JLabel("Employee ID :");
       labelempid.setBounds(160,465,300,60);
        labelempid.setFont(new Font("serif",Font.PLAIN,25));
        add(labelempid);
        
         empidinput = new  JLabel(""+number);
         empidinput.setFont(new Font("serif",Font.PLAIN,25));
         empidinput.setFont(new Font("serif",Font.PLAIN,25));
        empidinput.setBounds(320,470,250,50);
        add(empidinput);
        
        
        // ADD Details and Back Button
        
        adddetails = new JButton("ADD DETAILS");
        adddetails.setBounds(355,650,300,60);
         adddetails.setForeground(Color.GREEN);
         adddetails.setFont(new Font("serif",Font.BOLD,25));
         adddetails.addActionListener(this);
        add(adddetails);
        
        
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
        if(ae.getSource() == adddetails)
        {
            String name = nameinput.getText();
            String fathername = fatnameinput.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();    //As we are taking input from the calendar hence  we 1st used dateeditor then get UI component after that get Text.(Then we have to Type cast it to Text Editor) 
            String salary = salinput.getText();
            String address = addressinput.getText();
            String phonenum = phoneinput.getText();
            String email = emailinput.getText();
            String higestedu = (String) hieduinput.getSelectedItem();                        // As  the combo box stores the file in form of object hence we have to typecast it ,and then we have choose the selected item hence we used getSelectedItem.
            String designation = designationinput.getText();
            String aadharno = aadharinput.getText();
            String empid = empidinput.getText();    
            
            
         try 
         {
             Conn conn = new Conn();
             String query = "insert into employee values('"+name+"','"+fathername+"','"+dob+"','"+salary+"','"+address+"','"+phonenum+"','"+email+"','"+higestedu+"','"+designation+"','"+aadharno+"','"+empid+"') " ;
             conn.s.executeUpdate(query);                                                           // In the Login Page line 84 as that was to execute the query(that is a DDL Command), but here we are updating the table which is a DML Command language hence(we use executeUpdate(query));       
             JOptionPane.showMessageDialog(null,"Details added successfully");        //This will show a message the details added sucessfully.
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
        new AddEmployee();
    }

    

}

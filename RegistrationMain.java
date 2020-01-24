package casestudies;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class RegistrationMain {

String name;
String address;
String contactNumber;
String email;
String prooftype;
String proofid;



public static void main(String[] args) throws ClassNotFoundException,SQLException {
// TODO Auto-generated method stub

Class.forName("com.mysql.jdbc.Driver");//Register Driver class
Connection con=null;
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","");//get the connection
String op1,op2;
Scanner obj=new Scanner(System.in);
do {
System.out.print("1.Registration\n2.View\n3.Exit\n");
int r=obj.nextInt();
switch(r)
{
case 1:

System.out.println("Registration");
System.out.println("Enter your name");
String name;
name=obj.next();
System.out.println("Enter your address");
String address;
address=obj.next();
System.out.println("Contact Number ");
String contactNumber;
contactNumber=obj.next();
System.out.println("E-Mail ID");
String email;
email=obj.next();
System.out.println("Enter proof type");
String prooftype;
prooftype=obj.next();
System.out.println("Enter proof id");
String proofid;
proofid=obj.next();
//casestudy1registration obj1=new casestudy1registration(name,address,contactNumber,email,prooftype,proofid);
       //obj1.Register(name,address,contactNumber,email,prooftype,proofid);
    //obj.close();
Statement st= con.createStatement();//create statement
String s= "INSERT INTO email VALUES('"+name+"','"+address+"','"+contactNumber+"','"+email+"','"+prooftype+"','"+proofid+"')";//execute the query
st.execute(s);
break;
case 2:
Statement st1= con.createStatement();//create statement
String s1= "SELECT * FROM email";
ResultSet rs=st1.executeQuery(s1);
System.out.println("name\taddress\tcontactNumber\temail\tprooftype\tproofid");
while(rs.next())
{
name =rs.getString("Name");
address=rs.getString("Address");
contactNumber=rs.getString("Phone_no");
email =rs.getString("Email");
prooftype =rs.getString("Proof_Type");
proofid =rs.getString("Proof_Id");


System.out.println(name+"\t"+address+"\t"+contactNumber+"\t"+email+"\t"+prooftype+"\t"+proofid);
}
//st1.execute(s1);

break;
case 3:
System.exit(0);
}
System.out.println("Do you want to countinue (yes/no)");
op2=obj.next();
}

while(op2.equals("yes"));



}



}

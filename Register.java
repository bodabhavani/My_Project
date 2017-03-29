import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*; 


public class Register extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String fname=request.getParameter("fname");  
String lname=request.getParameter("lname");  
String rollno=request.getParameter("rollno");  
String email=request.getParameter("email"); 
String address=request.getParameter("address");  
String psw=request.getParameter("psw");  
String phoneno=request.getParameter("phoneno");  
String year=request.getParameter("year"); 
          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booktrade","root","bhavani412");  
  
PreparedStatement ps=con.prepareStatement(  
"insert into signup values(?,?,?,?,?,?,?,?)");  
  
ps.setString(1,fname);  
ps.setString(2,lname);  
ps.setString(3,rollno);  
ps.setString(4,email);  
ps.setString(5,address); 
ps.setString(6,psw); 
ps.setString(7,phoneno); 
ps.setString(8,year); 
          
int i=ps.executeUpdate();  
if(i>0)  {
out.print("You are successfully registered...");  
RequestDispatcher rd=request.getRequestDispatcher("login.html");  
rd.include(request,response);  
}
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  
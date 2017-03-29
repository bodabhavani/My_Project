import java.io.*;  
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.http.*; 


public class Login extends HttpServlet {  
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
          
String email=request.getParameter("email");  
String password=request.getParameter("psw");  

          
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/booktrade","root","bhavani412");  
  
PreparedStatement ps=con.prepareStatement(  
"select * from signup where email=? and password=?");  
  
ps.setString(1,email);  
ps.setString(2,password);  
 
ResultSet rs=ps.executeQuery();  
 
if(rs.next())  {
	 String firstName = rs.getString("firstname");
     String lastName = rs.getString("lastname");
out.print("Welcome "+ firstName +" "+ lastName); 
RequestDispatcher rd=request.getRequestDispatcher("options.jsp");  
rd.include(request,response);   
}
else{
	 
     RequestDispatcher rd=request.getRequestDispatcher("login.html");  
     rd.include(request,response);  
     out.print("Sorry username or password error");  
}
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  
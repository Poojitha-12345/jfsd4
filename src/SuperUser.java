package skill4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class SuperUser
 */
@WebServlet("/SuperUser")
public class SuperUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SuperUser() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("username");    
	    String pwd = request.getParameter("password");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4","root","root");
		System.out.println("Connected to database");
		 Statement st = con.createStatement();
		 
		 String sql = "select * from superAdmin where username = ? and password = ?";
		 PreparedStatement pst = con.prepareStatement(sql);
		   
		    pst.setString(1, userid);
		    pst.setString(2, pwd);
		    ResultSet resultSet = pst.executeQuery();
		    PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		    if(resultSet.next()) {
				out.println("<h2>Login Successfull</h2>");
				out.println("<h2>Click <a href='superAdminDas.html'>here</a></h2>");
		    }else {
		    	out.println("<h2>Login Failed</h2>");
		    	out.println("<h2>Click <a href='superAdmin.html'>here</a></h2>");
		    }
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}

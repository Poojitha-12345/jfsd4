package skill4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CustomerLogin
 */
@WebServlet("/CustomerLogin")
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("username");    
	    String pwd = request.getParameter("password");
		try {//190030061
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4",
				"root","root");
		System.out.println("Connected to database");
		 Statement st = con.createStatement();
		 String sql = "select * from customers where email = ? and password = ?";
		 PreparedStatement pst = con.prepareStatement(sql);
		   
		    pst.setString(1, userid);
		    pst.setString(2, pwd);
		    ResultSet resultSet = pst.executeQuery();
		    PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		    if(resultSet.next()) {
		    	out.println("<h2>Login Success</h2>");
		    	out.println("<h2>Click <a href='getMovieList'>here</a></h2>"); 

		    }else {
		    	out.println("<h2>Login Failed</h2>");
		    	out.println("<h2>Click <a href='customerLogin.html'>here</a></h2>");
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

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
 * Servlet implementation class BookTickets
 */
@WebServlet("/BookTickets")
public class BookTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTickets() {
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
		String email = request.getParameter("email");    
	    String theName = request.getParameter("thename");
	    String numberOfTickets = request.getParameter("not");
	    String bookedDate = request.getParameter("dob");
	    String movieName = request.getParameter("movieName");
		try {//190030061
			Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4",
				"root","root");
		System.out.println("Connected to database");
		 Statement st = con.createStatement();
		 //190030061
		 String sql = "insert into tickets values(NULL,?,?,?,?,?,?)";
		 PreparedStatement pst = con.prepareStatement(sql);
		   int totalAmount = Integer.parseInt(numberOfTickets)*200;
		    pst.setString(1, email);
		    pst.setString(2, theName);
		    pst.setString(3, numberOfTickets);
		    pst.setInt(4, totalAmount);
		    pst.setString(5, bookedDate);
		    pst.setString(6, movieName);
		    int r = pst.executeUpdate();
		    PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		    if(r!=0) {
		    	out.println("<h2>Tickets Booking Success</h2>");
		    	out.println("<h2>Click <a href='ViewBookedTickets'>here</a></h2>");  
		    }else {
		    	out.println("<h2>Tickets Booking Failed</h2>");
		    	out.println("<h2>Click <a href='bookTickets.html'>here</a></h2>");
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

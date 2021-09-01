package skill4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getMovieList
 */
@WebServlet("/getMovieList")
public class getMovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getMovieList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();  
         response.setContentType("text/html");  
         out.println("<html><body>");  
         try 
         {  
             Class.forName("com.mysql.jdbc.Driver");  
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4", "root", "root");  
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from movies");  
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Movie Name</th><th>Date Of Release</th><th>Price Of Ticket</th><th>Book Tickets</th><tr>");  
             while (rs.next()) 
             {  
                 String n = rs.getString("movieName");  
                 String nm = rs.getString("dateOfRelease");  
                 String s = "100";   
                 String link = "<a href='bookTickets.html'>Book Now</a>";
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td><td>" + link +"</td></tr>");   
             }  
             out.println("</table>");  
             out.println("</html></body>");   
            }  
         catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		    }catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
     }  

}

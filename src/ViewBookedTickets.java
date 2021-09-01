package skill4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBookedTickets
 */
@WebServlet("/ViewBookedTickets")
public class ViewBookedTickets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookedTickets() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();  
        response.setContentType("text/html");  
        out.println("<html><body>");  
        try 
        {  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/s4", "root", "root");  
            Statement stmt = con.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from tickets");  
            out.println("<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Booked By</th><th>Theatre Name</th><th>Number Of Tickets</th><th>Total Amount</th><th>Booked Date</th><th>Movie Name</th><tr>");  
            while (rs.next()) 
            {  
                String bookedby = rs.getString("bookedBy");  
                String thname = rs.getString("theatreName");  
                int nof = rs.getInt("numberOfTickets"); 
                int ta = rs.getInt("totalAmount"); 
                String bookeddate = rs.getString("bookedDate"); 
                String mname = rs.getString("movieName"); 
               
                out.println("<tr><td>" + bookedby + "</td><td>" + thname + "</td><td>" + nof + "</td><td>"+ ta +"</td><td>"+ bookeddate +"</td><td>"+ mname +"</td></tr>");   
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



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import oracle.jdbc.driver.OracleDriver;







import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPrintCustomer
 */
@WebServlet("/ServletPrintCustomer")
public class ServletPrintCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static{
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrintCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	      PrintWriter out = response.getWriter();
	      //out.println("<h1>" + message+"<h2>"); 
	      out.println("<!DOCTYPE html>");
	      out.println("<html lang=\"en\">");
	      out.println("<head>");
	      out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css\" integrity=\"sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==\" crossorigin=\"anonymous\">");
	      out.println("<meta charset=\"utf-8\">");
	      out.println(" <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
	      out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
	      out.println("<title>Bootstrap 101 Template</title>"); 
	      out.println("</head>");
	      out.println("<body>");
	      //out.println("<h1>Hello, world!</h1>");
	    
	
		String url = "jdbc:oracle:thin:system/password@localhost"; 
		response.setContentType("text/html"); 
        //properties for creating connection to Oracle database
        Properties props = new Properties();
        props.setProperty("user", "Testuserdb");
        props.setProperty("password", "password");
      
        //creating connection to Oracle database using JDBC
      
			Connection conn;
			try {
				conn = DriverManager.getConnection(url,props);
				String Fname=request.getParameter("fname");
				String Lname=request.getParameter("lname");

        //String sql ="select CUST_FIRST_NAME from demo_customers where CUSTOMER_ID=?";
				
				String sql ="select CUST_FIRST_NAME,CUST_LAST_NAME,CUST_CITY,CUST_STATE,CUST_POSTAL_CODE from demo_customers where CUST_FIRST_NAME=? and CUST_LAST_NAME=?";	
        PreparedStatement preStatement = conn.prepareStatement(sql);
        preStatement.setString(1,Fname);
        preStatement.setString(2, Lname);
        ResultSet result = preStatement.executeQuery();
        out.println("<Table class=\"table table-condensed\">");
       
        
        while(result.next()){
        	 out.println("<tr>");
        	 out.println("<td>");
            out.println("First Name :"+result.getString("CUST_FIRST_NAME")+"</br>");

            out.println("Last Name :"+result.getString("CUST_LAST_NAME")+"</br>");

            out.println("Customer City :"+result.getString("CUST_CITY")+"</br>");
            
            out.println("Customer State :"+result.getString("CUST_STATE")+"</br>");
            
            out.println("Zipcode :"+result.getString("CUST_POSTAL_CODE")+"</br>");
            out.println("</td>");
            out.println("</tr>");
        }
        
        out.println("</table>");
        
        out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js\"></script>");
	      out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js\" integrity=\"sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==\" crossorigin=\"anonymous");
        
        out.println("</body>");
	      out.println("</html>");
	      
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

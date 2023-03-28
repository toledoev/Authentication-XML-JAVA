
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetDataServlet
 */
public class GetAllCustServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/myDB?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "lake blue";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//Setup Database connection with customer table and execute SQL query
		try {
			Class.forName(DB_DRIVER);

			Connection con = null;
			PreparedStatement stmt = null;

			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			stmt = con.prepareStatement("SELECT customerNumber, customerName, phone FROM customers");
			ResultSet rs = stmt.executeQuery();

			List<Customer> customerList = new ArrayList<>();

				/*
				 * If query results has no rows, redirect user to the index.jsp page with error message
				 */
			if (!rs.next()) {
				request.setAttribute("errorMessage", "No results");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
				System.out.println("GetAllCustServlet query failed");
				
				//Create CustomerBean to Store Results
			} else {
					while(rs.next()) {
					
					Customer customer = new Customer();
					customer.setCustomerNumber(rs.getInt("customerNumber"));
					customer.setCustomerName(rs.getString("customerName"));
					customer.setPhone(rs.getString("phone"));
					customerList.add(customer);
					}
			}

			stmt.close();
			rs.close();
			con.close();

			// store the employee data as attributes on a session
			HttpSession session = request.getSession();
			session.setAttribute("customerList", customerList);

			// Use RequestDispatcher to forward the request to the 'allCustomers.jsp’ page
			request.getRequestDispatcher("allCustomers.jsp").forward(request, response);


		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}

}

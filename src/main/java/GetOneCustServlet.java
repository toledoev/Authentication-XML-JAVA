
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
public class GetOneCustServlet extends HttpServlet {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// String[] custId = request.getPathInfo().split("=",2);
		String queryString = request.getQueryString();
		String custId = queryString.substring(queryString.indexOf("=") + 1);
		System.out.println("Selected customer Number: " +custId);

		// Setup Database connection with customer table and execute SQL query
		try {
			Class.forName(DB_DRIVER);

			Connection con = null;
			PreparedStatement stmt = null;

			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			stmt = con.prepareStatement(
					"SELECT customerNumber, customerName, phone, addressLine1, addressLine2, city, state, postalCode, country, salesRepEmployeeNumber, creditLimit FROM customers WHERE customerNumber = ?");
			stmt.setString(1, custId);
			ResultSet rs = stmt.executeQuery();

			/*
			 * If query results has no rows, redirect user to the index.jsp page with error
			 * message
			 */
			if (!rs.next()) {
				request.setAttribute("errorMessage", "No results");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
				System.out.println("GetOneCustServlet query failed");

			} else {

				// Create CustomerBean to Store Results
				Customer customer = new Customer();
				customer.setCustomerNumber(rs.getInt("customerNumber"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setPhone(rs.getString("phone"));
				customer.setAddressLine1(rs.getString("addressLine1"));
				customer.setAddressLine2(rs.getString("addressLine2"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setPostalCode(rs.getString("postalCode"));
				customer.setCountry(rs.getString("country"));
				customer.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
				customer.setCreditLimit(rs.getDouble("creditLimit"));

				// store the employee data as attributes on a session
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);

			}

			stmt.close();
			rs.close();
			con.close();

			// Use RequestDispatcher to forward the request to the 'customerDetail.jsp’ page
			request.getRequestDispatcher("customerDetail.jsp").forward(request, response);

		}

		catch (Exception e) {

			e.printStackTrace();

		}
	}

}

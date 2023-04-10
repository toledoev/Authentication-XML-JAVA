
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAuthentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/myDB?useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/* Get attributes from session */
		String email = (String) request.getSession().getAttribute("email");
		String phone = (String) request.getSession().getAttribute("phone");
//		System.out.println(email + " " + phone);

		/* Setup a database connection and execute SQL query */
		try {
			Class.forName(DB_DRIVER);

			Connection con = null;
			PreparedStatement stmt = null;
			con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

			// Using the prepared statement to protect from SQL Injection
			stmt = con.prepareStatement("SELECT empId FROM emp WHERE email = ? and phone= ?");
			stmt.setString(1, email);
			stmt.setString(2, phone);

			ResultSet rs = stmt.executeQuery();

			/*
			 * If query has NO results, redirect user to the index.jsp page with error
			 * message
			 */
			
			if (!rs.next()) {
				request.setAttribute("errorMessage", "Authentication Failed!");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.include(request, response);
				System.out.println("user didnt authenticated");

			} else {

				/* If user is authenticated,forward the request to GetAllCustServlet */
				request.getRequestDispatcher("/GetAllCustServlet").forward(request, response);
				System.out.println("User was authenticated successfully!");

			}

			rs.close();
			stmt.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}



import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024
		* 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class XMLParsing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// get uploaded file
			Part filePart = request.getPart("file");
			InputStream fileContent = filePart.getInputStream();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// parse XML
			Document doc = builder.parse(fileContent);
			doc.getDocumentElement().normalize();

			// get a list of employee nodes
			NodeList employeeList = doc.getElementsByTagName("employee");
			for (int i = 0; i < employeeList.getLength(); i++) {
				Node employeeNode = employeeList.item(i);
				if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
					Element employeeElement = (Element) employeeNode;
					String email = employeeElement.getElementsByTagName("email").item(0).getTextContent();
					String phone = employeeElement.getElementsByTagName("phone").item(0).getTextContent();

					System.out.println("XML Parsed: " + email + " " + phone);

					// store attributes on a session
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					session.setAttribute("phone", phone);

					// Validate phone and email formats
					if (!phone.matches("\\d+")) {
						out.println("Invalid phone format ");
					}

					if (!email.matches("\\S+@\\S+\\.\\S+")) {
						out.println("Invalid email format ");
					}
				}
			}

			// send session data to AuthenticationServlet
			request.getRequestDispatcher("/UserAuthentication").forward(request, response);

		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}
	}
}
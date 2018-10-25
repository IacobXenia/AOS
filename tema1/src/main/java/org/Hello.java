package org;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Permission;
import javax.servlet.ServletException;

public class Hello extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().print("<h1>Hello Servlet </h1>");
		response.getWriter().print("session=" + request.getSession(true).getId());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonDAO personDAO=new PersonDAOImpl();
		String name=request.getParameter("name");
		String email= request.getParameter("email");
		String submitType=request.getParameter("submit");
		Person person=new Person();
		if(submitType.equals("Submit"))
		{
			person.setName(request.getParameter("name"));
			person.setEmail(email);
			System.out.println("Registration DONE!");
			personDAO.insertPerson(person);
			response.getWriter().print("<h1>Registration done! </h1>");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			System.out.println("Data Not Found!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}


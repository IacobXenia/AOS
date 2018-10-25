package org;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Registration() {
     
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
			personDAO.insertPerson(person);
			request.setAttribute("succesMessage", "Registered done!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			request.setAttribute("message", "Data Not Found");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}

package com.nagarro.training.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import com.nagarro.training.Utility.ValidUser;

@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Myservlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("UserName");
		String pass=req.getParameter("Password");
		HttpSession session=req.getSession();
		
		Session s=ValidUser.fetch(name,pass);
		if(s!=null) {
		
			session.setAttribute("uname", name);
			session.setAttribute("args",s);
			resp.sendRedirect("Home.jsp");
		}

		else {
			resp.getWriter().print("<html><body><h2><font color='red'>Invalid User*** </font></h2></body></html>");
		    req.getRequestDispatcher("index.jsp").include(req,resp);
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

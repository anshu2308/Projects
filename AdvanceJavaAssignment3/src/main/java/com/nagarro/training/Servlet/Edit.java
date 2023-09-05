package com.nagarro.training.Servlet;

import java.io.IOException;


import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.training.Entity.Products;
import com.nagarro.training.Utility.HibernateUtility;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/Edit")
public class Edit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		 Session sess=HibernateUtility.getSessionFactory().openSession();	
	
		int num=Integer.parseInt(request.getParameter("Id"));
		 System.out.println(num);
		Query q=sess.createQuery("from Products  where Sno=:id");
		q.setParameter("id", num);
		Products p = (Products) q.getSingleResult();
		session.setAttribute("id",p.getSno());
		session.setAttribute("title",p.getTitle());
		session.setAttribute("quantity", p.getQuantity());
		session.setAttribute("size", p.getSize());


		response.sendRedirect("edit.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

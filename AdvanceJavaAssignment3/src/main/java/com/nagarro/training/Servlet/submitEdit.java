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

import com.nagarro.training.Utility.HibernateUtility;

/**
 * Servlet implementation class submitEdit
 */
@WebServlet("/submitEdit")
public class submitEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public submitEdit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Session s = HibernateUtility.getSessionFactory().openSession();
		
		int id = (int) session.getAttribute("id");
		String title = request.getParameter("Title");
		int quantity = Integer.parseInt(request.getParameter("Quantity"));
		int size = Integer.parseInt(request.getParameter("Size"));
		
		Transaction tx = s.beginTransaction();
		Query query = s.createQuery("update Products set Title=:title,Quantity=:quantity,Size=:size where Sno=:id");
		query.setParameter("id", id);
		query.setParameter("title", title);
		query.setParameter("quantity", quantity);
		query.setParameter("size", size);
		query.executeUpdate();
		tx.commit();
		response.sendRedirect("Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

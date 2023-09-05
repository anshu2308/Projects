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
 * Servlet implementation class DeleteEntry
 */
@WebServlet("/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int num=Integer.parseInt(request.getParameter("Id"));
		Session sess=HibernateUtility.getSessionFactory().openSession();
		
		String str="Delete from Products where Sno="+num;
		Transaction tx=sess.beginTransaction();
		Query q=sess.createQuery(str);
		q.executeUpdate();
		tx.commit();
		System.out.println("deleted");
		response.sendRedirect("Home.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

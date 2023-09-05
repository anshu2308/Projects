package com.nagarro.training.Servlet;

import java.io.File;

import java.io.FileInputStream;
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
import com.nagarro.training.Entity.User;
import com.nagarro.training.Utility.HibernateUtility;

/**
 * Servlet implementation class AddDetails
 */
@WebServlet("/AddDetails")
public class AddDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDetails() {
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

		String title = request.getParameter("Title");
		int quantity = Integer.parseInt(request.getParameter("Quantity"));
		int size = Integer.parseInt(request.getParameter("Size"));
		String image = request.getParameter("Image");
		Query query = s.createQuery("from User where name=:uname");
		query.setParameter("uname", session.getAttribute("uname"));

		User u = (User) query.getSingleResult();
		Transaction tx = s.beginTransaction();
		Products product = new Products();
		product.setTitle(title);
		product.setQuantity(quantity);
		product.setSize(size);
		product.setUser_id(u);

		File file = new File(image);
		byte[] bFile = new byte[(int) file.length()];

		try (FileInputStream fileInputStream = new FileInputStream(file)) {

			// convert file into array of bytes
			fileInputStream.read(bFile);
			fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		product.setImage(bFile);
		s.save(product);
		tx.commit();
		response.sendRedirect("Home.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

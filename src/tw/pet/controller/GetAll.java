package tw.pet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.pet.dao_impl.PostDao_impl;
import tw.pet.model.Post;
import tw.pet.util.HibernateUtil;

@WebServlet("/funding/GetAll.do")
public class GetAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req, resp);
	}

	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		PostDao_impl pml = new PostDao_impl(session);
		
		List<Post> map = pml.getAll();
		System.out.println(map);
		req.setAttribute("posts", map);
		
		RequestDispatcher rd = req.getRequestDispatcher("/funding/GetAll.jsp");
		rd.forward(req, resp);
		return;
	

	}

}

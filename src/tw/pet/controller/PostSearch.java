package tw.pet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import tw.pet.dao_impl.PostDao_impl;
import tw.pet.model.Post;
import tw.pet.model.Topic;
import tw.pet.util.HibernateUtil;

@WebServlet("/funding/PostSearch.do")
public class PostSearch extends HttpServlet {
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
		
		String idstr = req.getParameter("postno");
		System.out.println(req.getParameter("postno"));
		int postno = 0;

		try {
			postno = Integer.parseInt(idstr.trim());
		} catch (NumberFormatException e) {
			throw new ServletException(e);
		}
		
		PostDao_impl pml = new PostDao_impl(session);
		
		Post pagecontent = pml.getPost(postno);
		System.out.println(pagecontent);
		req.setAttribute("PBean", pagecontent);


		RequestDispatcher rd = req.getRequestDispatcher("/funding/SearchPostSuccess.jsp");
		rd.forward(req, resp);
		return;
		

	}
}

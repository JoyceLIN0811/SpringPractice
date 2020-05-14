package tw.pet.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import tw.pet.dao_impl.PostDao_impl;
import tw.pet.model.PetMembers;
import tw.pet.model.Post;
import tw.pet.util.HibernateUtil;



@WebServlet("/funding/postInsert.do")
public class postInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req, resp);
	}

	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		

		String postname = req.getParameter("postname");
		String name = req.getParameter("name");
		String content = req.getParameter("content");
		String expdate = req.getParameter("expdate");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		System.out.println(postname);
		System.out.println(amount);
	
		PostDao_impl pml = new PostDao_impl(session);
		Post pb = new Post();
		
		pb.setPostname(postname);
		pb.setName(name);
		pb.setContent(content);
		pb.setExpdate(expdate);
		pb.setAmount(amount);
		pml.insert(pb);

		if (pb != null) {
			HttpSession rsession = req.getSession();
			rsession.setAttribute("post",pb);
			req.getRequestDispatcher("/funding/PostSuccess.jsp").forward(req, resp);

		}

	}

}

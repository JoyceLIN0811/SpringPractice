package tw.pet.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.pet.model.TopiclistView;
import tw.pet.util.HibernateUtil;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {

	private SessionFactory factory;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			factory = HibernateUtil.getSessionFactory();

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			System.out.println("Done");
		}
		
	}
	public List<TopiclistView> getAlltopic() {
		Query<TopiclistView> query = factory.getCurrentSession().createQuery("FROM TopiclistViewBean", TopiclistView.class);
		List<TopiclistView> list = query.list();
		System.out.println(list);
		return list;
	}
}

package tw.pet.dao_impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import org.hibernate.Session;
import org.hibernate.query.Query;

import tw.pet.dao.PostDao;
import tw.pet.model.Post;
import tw.pet.model.Topic;
import tw.pet.model.TopiclistView;



public class PostDao_impl implements PostDao{

	private Session session;

	public PostDao_impl(Session session) {
		this.session = session;
	}

	public PostDao_impl() {
	}

	public Session getSession() {
		return session;
	}

	@Override
	public Post insert(Post pb) {
		getSession().save(pb);
		return pb;
	}

	@Override
	public List<Post> getAll() {
		Query<Post> query = getSession().createQuery("FROM Post",
				Post.class);
		List<Post> list = query.list();
		return list;
	}

	@Override
	public Post getPost(int postno) {
		Post post = getSession().get(Post.class, postno);
		return post;
	}
	
	
	
}




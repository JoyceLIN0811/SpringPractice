package tw.pet.dao_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.pet.dao.ReplyDao;
import tw.pet.model.Reply;
import tw.pet.model.ReplylistView;
@Repository
public class ReplyDao_impl implements ReplyDao {
	
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;
	

	public ReplyDao_impl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Reply saveReply(Reply rb) {
		getSession().save(rb);
		return rb;
	}

	@Override
	public boolean deleteReply(int replyId) {
		Reply bean = getSession().get(Reply.class, replyId);
		if(bean != null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public Reply updateReply(Reply rb) {
		Reply bean = getSession().get(Reply.class, rb.getReplyId());
		if(bean != null) {
			bean.setReplyId(rb.getReplyId());
			bean.setReplyContent(rb.getReplyContent());
			getSession().update(bean);
		}
		
		return bean;
	}

	@Override
	public Reply queryReply(int replyId) {
		Reply bean = getSession().get(Reply.class, replyId);
		return bean;
	}

	@Override
	public List<ReplylistView> queryAllReply(int topicId) {
		Query<ReplylistView> query = getSession().createQuery("FROM ReplylistView WHERE topicId=:topicId ORDER BY replyTime DESC", ReplylistView.class);
		query.setParameter("topicId", topicId);
		List<ReplylistView> list = query.list();
		return list;
	}

	@Override
	public long AllReplyCounts(int topicId) {
		Query query = getSession().createQuery("SELECT COUNT(*) FROM ReplylistView WHERE topicId=:topicId");
		query.setParameter("topicId", topicId);
		long count = (long)query.uniqueResult();
		return count;
	}

}
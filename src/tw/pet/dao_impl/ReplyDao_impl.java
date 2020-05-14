package tw.pet.dao_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import tw.pet.dao.ReplyDao;
import tw.pet.model.Reply;
import tw.pet.model.ReplylistView;
@Repository
public class ReplyDao_impl implements ReplyDao {
	
	private Session session;

	public ReplyDao_impl() {
	}
	
	public ReplyDao_impl(Session session) {
		this.session = session;
	}
	
	public Session getSession() {
		return session;
	}

	@Override
	public Reply saveReply(Reply rb) {
		getSession().save(rb);
		return null;
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
	public List<ReplylistView> queryAllReply() {
		Query<ReplylistView> query = getSession().createQuery("FROM ReplylistView", ReplylistView.class);
		List<ReplylistView> list = query.list();
		return list;
	}

	@Override
	public long AllReplyCounts(int topicId) {
		Query query = getSession().createQuery("SELECT COUNT(*) FROM ReplylistView WHERE topicId=?1");
		query.setParameter(1, topicId);
		long count = (long)query.uniqueResult();
		return count;
	}

}
package tw.pet.dao_impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tw.pet.dao.TopicDao;
import tw.pet.model.Topic;
import tw.pet.model.TopiclistView;

@Repository
public class TopicDao_impl implements TopicDao {
	@Autowired
	@Qualifier(value = "sessionFactory")
	private SessionFactory sessionFactory;
	

	public TopicDao_impl() {
	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public Topic saveTopic(Topic tb) {
		getSession().save(tb);
		return tb;
	}

	@Override
	public boolean deleteTopic(int topicId) {
		Topic bean = getSession().get(Topic.class, topicId);
		if (bean != null) {
			getSession().delete(bean);
			return true;
		}
		return false;
	}

	@Override
	public Topic updateTopic(Topic tb) {
		Topic bean = getSession().get(Topic.class, tb.getTopicId());
		if (bean != null) {
			bean.setTopicId(tb.getTopicId());
			bean.setCategoryId(tb.getCategoryId());
			bean.setTitle(tb.getTitle());
			bean.setContent(tb.getContent());
			System.out.println(bean);
			getSession().update(bean);

		}
		return bean;
	}

	@Override
	public Topic queryTopic(int topicId) {
		Topic bean = getSession().get(Topic.class, topicId);
		return bean;
	}

	@Override
	public List<TopiclistView> queryAllTopic() {
		Query<TopiclistView> bean = getSession().createQuery("from TopiclistView ORDER BY postTime DESC", TopiclistView.class);
		List<TopiclistView> list = bean.list();
		return list;
	}

	@Override
	public List<TopiclistView> queryCategoryTopic(int categoryId) {
		Query<TopiclistView> query = getSession().createQuery("from TopiclistView where categoryId=:categoryId ORDER BY postTime DESC", TopiclistView.class);
		query.setParameter("categoryId", categoryId);
		List<TopiclistView> list = query.getResultList();
		return list;
	}

	@Override
	public List<TopiclistView> queryMyTopic(int memberId) {
		Query<TopiclistView> query = getSession().createQuery("from TopiclistView where memberId=:memberId ORDER BY postTime DESC", TopiclistView.class);
		query.setParameter("memberId", memberId);
		List<TopiclistView> list = query.getResultList();
		return list;
	}

	@Override
	public long AllTopicCounts() {
		Query query = getSession().createQuery("SELECT COUNT(*) FROM TopiclistView");
		long count = (long)query.uniqueResult();
		return count;
	}

	@Override
	public long CategoryTopicCounts(int categoryId) {
		Query query = getSession().createQuery("SELECT COUNT(*) FROM TopiclistView WHERE categoryId=:categoryId");
		query.setParameter("categoryId", categoryId);
		long count = (long)query.uniqueResult();
		return count;
	}

	@Override
	public long MyTopicCounts(int memberId) {
		Query query = getSession().createQuery("SELECT COUNT(*) FROM TopiclistView WHERE memberId=:memberId");
		query.setParameter("memberId", memberId);
		long count = (long)query.uniqueResult();
		return count;
	}

}

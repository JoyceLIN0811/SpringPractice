package tw.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.pet.dao_impl.TopicDao_impl;
import tw.pet.model.Topic;
import tw.pet.model.TopiclistView;

@Service
public class TopicService {
	@Autowired
	private TopicDao_impl tDao;

	public Topic saveTopic(Topic tb) {
		return tDao.saveTopic(tb);
	}

	public boolean deleteTopic(int topicId) {
		return tDao.deleteTopic(topicId);
	}

	public Topic updateTopic(Topic tb) {
		return tDao.updateTopic(tb);
	}

	public Topic queryTopic(int topicId) {
		return tDao.queryTopic(topicId);
	}

	public List<TopiclistView> queryAllTopic() {
		return tDao.queryAllTopic();
	}

	public List<TopiclistView> queryCategoryTpic(int categoryId) {
		return tDao.queryCategoryTpic(categoryId);
	}

	public List<TopiclistView> queryMyTopic(int memberId) {
		return tDao.queryMyTopic(memberId);
	}

	public long AllTopicCounts() {
		return tDao.AllTopicCounts();
	}

	public long CategoryTopicCounts(int categoryId) {
		return tDao.CategoryTopicCounts(categoryId);
	}

	public long MyTopicCounts(int memberId) {
		return tDao.MyTopicCounts(memberId);
	}

}

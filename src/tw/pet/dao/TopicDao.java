package tw.pet.dao;

import java.util.List;

import tw.pet.model.*;


public interface TopicDao {
	
	public Topic saveTopic(Topic tb);
	
	public boolean deleteTopic(int topicId);
	
	public Topic updateTopic(Topic tb);
	
	public Topic queryTopic(int topicId);
	
	public List<TopiclistView> queryAllTopic();
	
	public List<TopiclistView> queryCategoryTopic(int categoryId);
	
	public List<TopiclistView> queryMyTopic(int memberId);
	
	public long AllTopicCounts();
	
	public long CategoryTopicCounts(int categoryId);
	
	public long MyTopicCounts(int memberId);
}
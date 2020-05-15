package tw.pet.dao;

import java.util.List;

import tw.pet.model.*;


public interface ReplyDao {
	
	public Reply saveReply(Reply rb);
	
	public boolean deleteReply(int replyId);
	
	public Reply updateReply(Reply rb);
	
	public Reply queryReply(int replyId);
	
	public List<ReplylistView> queryAllReply(int topicId);
	
	public long AllReplyCounts(int topicId);
	

	
}
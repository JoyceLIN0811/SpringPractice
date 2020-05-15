package tw.pet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.pet.dao_impl.ReplyDao_impl;
import tw.pet.model.Reply;
import tw.pet.model.ReplylistView;

@Service
@Transactional
public class ReplyService {
	
	@Autowired
	private ReplyDao_impl rDao;

public Reply saveReply(Reply rb) {
	return rDao.saveReply(rb);
	}
	
	public boolean deleteReply(int replyId){
		return rDao.deleteReply(replyId);
	}
	
	public Reply updateReply(Reply rb){
		return rDao.updateReply(rb);
	}
	
	public Reply queryReply(int replyId){
		return rDao.queryReply(replyId);
	}
	
	public List<ReplylistView> queryAllReply(int topicId){
		return rDao.queryAllReply(topicId);
	}
	
	public long AllReplyCounts(int topicId){
		return rDao.AllReplyCounts(topicId);
	}

}

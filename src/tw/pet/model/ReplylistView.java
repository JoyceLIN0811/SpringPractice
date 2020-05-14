package tw.pet.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "replylistView")
public class ReplylistView {
	
	private Integer memberId;
	private String username;
	private Integer topicId;
	private String title;
	private Integer replyId;
	private String replyContent;
	private Timestamp replyTime;

	public ReplylistView() {
	}
	public ReplylistView(String username,Integer topicId,String title, Integer replyId,String replyContent,Timestamp replyTime) {
		this.username = username;
		this.topicId = topicId;
		this.replyId = replyId;
		this.replyContent = replyContent;
		this.title = title; 
		this.replyTime = replyTime;
	
	}
	
	
	@Column(name = "memberId")
	public Integer getMemberId() {
		return memberId;
	}
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
	
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "topicId")
	public Integer getTopicId() {
		return topicId;
	}
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	
	@Id
	@Column(name = "replyId")
	public Integer getReplyId() {
		return replyId;
	}
	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
	}
	
	@Column(name = "replyContent")
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	
	@Column(name = "title")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "replyTime")
	public Timestamp getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}

}

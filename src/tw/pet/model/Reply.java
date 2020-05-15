package tw.pet.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Reply")
public class Reply {
	
	private Integer replyId;
	private String username;
	private Integer topicId;
	private String replyContent;
	private Timestamp replyTime;


	public Reply() {
	}
	
	public Reply(String username,Integer topicId, String replyContent, Timestamp replyTime) {
	this.username = username;
	this.topicId = topicId;
	this.replyContent = replyContent;
	this.replyTime = replyTime;
	}

	@Id
	@Column(name = "replyId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getReplyId() {
		return replyId;
	}

	public void setReplyId(Integer replyId) {
		this.replyId = replyId;
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

	@Column(name = "replyContent")
	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	@Column(name = "replyTime")
	public Timestamp getReplyTime() {
//		Timestamp replyTime = new java.sql.Timestamp(System.currentTimeMillis());
		return replyTime;
	}

	public void setReplyTime(Timestamp replyTime) {
		this.replyTime = replyTime;
	}


}

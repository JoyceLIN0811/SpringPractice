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
@Table(name = "Topic")
public class Topic {
	
	private Integer topicId;
	private Integer categoryId;
	private String title;
	private String content;
	private String username;
	private Timestamp postTime;
	
	public Topic() {}
	
	public Topic(Integer categoryId, String title,String content, String username, Timestamp postTime) {
	this.categoryId = categoryId;
	this.title = title;
	this.content = content;
	this.username = username;
	this.postTime = postTime;
	}

	@Id
	@Column(name = "topicId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public Integer getTopicId() {
		return topicId;
	}


	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	@Column(name = "categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name ="postTime")
	public Timestamp getPostTime() {
		Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
		return postTime;
	}


	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}
	

}

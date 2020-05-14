package tw.pet.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "topiclistView")
//@SqlResultSetMapping(name = "TopiclistViewResults", entities = @EntityResult(entityClass = TopiclistView.class), columns = @ColumnResult(name = "replyNum"))
public class TopiclistView {
	private Integer memberId;
	private String username;
	private Integer topicId;
	private Integer categoryId;
	private String category;
	private String title;
	private Timestamp postTime;
	private Integer replyNum;

	public TopiclistView() {
	}

	public TopiclistView(String username, Integer topicId, Integer categoryId, String category, String title,
			Timestamp postTime, Integer replyNum) {
		this.username = username;
		this.topicId = topicId;
		this.categoryId = categoryId;
		this.category = category;
		this.title = title;
		this.postTime = postTime;
		this.replyNum = replyNum;

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

	@Id
	@Column(name = "topicId")
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

	@Column(name = "category")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "postTime")
	public Timestamp getPostTime() {
		return postTime;
	}

	public void setPostTime(Timestamp postTime) {
		this.postTime = postTime;
	}

//	@Transient
	@Column(name = "replyNum")
	public Integer getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(Integer replyNum) {
		this.replyNum = replyNum;
	}

}

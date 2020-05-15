package tw.pet.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.View;

import com.google.protobuf.Timestamp;

import tw.pet.model.PetMembers;
import tw.pet.model.ReplylistView;
import tw.pet.model.Topic;
import tw.pet.model.TopiclistView;
import tw.pet.service.MemberService;
import tw.pet.service.ReplyService;
import tw.pet.service.TopicService;

@Controller
@SessionAttributes(value={"topic"})
public class TopicController {

	@Autowired
	private TopicService ts;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private ReplyService rs;

	@RequestMapping(path = "/forum", method = RequestMethod.GET)
	public String processForum() {
		return "forum/forum";
	}

	@RequestMapping(value = "/topiclist", method = RequestMethod.GET)
	public String topiclist(@RequestParam(required = false , name = "categoryId") String categoryId, Model m) throws ServletException {
		if (categoryId == null) {
			List<TopiclistView> list = ts.queryAllTopic();
			m.addAttribute("title_list", list);

			long num = ts.AllTopicCounts();
			m.addAttribute("TopicsTotalNum", num);

			return "forum/topiclist";
		} else {
			int categoryIds = 0;

			try {
				categoryIds = Integer.parseInt(categoryId.trim());

			} catch (NumberFormatException e) {
				throw new ServletException(e);
			}
			
			List<TopiclistView> clist = ts.queryCategoryTopic(categoryIds);
			m.addAttribute("title_list", clist);

			long cnum = ts.CategoryTopicCounts(categoryIds);
			m.addAttribute("TopicsTotalNum", cnum);
			m.addAttribute("categoryId",categoryId);
						
			return "forum/topiclist";
		}
	}

	@RequestMapping(path = "/addtopics", method = RequestMethod.GET)
	public String processAddTopics() {
		return "forum/addtopics";
	}
	
	
	@RequestMapping(value = "/topicInsert", method = RequestMethod.POST)
	public String saveTopic(@SessionAttribute("petMembers") PetMembers petMembers, @RequestParam("categoryId") String categoryId, @RequestParam("title") String title,
			@RequestParam("content") String content,@RequestParam("username") String username, Model m) {
		Topic topic = new Topic();
		topic.setCategoryId(Integer.parseInt(categoryId));
		topic.setContent(content);
		topic.setTitle(title);
		java.sql.Timestamp postTime = new java.sql.Timestamp(System.currentTimeMillis());
		topic.setPostTime(postTime);
		topic.setUsername(petMembers.getUsername());

		Topic n = ts.saveTopic(topic);
//		m.addAttribute("topic", n);
		if (n != null) {
			return "redirect:/topiclist";
		} else {
			return "redirect:/addtopics";
		}
	}
	
	@RequestMapping(path = "/topic", method = RequestMethod.GET)
	public String showtopic(@SessionAttribute("petMembers") PetMembers petMembers, @RequestParam(name = "topicId") String topicId, @RequestParam(name = "categoryId") String categoryId,Model m) {
		
		Topic pagecontent = ts.queryTopic(Integer.parseInt(topicId));

		m.addAttribute("topic_content", pagecontent);
		
		long rnum = rs.AllReplyCounts(Integer.parseInt(topicId));
		m.addAttribute("ReplyTotalNum", rnum);

		List<ReplylistView> rpage = rs.queryAllReply(Integer.parseInt(topicId));
		m.addAttribute("reply_content", rpage);
		
		
		m.addAttribute("isFromAllList", (StringUtils.isEmpty(categoryId)));
		m.addAttribute("categoryId",categoryId);
//		m.addAttribute("topic", pagecontent);
		System.out.println("pagecontent="+pagecontent.getPostTime());
//		System.out.println("reply_time"+rpage.get(1).getReplyTime());
		System.out.println("reply_name"+petMembers.getUsername());
		System.out.println("categoryId="+categoryId);
		System.out.println(StringUtils.isEmpty(categoryId));

		return "forum/topic";
	}

}

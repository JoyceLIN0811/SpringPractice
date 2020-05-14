package tw.pet.controller;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.google.protobuf.Timestamp;

import tw.pet.model.PetMembers;
import tw.pet.model.Topic;
import tw.pet.model.TopiclistView;
import tw.pet.service.MemberService;
import tw.pet.service.TopicService;

@Controller
public class TopicController {

	@Autowired
	private TopicService ts;
	
	@Autowired
	private MemberService ms;

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
			
			List<TopiclistView> clist = ts.queryCategoryTpic(categoryIds);
			m.addAttribute("title_list", clist);

			long cnum = ts.CategoryTopicCounts(categoryIds);
			m.addAttribute("TopicsTotalNum", cnum);
			return "forum/topiclist";
		}
	}

	@RequestMapping(path = "/addtopics", method = RequestMethod.GET)
	public String processAddTopics() {
		return "forum/addtopics";
	}
	

	
//	@RequestMapping(value = "/topicInsert", method = RequestMethod.POST)
//	public String saveTopic(@ModelAttribute("addtopic") Topic tb, BindingResult bindingResult,Model m) { 
//		Topic n = ts.saveTopic(tb);
//		if (n != null) {
//			return "forum/topiclist";
//		} else {
//			return "forum/addtopics";
//		}
//	}
	
	@RequestMapping(value = "/topicInsert", method = RequestMethod.POST)
	public String addTask(@RequestParam("categoryId") String categoryId, @RequestParam("title") String title,
			@RequestParam("content") String content,@RequestParam("username") String username, HttpServletRequest req) {
		Topic topic = new Topic();
		PetMembers mb = (PetMembers) req.getSession(false).getAttribute("petMembers");

		topic.setCategoryId(Integer.parseInt(categoryId));
		topic.setContent(content);
		topic.setTitle(title);
		java.sql.Timestamp postTime = null;
		topic.setPostTime(postTime);
		topic.setUsername(mb.getUsername());

		Topic n = ts.saveTopic(topic);
		if (n != null) {
			return "redirect:/topiclist";
		} else {
			return "redirect:/addtopics";
		}
	}

}

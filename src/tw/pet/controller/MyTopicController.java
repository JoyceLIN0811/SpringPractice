package tw.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import tw.pet.model.PetMembers;
import tw.pet.model.Topic;
import tw.pet.model.TopiclistView;
import tw.pet.service.MemberService;
import tw.pet.service.ReplyService;
import tw.pet.service.TopicService;

@Controller
public class MyTopicController {
	
	@Autowired
	private MemberService ms;

	@Autowired
	private TopicService ts;
	
	@Autowired
	private ReplyService rs;
	
	@RequestMapping(value = "/mytopiclist", method=RequestMethod.GET)
	public String processMyTopiclist(@SessionAttribute("petMembers") PetMembers petMembers,Model m) {

		Integer memberId = petMembers.getMemberId();
		List<TopiclistView> list = ts.queryMyTopic(memberId);
		m.addAttribute("mytitle_list", list);
		
		long num = ts.MyTopicCounts(memberId);
		m.addAttribute("MyTopicsTotalNum", num);
		
		return "forum/mytopiclist";
	}
	
	@RequestMapping(value = "/mytopic", method=RequestMethod.GET)
	public String processMyTopic(@SessionAttribute("petMembers") PetMembers petMembers, @RequestParam(name = "topicId") String topicId, Model m) {
	
		Topic content = ts.queryTopic(Integer.parseInt(topicId));
		m.addAttribute("mytopic_content", content);

		return "forum/update_delete_topic";

	}
	
	@RequestMapping(value = "/update_delete_topic", method= RequestMethod.POST)
	public String updateMyTopic(@RequestParam(name = "content") String content,@RequestParam(name = "title") String title,@RequestParam(name = "categoryId") String categoryId,@RequestParam(name = "topicId") String topicId, @RequestParam(name = "action") String action) {
		Topic topic = new Topic();

		if ("delete".equals(action)) {
			ts.deleteTopic(Integer.parseInt(topicId));

		} else if ("update".equals(action)) {
			topic.setTopicId(Integer.parseInt(topicId));
			topic.setCategoryId(Integer.parseInt(categoryId));
			topic.setTitle(title);
			topic.setContent(content);
			System.out.println("action="+action);
			System.out.println("topicId="+topicId);
			System.out.println("categoryId="+categoryId);
			System.out.println("title="+title);
			System.out.println("content="+content);
			ts.updateTopic(topic);
		
		}
		return "redirect:/mytopiclist";
	}

}

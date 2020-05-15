package tw.pet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public String processMyTopic(@SessionAttribute("petMembers") PetMembers petMembers,@SessionAttribute("topic") Topic topic,Model m) {
		Integer topicId = topic.getTopicId();
		
		Topic content = ts.queryTopic(topicId);
		m.addAttribute("mytopic_content", content);
		
		return "update_delete_topic";


	}

}

package tw.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import tw.pet.model.PetMembers;
import tw.pet.model.Reply;
import tw.pet.model.Topic;
import tw.pet.service.MemberService;
import tw.pet.service.ReplyService;
import tw.pet.service.TopicService;

@Controller
@SessionAttributes(value={"reply"})
public class ReplyController {
	
	@Autowired
	private TopicService ts;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private ReplyService rs;
	
	@RequestMapping(value = "/addreply", method = RequestMethod.POST)
	public String saveReply(@SessionAttribute("petMembers") PetMembers petMembers, @RequestParam("replyContent") String replyContent, @RequestParam("topicId") String topicId,
			@RequestParam("username") String username, @RequestParam(name = "categoryId") String categoryId, Model m) {
		Reply reply = new Reply();
		Topic topic = new Topic();

		reply.setReplyContent(replyContent);
		reply.setTopicId(Integer.parseInt(topicId));
		java.sql.Timestamp replyTime = new java.sql.Timestamp(System.currentTimeMillis());
		reply.setReplyTime(replyTime);
		reply.setUsername(petMembers.getUsername());
		System.out.println("reply_name=" + petMembers.getUsername());
		System.out.println("reply_time=" + replyTime);
		System.out.println("categoryId="+categoryId);
		m.addAttribute("categoryId",categoryId);
		Reply r = rs.saveReply(reply);
		m.addAttribute("reply", r);
		return "redirect:/topic?topicId="+topicId;

	}
	
	
}

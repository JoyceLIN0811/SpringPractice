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
	public String saveReply(@SessionAttribute("petMembers") PetMembers petMembers, @SessionAttribute("topic") Topic topic, @RequestParam("replyContent") String replyContent, @RequestParam("topicId") String topicId,
			@RequestParam("username") String username, Model m) {
		Reply reply = new Reply();

		reply.setReplyContent(replyContent);
		reply.setTopicId(Integer.parseInt(topicId));
		java.sql.Timestamp replyTime = null;
		reply.setReplyTime(replyTime);
		reply.setUsername(petMembers.getUsername());
		System.out.println("reply_name=" + petMembers.getUsername());

		m.addAttribute("categoryId",topic.getCategoryId());
		Reply r = rs.saveReply(reply);
		m.addAttribute("reply", r);
		return "redirect:/topic?topicId="+topicId;

	}
	
	
}

package bg.proxiad.demo.championship.front;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.proxiad.demo.championship.logic.GroupsService;
import bg.proxiad.demo.championship.logic.MatchService;
import bg.proxiad.demo.championship.logic.ParticipantService;
import bg.proxiad.demo.championship.model.Group;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private GroupsService groupsService;
	
	@Autowired
	private MatchService matchService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String adminPanel(){
		return "adminPanel";
	}
	
	
	@RequestMapping(value = "/generateGroupMatches",method = RequestMethod.GET)
	public String generateGroupMatches(){
		
		List<Group> listGroups = (List<Group>) groupsService.listAllGroups();
		
		for(Group group:listGroups){
			matchService.generateMatches(group);
		}
		return "adminPanel";
	}
	
}

package bg.proxiad.demo.championship.front;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bg.proxiad.demo.championship.logic.GroupsService;
import bg.proxiad.demo.championship.logic.MatchService;
import bg.proxiad.demo.championship.logic.SetService;
import bg.proxiad.demo.championship.model.Group;
import bg.proxiad.demo.championship.model.Match;
import bg.proxiad.demo.championship.model.Participant;
import bg.proxiad.demo.championship.model.Set;

@Controller
@RequestMapping("/matches")
public class MatchesController {

	@Autowired
	private GroupsService groupsService;
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private SetService setService;

	@RequestMapping(method = RequestMethod.GET)
	public String listMatches(ModelMap model) {

		List<Group> listGroup = (List<Group>) groupsService.listAllGroups();

		List<String> groupNames = new ArrayList<String>();

		for (Group group : listGroup) {
			groupNames.add(group.getGroupName());
		}
		
//		Match match = new Match();
//		Set set1 = new Set();
//		Set set2 = new Set();
//		
//		setService.saveOrUpdateSet(set1);
//		setService.saveOrUpdateSet(set2);
//		
//		set1.setMatch(match);
//		set2.setMatch(match);
//		
//		
//		List<Set> listSets = new ArrayList<>();
//		listSets.add(set1);
//		listSets.add(set2);
//		
//		
//		matchService.saveOrUpdateMatch(match);

		model.addAttribute("groupNames", groupNames);
		return "list-matches";
	}

	
	@RequestMapping("{matchID}/editMatchScore")
	public String editMatchScore(@PathVariable("matchID") Long matchID,ModelMap model){
		
		Match match = matchService.loadMatch(matchID);
		
		model.addAttribute("match",match);
		return "editMatchScore";
	}
	
	@RequestMapping("{matchID}/editMatchScore/{setOneHost}/{setOneGuest}/{setTwoHost}/{setTwoGuest}/{setThreeHost}/{setThreeGuest}")
	public void editMatchScoreParams(@PathVariable("matchID") Long matchID,
			@PathVariable("setOneHost") int setOneHost, @PathVariable("setOneGuest") int setOneGuest,
			@PathVariable("setTwoHost") int setTwoHost, @PathVariable("setTwoGuest") int setTwoGuest,
			@PathVariable("setThreeHost") int setThreeHost, @PathVariable("setThreeGuest") int setThreeGuest,
				ModelMap model){
		
		
		Match match = matchService.loadMatch(matchID);
		Participant host = match.getHost();
		Participant guest = match.getGuest();
		
		host.getScore().setPointsMade(setOneHost + setTwoHost + setThreeHost); 
		guest.getScore().setPointsMade(setOneGuest + setTwoGuest + setThreeGuest); 
		
		
		
		
	}
	
	@RequestMapping(value = "/showGroup/{groupName}", method = RequestMethod.GET)
	public String showMatches(@PathVariable("groupName") String groupName, ModelMap model) {
		
		List<Group> listGroup = (List<Group>) groupsService.listAllGroups();
		Group selectedGroup = null;
		
		for (Group group : listGroup){
			if(group.getGroupName().equals(groupName)){
				selectedGroup = group;
				break;
			}
		}
		
		//matchService.generateMatches(selectedGroup);
		List<Match> listMatches = selectedGroup.getMatches();
		
		model.addAttribute("group",selectedGroup);
		model.addAttribute("listMatches", listMatches);
		return "groupMatches";
	}

}

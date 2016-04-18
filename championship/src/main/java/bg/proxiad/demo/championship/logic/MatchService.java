package bg.proxiad.demo.championship.logic;

import java.util.Collection;

import bg.proxiad.demo.championship.model.Group;
import bg.proxiad.demo.championship.model.Match;


public interface MatchService {

	Match loadMatch(Long id);
	
	void saveOrUpdateMatch(Match match);
	
	Collection<Match> listAllMatches();
	
	void deleteMatch(Long id);
	
	void generateMatches(Group group);
	
}

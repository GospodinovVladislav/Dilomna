package bg.proxiad.demo.championship.logic;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bg.proxiad.demo.championship.model.Group;
import bg.proxiad.demo.championship.model.GroupDao;


@Service
@Transactional
public class GroupsServiceImpl implements GroupsService{

	@Autowired
	private GroupDao groupDao;

	@Override
	public Group loadGroup(Long id) {
		return groupDao.load(id);
	}

	@Override
	public void saveOrUpdateGroup(Group group) {
		groupDao.saveOrUpdate(group);
	}

	@Override
	public Collection<Group> listAllGroups() {
		return groupDao.listAll();
	}

	@Override
		public void deleteGroup(Long id) {
			groupDao.deleteGroup(id);
	}
}

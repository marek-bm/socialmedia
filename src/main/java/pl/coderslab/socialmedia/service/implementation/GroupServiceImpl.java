package pl.coderslab.socialmedia.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.socialmedia.model.Group;
import pl.coderslab.socialmedia.repository.GroupRepository;
import pl.coderslab.socialmedia.service.GroupService;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group findByName(String name) {
        return groupRepository.findByName(name);
    }

    @Override
    public Group findById(long id) {
        return groupRepository.findById(id);
    }
}

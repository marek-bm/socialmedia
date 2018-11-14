package pl.coderslab.socialmedia.service;

import pl.coderslab.socialmedia.model.Group;

import java.util.List;

public interface GroupService {

    List<Group> findAll();

    Group findByName(String name);

    Group findById (long id);
}

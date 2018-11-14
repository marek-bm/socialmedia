package pl.coderslab.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.socialmedia.model.Group;

@Repository
public interface GroupRepository extends JpaRepository <Group, Long> {

    Group findById(long id);

    Group findByName(String name);
}

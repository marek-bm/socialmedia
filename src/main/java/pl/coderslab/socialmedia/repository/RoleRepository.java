package pl.coderslab.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.socialmedia.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}

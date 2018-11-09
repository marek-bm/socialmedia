package pl.coderslab.socialmedia.service.implementation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import pl.coderslab.socialmedia.model.Role;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.repository.RoleRepository;
import pl.coderslab.socialmedia.repository.UserRepository;
import pl.coderslab.socialmedia.service.UserService;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @TestConfiguration
    static class UserServiceImplTestConfig {
        @MockBean
        UserRepository userRepository;

        @MockBean
        RoleRepository roleRepository;

        @Bean
        public UserService userService() {
            return new UserServiceImpl(userRepository, roleRepository, new BCryptPasswordEncoder());

        }
    }

    @Before
    public void setUp(){
        User user=new User();
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        String password=passwordEncoder.encode("qwer");
        user.setUsername("user");
        user.setPassword(password);
        user.setFirstName("Jas");
        user.setEmail("mail@mail.com");

        Set<Role> roles=new HashSet<>();
        Role role=new Role();
        role.setName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);

        Mockito.when(userService.findByUserName("user")).thenReturn(user);
        Mockito.when(userService.findByMail("mail@mail.com")).thenReturn(user);


    }


    @Autowired
    UserService userService;

    @Test
    public void given_username_load_user() {
        //given
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String username = "user";
        User user = userService.findByUserName(username);


        String roleUser = "ROLE_USER";
        String roleAdmin = "ROLE_ADMIN";

        Set<Role> roles = user.getRoles();

        boolean hasRoleUser = roles.stream().allMatch(role -> role.getName().equals(roleUser));
        boolean hasRoleAdmin = roles.stream().allMatch(role -> role.getName().equals(roleAdmin));

        //then
        assertEquals(user.getUsername(), username);
        assertEquals(user.getFirstName(), "Jas");
        assertNotEquals(user.getUsername(), "User1");
        assertTrue(hasRoleUser);
        assertFalse(hasRoleAdmin);
        assert (passwordEncoder.matches("qwer", user.getPassword()));


    }
}

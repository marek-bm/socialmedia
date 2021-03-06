package pl.coderslab.socialmedia.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.socialmedia.model.CurrentUser;
import pl.coderslab.socialmedia.model.Role;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Primary
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {

        User user=userService.findByUserName(username);
        if(user==null){
            throw new UsernameNotFoundException(username);
        }

        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for (Role role:user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        CurrentUser currentUser=new CurrentUser(user.getUsername(), user.getPassword(), grantedAuthorities, user);

        return currentUser;
    }


    public boolean findEmailAndUsername(String username, String email){

        try {
            if (userService.findByUserName(username)==null && userService.findByMail(email)==null){
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

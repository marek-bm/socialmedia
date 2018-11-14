package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.socialmedia.model.Group;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.GroupService;
import pl.coderslab.socialmedia.service.UserService;

import java.util.List;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    UserService userService;

    @RequestMapping("/home")
    public String indexPage(Model model, Authentication authentication){

        List<Group> groups=groupService.findAll();

        model.addAttribute("groups", groups);

        return "home";
    }

}

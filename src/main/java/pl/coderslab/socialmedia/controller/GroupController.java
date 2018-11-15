package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.socialmedia.model.Group;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.GroupService;
import pl.coderslab.socialmedia.service.TweetService;
import pl.coderslab.socialmedia.service.UserService;

import java.util.List;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @RequestMapping("/home")
    public String homePage(Model model, Authentication authentication){

        List<Group> groups=groupService.findAll();

        model.addAttribute("groups", groups);

        return "home";
    }


    @RequestMapping("/group")
    public String homePage(Model model, Authentication authentication, @RequestParam long groupId){

        Group group=groupService.findById(groupId);

        List<Tweet> tweets=tweetService.findAllByGroup_Id(groupId);

        User user=userService.findByUserName(authentication.getName());

        Tweet tweet=new Tweet();

        tweet.setAuthor(user);

        model.addAttribute("chatRoom", group);

        model.addAttribute("tweets", tweets);

        model.addAttribute("user", user);

        model.addAttribute("tweet", tweet);

        return "group-page";
    }



}

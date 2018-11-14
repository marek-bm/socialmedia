package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.TweetService;
import pl.coderslab.socialmedia.service.UserService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    TweetService tweetService;

    @RequestMapping("/home2") //need to be updated
    public String home (Authentication authentication, Model model){

        User user = userService.getCurrentUser(authentication);

        Tweet tweet=new Tweet();

        tweet.setAuthor(user);

        List<Tweet> followingPeopleTweets=tweetService.findAllByAuthorIn(user.getFollowing());

        model.addAttribute("user", user);

        model.addAttribute("tweet", tweet);

        model.addAttribute("tweets", followingPeopleTweets);

        return "hyde-park";
    }

}

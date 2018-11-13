package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.TweetService;
import pl.coderslab.socialmedia.service.UserService;

import javax.validation.Valid;
import java.net.Authenticator;

@Controller
public class TweetController {

    @Autowired
    TweetService tweetService;

    @RequestMapping(value = "/tweet-new",method = RequestMethod.POST)
    public String newTweet(@Valid Tweet tweet, BindingResult result, Authentication authentication){

        if(result.hasErrors()){
            return "redirect:/home";
        }

        tweetService.save(tweet);

        return "redirect:/user-posts";
    }
}

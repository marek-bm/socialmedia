package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.TweetService;
import pl.coderslab.socialmedia.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.Authenticator;

@Controller
public class TweetController {

    @Autowired
    TweetService tweetService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/tweet-new",method = RequestMethod.POST)
    public String newTweet(@Valid Tweet tweet, BindingResult result, Authentication authentication){

        if(result.hasErrors()){

            return "redirect:/home";
        }

        tweetService.save(tweet);

        return "redirect:/user-posts";
    }


    @RequestMapping (value = "/give-like", method = RequestMethod.POST)
    public String assignLikeToTweet(Authentication authentication, @RequestParam long tweetId, HttpServletRequest request){

        User user = userService.findByUserName(authentication.getName());

        Tweet tweet=tweetService.findById(tweetId);

        if(!user.getLikedTweets().contains(tweet)){

            tweet.setNumberOfLikes(tweet.getNumberOfLikes()+1);

            tweetService.save(tweet);

            userService.save(user);
        }

        String referer = request.getHeader("Referer");

        return "redirect:"+ referer;
    }
}

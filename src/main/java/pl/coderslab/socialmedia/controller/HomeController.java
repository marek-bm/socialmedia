package pl.coderslab.socialmedia.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.socialmedia.model.Tweet;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.ImageService;
import pl.coderslab.socialmedia.service.UserService;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/home")
    public String home (Authentication authentication, Model model){
        String username=authentication.getName();

        User user=userService.findByUserName(username);

        Tweet tweet=new Tweet();

        tweet.setAuthor(user);

        model.addAttribute("user", user);

        model.addAttribute("tweet", tweet);

        return "home";
    }
}

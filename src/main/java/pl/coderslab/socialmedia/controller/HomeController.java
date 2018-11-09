package pl.coderslab.socialmedia.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.ImageService;

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
    ImageService imageService;

    @RequestMapping (value = "/home", method = RequestMethod.GET)
    public String homePage(Model model){

        User user=new User();
        user.setUsername("Juliusz");
        model.addAttribute("user", user);

        List<String> avatars=imageService.getPathsToAvatars();
        model.addAttribute("avatars", avatars);

        return "change-avatar";
    }


    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String changeAvatar(@RequestParam String avatar, Model model){
        User user=new User();
        user.setUsername("Cezar");
        user.setAvatarPath(avatar);
        model.addAttribute("user", user);

        return "change-avatar";

    }
}

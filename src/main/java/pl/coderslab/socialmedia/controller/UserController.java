package pl.coderslab.socialmedia.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.ImageService;
import pl.coderslab.socialmedia.service.UserService;

@Controller
public class UserController {


    @Autowired
    ImageService imageService;

    @Autowired
    UserService userService;

    @RequestMapping (value = "/edit", method = RequestMethod.GET)
    public String homePage(Model model, Authentication authentication){

        String username=authentication.getName();

        User user=userService.findByUserName(username);

        model.addAttribute("user", user);

        Page<String> avatars=imageService.getPagedPathsToAvatars();

        model.addAttribute("avatars", avatars);

        return "change-avatar";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String changeAvatar(@RequestParam long id, @RequestParam String avatar, Authentication authentication){

        String name=authentication.getName();

        User user=userService.findByUserName(name);

        user.setAvatarPath(avatar);

        userService.save(user);

        return "redirect:/home";

    }

}

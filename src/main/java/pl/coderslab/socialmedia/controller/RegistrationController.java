package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.socialmedia.model.User;
import pl.coderslab.socialmedia.service.UserService;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registrationInit(Model model){

        User userDTO=new User();

        model.addAttribute("userDTO", userDTO);

        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registrationFinish(@Valid User userDTO, BindingResult result, Model model){

        if (result.hasErrors()){

            return "register";
        }
        userService.saveUser(userDTO);

        return "redirect:/login";

    }

}

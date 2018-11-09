package pl.coderslab.socialmedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.coderslab.socialmedia.model.Image;
import pl.coderslab.socialmedia.service.ImageService;

@Controller
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping (value = "/upload", method = RequestMethod.GET)
    public String uploadFileGet(Model model){
        return "upload";
    }


    @RequestMapping (value = "/upload", method = RequestMethod.POST)
    public String fileIpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){


        try{
            imageService.save(file);
            redirectAttributes.addFlashAttribute("flash.message", "Sucessfully uploaded " + file.getOriginalFilename());
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("flash.message", "Sucessfully uploaded " + file.getOriginalFilename()+ " " + e.getMessage());
        }


        return "redirect:/upload";

    }
}

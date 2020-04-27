package space.dubovitsky.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import space.dubovitsky.portfolio.service.NameService;


@Controller
public class PublicDataController {

    @Autowired
    private NameService nameService;

    @GetMapping(value="/{uid}")
    public String getProfile(@PathVariable("uid") String uid, Model model){
        String fullName = nameService.convertName(uid);
        model.addAttribute("fullName", fullName);
        return "profile";
    }

    @GetMapping(value="/error")
    public String getError(){
        return "error";
    }
}

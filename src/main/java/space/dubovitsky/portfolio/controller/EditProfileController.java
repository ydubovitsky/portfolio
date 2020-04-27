package space.dubovitsky.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EditProfileController {

    @GetMapping(value="/edit")
    public String getError(){
        return "edit";
    }
}


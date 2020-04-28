package space.dubovitsky.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import space.dubovitsky.portfolio.entity.Profile;
import space.dubovitsky.portfolio.repository.ProfileRepository;

import javax.transaction.Transactional;

@Controller
@Transactional
public class PublicDataController {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value="/{uid}", method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model) {
        Profile profile = profileRepository.findByUid(uid);
        if (profile == null) {
            return "page-not-found";
        }
        model.addAttribute("profile", profile);
        return "profile";
    }

    @GetMapping(value="/error")
    public String getError(){
        return "page-not-found";
    }
}

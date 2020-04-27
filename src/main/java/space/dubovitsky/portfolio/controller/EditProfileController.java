package space.dubovitsky.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import space.dubovitsky.portfolio.repository.SkillCategoryRepository;

@Controller
public class EditProfileController {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @RequestMapping(value="/edit",method = RequestMethod.GET)
    public String getError(){
        return "edit";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getEditSkills(Model model) {
        model.addAttribute("skillCategories", skillCategoryRepository.findAll(Sort.by("id")));
        return "edit-skills";
    }
}


package space.dubovitsky.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import space.dubovitsky.portfolio.entity.Skill;
import space.dubovitsky.portfolio.form.SkillForm;
import space.dubovitsky.portfolio.repository.ProfileRepository;
import space.dubovitsky.portfolio.repository.SkillCategoryRepository;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@Transactional //! https://ru.stackoverflow.com/questions/460585/jparepository-hibernate-onetomany-%D0%B2%D1%8B%D0%BB%D0%B5%D1%82%D0%B0%D0%B5%D1%82-lazyinitializationexception
public class EditProfileController {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(value="/edit", method=RequestMethod.GET)
    public String getEditProfile(){
        return "edit";
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
    public String getEditTechSkills(Model model) {
        model.addAttribute("skillForm", new SkillForm(profileRepository.findById(1L).get().getSkills()));
        return gotoSkillsJSP(model);
    }

    @RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
    public String saveEditTechSkills(@ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model) {
        List<Skill> items = form.getItems();
        if (bindingResult.hasErrors()) {
            return gotoSkillsJSP(model);
        }
        //TODO Update skills
        return "redirect:/aly-dutta";
    }

    private String gotoSkillsJSP(Model model){
        model.addAttribute("skillCategories", skillCategoryRepository.findAll(Sort.by("id")));
        return "edit/skills";
    }
}


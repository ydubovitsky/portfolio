package space.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import space.portfolio.service.NameService;

@Controller
public class PublicDataController {

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/{uid}", method = RequestMethod.GET)
    public String getProfile(@PathVariable("uid") String uid, Model model) { //! В аргументах метода пишем то, к чему хотим получить доступ в методе
        String fullName = nameService.convertName(uid);
        model.addAttribute("fullName", fullName); //* Модель - это как req.setAttribute() для передачи объектов в представление
        return "profile";
    }

    @RequestMapping(value = "/error", method = RequestMethod.POST)
    public String getError() {
        return "error";
    }
}

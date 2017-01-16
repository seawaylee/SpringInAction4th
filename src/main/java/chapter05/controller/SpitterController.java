package chapter05.controller;

import chapter05.dao.SpitterDao;
import chapter05.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * @author NikoBelic
 * @create 02/01/2017 00:04
 */
@Controller
@RequestMapping("spitter")
public class SpitterController
{
    @Autowired
    private SpitterDao spitterDao;

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public String showRegisterForm(Model model)
    {
        model.addAttribute(new Spitter());
        return "register";
    }

    @RequestMapping(value ="register",method = RequestMethod.POST)
    public String processRegister(@Valid Spitter spitter, BindingResult errors)
    {
        if (errors.hasErrors())
            return "register";

        spitterDao.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value ="{username}" ,method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username,Model model)
    {
        Spitter spitter = spitterDao.findSpitterByUsername(username);
        model.addAttribute("spitter",spitter);
        return "profile";
    }
}

package org.apache.maven.formServerValidation.controller;

import org.apache.maven.formServerValidation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class StartController {
    @Autowired
    private Validator formValidator;

    @InitBinder("user")
    protected void initUserBinder(final WebDataBinder binder) {
        binder.setValidator(formValidator);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("user", new User());
        return mav;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addTeacher(@ModelAttribute("user") @Validated final User user,
                             final BindingResult bindingResultUser,
                             final Model model,
                             final HttpServletRequest httpServletRequest) {
        if (bindingResultUser.hasErrors()) {
            model.addAttribute("user", user);
            return "index";
        }
        else {
            user.writeToFile("users.dat");
            return "redirect: "+ httpServletRequest.getContextPath() +"/";
        }
    }
}

package com.example.pathfinder.web;


import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String login(Model model) {
        if (!model.containsAttribute("username")){
            model.addAttribute("username", "");
            model.addAttribute("bad_credentials", false);
        }
            return "login";

    }


    @PostMapping("/users/login-error")
    public String failedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                   String userName, RedirectAttributes attributes) {


        attributes.addFlashAttribute("bad_credentials", true);
        attributes.addFlashAttribute("username", userName);

        return "redirect:/users/login";
    }

}

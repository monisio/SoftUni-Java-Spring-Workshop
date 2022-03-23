package com.example.pathfinder.web;


import com.example.pathfinder.model.binding.UserRegisterBindingModel;
import com.example.pathfinder.model.service.UserServiceModel;
import com.example.pathfinder.model.view.UserViewModel;
import com.example.pathfinder.service.UserService;
import com.example.pathfinder.service.impl.user.PathFinderUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;



    public UserController(UserService userService, ModelMapper modelMapper){
        this.userService = userService;
        this.modelMapper= modelMapper;

    }



    @ModelAttribute
    UserRegisterBindingModel userRegisterBindingModel(){
        return  new UserRegisterBindingModel();
    }

    @GetMapping("/users/register")
    public String register(Model model){

        return "register";
    }

    @PostMapping("/users/register")
    public String registerConfirm(@Valid  UserRegisterBindingModel userRegisterBindingModel
    , BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())){
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        userService.register(modelMapper.map(userRegisterBindingModel, UserServiceModel.class));


        return "redirect:login";
    }



    @GetMapping("/users/profile")
    public String profile(Model model, @AuthenticationPrincipal PathFinderUser user){

        model.addAttribute("user",
                modelMapper.map(userService.findById(user.getId()), UserViewModel.class));

        return "profile";
    }

}

package com.example.pathfinder.web;

import com.example.pathfinder.model.binding.RouteAddBindingModel;
import com.example.pathfinder.model.service.RouteServiceModel;
import com.example.pathfinder.service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/routes")
public class RouteController {

   private final RouteService routeService;
   private final ModelMapper modelMapper;

   @ModelAttribute
   public RouteAddBindingModel routeBindingModel(){
       return  new RouteAddBindingModel();
   }

    public RouteController(RouteService routeService, ModelMapper modelMapper) {
        this.routeService = routeService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/all")
    public String routes(Model model){

        model.addAttribute("routes", routeService.findAllRoutes());

        return "routes";
    }

    @GetMapping("/{id}")
    public String routeDetails(@PathVariable Long id, Model model){
       model.addAttribute("routeId", id);
       model.addAttribute("route", routeService.findRouteById(id));
       return "route-details";
    }

    @GetMapping("/add")
    public String add(Model model){

        return "add-route";
    }

    @PostMapping("/add")
    public String addRoute(@Valid @ModelAttribute RouteAddBindingModel routeAddBindingModel, BindingResult bindingResult
    , RedirectAttributes redirectAttributes) throws IOException {

       if(bindingResult.hasErrors()){
           redirectAttributes.addFlashAttribute("routeBindingModel", routeAddBindingModel)
                   .addFlashAttribute("org.springframework.validation.BindingResult.routeBindingModel", bindingResult);

           return "redirect:/add";
       }

        RouteServiceModel routeServiceModel= modelMapper.map(routeAddBindingModel, RouteServiceModel.class);
       routeServiceModel.setGpxCoordinates(new String(routeAddBindingModel.getGpxCoordinates().getBytes()));

       routeService.addNewRoute(routeServiceModel);

       return "redirect:all";
    }
}

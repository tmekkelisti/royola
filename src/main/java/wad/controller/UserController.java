/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Person;
import wad.repository.PersonRepository;
import wad.service.PersonService;
import wad.service.StoryService;

/**
 *
 * @author markolai
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PersonRepository userRepo;
    
    @Autowired
    private StoryService storyService;
    
    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Person user, BindingResult br) {
        
        if(br.hasErrors()){
            return "signup";
        }
        
        userRepo.save(user);
        return "redirect:/login";
    }
    
    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("person", userRepo.findOne(id));
        model.addAttribute("comments", storyService.commentsListByAuthor(userRepo.findOne(id).getUsername()));
        model.addAttribute("amountOfComments", storyService.amountOfComments(userRepo.findOne(id).getUsername()));
        model.addAttribute("stories", storyService.storiesListByAuthor(userRepo.findOne(id).getUsername()));
        model.addAttribute("amountOfStories", storyService.amountOfStories(userRepo.findOne(id).getUsername()));
        return "user";   
    }
    
    @RequestMapping(value="/current", method = RequestMethod.POST)
    public String currentUser(){
        Long id = personService.getAuthenticatedPerson().getId();
        String url = "redirect:/users/" + id;
        System.out.println(url);
        return url;
    }

}

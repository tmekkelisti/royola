/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Person;
import wad.repository.PersonRepository;

/**
 *
 * @author markolai
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PersonRepository userRepo;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Person user, BindingResult br) {
        
        if(br.hasErrors()){
            return "signup";
        }
        
        userRepo.save(user);
        return "redirect:/login";
    }

}

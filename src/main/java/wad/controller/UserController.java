/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Person;
import wad.repository.UserRepository;

/**
 *
 * @author markolai
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute Person user) {
        userRepo.save(user);
        return "redirect:/login";
    }

}

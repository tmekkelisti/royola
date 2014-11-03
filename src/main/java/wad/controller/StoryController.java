/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Story;
import wad.service.StoryService;

/**
 *
 * @author rohamo
 */
@Controller
@RequestMapping("/stories")
public class StoryController {

    @Autowired
    private StoryService storyService;
    
    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute Story story) {
        // TODO: add person details in the future
        
        storyService.addStory(story);
        return "redirect:/index";
    }
}

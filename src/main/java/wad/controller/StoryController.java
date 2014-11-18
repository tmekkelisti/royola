/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Story;
import wad.service.StoryService;

/**
 *
 * @author royola
 */
@Controller
@RequestMapping("/stories")
public class StoryController {

    @Autowired
    private StoryService storyService;
    

    @RequestMapping(method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute Story story) {
        // TODO: add person details in the future
        
        storyService.addStory(story);
        return "redirect:/index";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {

        storyService.deleteStory(id);
        return "redirect:/index";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String get(@PathVariable Long id) {
        
        storyService.getStory(id);
        return "redirect:/index";
    }
}

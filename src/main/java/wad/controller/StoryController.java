/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.controller;

import javax.validation.Valid;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String create(@Valid @ModelAttribute Story story, BindingResult br) {
        // TODO: add person details in the future

        if(br.hasErrors()){
            return "redirect:/index";
        }
        
        String replaceAll = story.getContent().replaceAll("(\r\n|\n\r|\r|\n)", "<br />\n");
        Whitelist whitelist = new Whitelist();
        whitelist.addAttributes("br", "<br />\n");
        String safe = Jsoup.clean(replaceAll, whitelist);
        story.setContent(safe);
        storyService.addStory(story);

        return "redirect:/index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {

        storyService.deleteStory(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String singleStory(@PathVariable Long id, Model model) {
        model.addAttribute("story", storyService.getStory(id));
        return "singleStory";
    }

}

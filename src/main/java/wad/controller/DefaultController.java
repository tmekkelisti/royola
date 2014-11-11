package wad.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Story;
import wad.service.StoryService;

@Controller
@RequestMapping("*")
public class DefaultController {

    @Autowired
    private StoryService storyService;

    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model) throws UnsupportedEncodingException {
        List<Story> asd = new ArrayList<>();
        for (Story story : storyService.list()) {
            byte[] iso = story.getContent().getBytes("ISO-8859-1");
            story.setContent(new String(iso, "UTF-8"));
            asd.add(story);
        }
        model.addAttribute("stories", asd);
        return "index";
    }
}

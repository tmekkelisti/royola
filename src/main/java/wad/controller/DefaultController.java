package wad.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import wad.domain.Story;
import wad.service.StoryService;
import wad.service.UserService;

@Controller
@RequestMapping("*")
public class DefaultController {

    @Autowired
    private StoryService storyService;
    
    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String viewLogin(Model model) {
        return "login";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String viewSignup(Model model) {
        return "signup";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String view(Model model) {
        List<Story> asd = new ArrayList<>();
        if (!storyService.list().isEmpty()) {
            model.addAttribute("stories", storyService.list());
        }
        model.addAttribute("user", currentUser());
        return "index";
    }

    public String currentUser() {
        String user = "Not logged";

        if (userService.getAuthenticatedPerson() != null) {
            user = "Kirjautunut: " + userService.getAuthenticatedPerson().getUsername();
        }

        return user;
    }
}

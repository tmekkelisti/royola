/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.Collections;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Story;
import wad.repository.StoryRepository;

/**
 *
 * @author royola
 */
@Service
public class StoryService {
    
    @Autowired
    private StoryRepository storyRepository;
    
    @Autowired
    private UserService userService;
    
    public List<Story> list() {
        List<Story> stories = storyRepository.findAll();
        Collections.reverse(stories);
        return stories;
    }
    
    @Transactional
    public void addStory(Story story) {
        story.setStoryId();
        story.setAuthor(userService.getAuthenticatedPerson().getUsername());
        storyRepository.save(story);
    }
    
    @Transactional
    public void deleteStory(Long id) {
        storyRepository.delete(storyRepository.findOne(id));
    }
    
    @Transactional
    public Story getStory(Long id) {
        return storyRepository.findOne(id);
    }
}

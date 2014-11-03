/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.domain.Story;
import wad.repository.StoryRepository;

/**
 *
 * @author rohamo
 */
@Service
public class StoryService {
    
    @Autowired
    private StoryRepository storyRepository;
    
    public List<Story> list() {
        return storyRepository.findAll();
    }
    
    @Transactional
    public void addStory(Story story) {
        storyRepository.save(story);
    }
}

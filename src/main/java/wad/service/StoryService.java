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
import wad.domain.Comment;
import wad.domain.Story;
import wad.repository.CommentRepository;
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
    private PersonService userService;
    
    @Autowired
    private CommentRepository commentRepo;
    
    public List<Story> list() {
        List<Story> stories = storyRepository.findAll();
        Collections.reverse(stories);
        return stories;
    }
    
    @Transactional
    public void addStory(Story story) {
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
    
    @Transactional
    public void addCommentToStory(Comment comment, Long storyId){
        comment.setAuthor(userService.getAuthenticatedPerson().getUsername());
        comment.setStory(storyRepository.findOne(storyId));
        commentRepo.save(comment);
        storyRepository.findOne(storyId).getComments().add(comment);
    }
    
}

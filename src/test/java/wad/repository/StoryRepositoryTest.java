/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.Application;
import wad.domain.Story;

/**
 *
 * @author teeyoshi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class StoryRepositoryTest {
    
    @Autowired
    StoryRepository storyRepo;
    
    @Test
    public void saveStory(){
        
        final String content = "tämä on tarinan sisältö";
        final String title = "tämä on tarinan otsikko";
        final String location = "tarinan lokaatio";
        final String author = "tarinan kertoja";
        
        Story story = new Story();
        story.setContent(content);
        story.setAuthor(author);
        story.setTitle(title);
        story.setLocation(location);
        
        storyRepo.save(story);
        
        Story dbStory = storyRepo.findOne(story.getStoryId());
        assertNotNull(dbStory);
        assertEquals(content, dbStory.getContent());
        assertEquals(title, dbStory.getTitle());
        assertEquals(location, dbStory.getLocation());
        assertEquals(author, dbStory.getAuthor());
        
    }
   
}

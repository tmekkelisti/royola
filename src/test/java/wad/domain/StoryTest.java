/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 *
 * @author royola
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Story.class)
public class StoryTest {

    
    private Story testStory;
    
    @PostConstruct
    public void init() {
        testStory = new Story();
    }
    
    @Test
    public void atStartNewStoryNull() {
        Assert.assertEquals(null, testStory.getContent());
    }
    
    @Test
    public void settingLocationWorks() {
        testStory.setLocation("test");
        Assert.assertEquals("test", testStory.getLocation());
    }
    
    @Test
    public void settingAuthorWorks() {
        testStory.setAuthor("test");
        Assert.assertEquals("test", testStory.getAuthor());
    }
    
    @Test
    public void settingStoryIdWorks() {
        Long id = 12L;
        testStory.setStoryId(12L);
        Assert.assertEquals(id, testStory.getStoryId());
    }
    
    @Test
    public void settingContentWorks() {
        testStory.setContent("test");
        Assert.assertEquals("test", testStory.getContent());
    }
    
    @Test
    public void settingDateWorks() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 12, 11);
        Date date = calendar.getTime();
        
        testStory.setStoryDate(date);
        
        Assert.assertEquals(calendar.getTime(), testStory.getStoryDate());
    }
    
    @Test
    public void settingCommentsWorks(){
        Comment comment = new Comment();
        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        testStory.setComments(comments);
        
        assertEquals(comments, testStory.getComments());
    }
}

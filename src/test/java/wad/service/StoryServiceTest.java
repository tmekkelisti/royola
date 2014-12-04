///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package wad.service;
//
//import javax.transaction.Transactional;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import wad.Application;
//import wad.domain.Comment;
//import wad.domain.Story;
//import wad.repository.StoryRepository;
//
///**
// *
// * @author unknown
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//public class StoryServiceTest {
//  
//    @Autowired
//    private StoryService storyService;
//       
//    @Autowired
//    private StoryRepository storyRepository;
//    
//    @Test
//    public void testSaveStory(){
//        
//        String author = "testi tyyppi";
//        String storyContent = "tämä on kontentti";
//        String location = "tämä on lokaatio";
//        
//        Story story = new Story();
//        story.setAuthor(author);
//        story.setContent(storyContent);
//        story.setStoryDate(null);
//        story.setLocation(location);
//        
//        storyService.addStory(story);
//        
//        Story dbStory = storyService.getStory(story.getStoryId());
//        Assert.assertNotNull(dbStory);
//        Assert.assertEquals(author, dbStory.getAuthor());
//        Assert.assertEquals(storyContent, dbStory.getContent());
//        
//    } 
//}
//    
//

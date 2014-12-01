package wad.profiles;

import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import wad.domain.Comment;
import wad.domain.Person;
import wad.domain.Story;
import wad.repository.CommentRepository;
import wad.repository.PersonRepository;
import wad.repository.StoryRepository;

@Configuration
@Profile(value = {"dev", "default"})
public class DevProfile {

//    @Autowired
//    private StoryRepository storyRepository;
//
//    @PostConstruct
//    public void init() {
//        Story firstStory = new Story();
//        firstStory.setContent("Pikku testailua, jatkuu huomena");
//        storyRepository.save(firstStory);
//
//        for (int i = 0; i < 20; i++) {
//            Story newStory = new Story();
//            newStory.setContent(UUID.randomUUID().toString());
//            storyRepository.save(newStory);
//        }
//    }
    
    @Autowired
    private PersonRepository personRepo;
    
    @Autowired
    private StoryRepository storyRepo;
    
    @Autowired
    private CommentRepository commentRepo;
    
    @PostConstruct
    public void init(){
        Person postman = new Person();
        postman.setUsername("postman");
        postman.setPassword("asd");
        personRepo.save(postman);
        
        Story story = new Story();
        story.setContent("tämä on testistory jejeje");
        story.setStoryDate(new Date());
        story.setTitle("testistoryn otsikko");
        storyRepo.save(story);
        
        Comment comment = new Comment();
        comment.setAuthor("kommentaattori");
        comment.setBody("tämä on kommenttini");
        comment.setStory(story);
        commentRepo.save(comment);
        
        story.getComments().add(comment);
        storyRepo.save(story);
        
        
        
    }
    
}

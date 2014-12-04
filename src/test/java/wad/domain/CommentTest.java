
package wad.domain;

import javax.annotation.PostConstruct;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Comment.class)
public class CommentTest {
    
    private Comment comment;
    
    @PostConstruct
    public void init() {
        comment = new Comment();
    }
    
    @Test
    public void atStartNewCommentNull() {
        Assert.assertEquals(null, comment.getBody());
        assertNull(comment.getAuthor());
        assertNull(comment.getStory());        
    }
    
    @Test
    public void atStartDateCreated(){
        assertNotNull(comment.getCommentDate());
    }
        
    @Test
    public void setAuthorWorks(){
        final String author = "author";
        comment.setAuthor(author);
        assertEquals(author, comment.getAuthor());
    }
    
    @Test
    public void setBodyWorks(){
        final String commentBody = "comment body";
        comment.setBody(commentBody);
        assertEquals(commentBody, comment.getBody());
    }
    
    @Test
    public void setDateWorks(){
        assertNotNull(comment.getCommentDate());
    }
    
    @Test
    public void setIdWorks(){
        final Long id = Long.parseLong("123");
        comment.setCommentID(id);
        assertEquals(id, comment.getCommentID());
    }

}

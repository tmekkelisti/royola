/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author rohamo
 */
@Entity
public class Story extends AbstractPersistable<Long> {
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date storyDate;
    private String story;
    private String content;
    
    public Story() {
        this.storyDate = new Date();
    }
    
    public Date getStoryDate() {
        return storyDate;
    }
    
    public void setStoryDate(Date storyDate) {
        this.storyDate = storyDate;
    }
    
    public String getStory() {
        return story;
    }
    
    public void setStory(String story) {
        this.story = story;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author royola
 */
@Entity
public class Story extends AbstractPersistable<Long> {
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date storyDate;
    
    @Lob
    @Column(length = 10000)
    @NotBlank
    private String content;
    
    @Column(length = 50)
    private String author;
    
    @Column(length = 10)
    private String storyId;
    
    @NotBlank
    private String title;
    
    private String location;
    
    public Story() {
        this.storyDate = new Date();
    }
    
    public Date getStoryDate() {
        return storyDate;
    }
    
    public void setStoryDate(Date storyDate) {
        this.storyDate = storyDate;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    
    
    public String getStoryId() {
        return storyId;
    }
    
    public void setStoryId() {
        String uuid = UUID.randomUUID().toString();
        this.storyId = uuid.substring(0, 7);
    }
    
    
}


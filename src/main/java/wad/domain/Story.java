/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author royola
 */
@Entity
public class Story {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="STORY_ID")
    private Long storyId;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date storyDate;
    
    @Lob
    @Column(length = 10000)
    @NotBlank
    private String content;
    
    @Column(length = 50)
    private String author; 
    
    @NotBlank
    @Length(min = 5, max = 30)
    private String title;
    
    private String location;
    
    private int amountOfComments;
    
    @OneToMany(mappedBy = "story", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
    
    public Story() {
        this.storyDate = new Date();
        this.amountOfComments = 0;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getStoryId() {
        return storyId;
    }

    public void setStoryId(Long storyId) {
        this.storyId = storyId;
    }

    public int getAmountOfComments() {
        return amountOfComments;
    }

    public void setAmountOfComments(int amountOfComments) {
        this.amountOfComments = amountOfComments;
    }
    
    

    
    
}


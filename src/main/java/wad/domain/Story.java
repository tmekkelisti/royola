/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
    
    @Temporal(TemporalType.DATE)
    private Date storyDateShort;
    
    @Lob
    @Column(length = 10000)
    @NotBlank
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
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

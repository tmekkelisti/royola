
package wad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class User extends AbstractPersistable<Long> {
    
    @NotBlank
    @Length(min = 3, max = 15)
    @Column(unique = true)
    private String username;
    @NotBlank
    @Length(min = 5, max = 20)
    private String password;
    
    
    
}

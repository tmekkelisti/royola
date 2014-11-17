
package wad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
public class User extends AbstractPersistable<Long> {
    
    @NotBlank
    @Length(min = 3, max = 15)
    @Column(unique = true)
    private String username;
    @NotBlank
    // ei vittu mä sanon @Length(min = 5, max = 20)
    private String password;
    
    @Column(unique = true)
    private String salt;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.salt = BCrypt.gensalt();
        this.password = BCrypt.hashpw(password, this.salt);
    }
    
    
    
}

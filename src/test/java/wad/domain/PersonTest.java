package wad.domain;


import javax.annotation.PostConstruct;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author teeyoshi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Person.class)
public class PersonTest {

    private Person person;

    @PostConstruct
    public void init() {
        person = new Person();
    }

    @Test
    public void setUsernameWorks() {
        final String username = "username";
        person.setUsername(username);
        assertEquals(username, person.getUsername());
    }

    @Test
    public void setSaltWorks() {
        final String salt = "salt";
        person.setSalt(salt);
        assertEquals(salt, person.getSalt());
    }

    @Test
    public void passwordNotEncrypted() {
        final String password = "password";
        person.setPassword(password);
        
        assertNotEquals(password, person.getPassword());
    }
    

}

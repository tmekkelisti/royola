/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import wad.Application;
import wad.domain.Person;

/**
 *
 * @author teeyoshi
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PersonRepositoryTest {
    
    @Autowired
    PersonRepository personRepo;
    
    @Test
    public void savePerson(){
        
        final String username = "username";
        final String password = "password";
        
        Person person = new Person();
        person.setUsername(username);
        person.setPassword(password);
        
        personRepo.save(person);
        
        Person dbPerson = personRepo.findOne(person.getId());
        assertNotNull(dbPerson);
        assertEquals(username, dbPerson.getUsername());
        
    }
    
    @Test
    public void findByUsername(){
        
        Person dbPerson = personRepo.findByUsername("username");
        assertNotNull(dbPerson);
        assertEquals("username", dbPerson.getUsername());
        
    }
    
}

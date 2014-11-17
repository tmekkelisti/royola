/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import wad.domain.User;
import wad.repository.UserRepository;

/**
 *
 * @author markolai
 */

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User getAuthenticatedPerson() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepo.findByUsername(authentication.getName());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Comment;

/**
 *
 * @author teeyoshi
 */

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}

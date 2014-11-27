///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package wad.repository;
//
//import javax.transaction.Transactional;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import wad.Application;
//import wad.domain.Comment;
//
//
///**
// *
// * @author teeyoshi
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = Application.class)
//@Transactional
//public class CommentRepositoryTest {
//    
//    @Autowired
//    CommentRepository commentRepo;
//    
//    @Test
//    public void insertTest(){
//        
//        final String author = "testi tyyppi";
//        final String commentContent = "tämä on kommentti";
//        
//        Comment comment = new Comment();
//        comment.setAuthor(author);
//        comment.setComment(commentContent);
//        
//        commentRepo.save(comment);
//        
//        Comment dbComment = commentRepo.findOne(comment.getCommentID());
//        assertNotNull(dbComment);
//        assertEquals(author, dbComment.getAuthor());
//        assertEquals(commentContent, dbComment.getComment());
//        
//    }
//   
//   
//}

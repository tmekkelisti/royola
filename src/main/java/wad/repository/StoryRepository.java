/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Story;

/**
 *
 * @author royola
 */
public interface StoryRepository extends JpaRepository<Story, Long> {
//    List<Story> findByName(String id);
}

package wad.profiles;

import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import wad.domain.Story;
import wad.repository.StoryRepository;

@Configuration
@Profile(value = {"dev", "default"})
public class DevProfile {

    @Autowired
    private StoryRepository storyRepository;

    @PostConstruct
    public void init() {
        Story firstStory = new Story();
        firstStory.setContent("Pikku testailua, jatkuu huomena");
        storyRepository.save(firstStory);

        for (int i = 0; i < 20; i++) {
            Story newStory = new Story();
            newStory.setContent(UUID.randomUUID().toString());
            storyRepository.save(newStory);
        }
    }
}

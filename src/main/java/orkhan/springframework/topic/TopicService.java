package orkhan.springframework.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics= new ArrayList<>(Arrays.asList(
            new Topic("1","Spring1","first topic"),
                new Topic("2","Spring2","second topic"),
                new Topic("3","Spring3","third topic")
        ));

    public List<Topic> getAllTopics(){

        List<Topic> topics=new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){

        return topicRepository.findById(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic,String id) {

        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {

        topicRepository.deleteById(id);
    }
}

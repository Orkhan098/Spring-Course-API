package orkhan.springframework.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import orkhan.springframework.topic.Topic;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id){
        return courseService.getAllCourses(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Optional<Course> getOneCourse(@PathVariable String id){
        return courseService.getOneCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course,@PathVariable String id,@PathVariable String topicId){
        course.setTopic(new Topic(topicId,"",""));
        courseService.updateCourse(course,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);
    }


}

package orkhan.springframework.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

//    private List<Course> courses =new ArrayList<>(Arrays.asList(
//            new Course("1","Course1","first Course"),
//            new Course("2","Course2","second Course"),
//            new Course("3","Course3","third Course")
//
//    ));

    public List<Course> getAllCourses(String topicId){
        List<Course> courses=new ArrayList<>();
        courseRepository.findByTopicId(topicId).forEach(courses::add);
        return courses;
    }

    public Optional<Course> getOneCourse(String id){
        return courseRepository.findById(id);
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course,String id){
        courseRepository.save(course);
    }

    public void deleteCourse(String id){
        courseRepository.deleteById(id);
    }



}

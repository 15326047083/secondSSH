import com.ambow.second.entity.Course;
import com.ambow.second.service.ICourseService;
import com.ambow.second.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class CourseTest {
    @Autowired
    private ICourseService iCourseService;
    @Test
    public void saveCourse(){
        Course course=new Course("ww","10","12","qew","3",1,2);
      iCourseService.addCourse(course);

    }
    @Test
     public void queryTeacherID(){


        System.out.print(iCourseService.queryTeacherById("2").toString());

    }
      @Test
    public void queryCourse(){
        System.out.print(iCourseService.queryCourse().toString());

    }
      @Test
    public void updateCourse(){
        Course course=new Course();
        course.setId("2");
        course.setAlive(1);
        iCourseService.updateCourse(course);
      }
      @Test
      public void deleteCourse(){
          Course course=new Course();

          iCourseService.deleteCourse("1");
      }
      @Test
      public void queryUser(){
          System.out.print(iCourseService.queryUser().toString());

      }


}

import com.ambow.second.entity.User;
import com.ambow.second.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 读取spring配置文件
 */
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class GuoweiTest {

    // 自动注入userService
    @Autowired
    private IUserService userService;

    @Test
    public void findUserById(){
        User user = new User();
        user.setId("4028abf064efab9f0164efaba1d80000");
        System.out.println(userService.findUserById(user));
    }
    @Test
    public void saveOrUpdate(){
        User user=new User();
        user.setId("4028abf064efab9f0164efaba1d80000");
        user.setName("test");
        System.out.println(userService.saveOrUpdate(user));
    }
    @Test
    public void delete(){
        User user=new User();
        user.setId("3");
        userService.delete(user);
    }
    @Test
    public void queryCheckVoAll(){
        System.out.println(userService.queryCheckVoAll());
    }

    @Test
    public void getByCheckVoId(){
        System.out.println(userService.getByCheckVoId("2"));
    }


}

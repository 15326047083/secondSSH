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
public class UserTest {
    // 自动注入userService
    @Autowired
    private IUserService userService;

    /**
     * 获取UserList
     */
    @Test
    public void getUserTest() {

        System.out.println(userService.queryAll().toString());


    }
}

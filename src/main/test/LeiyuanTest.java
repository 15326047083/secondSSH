import com.ambow.second.dao.IUserDao;
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
public class LeiyuanTest {

    @Autowired
    private IUserDao userService;

    @Test
    public void userSaveOrUpdateTest() {
        User user = new User("1", 2, "3", "4", "5", "6", "7", "8", "9", "0", "9", 1);
        userService.saveOrUpdate(user);
    }

    @Test
    public void userGetTest() {
        System.out.println(userService.get("4028abf064ef73ee0164ef73f11b0000"));
    }

    @Test
    public void userDeleteTest() {
        userService.delete("4028abf064ef73ee0164ef73f11b0000");
    }
}

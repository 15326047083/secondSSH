
import com.ambow.second.service.ICheckService;
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
public class CheckVoTest {
    @Autowired
    private ICheckService checkService;
    /**
     * 根据id测试check VO
     */
    @Test
    public void getByIdTest(){
        System.out.println(checkService.getByCheckVoId("2"));
    }
}

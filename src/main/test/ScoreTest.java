

import com.ambow.second.entity.Score;
import com.ambow.second.service.IScoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Table;

        /**
        * 读取spring配置文件
        */
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class ScoreTest {

    @Autowired
    private IScoreService scoreService;

            /**
             *添加成绩
             */
    @Test
    public  void  saveScoreTest(){
        Score score= new Score("3","3","89","999");
        score.setId("2c87b4f664f05b1c0164f05b25cb0000");
        System.out.print(scoreService.saveorUpdateScore(score));
    }

            /**
             * 根据ID查询
             */
    @Test
            public  void  getScoreById(){
        System.out.print(scoreService.getScoreById("2c87b4f664f0016e0164f0017a610000").toString());
    }
    @Test
            public void deleteById(){
        scoreService.deleteScore("2c87b4f664f0016e0164f0017a610000");
    }



            /**
             * 全查
             */
@Test
            public  void getAll(){
                System.out.print(scoreService.getAll().toString());
            }
        }
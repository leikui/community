package club.oyyo.community.serviceTest;

import club.oyyo.community.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @ClassName: QuestionServiceTest
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-30 15:56
 * @Version: 1.0
 */
@SpringBootTest
public class QuestionServiceTest {
    @Autowired
    QuestionService questionService;

    @Test
    public void questionVOTest(){
        Integer pageNum = 1;

    }

}
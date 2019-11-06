package club.oyyo.community.service.impl;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.entity.Question;
import club.oyyo.community.mapper.QuestionMapper;
import club.oyyo.community.service.QuestionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: QuestionServiceImpl
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-29 10:54
 * @Version: 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Value("${pagehelper.page-size}")
    Integer size;

    @Autowired
    QuestionMapper questionMapper;

    /**
     * 插入问题
     *
     * @param question
     * @return
     */
    @Override
    public void insertQuestion(Question question) {
        Integer result = questionMapper.insertQuestion(question);
        if (result != 1) {
            System.out.println("插入失败！！");
        }
    }

    /**
     * 查询问题列表
     *
     * @return
     */
    @Override
    public PageInfo<QuestionVo> questionsList(Integer pageNum) {
        if (pageNum == null || "".equals(pageNum)) {
            pageNum = 1;
        }
        PageHelper.startPage(pageNum, size);
        List<QuestionVo> questionVos = questionMapper.questionsList(pageNum);
        PageInfo<QuestionVo> pageInfo = new PageInfo<>(questionVos);
        System.out.println("questionVos" + pageInfo);
        return pageInfo;

    }

    /**
     * 根据问题id  查询问题详情
     *
     * @param id
     * @return
     */
    @Override
    public QuestionVo findById(Integer id) {
        QuestionVo questionDetails = questionMapper.findById(id);
        return questionDetails;
    }
}
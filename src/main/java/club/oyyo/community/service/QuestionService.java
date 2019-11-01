package club.oyyo.community.service;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.entity.Question;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: QuestionService
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-29 10:53
 * @Version: 1.0
 */
public interface QuestionService {

    /**
     * 插入问题
     * @return
     */
    void insertQuestion(Question question);

    /**
     * 查询问题列表
     * @param pageNum 当前页码
     * @return
     */
    PageInfo<QuestionVo> questionsList(Integer pageNum);
}
package club.oyyo.community.mapper;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.entity.Question;

import java.util.List;

/**
 * @ClassName: QuestionMapper
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-29 10:39
 * @Version: 1.0
 */
public interface QuestionMapper {
    /**
     * 插入问题
     * @return
     */
    Integer insertQuestion(Question question);

    /**
     * 查询问题列表
     * @return
     */
    List<QuestionVo> questionsList(Integer pageNum);

}
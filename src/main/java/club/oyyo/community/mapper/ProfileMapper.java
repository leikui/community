package club.oyyo.community.mapper;

import club.oyyo.community.VO.QuestionVo;

import java.util.List;

/**
 * @ClassName: ProfileMapper
 * @Description: TODO 个人相关问题
 * @Author: LiKui
 * @Date: 2019-11-4 16:01
 * @Version: 1.0
 */

public interface ProfileMapper {

    /**
     * 个人问题列表
     * @param pageNum
     * @return
     */
    List<QuestionVo> userQusList(String accountId,Integer pageNum);

}
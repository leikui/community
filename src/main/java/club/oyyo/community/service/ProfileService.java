package club.oyyo.community.service;

import club.oyyo.community.VO.QuestionVo;
import com.github.pagehelper.PageInfo;

public interface ProfileService {

    /**
     * 查询问题列表
     * @param pageNum 当前页码
     * @return
     */
    PageInfo<QuestionVo> userQusList(String accountId,Integer pageNum);
}

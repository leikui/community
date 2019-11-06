package club.oyyo.community.service.impl;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.mapper.ProfileMapper;
import club.oyyo.community.service.ProfileService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: ProfileServiceImpl
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-11-4 16:03
 * @Version: 1.0
 */
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private ProfileMapper profileMapper;

    /**
     * 查询问题列表
     *
     * @param pageNum 当前页码
     * @return
     */
    @Override
    public PageInfo<QuestionVo> userQusList(String accountId, Integer pageNum) {
        if (pageNum == null || "".equals(pageNum)) {
            pageNum = 1;
        }
        List<QuestionVo> userQus = profileMapper.userQusList(accountId, pageNum);
        PageInfo<QuestionVo> pageInfo = new PageInfo<>(userQus);
        System.out.println("pageInfo..." + pageInfo);
        return pageInfo;
    }
}
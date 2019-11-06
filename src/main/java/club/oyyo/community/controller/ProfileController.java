package club.oyyo.community.controller;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.service.ProfileService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName: ProfileController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-11-3 11:36
 * @Version: 1.0
 */
@Controller
@RequestMapping("oyyo")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("profile/{lable}")
    public String profile(@PathVariable("lable") String action,
                          @RequestParam("userId") String userId,
                          @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                          Model model) {
        PageInfo<QuestionVo> userQusPageInfo = profileService.userQusList(userId, pageNum);

        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
            model.addAttribute("userQusList",userQusPageInfo);
        }
        return "profile";
    }
}
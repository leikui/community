package club.oyyo.community.controller;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.entity.User;
import club.oyyo.community.service.QuestionService;
import club.oyyo.community.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 15:02
 * @Version: 1.0
 */
@Controller
@RequestMapping("oyyo")
public class IndexController {

    @Autowired
    UserService userService;
    @Autowired
    QuestionService questionService;

    @GetMapping("")
    public String index(HttpServletRequest request, Model model,
                        @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum){
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            System.out.println("cookies为空");
            return "index";
        }
        for (Cookie cookie : cookies) {
            if ("token".equals(cookie.getName())){
                String token = cookie.getValue();
                User user = userService.findByToken(token);
                if (user != null) {
                    request.getSession().setAttribute("user",user);
                    System.out.println(user);
                }
                break;
            }

        }

        PageInfo<QuestionVo> questionVos = questionService.questionsList(pageNum);
        model.addAttribute("questionVos" ,questionVos);
        return "index";
    }
}
package club.oyyo.community.controller;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.entity.Question;
import club.oyyo.community.entity.User;
import club.oyyo.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;

/**
 * @ClassName: PublishController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-28 15:32
 * @Version: 1.0
 */
@Controller
@RequestMapping("oyyo")
public class PublishController {

    @Autowired
    QuestionService questionService;

    @GetMapping("publish")
    public String publish(@RequestParam("id") Integer id,Model model) {
        if (id != null) {
            QuestionVo question = questionService.findById(id);
            model.addAttribute("question",question);
            return "publish";
        }
        return "publish";
    }

    @PostMapping("publish")
    public String doPublish(@RequestParam("title") String title,
                            @RequestParam("description") String description,
                            @RequestParam("tag") String tag,
                            HttpServletRequest request, Model model) {

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录，请重新登录！");
            System.out.println("error.....");
            return "publish";
        }
        if (title == null || "".equals(title)) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || "".equals(description)) {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag == null || "".equals(tag)) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTags(tag);
        question.setCreatorId(user.getAccountId());
        question.setGmtCreate(Calendar.getInstance().getTimeInMillis());
        question.setGmtModified(question.getGmtCreate());

        questionService.insertQuestion(question);
        return "redirect:/oyyo";
    }

}
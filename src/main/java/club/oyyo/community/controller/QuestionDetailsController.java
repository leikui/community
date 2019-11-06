package club.oyyo.community.controller;

import club.oyyo.community.VO.QuestionVo;
import club.oyyo.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: QuestionDetailsController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-11-5 14:40
 * @Version: 1.0
 */

@Controller
@RequestMapping("oyyo")
public class QuestionDetailsController {

    @Autowired
    private QuestionService questionService;


    @GetMapping("/questions/{id}")
    public String findQuestionById(@PathVariable("id") Integer id,
                                   Model model){
        QuestionVo questionDetails = questionService.findById(id);
        model.addAttribute("questionDetails",questionDetails);

        return "questionDetails";
    }
}
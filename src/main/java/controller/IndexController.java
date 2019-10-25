package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName: IndexController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 15:02
 * @Version: 1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
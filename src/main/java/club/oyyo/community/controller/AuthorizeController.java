package club.oyyo.community.controller;

import club.oyyo.community.entity.AccesToken;
import club.oyyo.community.entity.GithubUser;
import club.oyyo.community.entity.User;
import club.oyyo.community.provider.GithubProvider;
import club.oyyo.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @ClassName: AuthorizeController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 15:48
 * @Version: 1.0
 */

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.client.redirectUri}")
    private String clientRedirectUri;

    @GetMapping("callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request){
        AccesToken accesToken = new AccesToken();
        accesToken.setCode(code);
        accesToken.setState(state);
        accesToken.setClient_secret(clientSecret);
        accesToken.setClient_id(clientId);
        accesToken.setRedirect_uri(clientRedirectUri);
        String accessToken = githubProvider.getAccessToken(accesToken);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            //登录成功 写入cookie和session
            request.getSession().setAttribute("user",githubUser);
            User user = new User();
            user.setName(githubUser.getName());
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setToken(UUID.randomUUID().toString());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());

            userService.addUser(user);
            return "redirect:/";
        }else {
            //登录失败
            return "redirect:/";

        }
    }
}
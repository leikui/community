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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.UUID;

/**
 * @ClassName: AuthorizeController
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 15:48
 * @Version: 1.0
 */

@Controller
@RequestMapping("oyyo")
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
                           HttpServletRequest request,
                           HttpServletResponse response){
        AccesToken accesToken = new AccesToken();
        accesToken.setCode(code);
        accesToken.setState(state);
        accesToken.setClient_secret(clientSecret);
        accesToken.setClient_id(clientId);
        accesToken.setRedirect_uri(clientRedirectUri);
        String accessToken = githubProvider.getAccessToken(accesToken);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null && githubUser.getId() != null) {
            User user = new User();
            user.setName(githubUser.getName());
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setAvatarUrl(githubUser.getAvatarUrl());
            user.setBio(githubUser.getBio());
            user.setGmtCreate(Calendar.getInstance().getTimeInMillis());
            user.setGmtModified(user.getGmtCreate());
            userService.addUser(user);
            //登录成功 写入cookie和session
            response.addCookie(new Cookie("token",token));

            return "redirect:/oyyo";
        }else {
            //登录失败
            return "redirect:/oyyo";

        }
    }
}
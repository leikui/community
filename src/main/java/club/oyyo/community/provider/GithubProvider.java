package club.oyyo.community.provider;

import club.oyyo.community.entity.AccesToken;
import club.oyyo.community.entity.GithubUser;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName: GithubProvider
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 15:54
 * @Version: 1.0
 */
@Component
public class GithubProvider {

    public String getAccessToken(AccesToken accessToken){
        MediaType mediaType
                = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessToken));
        Request request = new Request.Builder().url("https://github.com/login/oauth/access_token").post(body).build();
            try (Response response = client.newCall(request).execute()) {
                String res = response.body().string();
                String token = res.split("&")[0].split("=")[1];
                System.out.println("res...." + token);
                return token;
        } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    public GithubUser getUser(String accessToken){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String str = response.body().string();
            GithubUser githubUser = JSON.parseObject(str, GithubUser.class);
            System.out.println(githubUser.getName());
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
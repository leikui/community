package club.oyyo.community.entity;

import lombok.Data;

/**
 * @ClassName: GithubUser
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 16:21
 * @Version: 1.0
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}
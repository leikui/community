package club.oyyo.community.entity;

import lombok.Data;

/**
 * @ClassName: User
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-28 10:32
 * @Version: 1.0
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private String bio;
    private String avatarUrl;
    private Long gmtCreate;
    private Long gmtModified;

}
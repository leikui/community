package club.oyyo.community.entity;

import lombok.Data;

/**
 * @ClassName: AccesToken
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-25 15:56
 * @Version: 1.0
 */
@Data
public class AccesToken {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
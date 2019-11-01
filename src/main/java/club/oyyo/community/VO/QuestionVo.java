package club.oyyo.community.VO;

import club.oyyo.community.entity.User;
import lombok.Data;

/**
 * @ClassName: QuestionVo
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-30 15:00
 * @Version: 1.0
 */
@Data
public class QuestionVo {
    private Integer id;
    private String title;
    private String description;
    private Integer creatorId;
    private Integer commentNum;
    private Integer viewNum;
    private Integer likeNum;
    private String tags;
    private Long gmtCreate;
    private Long gmtModified;
    private User user;
}
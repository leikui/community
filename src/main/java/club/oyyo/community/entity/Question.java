package club.oyyo.community.entity;

import lombok.Data;

/**
 * @ClassName: Question
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-29 10:49
 * @Version: 1.0
 */
@Data
public class Question {
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

}
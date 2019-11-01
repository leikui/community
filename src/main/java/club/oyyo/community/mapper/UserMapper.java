package club.oyyo.community.mapper;

import club.oyyo.community.entity.User;

/**
 * @ClassName: mapper
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-28 10:30
 * @Version: 1.0
 */
public interface UserMapper {

    /**
     * 插入用户
     * @param user
     * @return
     */
    Integer addUser(User user);

    /**
     * 根据 token 查询 用户信息
     * @param token
     * @return
     */
    User findByToken(String token);

}
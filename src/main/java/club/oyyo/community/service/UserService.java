package club.oyyo.community.service;

import club.oyyo.community.entity.User;

/**
 * @ClassName: service
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-28 10:49
 * @Version: 1.0
 */
public interface UserService {

    /**
     * 插入用户
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 根据 token 查询 用户信息
     * @param token
     * @return
     */
    User findByToken(String token);
}
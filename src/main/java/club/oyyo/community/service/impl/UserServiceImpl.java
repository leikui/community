package club.oyyo.community.service.impl;

import club.oyyo.community.entity.User;
import club.oyyo.community.mapper.UserMapper;
import club.oyyo.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: serviceImpl
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-28 10:50
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 插入用户
     *
     * @param user
     * @return
     */
    @Override
    public void addUser(User user) {
        Integer result = userMapper.addUser(user);
        if (result != 1) {
            System.out.println("插入失败");
        }
    }

    @Override
    public User findByToken(String token) {
        return userMapper.findByToken(token);
    }

    /**
     * 根据 token 查询 用户信息
     *
     * @param id
     * @return User
     */
    @Override
    public User findByGithubId(Long id) {
        return userMapper.findByGithubId(id);
    }

    /**
     * 更新用户信息
     *
     * @param accountId@return User
     */
    @Override
    public void updateUserInfo(User accountId) {
        userMapper.updateUserInfo(accountId);
    }
}
package club.oyyo.community.DemoTest;

import club.oyyo.community.entity.User;

/**
 * @ClassName: test
 * @Description: TODO
 * @Author: LiKui
 * @Date: 2019-10-28 11:45
 * @Version: 1.0
 */
public class test {
    public static void main(String[] args) {
        User user = new User();
        user.setGmtCreate(System.currentTimeMillis());
        user.setGmtModified(user.getGmtCreate());
        System.out.println(user.getGmtModified());
    }
}
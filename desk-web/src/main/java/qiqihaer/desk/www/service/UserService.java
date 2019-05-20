package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entity.User;

public interface UserService {
    /*
        用户注册
         */
    int regist(User user);
    /*
    用户登陆
     */
    User login(String userid,String pw);
    /*
    根据学生id查询
     */
    User findById(String userid);

    /**
     * 更新user对象
     */
    int updateU(User user);

    User findUserbyPrimaryKey(int id);
}

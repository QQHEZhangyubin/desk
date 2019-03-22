package qiqihaer.desk.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.UserMapper;
import qiqihaer.desk.www.entity.User;
import qiqihaer.desk.www.service.UserService;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int regist(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User login(String userid,String pw) {
        User user = new User();
        user.setUserid(userid);
        user.setPassword(pw);
        return userMapper.selectOne(user);
    }

    @Override
    public User findById(String userid) {
        User user = new User();
        user.setUserid(userid);
        return userMapper.selectOne(user);
    }

    @Override
    public int updateU(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}

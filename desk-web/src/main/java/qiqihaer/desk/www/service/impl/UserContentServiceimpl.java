package qiqihaer.desk.www.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.UserContentMapper;
import qiqihaer.desk.www.entity.UserContent;
import qiqihaer.desk.www.service.UserContentService;

import java.util.List;

@Service
public class UserContentServiceimpl implements UserContentService {
    @Autowired
    private UserContentMapper userContentMapper;
    @Override
    public List<UserContent> PullDownAll() {
        UserContent userContent = new UserContent();
        RowBounds rowBounds = new RowBounds(1,100);
        List<UserContent> userContents = userContentMapper.selectByRowBounds(userContent,rowBounds );
        return userContents;
    }

    @Override
    public int AddShuoShuo(UserContent userContent) {
        return userContentMapper.insert(userContent);
    }
}

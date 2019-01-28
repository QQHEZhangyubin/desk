package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entity.UserContent;

import java.util.List;

public interface UserContentService {

    //请求所有说说数据
    List<UserContent> PullDownAll();
    //插入一条新说说
    int AddShuoShuo(UserContent userContent);
}

package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entity.Comment;
import qiqihaer.desk.www.entity.Reply;
import qiqihaer.desk.www.entity.UserContent;

import java.util.Date;
import java.util.List;

public interface UserContentService {

    //请求所有说说数据
    List<UserContent> PullDownAll();
    //插入一条新说说
    int AddShuoShuo(UserContent userContent);

    //请求一条说说下的所有评论数据
    List<Comment> PullThis(UserContent userContent);

    //得到一条评论下的所有回复
    List<Reply> PullThese(Comment comment);

    //得到一条说说的具体发布时间
    Date GetCreateDate(UserContent userContent);
}

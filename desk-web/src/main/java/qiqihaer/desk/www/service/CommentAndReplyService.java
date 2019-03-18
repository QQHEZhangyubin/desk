package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entity.Comment;
import qiqihaer.desk.www.entity.Reply;

public interface CommentAndReplyService {

    //插入一条评论

    int Insert_One_Comment(Comment comment);

    //插入一条回复
    int Inssert_One_Reply(Reply reply);

}

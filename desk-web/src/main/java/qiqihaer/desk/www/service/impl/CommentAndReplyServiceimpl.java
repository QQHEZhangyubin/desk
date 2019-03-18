package qiqihaer.desk.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.CommentMapper;
import qiqihaer.desk.www.dao.ReplyMapper;
import qiqihaer.desk.www.entity.Comment;
import qiqihaer.desk.www.entity.Reply;
import qiqihaer.desk.www.service.CommentAndReplyService;

@Service
public class CommentAndReplyServiceimpl implements CommentAndReplyService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public int Insert_One_Comment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int Inssert_One_Reply(Reply reply) {
        return replyMapper.insert(reply);
    }
}

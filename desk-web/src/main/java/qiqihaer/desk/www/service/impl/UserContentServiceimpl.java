package qiqihaer.desk.www.service.impl;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.CommentMapper;
import qiqihaer.desk.www.dao.ReplyMapper;
import qiqihaer.desk.www.dao.UserContentMapper;
import qiqihaer.desk.www.entity.Comment;
import qiqihaer.desk.www.entity.Reply;
import qiqihaer.desk.www.entity.UserContent;
import qiqihaer.desk.www.service.UserContentService;

import java.util.Date;
import java.util.List;

@Service
public class UserContentServiceimpl implements UserContentService {
    @Autowired
    private UserContentMapper userContentMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ReplyMapper replyMapper;
    @Override
    public List<UserContent> PullDownAll() {
        UserContent userContent = new UserContent();
        RowBounds rowBounds = new RowBounds(0,100);
        List<UserContent> userContents = userContentMapper.selectByRowBounds(userContent,rowBounds );
        return userContents;
    }

    @Override
    public int AddShuoShuo(UserContent userContent) {
        return userContentMapper.insert(userContent);
    }

    @Override
    public List<Comment> PullThis(UserContent userContent) {
        //请求一条说说下的所有评论数据
        Long content_id = userContent.getIduserContent();//得到该说说的标识
        Comment comment = new Comment();
        comment.setComId(content_id);
        List<Comment> t = commentMapper.select(comment);
        return t;
    }

    @Override
    public List<Reply> PullThese(Comment comment) {
        //得到一条评论下的所有回复
        Integer c_id = comment.getId();//得到该评论的标识
        Reply reply = new Reply();
        reply.setReplyComId(c_id);
        List<Reply> t1 = replyMapper.select(reply);
        return t1;
    }

    @Override
    public Date GetCreateDate(UserContent userContent) {

      return userContentMapper.selectOne(userContent).getContentDate();
    }
}

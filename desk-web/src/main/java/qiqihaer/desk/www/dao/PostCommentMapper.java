package qiqihaer.desk.www.dao;


import qiqihaer.desk.www.entitytmp.PostComment;
import tk.mybatis.mapper.common.Mapper;

public interface PostCommentMapper extends Mapper<PostComment> {
    int deleteByPrimaryKey(Integer id);

    int insert(PostComment record);

    int insertSelective(PostComment record);

    PostComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostComment record);

    int updateByPrimaryKey(PostComment record);
}
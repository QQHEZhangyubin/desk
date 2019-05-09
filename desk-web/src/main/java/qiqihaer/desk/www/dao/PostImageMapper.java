package qiqihaer.desk.www.dao;



import qiqihaer.desk.www.entitytmp.PostImage;
import tk.mybatis.mapper.common.Mapper;

public interface PostImageMapper extends Mapper<PostImage> {
    int deleteByPrimaryKey(Integer id);

    int insert(PostImage record);

    int insertSelective(PostImage record);

    PostImage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostImage record);

    int updateByPrimaryKey(PostImage record);
}
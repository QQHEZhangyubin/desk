package qiqihaer.desk.www.dao;


import qiqihaer.desk.www.entitytmp.PostFavort;
import tk.mybatis.mapper.common.Mapper;

public interface PostFavortMapper extends Mapper<PostFavort> {
    int deleteByPrimaryKey(Integer id);

    int insert(PostFavort record);

    int insertSelective(PostFavort record);

    PostFavort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PostFavort record);

    int updateByPrimaryKey(PostFavort record);
}
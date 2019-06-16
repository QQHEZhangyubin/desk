package qiqihaer.desk.www.dao;


import qiqihaer.desk.www.entitytmp.Post;
import qiqihaer.desk.www.entitytmp.PostImage;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface PostMapper extends Mapper<Post> {

    List<PostImage> select(Example example);
}
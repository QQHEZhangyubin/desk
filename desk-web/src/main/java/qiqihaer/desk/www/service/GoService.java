package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entitytmp.Post;

import java.util.List;

public interface GoService {
    List<Post> QueryPost(int pageIndex, int pageSize);
}

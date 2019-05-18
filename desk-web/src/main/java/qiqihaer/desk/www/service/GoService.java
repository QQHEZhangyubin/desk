package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entitytmp.Post;

import java.util.List;

public interface GoService {
    List<Post> QueryPost(int pageIndex, int pageSize);

    int InsertVideoPost(Post post);

    Post QueryOneVideoPost(Post post);

    void InsertImagePost(int authorId,List<String> images);

    Post QueryOneImagePost(Post post);

    Post QueryNoImagePost(Post post);

    int FindPostId(Post post);
}

package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entitytmp.Post;
import qiqihaer.desk.www.entitytmp.PostComment;
import qiqihaer.desk.www.entitytmp.PostFavort;

import java.util.List;

public interface GoService {
    List<Post> QueryPost(int pageIndex, int pageSize);

    int InsertVideoPost(Post post);

    Post QueryOneVideoPost(Post post);

    void InsertImagePost(int authorId,List<String> images);

    Post QueryOneImagePost(Post post);

    Post QueryNoImagePost(Post post);

    int FindPostId(Post post);

    int InsertFavort(PostFavort postFavort);
    int ReturnFavortId(PostFavort postFavort);

    Post FindPostbyPrimaryKey(int postid);

    int DeleteFavort(PostFavort postFavort);


    int InsertPostComment(PostComment postComment);
    PostComment ReturnCommentLastOne();

    int DeleteComment(int commentId);

    int DeletePost(Post post);

}

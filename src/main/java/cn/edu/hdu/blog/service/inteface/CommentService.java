package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.entity.dto.Comment;
import cn.edu.hdu.blog.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService extends BaseService<Comment,Integer> {

    Page<Comment> getByArticleId(Integer articleId, Pageable pageable);
}

package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Long countAllByArticleId(Integer articleId);
    Page<Comment> findAllByArticleIdOrderByCreateTimeDesc(Integer articleId, Pageable pageable);
}

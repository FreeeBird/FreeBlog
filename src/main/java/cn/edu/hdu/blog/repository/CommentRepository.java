package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

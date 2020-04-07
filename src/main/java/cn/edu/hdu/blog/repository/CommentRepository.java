package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Comment;
import cn.edu.hdu.blog.entity.vo.CommentSysVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    Long countAllByArticleId(Integer articleId);
    Page<Comment> findAllByArticleIdOrderByCreateTimeDesc(Integer articleId, Pageable pageable);


    @Query("select new cn.edu.hdu.blog.entity.vo.CommentSysVo(c.id,c.articleId,a.title,c.nickname,c.email,c.content,c.parentId,c.createTime) " +
            "from Comment c join Article a on c.articleId=a.id order by c.createTime desc")
    Page<CommentSysVo> getCommentSysVoOrderByCreateTimeDesc(Pageable pageable);
}

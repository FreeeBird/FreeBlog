package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Comment;
import cn.edu.hdu.blog.entity.vo.CommentSysVo;
import cn.edu.hdu.blog.repository.ArticleHeatRepository;
import cn.edu.hdu.blog.repository.CommentRepository;
import cn.edu.hdu.blog.service.inteface.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private ArticleHeatRepository articleHeatRepository;
    @Override
    public Comment saveOne(Comment comment) {
        articleHeatRepository.increaseComment(comment.getArticleId());
        return commentRepository.save(comment);
    }

    @Transactional
    @Override
    public Boolean deleteById(Integer integer) {
        articleHeatRepository.deComment(commentRepository.getOne(integer).getArticleId());
        commentRepository.deleteById(integer);
        return !commentRepository.existsById(integer);
    }

    @Override
    public Comment getOne(Integer integer) {
        return commentRepository.getOne(integer);
    }

    @Override
    public Page<Comment> getAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return commentRepository.count();
    }

    @Override
    public Page<Comment> getByArticleId(Integer articleId, Pageable pageable) {
        return commentRepository.findAllByArticleIdOrderByCreateTimeDesc(articleId,pageable);
    }

    @Override
    public Page<CommentSysVo> getAllCommentSysVo(Pageable pageable) {
        return commentRepository.getCommentSysVoOrderByCreateTimeDesc(pageable);
    }
}

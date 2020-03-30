package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Comment;
import cn.edu.hdu.blog.repository.CommentRepository;
import cn.edu.hdu.blog.service.inteface.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment saveOne(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Boolean deleteById(Integer integer) {
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
}

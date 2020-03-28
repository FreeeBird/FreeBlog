package cn.edu.hdu.blog.service.impl;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.repository.BloggerRepository;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    BloggerRepository bloggerRepository;


    @Override
    public Blogger saveOne(Blogger blogger) {
        return bloggerRepository.save(blogger);
    }

    @Override
    public Boolean deleteById(Integer id) {
        bloggerRepository.deleteById(id);
        return !bloggerRepository.existsById(id);
    }


    @Override
    public Blogger getOne(Integer id) {
        return bloggerRepository.getOne(id);
    }


    @Override
    public Page<Blogger> getAll(Pageable pageable) {
        return bloggerRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return bloggerRepository.count();
    }

    @Override
    public Blogger getByUsernameAndPassword(String username, String password) {
        return bloggerRepository.findByUsernameAndPassword(username,password);
    }

    @Override
    public Blogger getByEmail(String email) {
        return bloggerRepository.findByEmail(email);
    }

    @Override
    public Blogger getByPassword(String password) {
        return bloggerRepository.findByPassword(password);
    }

    @Override
    public Blogger findFirst() {
        return bloggerRepository.findFirstBy();
    }
}

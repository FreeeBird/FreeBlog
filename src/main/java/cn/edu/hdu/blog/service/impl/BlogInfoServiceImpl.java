package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.BlogInfo;
import cn.edu.hdu.blog.repository.BlogInfoRepository;
import cn.edu.hdu.blog.service.inteface.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BlogInfoServiceImpl implements BlogInfoService {

    @Autowired
    BlogInfoRepository blogInfoRepository;


    @Override
    public BlogInfo saveOne(BlogInfo blogInfo) {
        return blogInfoRepository.save(blogInfo);
    }

    @Override
    public Boolean deleteById(Integer id) {
        blogInfoRepository.deleteById(id);
        return !blogInfoRepository.existsById(id);
    }


    @Override
    public BlogInfo getOne(Integer id) {
        return blogInfoRepository.getOne(id);
    }


    @Override
    public Page<BlogInfo> getAll(Pageable pageable) {
        return blogInfoRepository.findAll(pageable);
    }


    @Override
    public Long count() {
        return blogInfoRepository.count();
    }

    @Override
    public BlogInfo findFirst() {
        return blogInfoRepository.findFirstBy();
    }
}

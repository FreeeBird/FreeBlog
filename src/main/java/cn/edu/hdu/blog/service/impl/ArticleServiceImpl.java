package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.repository.ArticleRepository;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Boolean deleteById(Integer id) {
        articleRepository.deleteById(id);
        return !articleRepository.existsById(id);
    }

    @Override
    public Article saveOne(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getOne(Integer id) {
        return articleRepository.getOne(id);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }

    @Override
    public Page<Article> getAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public List<Article> getAll(Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum-1,pageSize);
        return articleRepository.findAll(pageable).getContent();
    }

    @Override
    public Integer count() {
        return Long.valueOf(articleRepository.count()).intValue();
    }


}

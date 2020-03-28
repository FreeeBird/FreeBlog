package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.enums.ArticleStatus;
import cn.edu.hdu.blog.entity.vo.SimpleArticle;
import cn.edu.hdu.blog.repository.ArticleRepository;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleServiceImpl  {
//    @Autowired
//    private ArticleRepository articleRepository;
//
//    @Override
//    public List<Article> getPublicArticles(Pageable pageable) {
//        return articleRepository.findAllByStatus(ArticleStatus.PUBLIC.getCode(),pageable);
//    }
//
//    @Override
//    public List<Article> getPrivateArticles(Pageable pageable) {
//        return articleRepository.findAllByStatus(ArticleStatus.PRIVATE.getCode(),pageable);
//    }
//
//    @Override
//    public List<Article> getDraftArticles(Pageable pageable) {
//        return articleRepository.findAllByStatus(ArticleStatus.DRAFT.getCode(),pageable);
//    }
//
//    @Override
//    public List<SimpleArticle> getPublicArticleList(Pageable pageable) {
//        return articleRepository.findArticleListByStatus(ArticleStatus.PUBLIC.getCode(),pageable);
//    }
//
//    @Override
//    public List<SimpleArticle> getTopNumPublicOrderByHitsDesc(Integer num) {
//        Pageable pageable = PageRequest.of(0,num);
//        return articleRepository.findArticleListOrderByHitsDesc(ArticleStatus.PUBLIC.getCode(),pageable);
//    }
//
//    @Override
//    public List<SimpleArticle> getTopNumPublicOrderByCreateTimeDesc(Integer num) {
//        Pageable pageable = PageRequest.of(0,num);
//        return articleRepository.findArticleListOrderByCreateTimeDesc(ArticleStatus.PUBLIC.getCode(),pageable);
//    }
//
//    @Override
//    public List<SimpleArticle> getArticleListByCategory(Integer categoryId, Pageable pageable) {
//        return articleRepository.findArticleListByCategoryId(categoryId,pageable);
//    }
//
//    @Override
//    @Transactional
//    public Article saveOne(Article article) {
//        return articleRepository.saveAndFlush(article);
//    }
//
//    @Override
//    @Transactional
//    public Boolean deleteById(Integer id) {
//        articleRepository.deleteById(id);
//        return !articleRepository.existsById(id);
//    }
//
//    @Override
//    public Integer deleteByIds(Integer... ids) {
//        List<Integer> list = Arrays.asList(ids);
//        return null;
//    }
//
//    @Override
//    public Article getOne(Integer id) {
//        return articleRepository.getOne(id);
//    }
//
//    @Override
//    public List<Article> getAll() {
//        return articleRepository.findAll();
//    }
//
//    @Override
//    public Page<Article> getAll(Pageable pageable) {
//        return articleRepository.findAll(pageable);
//    }
//
//    @Override
//    public List<Article> getAll(Integer pageNum, Integer pageSize) {
//        Pageable pageable = PageRequest.of(pageNum,pageSize);
//        return articleRepository.findAll(pageable).getContent();
//    }
//
//    @Override
//    public Integer count() {
//        return articleRepository.countAllByStatus(ArticleStatus.PUBLIC.getCode());
//    }
}

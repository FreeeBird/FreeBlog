package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.enums.ArticleStatus;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import cn.edu.hdu.blog.repository.ArticleRepository;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;


    @Override
    public Page<ArticleVo> getPublicArticleVoList(Pageable pageable) {
        return articleRepository.findArticleVoListByStatus(ArticleStatus.PUBLIC.getCode(),pageable);
    }

    @Override
    public Page<ArticleVo> getDraftArticleVoList(Pageable pageable) {
        return articleRepository.findArticleVoListByStatus(ArticleStatus.DRAFT.getCode(),pageable);
    }

    @Override
    public List<Article> getPublicArticles(Pageable pageable) {
        return null;
    }

    @Override
    public List<Article> getPrivateArticles(Pageable pageable) {
        return null;
    }

    @Override
    public List<Article> getDraftArticles(Pageable pageable) {
        return null;
    }

    @Override
    public List<ArticleWithCountVo> getPublicArticleList(Pageable pageable) {
        return null;
    }

    @Override
    public List<ArticleWithCountVo> getTopNumPublicOrderByHitsDesc(Integer num) {
        return null;
    }

    @Override
    public List<ArticleWithCountVo> getTopNumPublicOrderByCreateTimeDesc(Integer num) {
        return null;
    }

    @Override
    public List<ArticleWithCountVo> getArticleListByCategory(Integer categoryId, Pageable pageable) {
        return null;
    }

    @Override
    public Article saveOne(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Boolean deleteById(Integer integer) {
        articleRepository.deleteById(integer);
        return !articleRepository.existsById(integer);
    }

    @Override
    public Article getOne(Integer integer) {
        return articleRepository.getOne(integer);
    }

    @Override
    public Page<Article> getAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return articleRepository.count();
    }
}

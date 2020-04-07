package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.dto.ArticleHeat;
import cn.edu.hdu.blog.entity.enums.ArticleStatus;
import cn.edu.hdu.blog.entity.vo.ArchiveVo;
import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import cn.edu.hdu.blog.repository.ArticleHeatRepository;
import cn.edu.hdu.blog.repository.ArticleRepository;
import cn.edu.hdu.blog.repository.CategoryRepository;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleHeatRepository heatRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ArticleDetailVo getArticleById(Integer id) {
        heatRepository.increaseHits(id);
        return articleRepository.findByIdAndStatus(id,ArticleStatus.PUBLIC.getCode());
    }

    @Override
    public Page<ArticleWithCountVo> getArticleWithCountVoList(Pageable pageable) {
        return articleRepository.findArticleWithCountVoListByStatusOrderByCreateTime(ArticleStatus.PUBLIC.getCode(),pageable);
    }

    @Override
    public Page<ArticleWithCountVo> getArticleWithCountVoListByCategory(Integer categoryId, Pageable pageable) {
        return articleRepository.findArticleWithCountVoListByStatusAndCategoryId(
                ArticleStatus.PUBLIC.getCode(),categoryId,pageable
        );
    }

    @Override
    public Page<ArticleWithCountVo> getHeatArticleWithCountVoList(Integer num) {
        Pageable pageable = PageRequest.of(0,num);
        return articleRepository.findArticleWithCountVoListByStatusOrderByHits(ArticleStatus.PUBLIC.getCode(),pageable);
    }

    @Override
    public Page<ArticleWithCountVo> getNewestArticleWithCountVoList(Integer num) {
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = PageRequest.of(0,num,sort);
        return articleRepository.findArticleWithCountVoListByStatus(ArticleStatus.PUBLIC.getCode(),pageable);
    }

    @Override
    public Page<ArticleWithCountVo> getDraftWithCountVoList(Pageable pageable) {
        return articleRepository.findArticleWithCountVoListByStatus(ArticleStatus.DRAFT.getCode(),pageable);
    }

    @Override
    public List<ArchiveVo> getArchiveMonths() {
        return articleRepository.getArchiveGroupByMonth(ArticleStatus.PUBLIC.getCode(),Pageable.unpaged()).getContent();
    }

    @Override
    public Page<ArticleVo> getArticleVoGroupByMonth(Integer year,Integer month,Pageable pageable) {
        return articleRepository.getArticleByMonth(ArticleStatus.PUBLIC.getCode(),year,month,pageable);
    }

    @Override
    public Page<ArticleWithCountVo> searchArticles(String keyword, Pageable pageable) {
        return articleRepository.searchArticleWithCountVoListByStatusAndTitleLikeOrSummaryLikeOrContentLike(
                ArticleStatus.PUBLIC.getCode(),keyword,pageable
        );
    }

    @Override
    public void updateCategoryById(Integer oldId, Integer newId) {
        articleRepository.updateCategoryById(oldId, newId);
    }

    @Override
    public Boolean isExistById(Integer id) {
        return articleRepository.existsById(id);
    }

    @Override
    public Long countArticleByCategory(Integer categoryId) {
        return articleRepository.countAllByCategoryIdAndStatus(categoryId,ArticleStatus.PUBLIC.getCode());
    }

    @Override
    public Long countArticle() {
        return articleRepository.countAllByStatus(ArticleStatus.PUBLIC.getCode());
    }


    @Override
    public Article saveOne(Article article) {
        if (article.getId() == null){
            article =articleRepository.save(article);
            categoryRepository.increaseCount(article.getCategoryId());
            ArticleHeat heat = new ArticleHeat();
            heat.setArticleId(article.getId());
            heat.setComments(0L);
            heat.setHits(0L);
            heatRepository.save(heat);
            return article;
        }
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
        return null;
    }

    @Override
    public Long count() {
        return articleRepository.count();
    }
}

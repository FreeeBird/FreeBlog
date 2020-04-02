package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.service.BaseService;
import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ArticleService extends BaseService<Article,Integer> {

    ArticleDetailVo getArticleById(Integer id);

    Page<ArticleWithCountVo> getArticleWithCountVoList(Pageable pageable);
    Page<ArticleWithCountVo> getArticleWithCountVoListByCategory(Integer categoryId,Pageable pageable);

    Page<ArticleWithCountVo> getHeatArticleWithCountVoList(Integer num);

    Page<ArticleWithCountVo> getNewestArticleWithCountVoList(Integer num);

    Page<ArticleWithCountVo> getDraftWithCountVoList(Pageable pageable);

    void updateCategoryById(Integer oldId,Integer newId);

    Long countArticleByCategory(Integer categoryId);
    Long countArticle();





}

package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArchiveVo;
import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import cn.edu.hdu.blog.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ArticleService extends BaseService<Article,Integer> {

    ArticleDetailVo getArticleById(Integer id);

    Page<ArticleWithCountVo> getArticleWithCountVoList(Pageable pageable);
    Page<ArticleWithCountVo> getArticleWithCountVoListByCategory(Integer categoryId,Pageable pageable);

    Page<ArticleWithCountVo> getHeatArticleWithCountVoList(Integer num);

    Page<ArticleWithCountVo> getNewestArticleWithCountVoList(Integer num);

    Page<ArticleWithCountVo> getDraftWithCountVoList(Pageable pageable);

    //归档
    List<ArchiveVo> getArchiveMonths();
    Page<ArticleVo> getArticleVoGroupByMonth(Integer year,Integer month,Pageable pageable);

    Page<ArticleWithCountVo> searchArticles(String keyword,Pageable pageable);

    void updateCategoryById(Integer oldId,Integer newId);

    Boolean isExistById(Integer id);

    Long countArticleByCategory(Integer categoryId);
    Long countArticle();





}

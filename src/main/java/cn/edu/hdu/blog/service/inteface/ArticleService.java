package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.service.BaseService;
import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService extends BaseService<Article,Integer> {


    Page<ArticleVo> getPublicArticleVoList(Pageable pageable);
    Page<ArticleVo> getDraftArticleVoList(Pageable pageable);



    List<Article> getPublicArticles(Pageable pageable);
    List<Article> getPrivateArticles(Pageable pageable);
    List<Article> getDraftArticles(Pageable pageable);
    List<ArticleWithCountVo> getPublicArticleList(Pageable pageable);
    List<ArticleWithCountVo> getTopNumPublicOrderByHitsDesc(Integer num);
    List<ArticleWithCountVo> getTopNumPublicOrderByCreateTimeDesc(Integer num);

    List<ArticleWithCountVo> getArticleListByCategory(Integer categoryId, Pageable pageable);

}

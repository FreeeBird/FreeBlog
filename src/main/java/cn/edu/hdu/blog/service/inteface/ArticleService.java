package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.SimpleArticle;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticleService extends BaseService<Article> {

    List<Article> getPublicArticles(Pageable pageable);
    List<Article> getPrivateArticles(Pageable pageable);
    List<Article> getDraftArticles(Pageable pageable);
    List<SimpleArticle> getPublicArticleList(Pageable pageable);
    List<SimpleArticle> getTopNumPublicOrderByHitsDesc(Integer num);
    List<SimpleArticle> getTopNumPublicOrderByCreateTimeDesc(Integer num);

    List<SimpleArticle> getArticleListByCategory(Integer categoryId,Pageable pageable);

}

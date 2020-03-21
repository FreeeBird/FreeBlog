package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.SimpleArticle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    List<Article> findAllByStatus(Integer status, Pageable pageable);

    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.SimpleArticle(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,a.hits,a.comments,a.createTime,a.updateTime) " +
            "from Article a,Category c where a.status = :status and a.categoryId = c.id")
    List<SimpleArticle> findArticleListByStatus(Integer status, Pageable pageable);

    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.SimpleArticle(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,a.hits,a.comments,a.createTime,a.updateTime) " +
            "from Article a,Category c where a.categoryId = :categoryId and a.categoryId = c.id")
    List<SimpleArticle> findArticleListByCategoryId(Integer categoryId, Pageable pageable);

    List<Article> findAllByCategoryId(Integer categoryId, Pageable pageable);

    Integer countAllByCategoryId(Integer categoryId);

    Integer countAllByStatus(Integer status);

    List<Article> findAllByOrderByHitsDesc(Pageable pageable);

    List<Article> findAllByOrderByCommentsDesc(Pageable pageable);

    List<Article> findAllByOrderByCreateTimeDesc(Pageable pageable);

    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.SimpleArticle(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,a.hits,a.comments,a.createTime,a.updateTime) " +
            "from Article a,Category c where a.status = :status and a.categoryId = c.id order by a.hits desc")
    List<SimpleArticle> findArticleListOrderByHitsDesc(Integer status, Pageable pageable);


    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.SimpleArticle(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,a.hits,a.comments,a.createTime,a.updateTime) " +
            "from Article a,Category c where a.status = :status and a.categoryId = c.id order by a.createTime desc")
    List<SimpleArticle> findArticleListOrderByCreateTimeDesc(Integer status, Pageable pageable);


}

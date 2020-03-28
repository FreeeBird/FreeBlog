package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

    Page<Article> findAllByStatus(Integer status, Pageable pageable);
    Page<Article> findAllByStatusOrderByCreateTimeDesc(Integer status, Pageable pageable);


    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,a.category,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,ArticleHeat h where a.status = :status and a.id=h.articleId")
    Page<ArticleWithCountVo> findArticleWithCountVoListByStatus(Integer status, Pageable pageable);

    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,a.category,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,ArticleHeat h where a.id=h.articleId")
    Page<ArticleWithCountVo> findArticleWithCountVoList(Pageable pageable);

    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.ArticleVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,a.category,a.createTime,a.updateTime) " +
            "from Article a where a.status = :status")
    Page<ArticleVo> findArticleVoListByStatus(Integer status, Pageable pageable);

    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.ArticleVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,a.category,a.createTime,a.updateTime) " +
            "from Article a")
    Page<ArticleVo> findArticleVoList(Pageable pageable);




    List<Article> findAllByCategoryId(Integer categoryId, Pageable pageable);

    Integer countAllByCategoryId(Integer categoryId);

    Integer countAllByStatus(Integer status);

    List<Article> findAllByOrderByHitsDesc(Pageable pageable);

    List<Article> findAllByOrderByCommentsDesc(Pageable pageable);

    List<Article> findAllByOrderByCreateTimeDesc(Pageable pageable);


}

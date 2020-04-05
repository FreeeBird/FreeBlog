package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArchiveVo;
import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.entity.vo.ArticleVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

    @Query("select new cn.edu.hdu.blog.entity.vo.ArticleDetailVo(a.id,a.thumbnailUrl,a.title,a.summary,a.content,a.categoryId,c.name,a.status,a.type,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,Category c,ArticleHeat h where a.id = :id and a.status=:status and a.categoryId=c.id and a.id=h.articleId")
    ArticleDetailVo findByIdAndStatus(Integer id, Integer status);


    @Query(value = "select new cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,ArticleHeat h,Category c where a.status = :status and a.id=h.articleId and a.categoryId=c.id")
    Page<ArticleWithCountVo> findArticleWithCountVoListByStatus(Integer status, Pageable pageable);

    @Query(value = "select new cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a join ArticleHeat h on a.id=h.articleId join Category c on a.categoryId=c.id  where a.status = :status order by a.createTime desc ")
    Page<ArticleWithCountVo> findArticleWithCountVoListByStatusOrderByCreateTime(Integer status, Pageable pageable);


    @Query(value = "select new cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,ArticleHeat h,Category c where a.status = :status and a.id=h.articleId and a.categoryId=c.id order by h.hits desc ")
    Page<ArticleWithCountVo> findArticleWithCountVoListByStatusOrderByHits(Integer status, Pageable pageable);


    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,ArticleHeat h,Category c where a.status=:status and a.categoryId=:categoryId and a.id=h.articleId and a.categoryId=c.id")
    Page<ArticleWithCountVo> findArticleWithCountVoListByStatusAndCategoryId(Integer status,Integer categoryId,Pageable pageable);


    @Query(value = "select new " +
            "cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a join ArticleHeat h on a.id= h.articleId join Category c on a.categoryId=c.id " +
            "where a.status=:status and a.id in (select a.id from Article a " +
            "where a.content like concat('%',:keyword,'%') or a.title like concat('%',:keyword,'%') or a.summary like concat('%',:keyword,'%'))")
    Page<ArticleWithCountVo> searchArticleWithCountVoListByStatusAndTitleLikeOrSummaryLikeOrContentLike(Integer status,String keyword,Pageable pageable);


    @Query("select new cn.edu.hdu.blog.entity.vo.ArchiveVo(function('YEAR',a.updateTime),function('MONTH',a.updateTime),count(a)) from Article a where a.status=:status group by function('YEAR',a.updateTime),function('MONTH',a.updateTime) order by a.updateTime desc ")
    Page<ArchiveVo> getArchiveGroupByMonth(Integer status,Pageable pageable);

    @Query("select new cn.edu.hdu.blog.entity.vo.ArticleVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,a.createTime,a.updateTime) from Article a join Category c on a.categoryId=c.id " +
            "where a.status=:status and function('YEAR',a.updateTime)=:year and function('MONTH',a.updateTime)=:month order by a.updateTime")
    Page<ArticleVo> getArticleByMonth(Integer status,Integer year,Integer month,Pageable pageable);


    @Transactional
    @Modifying
    @Query("update Article a set a.categoryId = :newId where a.categoryId = :oldId")
    void updateCategoryById(Integer oldId,Integer newId);



    @Query("select count(a.id) from Article a where a.categoryId=:categoryId and a.status=:status")
    Long countAllByCategoryIdAndStatus(Integer categoryId,Integer status);
    @Query("select count(a.id) from Article a where a.status=:status")
    Long countAllByStatus(Integer status);



}

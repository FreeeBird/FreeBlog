package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleHeatRepository extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {



    @Query(value = "select new cn.edu.hdu.blog.entity.vo.ArticleWithCountVo" +
            "(a.id,a.thumbnailUrl,a.title,a.summary,a.categoryId,c.name,h.hits,h.comments,a.createTime,a.updateTime) " +
            "from Article a,ArticleHeat h,Category c where a.status = :status and a.id=h.articleId and a.categoryId=c.id")
    Page<ArticleWithCountVo> findArticleWithCountVoListByStatus(Integer status, Pageable pageable);



}

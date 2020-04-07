package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.ArticleHeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface ArticleHeatRepository extends JpaRepository<ArticleHeat,Integer>, JpaSpecificationExecutor<ArticleHeat> {

    @Transactional
    @Modifying
    @Query(value = "update ArticleHeat h set h.hits=h.hits+1 where h.articleId=:aid")
    void increaseHits(Integer aid);

    @Transactional
    @Modifying
    @Query(value = "update ArticleHeat h set h.comments=h.comments+1 where h.articleId=:aid")
    void increaseComment(Integer aid);


    @Transactional
    @Modifying
    @Query(value = "update ArticleHeat h set h.comments=h.comments-1 where h.articleId=:aid")
    void deComment(Integer aid);

}

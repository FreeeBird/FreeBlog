package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.entity.vo.ArticleWithCountVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface ArticleHeatRepository extends JpaRepository<Article,Integer>, JpaSpecificationExecutor<Article> {

    @Transactional
    @Modifying
    @Query(value = "update article_heat h set h.hits=h.hits+1 where h.article_id=?1",nativeQuery = true)
    void increaseHits(Integer aid);

}

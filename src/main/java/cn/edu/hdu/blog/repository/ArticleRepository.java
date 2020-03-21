package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.entity.vo.SimpleArticle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    List<Article> findAllByStatus(Integer status);
    @Query(value = "select new cn.edu.hdu.blog.entity.vo.SimpleArticle(a.id,a.title,a.thumbnailUrl,a.categoryId,c.name,a.status,a.hits,a.comments,a.createTime,a.updateTime) " +
            "from Article a,Category c where a.status = :status and a.categoryId = c.id")
    List<SimpleArticle> findSimpleArticlesByStatus(Integer status);
    List<Article> findAllByCategoryId(Integer categoryId);
    Integer countAllByCategoryId(Integer categoryId);

}

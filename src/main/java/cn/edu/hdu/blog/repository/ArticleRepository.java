package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer> {

    List<Article> findAllByStatus(Integer status);
    List<Article> findAllByCategoryId(Integer categoryId);
    List<Article> countAllByCategoryId(Integer categoryId);

}

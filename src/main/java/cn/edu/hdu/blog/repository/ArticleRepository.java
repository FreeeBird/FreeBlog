package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}

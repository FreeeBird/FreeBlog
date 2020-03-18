package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

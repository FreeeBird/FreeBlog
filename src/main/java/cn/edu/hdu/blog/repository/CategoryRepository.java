package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Page<Category> findAllByOrderByCountDesc(Pageable pageable);


}

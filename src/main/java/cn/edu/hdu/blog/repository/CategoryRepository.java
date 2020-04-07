package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Page<Category> findAllByOrderByCountDesc(Pageable pageable);


    @Transactional
    @Modifying
    @Query(value = "update Category c set c.count=c.count+1 where c.id=:id")
    void increaseCount(Integer id);


}

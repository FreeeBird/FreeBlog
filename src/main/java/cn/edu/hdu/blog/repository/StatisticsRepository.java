package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Statistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticsRepository extends JpaRepository<Statistics,Integer> {

    Page<Statistics> findAllByOrderByCreateTimeDesc(Pageable pageable);
}

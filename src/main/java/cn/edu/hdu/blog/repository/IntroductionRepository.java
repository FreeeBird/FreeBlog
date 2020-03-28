package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IntroductionRepository extends JpaRepository<Introduction,Integer> , JpaSpecificationExecutor<Introduction> {
}

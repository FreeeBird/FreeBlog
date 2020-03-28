package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.BlogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BlogInfoRepository extends JpaRepository<BlogInfo,Integer>{

    BlogInfo findFirstBy();

}

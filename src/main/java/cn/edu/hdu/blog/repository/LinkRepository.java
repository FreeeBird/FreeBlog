package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link,Integer> {
}

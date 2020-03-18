package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}

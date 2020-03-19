package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Integer> {
}

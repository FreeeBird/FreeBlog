package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest,Long> {
}

package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Setting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingRepository extends JpaRepository<Setting,Long> {
}

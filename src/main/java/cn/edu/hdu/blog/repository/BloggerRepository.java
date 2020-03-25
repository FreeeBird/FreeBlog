package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Blogger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BloggerRepository extends JpaRepository<Blogger,Integer> {

    Blogger findByUsernameAndPassword(String username, String password);
    Blogger findByEmail(String email);

}

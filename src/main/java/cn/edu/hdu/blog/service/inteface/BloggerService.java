package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.service.BaseService;
import cn.edu.hdu.blog.entity.dto.Blogger;


public interface BloggerService extends BaseService<Blogger,Integer> {

    Blogger getByUsernameAndPassword(String username,String password);
    Blogger getByEmail(String email);
    Blogger getByPassword(String password);
    Blogger findFirst();
}

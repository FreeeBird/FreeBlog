package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.service.BaseService;
import cn.edu.hdu.blog.entity.dto.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService extends BaseService<Category,Integer> {

    Page<Category> findAllOrderByCountDesc(Pageable pageable);
    Category countChange(Integer id,Integer change);


}

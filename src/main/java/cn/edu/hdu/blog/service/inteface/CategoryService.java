package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.entity.dto.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService extends BaseService<Category,Integer> {

    Page<Category> findAllOrderByCountDesc(Pageable pageable);
    Category countIncrement(Integer id);


}

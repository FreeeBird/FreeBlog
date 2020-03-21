package cn.edu.hdu.blog.service.inteface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T> {


    T saveOne(T t);
    Boolean deleteById(Integer id);
    Integer deleteByIds(Integer... ids);
    T getOne(Integer id);
    List<T> getAll();
    Page<T> getAll(Pageable pageable);
    List<T> getAll(Integer pageNum,Integer pageSize);
    Integer count();
}

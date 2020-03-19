package cn.edu.hdu.blog.service.inteface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T> {


    public T saveOne(T t);
    public Boolean deleteById(Integer id);
    public T getOne(Integer id);
    public List<T> getAll();
    public Page<T> getAll(Pageable pageable);
    public List<T> getAll(Integer pageNum,Integer pageSize);
    public Integer count();
}

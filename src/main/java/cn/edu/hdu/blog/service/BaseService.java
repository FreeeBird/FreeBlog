package cn.edu.hdu.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T,ID extends Serializable> {

//    T saveOne(T t);
//    Boolean deleteById(ID id);
//    T getOne(ID id);
//    Page<T> getAll(Pageable pageable);
//    Long count();
    T saveOne(T t);
    Boolean deleteById(ID id);
    T getOne(ID id);
    Page<T> getAll(Pageable pageable);
    Long count();
}

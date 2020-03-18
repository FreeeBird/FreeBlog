package cn.edu.hdu.blog.service;

import java.util.List;

public interface BaseService<T> {

    public Boolean deleteById(Long id);
    public T saveOne(T t);
    public T getOne(Long id);
    public List<T> getAll();
}

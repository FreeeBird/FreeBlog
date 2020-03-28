package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Category;
import cn.edu.hdu.blog.repository.CategoryRepository;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    @Transactional
    public Category saveOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Boolean deleteById(Integer integer) {
        categoryRepository.deleteById(integer);
        return !categoryRepository.existsById(integer);
    }

    @Override
    public Category getOne(Integer integer) {
        return categoryRepository.getOne(integer);
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return categoryRepository.count();
    }

    @Override
    public Page<Category> findAllOrderByCountDesc(Pageable pageable) {
        return categoryRepository.findAllByOrderByCountDesc(pageable);
    }

    @Override
    @Transactional
    public Category countIncrement(Integer id) {
        Category category = categoryRepository.getOne(id);
        category.setCount(category.getCount()+1);
        return categoryRepository.save(category);
    }
}

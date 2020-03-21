package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Category;
import cn.edu.hdu.blog.repository.CategoryRepository;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category saveOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteById(Integer id) {
        categoryRepository.deleteById(id);
        return !categoryRepository.existsById(id);
    }

    @Override
    public Integer deleteByIds(Integer... ids) {
        return null;
    }

    @Override
    public Category getOne(Integer id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> getAll(Integer pageNum, Integer pageSize) {
        return categoryRepository.findAll(PageRequest.of(pageSize,pageNum)).getContent();
    }

    @Override
    public Integer count() {
        return Math.toIntExact(categoryRepository.count());
    }

    @Override
    public List<Category> findAllOrderByCountDesc(Pageable pageable) {
        return categoryRepository.findAllByOrderByCountDesc(pageable);
    }

    @Override
    public Category countIncrement(Integer id) {
        Category category = categoryRepository.getOne(id);
        category.setCount(category.getCount()+1);
        return categoryRepository.saveAndFlush(category);
    }
}

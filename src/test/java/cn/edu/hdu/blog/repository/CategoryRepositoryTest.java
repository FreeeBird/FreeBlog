package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    public void insert(){
        for (int i = 0; i < 10; i++) {
            Category category = new Category();
            category.setName("cate"+i);
            category.setCount(10L-i);
            categoryRepository.save(category);
        }
    }

    @Test
    public void findTopByOrderByCount() {
    }

    @Test
    public void findAllOrderByCount() {
        Pageable pageable = Pageable.unpaged();
        Page<Category> categoryPageable = categoryRepository.findAllByOrderByCountDesc(pageable);
        System.out.println("total:"+categoryPageable.getTotalElements());
        System.out.println("totalPage:"+categoryPageable.getTotalPages());
    }
}
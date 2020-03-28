package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Category;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping("")
    public AjaxResult getAllByPage(Integer pageNum, Integer pageSize){
        if(null == pageNum || null == pageSize) return getAll();
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        List<Category> categories = categoryService.getAll(pageable).getContent();
        return ResponseTool.success(categories);
    }

    public AjaxResult getAll(){
        return ResponseTool.success(categoryService.getAll(Pageable.unpaged()));
    }

    @RequestMapping(value = "/{id}")
    public AjaxResult getOneById(@PathVariable Integer id){
        Category category = categoryService.getOne(id);
        return ResponseTool.success(category);
    }

    @RequestMapping(value = "/order")
    public AjaxResult getTopNumberOrderByCountDesc(Integer num){
        if(null == num) return getAllNotPage();
        Pageable pageable = PageRequest.of(0,num);
        return ResponseTool.success(categoryService.findAllOrderByCountDesc(pageable).getContent());
    }

    public AjaxResult getAllNotPage(){
        return ResponseTool.success(categoryService.findAllOrderByCountDesc(Pageable.unpaged()));
    }



}

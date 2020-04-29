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

    /**
     * 获取所有分类
     * @param pageNum
     * @param pageSize
     * @return
     */
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

    /**
     * 根据ID获取分类信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}")
    public AjaxResult getOneById(@PathVariable Integer id){
        Category category = categoryService.getOne(id);
        return ResponseTool.success(category);
    }

    /**
     * 按文章数量排序
     * @param num
     * @return
     */
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

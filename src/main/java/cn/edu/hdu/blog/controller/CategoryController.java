package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "")
    public AjaxResult getAll(){
        return ResponseTool.success(categoryService.getAll());
    }

    @RequestMapping(value = "/top")
    public AjaxResult getTopNumberOrderByCountDesc(Integer num){
        Pageable pageable = PageRequest.of(0,num);
        return ResponseTool.success(categoryService.findAllOrderByCountDesc(pageable));
    }



}

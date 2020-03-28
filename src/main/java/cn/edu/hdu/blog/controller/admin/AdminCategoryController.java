package cn.edu.hdu.blog.controller.admin;


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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/category")
public class AdminCategoryController {


    @Autowired
    private CategoryService categoryService;

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

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult saveOne(Category category){
        return ResponseTool.success(categoryService.saveOne(category));
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResult saveOne(String name){
        Category category = new Category();
        category.setName(name);
        return ResponseTool.success(categoryService.saveOne(category));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public AjaxResult delete(Integer id){
        if(null == id) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(categoryService.deleteById(id))
            return ResponseTool.success();
        else return ResponseTool.failed();
    }



}

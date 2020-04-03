package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.Category;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.springframework.beans.BeanUtils;
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
public class CategorySysController {


    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "",method = RequestMethod.GET)
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

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public AjaxResult saveOne(Category category){
        Category old = categoryService.getOne(category.getId());
        BeanUtils.copyProperties(category,old);
        return ResponseTool.success(categoryService.saveOne(old));
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult addOne(Category category){
        return ResponseTool.success(categoryService.saveOne(category));
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable Integer id){
        if(null == id) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        Category def = categoryService.getAll(PageRequest.of(0,1)).getContent().get(0);
        Category del = categoryService.getOne(id);
        if(categoryService.deleteById(id)){
            articleService.updateCategoryById(id,def.getId());
            def.setCount(def.getCount()+del.getCount());
            return ResponseTool.success();
        }
        else return ResponseTool.failed();
    }



}

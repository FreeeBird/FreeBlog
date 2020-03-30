package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/article")
public class ArticleSysController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getArticleList(Integer pageNum, Integer pageSize){
        if(null == pageSize || null == pageNum) return ResponseTool.failed();
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleWithCountVoList(pageable));
    }

    @RequestMapping(value = "/{id}")
    public AjaxResult getArticleById(@PathVariable Integer id){
        return ResponseTool.success(articleService.getArticleById(id));
    }

    @RequestMapping(value = "/draft",method = RequestMethod.GET)
    public AjaxResult getDraftList(Integer pageNum, Integer pageSize){
        if(null == pageSize || null == pageNum) return ResponseTool.failed();
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getDraftWithCountVoList(pageable));
    }



    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResult deleteById(@PathVariable Integer id){
        if(articleService.deleteById(id)) return ResponseTool.success();
        else return ResponseTool.failed();

    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult saveOne(Article article){
        if(null == article) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        Article article1 = articleService.saveOne(article);
        categoryService.countIncrement(article1.getCategoryId());
        return ResponseTool.success(article1);
    }



}

package cn.edu.hdu.blog.controller.admin;


import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/article")
public class adminArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "")
    public AjaxResult getArticleList(Integer pageNum, Integer pageSize){
        if(null == pageSize || null == pageNum) return null;
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getAll(pageable));
    }

    @RequestMapping(value = "/{id}")
    public AjaxResult getArticleById(@PathVariable Integer id){
        return ResponseTool.success(articleService.getOne(id));
    }

    @RequestMapping(value = "/category/{categoryId}")
    public AjaxResult getArticlesByCategory(@PathVariable Integer categoryId,Integer pageNum,Integer pageSize){
        if(null == categoryId) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleListByCategory(categoryId,pageable));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public AjaxResult deleteById(Integer id){
        if(articleService.deleteById(id)) return ResponseTool.success();
        else return ResponseTool.failed();

    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult saveOne(Article article){
        return ResponseTool.success(articleService.saveOne(article));
    }



}

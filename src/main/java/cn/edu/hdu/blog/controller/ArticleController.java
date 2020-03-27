package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "")
    public AjaxResult getArticleList(Integer pageNum,Integer pageSize){
        if(null == pageSize || null == pageNum)
            return ResponseTool.success(articleService.getPublicArticleList(Pageable.unpaged()));
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getPublicArticleList(pageable));
    }

    @RequestMapping(value = "/hits")
    public AjaxResult getHitArticles(Integer num){
        if(null==num || num<=0) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        return ResponseTool.success(articleService.getTopNumPublicOrderByHitsDesc(num));
    }

    @RequestMapping(value = "/newest")
    public AjaxResult getNewArticles(Integer num){
        if(null==num || num<=0) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        return ResponseTool.success(articleService.getTopNumPublicOrderByCreateTimeDesc(num));
    }

    @RequestMapping(value = "/search")
    public AjaxResult searchArticles(String keyword){
        return null;
    }

    @RequestMapping(value = "/category/{categoryId}")
    public AjaxResult getArticlesByCategory(@PathVariable Integer categoryId,Integer pageNum,Integer pageSize){
        if(null == categoryId) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleListByCategory(categoryId,pageable));
    }


    @RequestMapping(value = "/{id}")
    public AjaxResult getArticleById(@PathVariable Integer id){
        return ResponseTool.success(articleService.getOne(id));
    }

    @RequestMapping(value = "/comments")
    public AjaxResult getComments(Integer articleId){
        return null;
    }

    @RequestMapping(value = "/comment")
    public AjaxResult createComment(Integer articleId,Integer guestId,String nickname,String contact,String content){
        return null;
    }



}

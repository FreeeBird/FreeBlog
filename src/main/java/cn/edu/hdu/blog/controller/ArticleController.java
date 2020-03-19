package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @RequestMapping(value = "")
    public AjaxResult getArticles(Integer pageSize,Integer pageNum){
        return null;
    }

    @RequestMapping(value = "/search")
    public AjaxResult searchArticles(String keyword){
        return null;
    }

    @RequestMapping(value = "/category")
    public AjaxResult getArticlesByCategory(Integer categoryId){
        return null;
    }

    @RequestMapping(value = "/simpleList")
    public AjaxResult getArticleList(){
        return null;
    }

    @RequestMapping(value = "/{id}")
    public AjaxResult getArticleById(@PathVariable Integer id){
        return null;
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

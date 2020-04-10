package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.Article;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import cn.edu.hdu.blog.service.inteface.CategoryService;
import cn.edu.hdu.blog.utils.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getArticleList(Integer pageNum, Integer pageSize){
        if(null == pageSize || null == pageNum) return ResponseTool.failed();
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleWithCountVoList(pageable));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult getArticleById(@PathVariable Integer id){
        return ResponseTool.success(articleService.getOne(id));
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
        if(articleService.deleteById(id)) {
            redisUtil.hashSet("blog_statistics","article_num",articleService.countArticle());
            return ResponseTool.success();
        }
        else return ResponseTool.failed();

    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult addOne(Article article){
        if(null == article) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        Article article1 = articleService.saveOne(article);
        categoryService.countChange(article1.getCategoryId(),1);
        redisUtil.hashSet("blog_statistics","article_num",articleService.countArticle());
        return ResponseTool.success(article1);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public AjaxResult saveOne(Article article){
        if(null == article) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        Article old = articleService.getOne(article.getId());
        if(old.getCategoryId()!=article.getCategoryId()){
            categoryService.countChange(article.getCategoryId(),1);
            categoryService.countChange(old.getCategoryId(),-1);
        }
        article.setCreateTime(null);
        article.setUpdateTime(null);
        article = articleService.saveOne(article);
        return ResponseTool.success(article);
    }


}

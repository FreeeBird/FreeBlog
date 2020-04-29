package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Comment;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.entity.vo.ArticleDetailVo;
import cn.edu.hdu.blog.entity.vo.CommentVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import cn.edu.hdu.blog.service.inteface.CommentService;
import cn.edu.hdu.blog.utils.Markdown2HtmlUtils;
import cn.edu.hdu.blog.utils.RedisUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 获取文章
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "分页获取文章")
    @RequestMapping(value = "")
    public AjaxResult getArticleList(Integer pageNum,Integer pageSize){
        if(null == pageSize || null == pageNum)
            return ResponseTool.success(articleService.getArticleWithCountVoList(Pageable.unpaged()));
        if(pageNum<0|| pageSize<1) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.Direction.DESC,"createTime");
        return ResponseTool.success(articleService.getArticleWithCountVoList(pageable));
    }

    /**
     * 根据ID获取文章
     * @param id
     * @return
     */
    @ApiOperation(value = "根据ID获取文章")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public AjaxResult getArticleById(@PathVariable Integer id){
        if (!articleService.isExistById(id)) return ResponseTool.failed(MsgType.ARTICLE_IS_NOT_FOUND);
        Integer hits = (Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.HITS.getKey());
        if(null==hits) hits = 0;
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.HITS.getKey(),hits+1);
        ArticleDetailVo article = articleService.getArticleById(id);
        if(redisUtil.hasKey(BlogKey.ARTICLE.getKey()+id)){
            article.setContent((String) redisUtil.get(BlogKey.ARTICLE.getKey()+id));
        }else if (article.getType()==1){
            String html = Markdown2HtmlUtils.parse(article.getContent());
            redisUtil.set(BlogKey.ARTICLE.getKey()+id,html);
            article.setContent(html);
        }
        return ResponseTool.success(article);
    }


    /**
     * 获取热门文章(点击量最多)
     * @param num
     * @return
     */
    @ApiOperation(value = "获取热门文章")
    @RequestMapping(value = "/hits")
    public AjaxResult getHitArticles(Integer num){
        if(null==num || num<=0) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        return ResponseTool.success(articleService.getHeatArticleWithCountVoList(num));
    }

    /**
     * 获取最新文章
     * @param num
     * @return
     */
    @ApiOperation(value = "获取最新文章")
    @RequestMapping(value = "/newest")
    public AjaxResult getNewArticles(Integer num){
        if(null==num || num<=0) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        return ResponseTool.success(articleService.getNewestArticleWithCountVoList(num));
    }

    /**
     * 搜索文章（标题、简介、内容）
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "搜索文章")
    @RequestMapping(value = "/search")
    public AjaxResult searchArticles(String keyword,Integer pageNum,Integer pageSize){
        if(StringUtils.isEmpty(keyword))
            return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return ResponseTool.success(articleService.searchArticles(keyword,pageable));
    }

    /**
     * 获取一个分类的文章
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取某个分类的文章")
    @RequestMapping(value = "/category/{categoryId}")
    public AjaxResult getArticlesByCategory(@PathVariable Integer categoryId,Integer pageNum,Integer pageSize){
        if(null == categoryId) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleWithCountVoListByCategory(categoryId,pageable));
    }


    /**
     * 获取文章的评论
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/{articleId}/comment",method = RequestMethod.GET)
    public AjaxResult getComments(@PathVariable Integer articleId,Integer pageNum,Integer pageSize){
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(commentService.getByArticleId(articleId,pageable));
    }

    /**
     * 发表文章评论
     * @param articleId
     * @param commentVo
     * @return
     */
    @RequestMapping(value = "/{articleId}/comment",method = RequestMethod.POST)
    public AjaxResult postComment(@PathVariable Integer articleId, CommentVo commentVo){
        if(!articleService.isExistById(articleId)) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentVo,comment);
        Integer num = (Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.COMMENT_NUM.getKey());
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.COMMENT_NUM.getKey(),num+1);
        return ResponseTool.success(commentService.saveOne(comment));
    }

    /**
     * 归档的月份
     * @return
     */
    @RequestMapping(value = "/archive",method = RequestMethod.GET)
    public AjaxResult getArchiveMonths(){
        return ResponseTool.success(articleService.getArchiveMonths());
    }

    /**
     * 归档文章
     * @param year
     * @param month
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/archive/{year}/{month}")
    public AjaxResult getArticleByMonth(@PathVariable Integer year,@PathVariable Integer month,Integer pageNum,Integer pageSize){
        if(null == pageNum || null == pageSize)
            return ResponseTool.success(articleService.getArticleVoGroupByMonth(year,month,Pageable.unpaged()));
        if(pageNum<0||pageSize<=0)
            return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleVoGroupByMonth(year,month,pageable));
    }



}

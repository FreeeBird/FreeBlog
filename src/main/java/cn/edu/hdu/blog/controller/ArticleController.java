package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Comment;
import cn.edu.hdu.blog.entity.vo.CommentVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.ArticleService;
import cn.edu.hdu.blog.service.inteface.CommentService;
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

    @ApiOperation(value = "分页获取文章")
    @RequestMapping(value = "")
    public AjaxResult getArticleList(Integer pageNum,Integer pageSize){
        if(null == pageSize || null == pageNum)
            return ResponseTool.success(articleService.getArticleWithCountVoList(Pageable.unpaged()));
        if(pageNum<0|| pageSize<1) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.Direction.DESC,"createTime");
        return ResponseTool.success(articleService.getArticleWithCountVoList(pageable));
    }


    @ApiOperation(value = "根据ID获取文章")
    @RequestMapping(value = "/{id}")
    public AjaxResult getArticleById(@PathVariable Integer id){

        return ResponseTool.success(articleService.getArticleById(id));
    }


    @ApiOperation(value = "获取热门文章")
    @RequestMapping(value = "/hits")
    public AjaxResult getHitArticles(Integer num){
        if(null==num || num<=0) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        return ResponseTool.success(articleService.getHeatArticleWithCountVoList(num));
    }

    @ApiOperation(value = "获取最新文章")
    @RequestMapping(value = "/newest")
    public AjaxResult getNewArticles(Integer num){
        if(null==num || num<=0) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        return ResponseTool.success(articleService.getNewestArticleWithCountVoList(num));
    }

    @ApiOperation(value = "搜索文章")
    @RequestMapping(value = "/search")
    public AjaxResult searchArticles(String keyword,Integer pageNum,Integer pageSize){
        if(StringUtils.isEmpty(keyword))
            return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return ResponseTool.success(articleService.searchArticles(keyword,pageable));
    }

    @ApiOperation(value = "获取某个分类的文章")
    @RequestMapping(value = "/category/{categoryId}")
    public AjaxResult getArticlesByCategory(@PathVariable Integer categoryId,Integer pageNum,Integer pageSize){
        if(null == categoryId) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(articleService.getArticleWithCountVoListByCategory(categoryId,pageable));
    }



    @RequestMapping(value = "/{articleId}/comment",method = RequestMethod.GET)
    public AjaxResult getComments(@PathVariable Integer articleId,Integer pageNum,Integer pageSize){
        if(null==pageNum||null==pageSize) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        return ResponseTool.success(commentService.getByArticleId(articleId,pageable));
    }
    @RequestMapping(value = "/{articleId}/comment",method = RequestMethod.POST)
    public AjaxResult postComment(@PathVariable Integer articleId, CommentVo commentVo){
        if(!articleService.isExistById(articleId)) return ResponseTool.failed(MsgType.PARAM_IS_INVALID);
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentVo,comment);
        return ResponseTool.success(commentService.saveOne(comment));
    }

    @RequestMapping(value = "/archive",method = RequestMethod.GET)
    public AjaxResult getArchiveMonths(){
        return ResponseTool.success(articleService.getArchiveMonths());
    }

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

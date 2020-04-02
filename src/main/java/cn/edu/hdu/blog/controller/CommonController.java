package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.BlogInfo;
import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.dto.Message;
import cn.edu.hdu.blog.entity.vo.BlogInfoVo;
import cn.edu.hdu.blog.entity.vo.BloggerVo;
import cn.edu.hdu.blog.entity.vo.StatisticsVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.*;
import cn.edu.hdu.blog.utils.MD5Utils;
import cn.edu.hdu.blog.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "公共信息接口")
public class CommonController {

    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private BloggerService bloggerService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "发表留言",httpMethod = "POST",response = AjaxResult.class)
    @RequestMapping(value = "/message",method = RequestMethod.POST)
    public AjaxResult leaveMessage(Message message){
        if(StringUtils.isEmpty(message.getNickname()))
            ResponseTool.failed(MsgType.NICKNAME_IS_EMPTY);
        if(StringUtils.isEmpty(message.getEmail()))
            ResponseTool.failed(MsgType.EMAIL_IS_EMPTY);
        return ResponseTool.success(messageService.saveOne(message));
    }

    @ApiOperation(value = "获取链接",httpMethod = "GET")
    @RequestMapping(value = "/link",method = RequestMethod.GET)
    public AjaxResult getLinks(Integer pageNum,Integer pageSize){

        if(null == pageNum|| null==pageSize)
            return ResponseTool.success(linkService.getAll(Pageable.unpaged()));
        if(pageNum<0||pageSize<1) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        return ResponseTool.success(linkService.getAll(PageRequest.of(pageNum,pageSize)));
    }

    @ApiOperation(value = "获取博客信息",httpMethod = "GET")
    @RequestMapping(value = "/blogInfo",method = RequestMethod.GET)
    public AjaxResult getBlogIntro(){
        BlogInfo blogInfo = blogInfoService.findFirst();
        if(null==blogInfo) return ResponseTool.failed(MsgType.SYSTEM_DATA_ERROR);
        BlogInfoVo blogInfoVo = new BlogInfoVo();
        BeanUtils.copyProperties(blogInfo,blogInfoVo);
        return ResponseTool.success(blogInfoVo);
    }

    @ApiOperation(value = "获取博主信息",httpMethod = "GET")
    @RequestMapping(value = "/blogger",method = RequestMethod.GET)
    public AjaxResult getBlogger(){
        Blogger blogger = bloggerService.findFirst();
        if(null==blogger) return ResponseTool.failed(MsgType.SYSTEM_DATA_ERROR);
        BloggerVo bloggerVo = new BloggerVo();
        BeanUtils.copyProperties(blogger,bloggerVo);
        return ResponseTool.success(bloggerVo);
    }


    @ApiOperation(value = "获取统计信息",httpMethod = "GET")
    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public AjaxResult getStatistics(){
        Long articleNum = articleService.countArticle();
        Long cateNum = categoryService.count();
        Long comment = commentService.count();
        Long mess = messageService.count();
        StatisticsVo statisticsVo = new StatisticsVo(articleNum,cateNum,comment,mess);
        return ResponseTool.success(statisticsVo);
    }


}

package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.BlogInfo;
import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.dto.Link;
import cn.edu.hdu.blog.entity.dto.Message;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.entity.vo.BlogInfoVo;
import cn.edu.hdu.blog.entity.vo.BloggerVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BlogInfoService;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.service.inteface.LinkService;
import cn.edu.hdu.blog.service.inteface.MessageService;
import cn.edu.hdu.blog.utils.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        message.setId(null);
        message.setCreateTime(null);
        Integer num = (Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.MESSAGE_NUM.getKey());
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.MESSAGE_NUM.getKey(),num+1);
        return ResponseTool.success(messageService.saveOne(message));
    }

    /**
     * 获取友链
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "获取链接",httpMethod = "GET")
    @RequestMapping(value = "/link",method = RequestMethod.GET)
    public AjaxResult getLinks(Integer pageNum,Integer pageSize){
        if(null == pageNum|| null==pageSize){
            if(redisUtil.hasKey(BlogKey.LINKS.getKey())){
                List<Object> links = (List<Object>) redisUtil.get(BlogKey.LINKS.getKey());
                if(null!=links || links.size()>0) {
                    return ResponseTool.success(links);
                }
            }
            Page<Link> links = linkService.getAll(Pageable.unpaged());
            redisUtil.set(BlogKey.LINKS.getKey(),links.getContent());
            return ResponseTool.success(links);
        }
        if(pageNum<0||pageSize<1) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        return ResponseTool.success(linkService.getAll(PageRequest.of(pageNum,pageSize)));
    }

    @ApiOperation(value = "获取博客信息",httpMethod = "GET")
    @RequestMapping(value = "/blogInfo",method = RequestMethod.GET)
    public AjaxResult getBlogIntro(){
        if(redisUtil.hasKey(BlogKey.BLOG_INFO.getKey())){
            BlogInfoVo blogInfoVo = (BlogInfoVo) redisUtil.get(BlogKey.BLOG_INFO.getKey());
            if(null!=blogInfoVo) return ResponseTool.success(blogInfoVo);
        }
        BlogInfo blogInfo = blogInfoService.findFirst();
        if(null==blogInfo) return ResponseTool.failed(MsgType.SYSTEM_DATA_ERROR);
        BlogInfoVo blogInfoVo = new BlogInfoVo();
        BeanUtils.copyProperties(blogInfo,blogInfoVo);
        redisUtil.set(BlogKey.BLOG_INFO.getKey(),blogInfoVo);
        return ResponseTool.success(blogInfoVo);
    }

    @ApiOperation(value = "获取博主信息",httpMethod = "GET")
    @RequestMapping(value = "/blogger",method = RequestMethod.GET)
    public AjaxResult getBlogger(){
        if(redisUtil.hasKey(BlogKey.BLOGGER.getKey())){
            BloggerVo bloggerVo = (BloggerVo) redisUtil.get(BlogKey.BLOGGER.getKey());
            if(null!=bloggerVo) return ResponseTool.success(bloggerVo);
        }
        Blogger blogger = bloggerService.findFirst();
        if(null==blogger) return ResponseTool.failed(MsgType.SYSTEM_DATA_ERROR);
        BloggerVo bloggerVo = new BloggerVo();
        BeanUtils.copyProperties(blogger,bloggerVo);
        redisUtil.set(BlogKey.BLOGGER.getKey(),bloggerVo);
        return ResponseTool.success(bloggerVo);
    }


}

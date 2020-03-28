package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.vo.BloggerVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BlogInfoService;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.service.inteface.LinkService;
import cn.edu.hdu.blog.utils.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private BloggerService bloggerService;
    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/link",method = RequestMethod.GET)
    public AjaxResult getLinks(){
        return ResponseTool.success(linkService.getAll(Pageable.unpaged()));
    }


    @RequestMapping("/blogInfo")
    public AjaxResult getBlogIntro(){
        return ResponseTool.success(blogInfoService.findFirst());
    }


    @RequestMapping(value = "/blogger")
    public AjaxResult getBlogger(){
        Blogger blogger = bloggerService.findFirst();
        BloggerVo bloggerVo = new BloggerVo();
        BeanUtils.copyProperties(blogger,bloggerVo);
        return ResponseTool.success(bloggerVo);
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(String username,String password){
        return ResponseTool.success(bloggerService.getByUsernameAndPassword(username, MD5Utils.MD5Encode(password)));
    }

}

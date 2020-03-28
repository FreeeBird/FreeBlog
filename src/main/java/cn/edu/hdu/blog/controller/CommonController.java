package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.vo.BloggerVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BlogInfoService;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private BloggerService bloggerService;


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

}

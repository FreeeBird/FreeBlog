package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BlogInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    @Autowired
    BlogInfoService blogInfoService;

    @RequestMapping("/blogInfo")
    public AjaxResult getBlogIntro(){
        return ResponseTool.success(blogInfoService.findFirst());
    }

}

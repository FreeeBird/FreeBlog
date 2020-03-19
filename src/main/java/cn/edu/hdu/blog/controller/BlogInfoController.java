package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class BlogInfoController {

    @RequestMapping(value = "")
    public AjaxResult getBlogInfo(){
        return null;
    }

    @RequestMapping(value = "/links")
    public AjaxResult getFriendLinks(){
        return null;
    }

}

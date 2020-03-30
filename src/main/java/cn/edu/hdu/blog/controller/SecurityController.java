package cn.edu.hdu.blog.controller;

import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    private BloggerService bloggerService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(String username, String password){
        return ResponseTool.success(bloggerService.getByUsernameAndPassword(username, MD5Utils.MD5Encode(password)));
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public AjaxResult logout(){
        return ResponseTool.success();
    }
}

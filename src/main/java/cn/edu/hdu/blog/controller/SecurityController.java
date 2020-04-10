package cn.edu.hdu.blog.controller;

import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.utils.MD5Utils;
import cn.edu.hdu.blog.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
public class SecurityController {

    @Autowired
    private BloggerService bloggerService;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public AjaxResult login(String username, String password, HttpServletRequest request){
        if(StringUtils.isEmpty(username))
            return ResponseTool.failed(MsgType.LOGIN_USERNAME_IS_NULL);
        if(StringUtils.isEmpty(password))
            return ResponseTool.failed(MsgType.LOGIN_PASS_IS_NULL);
        Blogger blogger = bloggerService.getByUsernameAndPassword(username, MD5Utils.MD5Encode(password));
        if(null == blogger)
            return ResponseTool.failed(MsgType.LOGIN_FAILED);
        HttpSession session = request.getSession();
        UUID token = UUID.randomUUID();
        session.setAttribute(BlogKey.BLOG_TOKEN.getKey(),token);
        redisUtil.set(BlogKey.BLOG_TOKEN.getKey(),token,15*60*1000);
        return ResponseTool.success();
    }

    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public AjaxResult logout(HttpServletRequest request){
        redisUtil.del(BlogKey.BLOG_TOKEN.getKey());
        request.getSession().removeAttribute(BlogKey.BLOG_TOKEN.getKey());
        return ResponseTool.success();
    }
}

package cn.edu.hdu.blog.controller.admin;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.utils.SecureUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blogger")
public class AdminBloggerController {

//    @Autowired
//    BloggerService bloggerService;
//
//    @RequestMapping("")
//    public AjaxResult getBlogger(){
//        Blogger blogger = bloggerService.getAll().get(0);
//        blogger.setPassword("");
//        return ResponseTool.success(blogger);
//    }
//
//
//    @RequestMapping(value = "/updatePass",method = RequestMethod.POST)
//    public AjaxResult updatePassword(String oldPass,String newPass){
//        return null;
//    }
//
//    @RequestMapping(value = "/save",method = RequestMethod.POST)
//    public AjaxResult saveOne(Blogger blogger){
//        return ResponseTool.success(bloggerService.saveOne(blogger));
//    }
//
//    @RequestMapping(value = "/update",method = RequestMethod.POST)
//    public AjaxResult updateInfo(){
//        return null;
//    }

}

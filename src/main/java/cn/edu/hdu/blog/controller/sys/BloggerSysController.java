package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.vo.BloggerSysVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.utils.IgnorePropertiesUtil;
import cn.edu.hdu.blog.utils.MD5Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blogger")
public class BloggerSysController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getBlogger(){
        Blogger blogger = bloggerService.findFirst();
        blogger.setPassword("");
        return ResponseTool.success(blogger);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult saveBlogger(BloggerSysVo blogger){
        Blogger old = bloggerService.findFirst();
        BeanUtils.copyProperties(blogger,old);
        return ResponseTool.success(bloggerService.saveOne(old));
    }


    @RequestMapping(value = "/updatePass",method = RequestMethod.POST)
    public AjaxResult updatePassword(String oldPass,String newPass){
        Blogger blogger = bloggerService.getByPassword(MD5Utils.MD5Encode(oldPass));
        if(null == blogger)
            return ResponseTool.failed();
        blogger.setPassword(MD5Utils.MD5Encode(newPass));
        return ResponseTool.success(bloggerService.saveOne(blogger));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult saveOne(Blogger blogger){
        return ResponseTool.success(bloggerService.saveOne(blogger));
    }


}

package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.entity.vo.BloggerSysVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.utils.MD5Utils;
import cn.edu.hdu.blog.utils.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getBlogger(){
        Blogger blogger = bloggerService.findFirst();
        BloggerSysVo bloggerSysVo = new BloggerSysVo();
        BeanUtils.copyProperties(blogger,bloggerSysVo);
        redisUtil.del(BlogKey.BLOGGER.getKey());
        return ResponseTool.success(bloggerSysVo);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult saveBlogger(BloggerSysVo blogger){
        Blogger old = bloggerService.findFirst();
        BeanUtils.copyProperties(blogger,old);
        bloggerService.saveOne(old);
        return getBlogger();
    }


    @RequestMapping(value = "/updatePass",method = RequestMethod.POST)
    public AjaxResult updatePassword(String oldPass,String newPass){
        Blogger blogger = bloggerService.getByPassword(MD5Utils.MD5Encode(oldPass));
        if(null == blogger)
            return ResponseTool.failed();
        blogger.setPassword(MD5Utils.MD5Encode(newPass));
        return ResponseTool.success(bloggerService.saveOne(blogger));
    }


}

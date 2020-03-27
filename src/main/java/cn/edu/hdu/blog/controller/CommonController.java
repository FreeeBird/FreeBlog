package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.dto.Guest;
import cn.edu.hdu.blog.entity.vo.SimpleBlogger;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BloggerService;
import cn.edu.hdu.blog.service.inteface.GuestService;
import cn.edu.hdu.blog.service.inteface.IntroductionService;
import cn.edu.hdu.blog.utils.SecureUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CommonController {

    @Autowired
    GuestService guestService;
    @Autowired
    BloggerService bloggerService;


    @RequestMapping(value = "/in")
    public AjaxResult checkIn(HttpServletRequest request){
        Guest guest = new Guest();
        guest.setIp(request.getRemoteAddr());
        guest.setHost(request.getRemoteHost());
        guest.setUserAgent(request.getHeader("User-Agent"));
        guest = guestService.saveOne(guest);
        request.getSession().setAttribute("userId",guest.getId());
        return ResponseTool.success(guest);
    }

    @RequestMapping("/blogger")
    public AjaxResult getBlogger(){
        if(bloggerService.count()<1) return ResponseTool.failed();
        Blogger blogger = bloggerService.getAll().get(0);
        SimpleBlogger simpleBlogger = new SimpleBlogger();
        BeanUtils.copyProperties(blogger,simpleBlogger);
        return ResponseTool.success(simpleBlogger);
    }


}

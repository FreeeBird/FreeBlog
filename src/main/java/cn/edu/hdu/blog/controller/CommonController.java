package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.Guest;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
public class CommonController {

    @Autowired
    GuestService guestService;


    @RequestMapping(value = "/in")
    public AjaxResult checkIn(HttpServletRequest request){
        Guest guest = new Guest();
        guest.setIp(request.getRemoteAddr());
        guest.setHost(request.getRemoteHost());
        guest.setUserAgent(request.getHeader("User-Agent"));
        return ResponseTool.success(guestService.saveOne(guest));
    }
}

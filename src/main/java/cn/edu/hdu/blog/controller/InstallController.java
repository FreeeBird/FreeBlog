package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/install")
public class InstallController {


    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult install(){
        return null;
    }

}

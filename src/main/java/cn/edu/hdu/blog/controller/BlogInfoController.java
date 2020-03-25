package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class BlogInfoController {

    @Autowired
    IntroductionService introductionService;

    @RequestMapping("")
    public AjaxResult getBlogIntro(){
        return ResponseTool.success(introductionService.getAll().get(0));
    }



}

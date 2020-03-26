package cn.edu.hdu.blog.controller.admin;


import cn.edu.hdu.blog.entity.dto.Introduction;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("admin/info")
public class AdminIntroductionController {
    @Autowired
    IntroductionService introductionService;

    @RequestMapping("")
    public AjaxResult getBlogIntro(){
        return ResponseTool.success(introductionService.getAll().get(0));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult saveBlogInfo(Introduction introduction){
        return ResponseTool.success(introductionService.saveOne(introduction));
    }




}

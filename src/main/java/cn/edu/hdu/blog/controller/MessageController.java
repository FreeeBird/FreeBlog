package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.response.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客留言（游客）
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @RequestMapping(value = "")
    public AjaxResult getMessages(){
        return null;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResult addMessage(Integer guestId,String nickname,String contact,String content){
        return null;
    }


}

package cn.edu.hdu.blog.controller.admin;


import cn.edu.hdu.blog.entity.dto.Message;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
@RequestMapping("/message")
public class MessageAdminController {
    @Autowired
    private MessageService messageService;

    public AjaxResult getAll(){
        return ResponseTool.success(messageService.getAll(Pageable.unpaged()));
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getMessages(Integer pageNum,Integer pageSize){
        if(null==pageNum || null== pageSize) return getAll();
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        if(pageable.isUnpaged()) ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        return ResponseTool.success(messageService.getAll(pageable));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResult removeOne(@PathVariable Integer id){
        return ResponseTool.success(messageService.deleteById(id));
    }

}

package cn.edu.hdu.blog.controller.admin;

import cn.edu.hdu.blog.entity.dto.Guest;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/guest")
public class AdminGuestController {

    @Autowired
    GuestService guestService;

    public AjaxResult getAll(){
        return ResponseTool.success(guestService.getAll());
    }

    @RequestMapping("")
    public AjaxResult getAll(Integer pageNum,Integer pageSize){
        if(null == pageNum || pageNum==null) return getAll();
        if(pageNum<0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        return ResponseTool.success(guestService.getAll(pageNum,pageSize));
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public AjaxResult saveOne(Guest guest){
        return ResponseTool.success(guestService.saveOne(guest));
    }

    @RequestMapping(value = "/remove",method = RequestMethod.POST)
    public AjaxResult deleteById(Integer id){
        return ResponseTool.success(guestService.deleteById(id));
    }



}

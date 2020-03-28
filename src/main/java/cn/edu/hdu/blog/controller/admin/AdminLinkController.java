package cn.edu.hdu.blog.controller.admin;


import cn.edu.hdu.blog.entity.dto.Link;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/link")
public class AdminLinkController {
    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getAllLink(Integer pageNum,Integer pageSize){
        if(null==pageNum||null==pageSize) return getAll();
        if(pageNum<0 || pageSize<=0) return ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        return ResponseTool.success(linkService.getAll(PageRequest.of(pageNum,pageSize)));
    }

    public AjaxResult getAll(){
        return ResponseTool.success(linkService.getAll(Pageable.unpaged()));
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult saveOne(Link link){
        return ResponseTool.success(linkService.saveOne(link));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResult removeOne(@PathVariable Integer id){
        return ResponseTool.success(linkService.deleteById(id));
    }


}

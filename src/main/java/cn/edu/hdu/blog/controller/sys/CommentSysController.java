package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/comment")
public class CommentSysController {

    @Autowired
    private CommentService commentService;




    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getAllByPage(Integer pageNum,Integer pageSize){
        if(null==pageNum || null== pageSize) return ResponseTool.failed();
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        if(pageable.isUnpaged()) ResponseTool.failed(MsgType.PAGE_PARAM_IS_INVALID);
        return ResponseTool.success(commentService.getAllCommentSysVo(pageable));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public AjaxResult deleteById(@PathVariable Integer id){
        if (commentService.deleteById(id))
            return ResponseTool.success();
        return ResponseTool.failed();
    }

}

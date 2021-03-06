package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.BlogInfo;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.entity.vo.BlogInfoVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.BlogInfoService;
import cn.edu.hdu.blog.utils.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blogInfo")
public class BlogInfoSysController {

    @Autowired
    private BlogInfoService blogInfoService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult get(){
        BlogInfoVo blogInfoVo = new BlogInfoVo();
        BeanUtils.copyProperties(blogInfoService.findFirst(),blogInfoVo);
        redisUtil.del(BlogKey.BLOG_INFO.getKey());
        return ResponseTool.success(blogInfoVo);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public AjaxResult save(BlogInfoVo blogInfoVo){
        BlogInfo old = blogInfoService.findFirst();
        BeanUtils.copyProperties(blogInfoVo,old);
        old = blogInfoService.saveOne(old);
        BeanUtils.copyProperties(old,blogInfoVo);
        return ResponseTool.success(blogInfoVo);
    }
}

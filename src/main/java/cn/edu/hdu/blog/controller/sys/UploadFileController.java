package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.utils.QiNiuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/admin/upload")
public class UploadFileController {
    @Autowired
    private QiNiuUtil qiNiuUtil;

    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public AjaxResult uploadFileToQiniu(@RequestParam("img") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        String fileKey = UUID.randomUUID().toString()+originalFilename;
        return ResponseTool.success(qiNiuUtil.upload(file.getInputStream(),fileKey));
    }

}

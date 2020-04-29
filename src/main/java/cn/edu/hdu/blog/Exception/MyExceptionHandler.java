package cn.edu.hdu.blog.Exception;

import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public AjaxResult bizHandler(HttpServletRequest req, BizException e){
        System.out.println("biz:"+e);
        return ResponseTool.failed(e.getMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public String exceptionHandler(Exception e){
        System.out.println("异常！原因是："+e);
        return e.getMessage();
    }


}

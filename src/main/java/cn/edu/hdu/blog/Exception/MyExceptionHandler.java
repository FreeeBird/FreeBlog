package cn.edu.hdu.blog.Exception;

import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.MsgType;
import cn.edu.hdu.blog.response.ResponseTool;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public AjaxResult exceptionHandler(Exception e){
        System.out.println("异常！原因是："+e);
        return ResponseTool.failed(MsgType.SYSTEM_DATA_ERROR);
    }


}

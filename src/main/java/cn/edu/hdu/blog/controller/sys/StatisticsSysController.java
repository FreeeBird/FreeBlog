package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.StatisticsService;
import cn.edu.hdu.blog.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/statistics")
public class StatisticsSysController {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/weekly",method = RequestMethod.GET)
    public AjaxResult getWeekly(){
        return ResponseTool.success(statisticsService.getAll(PageRequest.of(0,7)));
    }

    


}

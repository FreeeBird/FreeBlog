package cn.edu.hdu.blog.controller.sys;


import cn.edu.hdu.blog.entity.dto.Statistics;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.entity.vo.StatisticsVo;
import cn.edu.hdu.blog.response.AjaxResult;
import cn.edu.hdu.blog.response.ResponseTool;
import cn.edu.hdu.blog.service.inteface.StatisticsService;
import cn.edu.hdu.blog.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/admin/statistics")
public class StatisticsSysController {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/daily",method = RequestMethod.GET)
    public AjaxResult getDaily(){
        Statistics statistics = new Statistics();
        statistics.setVisit((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.DAY_VISIT.getKey()));
        statistics.setHits((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.DAY_HITS.getKey()));
        statistics.setCreateTime(new Date());
        return ResponseTool.success(statistics);
    }

    @RequestMapping(value = "/weekly",method = RequestMethod.GET)
    public AjaxResult getWeekly(){
        return ResponseTool.success(statisticsService.getAll(PageRequest.of(0,7)));
    }


    @RequestMapping(value = "/monthly",method = RequestMethod.GET)
    public AjaxResult getMonthly(){
        return ResponseTool.success(statisticsService.getAll(PageRequest.of(0,30)));
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public AjaxResult getStatistics(){
        StatisticsVo statistics = new StatisticsVo();
        statistics.setArticleNum((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.ARTICLE_NUM.getKey()));
        statistics.setCategoryNum((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.CATEGORY_NUM.getKey()));
        statistics.setCommentNum((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.COMMENT_NUM.getKey()));
        statistics.setMessageNum((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.MESSAGE_NUM.getKey()));
        statistics.setDayVisit((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.DAY_VISIT.getKey()));
        statistics.setDayHits((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.DAY_HITS.getKey()));
        statistics.setVisit((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.VISIT_NUM.getKey()));
        statistics.setHits((Integer) redisUtil.hashGet(BlogKey.BLOG_STATISTICS.getKey(),BlogKey.HITS.getKey()));
        return ResponseTool.success(statistics);
    }


}

package cn.edu.hdu.blog.task;


import cn.edu.hdu.blog.entity.dto.Statistics;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.repository.StatisticsRepository;
import cn.edu.hdu.blog.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务cron = 秒 分 时 日 月 周 年
 */
@Component
public class ScheduleTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private StatisticsRepository statisticsRepository;

    /**
     * 每天0时0分0秒 触发
     * 将缓存的每天访问量、文章点击量持久化
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void resetBlogStatistics(){
        Integer visit = (Integer) redisUtil.hashGet(
                BlogKey.BLOG_STATISTICS.getKey(),
                BlogKey.DAY_VISIT.getKey()
        );
        Integer hit = (Integer) redisUtil.hashGet(
                BlogKey.BLOG_STATISTICS.getKey(),
                BlogKey.DAY_HITS.getKey()
        );
        Statistics statistics = new Statistics();
        statistics.setVisit(visit);
        statistics.setHits(hit);
        statistics = statisticsRepository.save(statistics);
        if(null==statistics.getId()){
            logger.warn(new Date().toString()+" statistics save error!");
        }
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.DAY_VISIT.getKey(),0);
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.DAY_HITS.getKey(),0);
    }




}

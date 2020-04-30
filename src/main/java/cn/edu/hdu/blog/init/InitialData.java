package cn.edu.hdu.blog.init;


import cn.edu.hdu.blog.entity.dto.BlogInfo;
import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.entity.enums.BlogKey;
import cn.edu.hdu.blog.repository.BlogInfoRepository;
import cn.edu.hdu.blog.repository.BloggerRepository;
import cn.edu.hdu.blog.utils.MD5Utils;
import cn.edu.hdu.blog.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 项目启动时从配置文件中读取信息
 * 初始化博客信息
 * 初始化缓存
 */
@Component
public class InitialData {

    @Autowired
    private BloggerRepository bloggerRepository;
    @Autowired
    private BlogInfoRepository blogInfoRepository;
    @Autowired
    private BlogConfig blogConfig;
    @Autowired
    private BloggerConfig bloggerConfig;
    @Autowired
    private RedisUtil redisUtil;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void init(){
        initBlog();
        initBlogger();
        initCache();
    }

    public void initBlogger(){
        Blogger blogger = bloggerRepository.findFirstBy();
        if(null!= blogger) {
            logger.info("Blogger is exist.");
            return;
        }
        blogger = new Blogger();
        blogger.setUsername(bloggerConfig.getUsername());
        blogger.setPassword(MD5Utils.MD5Encode(bloggerConfig.getPassword()));
        blogger.setNickname(bloggerConfig.getNickname());
        blogger.setEmail(bloggerConfig.getEmail());
        blogger.setPortraitUrl(bloggerConfig.getPortraitUrl());
        blogger = bloggerRepository.save(blogger);
        logger.info("Blogger "+blogger.getNickname() + " is created successfully.");
    }


    public void initBlog(){
        BlogInfo blog = blogInfoRepository.findFirstBy();
        if(null!=blog){
            logger.info("Blog info is exist.");
            return;
        }
        blog = new BlogInfo();
        blog.setDescription(blogConfig.getDescription());
        blog.setKeywords(blogConfig.getKeywords());
        blog.setTitle(blogConfig.getTitle());
        blogInfoRepository.save(blog);
        logger.info("Blog is created successfully.");
    }

    public void initCache(){
        if(!redisUtil.hHasKey(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.HITS.getKey())){
            redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.HITS.getKey(),0);
        }
        if(!redisUtil.hHasKey(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.VISIT_NUM.getKey())){
            redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.VISIT_NUM.getKey(),0);
        }
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.DAY_VISIT.getKey(),0);
        redisUtil.hashSet(BlogKey.BLOG_STATISTICS.getKey(), BlogKey.DAY_HITS.getKey(),0);
    }

}

package cn.edu.hdu.blog.task;


import cn.edu.hdu.blog.entity.dto.BlogInfo;
import cn.edu.hdu.blog.entity.dto.Blogger;
import cn.edu.hdu.blog.repository.BlogInfoRepository;
import cn.edu.hdu.blog.repository.BloggerRepository;
import cn.edu.hdu.blog.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class InitialData {

    @Autowired
    private BloggerRepository bloggerRepository;
    @Autowired
    private BlogInfoRepository blogInfoRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostConstruct
    public void initBlogger(){
        Blogger blogger = bloggerRepository.findFirstBy();
        if(null!= blogger) {
            logger.info("Blogger is exist.");
            return;
        }
        blogger = new Blogger();
        blogger.setUsername("admin");
        blogger.setPassword(MD5Utils.MD5Encode("admin"));
        blogger.setNickname("FF");
        blogger.setEmail("FF@qq.com");
        blogger.setPortraitUrl("");
        blogger = bloggerRepository.save(blogger);
        logger.info("Blogger "+blogger.getNickname() + " is created successfully.");
    }

    @PostConstruct
    public void initBlog(){
        BlogInfo blog = blogInfoRepository.findFirstBy();
        if(null!=blog){
            logger.info("Blog info is exist.");
            return;
        }
        blog = new BlogInfo();
        blog.setDescription("new blog");
        blog.setKeywords("online");
        blog.setTitle("My Blog");
        blogInfoRepository.save(blog);
        logger.info("Blog is created successfully.");
    }

}

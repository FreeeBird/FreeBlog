package cn.edu.hdu.blog.repository;

import cn.edu.hdu.blog.entity.dto.BlogInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BlogInfoRepositoryTest {

    @Autowired
    private BlogInfoRepository blogInfoRepository;

    @Test
    public void findFirstBy() {
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setTitle("fa");
        blogInfoRepository.save(blogInfo);
        System.out.println(blogInfoRepository.findFirstBy());
    }
}
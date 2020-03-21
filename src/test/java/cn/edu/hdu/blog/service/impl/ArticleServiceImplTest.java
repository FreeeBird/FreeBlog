package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.service.inteface.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceImplTest {

    @Autowired
    ArticleService articleService;

    @Test
    public void getPublicArticles() {

    }
}
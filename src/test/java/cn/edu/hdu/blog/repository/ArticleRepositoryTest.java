package cn.edu.hdu.blog.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;
    @Test
    public void countAllGroupByMonth() {
//        Page<ArchiveVo> page = articleRepository.getArchiveGroupByMonth(0, Pageable.unpaged());
//        Page<ArticleVo> page1 = articleRepository.getArticleByMonth(0,2020,4,Pageable.unpaged());
//        page1.getContent().forEach(System.out::println);
    }
}
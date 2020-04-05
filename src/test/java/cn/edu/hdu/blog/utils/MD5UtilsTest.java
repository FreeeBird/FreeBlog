package cn.edu.hdu.blog.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MD5UtilsTest {

    @Test
    public void MD5Encode() {
        System.out.println(MD5Utils.MD5Encode("123456"));
    }
}
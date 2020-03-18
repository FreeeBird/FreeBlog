package cn.edu.hdu.blog.controller;


import cn.edu.hdu.blog.entity.dto.User;
import cn.edu.hdu.blog.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/")
    public User test(){
        return userRepository.findAll().get(0);
    }

    @RequestMapping(value = "/in")
    public User testI(){
        User user = new User();
        user.setNickname("fadfdafafdasf");

        return userRepository.save(user);
    }
}

package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.User;
import cn.edu.hdu.blog.repository.UserRepository;
import cn.edu.hdu.blog.service.inteface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Boolean deleteById(Integer id) {
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    @Override
    public User saveOne(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<User> getAll(Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public Integer count() {
        return null;
    }
}

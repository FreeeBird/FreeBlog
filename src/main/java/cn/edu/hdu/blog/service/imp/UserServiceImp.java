package cn.edu.hdu.blog.service.imp;

import cn.edu.hdu.blog.entity.dto.User;
import cn.edu.hdu.blog.repository.UserRepository;
import cn.edu.hdu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public Boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return !userRepository.existsById(id);
    }

    @Override
    public User saveOne(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getOne(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}

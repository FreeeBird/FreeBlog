package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Message;
import cn.edu.hdu.blog.repository.MessageRepository;
import cn.edu.hdu.blog.service.inteface.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message saveOne(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Boolean deleteById(Integer integer) {
        messageRepository.deleteById(integer);
        return !messageRepository.existsById(integer);
    }

    @Override
    public Message getOne(Integer integer) {
        return messageRepository.getOne(integer);
    }

    @Override
    public Page<Message> getAll(Pageable pageable) {
        return messageRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return messageRepository.count();
    }
}

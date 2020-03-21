package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Guest;
import cn.edu.hdu.blog.repository.GuestRepository;
import cn.edu.hdu.blog.service.inteface.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GuestServiceImpl implements GuestService {

    @Autowired
    GuestRepository guestRepository;

    @Override
    @Transactional
    public Guest saveOne(Guest guest) {
        return guestRepository.save(guest);
    }

    @Override
    @Transactional
    public Boolean deleteById(Integer id) {
        guestRepository.deleteById(id);
        return !guestRepository.existsById(id);
    }

    @Override
    public Integer deleteByIds(Integer... ids) {
        return null;
    }

    @Override
    public Guest getOne(Integer id) {
        return guestRepository.getOne(id);
    }

    @Override
    public List<Guest> getAll() {
        return guestRepository.findAll();
    }

    @Override
    public Page<Guest> getAll(Pageable pageable) {
        return guestRepository.findAll(pageable);
    }

    @Override
    public List<Guest> getAll(Integer pageNum, Integer pageSize) {
        return guestRepository.findAll(PageRequest.of(pageNum,pageSize)).getContent();
    }

    @Override
    public Integer count() {
        return Math.toIntExact(guestRepository.count());
    }
}

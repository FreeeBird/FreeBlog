package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Link;
import cn.edu.hdu.blog.repository.LinkRepository;
import cn.edu.hdu.blog.service.inteface.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link saveOne(Link link) {
        return linkRepository.save(link);
    }

    @Override
    public Boolean deleteById(Integer integer) {
        linkRepository.deleteById(integer);
        return !linkRepository.existsById(integer);
    }

    @Override
    public Link getOne(Integer integer) {
        return linkRepository.getOne(integer);
    }

    @Override
    public Page<Link> getAll(Pageable pageable) {
        return linkRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return linkRepository.count();
    }
}

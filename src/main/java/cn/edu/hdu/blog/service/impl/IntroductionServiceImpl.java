package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Introduction;
import cn.edu.hdu.blog.repository.IntroductionRepository;
import cn.edu.hdu.blog.service.inteface.IntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntroductionServiceImpl implements IntroductionService {

    @Autowired
    IntroductionRepository introductionRepository;


    @Override
    public Introduction saveOne(Introduction introduction) {
        return introductionRepository.save(introduction);
    }

    @Override
    public Boolean deleteById(Integer id) {
        introductionRepository.deleteById(id);
        return !introductionRepository.existsById(id);
    }

    @Override
    public Integer deleteByIds(Integer... ids) {
        return null;
    }

    @Override
    public Introduction getOne(Integer id) {
        return introductionRepository.getOne(id);
    }

    @Override
    public List<Introduction> getAll() {
        return introductionRepository.findAll();
    }

    @Override
    public Page<Introduction> getAll(Pageable pageable) {
        return introductionRepository.findAll(pageable);
    }

    @Override
    public List<Introduction> getAll(Integer pageNum, Integer pageSize) {
        return getAll(PageRequest.of(pageNum,pageSize)).getContent();
    }

    @Override
    public Integer count() {
        return Math.toIntExact(introductionRepository.count());
    }
}

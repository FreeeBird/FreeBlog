package cn.edu.hdu.blog.service.impl;

import cn.edu.hdu.blog.entity.dto.Statistics;
import cn.edu.hdu.blog.repository.StatisticsRepository;
import cn.edu.hdu.blog.service.inteface.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Override
    public Statistics saveOne(Statistics statistics) {
        return statisticsRepository.save(statistics);
    }

    @Override
    public Boolean deleteById(Integer integer) {
        statisticsRepository.deleteById(integer);
        return !statisticsRepository.existsById(integer);
    }

    @Override
    public Statistics getOne(Integer integer) {
        return statisticsRepository.getOne(integer);
    }

    @Override
    public Page<Statistics> getAll(Pageable pageable) {
        return statisticsRepository.findAllByOrderByCreateTimeDesc(pageable);
    }

    @Override
    public Long count() {
        return statisticsRepository.count();
    }
}

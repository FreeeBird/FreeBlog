package cn.edu.hdu.blog.service.inteface;

import cn.edu.hdu.blog.entity.dto.BlogInfo;

public interface BlogInfoService extends BaseService<BlogInfo,Integer> {

    BlogInfo findFirst();
}

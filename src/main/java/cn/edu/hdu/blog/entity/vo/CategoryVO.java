package cn.edu.hdu.blog.entity.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CategoryVO {
    private Integer id;
    private String name;
    private Integer count = 0;
}

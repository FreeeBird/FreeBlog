package cn.edu.hdu.blog.entity.dto;


import javax.persistence.*;
import java.util.Date;


@Entity
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String thumbnailUrl;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private Long categoryId;
    @Column
    private Integer status;
    @Column
    private Integer hits;
    @Column
    private Integer comments;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;


}

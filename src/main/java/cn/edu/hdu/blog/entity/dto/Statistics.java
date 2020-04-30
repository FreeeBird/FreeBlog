package cn.edu.hdu.blog.entity.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
@Entity
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@EntityListeners(AuditingEntityListener.class)
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "int default 0")
    private Integer hits;
    @Column(columnDefinition = "int default 0")
    private Integer visit;
    @Column(columnDefinition = "int default 0")

    @CreatedDate
    private Date createTime;

    public Statistics() {
    }

    public Statistics(Integer id, Integer hits, Integer visit) {
        this.id = id;
        this.hits = hits;
        this.visit = visit;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "id=" + id +
                ", hits=" + hits +
                ", visit=" + visit +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}

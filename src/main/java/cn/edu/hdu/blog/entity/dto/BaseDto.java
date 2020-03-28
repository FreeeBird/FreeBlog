package cn.edu.hdu.blog.entity.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@EntityListeners(AuditingEntityListener.class)
public class BaseDto {
}

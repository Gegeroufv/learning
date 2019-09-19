package com.example.demo.base.entity;


import com.example.demo.base.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@Where(clause = " deleted = 'F'")
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("主键")
    private Long baseId;

    @Comment("关联日志uuid")
    @Column(length = 40)
    private String logId;

    @JsonIgnore
    @Comment("是否删除")
    @Type(type = "true_false")
    private Boolean deleted=false;

    @Comment("创建时间")
    @CreatedDate
    private LocalDateTime createTime;

    @Comment("最后修改时间")
    @LastModifiedDate
    private LocalDateTime lastModifiedTime;

    @Comment("信息")
    @Column(length = 20)
    private String resInfo;

    @Comment("接收时间")
    @Column(length = 20)
    private String receiveTime;

    @Comment("错误码")
    @Column(length = 5)
    private Integer errCode;

    @Comment("错误信息")
    @Column(length = 50)
    private String errMsg;
}

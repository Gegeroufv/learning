package com.example.demo.base.entity;//package com.shibo.migration.base.entity;
//
//import com.etc.order.base.Comment;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//import springfox.documentation.annotations.ApiIgnore;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@ApiIgnore
//@Getter
//@Setter
//@MappedSuperclass
//@EntityListeners(AuditorEntity.class)
//public class AuditorEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Comment("主键")
//    @ApiModelProperty("id")
//    private Long id;
//
//    @JsonIgnore
//    @Comment("是否删除")
//    private String removed = "0";
//
//
//    @Comment("创建时间")
//    @CreatedDate
//    @ApiModelProperty("创建时间")
//    private LocalDateTime createTime;
//
//    @Comment("最后修改时间")
//    @LastModifiedDate
//    @ApiModelProperty("最后修改时间")
//    private LocalDateTime lastModifiedTime;
//
//    @Comment("创建人")
//    @CreatedBy
//    @ApiModelProperty("创建人")
//    private String createBy;
//
//    @Comment("最后修改人")
//    @LastModifiedBy
//    @ApiModelProperty("最后修改人")
//    private String lastModifidBy;
//
//}

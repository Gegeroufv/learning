package com.example.demo.base.res;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ApiModel("通用列表返回")
public class BaseListRes extends BaseRes {
    @ApiModelProperty("总的元素个数")
    private Long totalElements;

    @ApiModelProperty("总的页数")
    private Integer totalPages;

    @ApiModelProperty("数据对象")
    private List data=new ArrayList<>();
}

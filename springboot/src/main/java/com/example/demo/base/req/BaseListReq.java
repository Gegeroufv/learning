package com.example.demo.base.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ApiIgnore
public class BaseListReq {
    @ApiModelProperty("当前页数")
    @Min(value = 1,message = "输入页面不合法")
    @NotNull(message = "输入页面不能为空")
    private Integer page=1;

    @ApiModelProperty("页面条数")
    @Min(value = 1,message = "输入页面大小不合法")
    @NotNull(message = "输入页面大小不能为空")
    private Integer pageSize=10;
}

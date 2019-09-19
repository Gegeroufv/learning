package com.example.demo.base.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


@ApiModel("通用响应对象")
public class BaseRes {
	@ApiModelProperty("成功标志")
	private boolean success = false;
	@ApiModelProperty("成功信息")
	private String message;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

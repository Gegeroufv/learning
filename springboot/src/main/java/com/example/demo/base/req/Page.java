package com.example.demo.base.req;

import io.swagger.annotations.ApiModelProperty;

public class Page {

	@ApiModelProperty("当前页数")
	private Integer page=1;

	@ApiModelProperty("每页条数")
	private Integer pageSize=10;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	
}

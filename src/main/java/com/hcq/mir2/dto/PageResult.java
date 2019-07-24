package com.hcq.mir2.dto;




import com.hcq.mir2.entries.BaseBean;

import java.util.List;

/**
 * <p>
 * 分页
 * </p>
 *
 * @author shang
 * @since 2019-1-2
 */

public class PageResult<T> extends BaseBean {

	private Long total;
	private List<T> rows;
	private Long pageSize;
	private Long pageIndex;


	public PageResult() {
	}

	public PageResult(Long total, List<T> rows, Long pageSize, Long pageIndex) {
		this.total = total;
		this.rows = rows;
		this.pageSize = pageSize;
		this.pageIndex = pageIndex;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}
}

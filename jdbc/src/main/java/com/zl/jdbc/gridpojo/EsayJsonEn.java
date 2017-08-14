package com.zl.jdbc.gridpojo;

import java.util.List;

/**
 * @Grid Json_data 设置类
 * @author 周路		2011/12/07 15:17
 *
 * @param total -记录总数
 * @param rows	-View层 根结点
 * @param page	-当前页码
 */
public class EsayJsonEn {
	private Integer total; //记录总数
	private	Integer page;  //当前页码
	private	List  	rows ; //Ext.Grid root 根结点
	
	/**
	 * 
	 * @param total -记录总数
	 * @param page	-当前页码
	 * @param rows	-Ext.Grid root 根结点
	 */
	public void EsayJsonEn(Integer total,Integer page,List rows){
		this.total=total;
		this.page=page;
		this.rows=rows;
	}
	
	public Integer getTotal() {		return total;	}
	public void setTotal(Integer total) {		this.total = total;	}
	public Integer getPage() {		return page;	}
	public void setPage(Integer page) {		this.page = page;	}
	public List getRows() {		return rows;	}
	public void setRows(List rows) {		this.rows = rows;	}
}

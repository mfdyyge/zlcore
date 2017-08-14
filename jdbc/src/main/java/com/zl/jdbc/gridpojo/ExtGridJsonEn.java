package com.zl.jdbc.gridpojo;

import java.util.List;

/**
 * 
 * @author 	周路		
 * @TimeApp   	2011/12/07 15:17
 * @version 2012/03/07 第二次修订  
 */
public class ExtGridJsonEn{
	private Integer totalCount; //总条数
	private List rootlist;
	//private List topics; //根节点
	public Integer getTotalCount() {return totalCount;}
	public void setTotalCount(Integer totalCount) {this.totalCount = totalCount;}
	public List getRootlist() {return rootlist;}
	public void setRootlist(List rootlist) {this.rootlist = rootlist;}

}
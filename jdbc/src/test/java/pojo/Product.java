package pojo;

import com.xiaoleilu.hutool.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 
 * @Description: 商品
 * @Copyright: Copyright (c) 2015 FFCS All Rights Reserved
 * @Company: 北京福富软件有限公司
 * @author 黄君毅 2015-5-15
 * @version 1.00.00
 * @history:
 * 
 */
public class Product {
	private long id; // ID
	private String name; // 名称
	private int stock; // 库存
	private Date createdDate; // 创建时间
	private boolean status; // 状态，是否已上架

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getStock() {
		return stock;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * 2017-09-03 <br/>
	 * "yyyy-MM-dd"  <br/>
	 * @param createdDate
     */
	public void setCreatedDate(String createdDate)
	{
		this.createdDate = DateUtil.parse(createdDate, "yyyy-MM-dd");
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", stock=" + stock	+ ", createdDate=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdDate) ;
	}
}

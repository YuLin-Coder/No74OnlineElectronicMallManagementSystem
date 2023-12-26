package cn.itbaizhan.po;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //表示它是实体类，交给Hibernate管理，
//意味着跟数据库的某张表对应是javax.persistence包，其实Hibernate是此JPA标准的实现
@Table(name="commodityClasses")//表名
public class CommodityClass implements java.io.Serializable {
	
	@Id //加主键，一般写在其get方法上，或是属性上
	@GeneratedValue(strategy = GenerationType.AUTO)  //Id的生成策略javax.persistence包
	private Integer commodityClassId;		//商品种类编号
	private String commodityClassName;		//商品种类名称

	public Integer getCommodityClassId() {
		return this.commodityClassId;
	}

	public void setCommodityClassId(Integer commodityClassId) {
		this.commodityClassId = commodityClassId;
	}

	public String getCommodityClassName() {
		return this.commodityClassName;
	}

	public void setCommodityClassName(String commodityClassName) {
		this.commodityClassName = commodityClassName;
	}

	public CommodityClass(Integer commodityClassId) {
		super();
		this.commodityClassId = commodityClassId;
	}

	public CommodityClass() {
		super();
	}
}
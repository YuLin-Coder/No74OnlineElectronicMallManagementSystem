package cn.itbaizhan.po;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //表示它是实体类，交给Hibernate管理，
//意味着跟数据库的某张表对应是javax.persistence包，其实Hibernate是此JPA标准的实现
@Table(name="commoditys")//表名
public class Commodity implements java.io.Serializable {
	@Id //加主键，一般写在其get方法上，或是属性上
	@GeneratedValue(strategy = GenerationType.AUTO)  //Id的生成策略javax.persistence包
	private Integer commodityId;			//商品编号
	
	@ManyToOne(cascade=CascadeType.MERGE)
	private CommodityClass commodityClass;//商品种类
	
	private String commodityName;			//商品名称
	private String manufacturer;			//生产厂家
	private String commodityDepict;			//商品描述
	private Double commodityPrice;			//商品价格
	private Double webPrice;				//商城价格
	private Integer commodityAmount;		//商品总数量
	private Integer commodityLeaveNum;		//商品剩余数量
	private String image;					//商品图片

	public Commodity() {
	}

	public Commodity(CommodityClass commodityClass, String commodityName,
			String manufacturer, String commodityDepict, Double commodityPrice,
			Double webPrice, Integer commodityAmount, Integer commodityLeaveNum,
			String image) {
		this.commodityClass = commodityClass;
		this.commodityName = commodityName;
		this.manufacturer = manufacturer;
		this.commodityDepict = commodityDepict;
		this.commodityPrice = commodityPrice;
		this.webPrice = webPrice;
		this.commodityAmount = commodityAmount;
		this.commodityLeaveNum = commodityLeaveNum;
		
		this.image = image;
	}

	public Integer getCommodityId() {
		return this.commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public CommodityClass getCommodityClass() {
		return this.commodityClass;
	}

	public void setCommodityClass(CommodityClass commodityClass) {
		this.commodityClass = commodityClass;
	}

	public String getCommodityName() {
		return this.commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCommodityDepict() {
		return this.commodityDepict;
	}

	public void setCommodityDepict(String commodityDepict) {
		this.commodityDepict = commodityDepict;
	}

	public Double getCommodityPrice() {
		return this.commodityPrice;
	}

	public void setCommodityPrice(Double commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public Double getWebPrice() {
		return this.webPrice;
	}

	public void setWebPrice(Double webPrice) {
		this.webPrice = webPrice;
	}

	public Integer getCommodityAmount() {
		return this.commodityAmount;
	}

	public void setCommodityAmount(Integer commodityAmount) {
		this.commodityAmount = commodityAmount;
	}

	public Integer getCommodityLeaveNum() {
		return this.commodityLeaveNum;
	}

	public void setCommodityLeaveNum(Integer commodityLeaveNum) {
		this.commodityLeaveNum = commodityLeaveNum;
	}



	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
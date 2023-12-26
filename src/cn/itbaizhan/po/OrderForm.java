package cn.itbaizhan.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //表示它是实体类，交给Hibernate管理，
//意味着跟数据库的某张表对应是javax.persistence包，其实Hibernate是此JPA标准的实现
@Table(name="orderform")//表名
public class OrderForm implements java.io.Serializable {
	@Id //加主键，一般写在其get方法上，或是属性上
	@GeneratedValue(strategy = GenerationType.AUTO)  //Id的生成策略javax.persistence包
	private Integer orderFormId;	//订单编号
	private String username;		//用户名
	
	private String submitTime;		//提交订单时间
	private String consignmentTime;	//发货时间
	private Double totalPrice;		//总金额
	private String remark;			//买家备注
	
	private String isPayoff;		//买家是否付款
	private String isConsignment;	//是否发货
	private Long orderFormNum;	//订单流水号
	
	public OrderForm()
	{}

	public OrderForm(String username, String submitTime,
			String consignmentTime, Double totalPrice, String remark,
			 String isPayoff, String isConsignment,Long orderFormNum) {
		this.username = username;
		this.submitTime = submitTime;
		this.consignmentTime = consignmentTime;
		this.totalPrice = totalPrice;
		this.remark = remark;
		
		this.isPayoff = isPayoff;
		this.isConsignment = isConsignment;
		this.setOrderFormNum(orderFormNum);
	}
	
	public Integer getOrderFormId() {
		return this.orderFormId;
	}

	public void setOrderFormId(Integer orderFormId) {
		this.orderFormId = orderFormId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public String getConsignmentTime() {
		return this.consignmentTime;
	}

	public void setConsignmentTime(String consignmentTime) {
		this.consignmentTime = consignmentTime;
	}

	public Double getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsPayoff() {
		return this.isPayoff;
	}

	public void setIsPayoff(String isPayoff) {
		this.isPayoff = isPayoff;
	}

	public String getIsConsignment() {
		return this.isConsignment;
	}

	public void setIsConsignment(String isConsignment) {
		this.isConsignment = isConsignment;
	}

	public void setOrderFormNum(Long orderFormNum) {
		this.orderFormNum = orderFormNum;
	}

	public Long getOrderFormNum() {
		return orderFormNum;
	}

}
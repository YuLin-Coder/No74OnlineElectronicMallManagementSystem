package cn.itbaizhan.po;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity //表示它是实体类，交给Hibernate管理，
@Table(name="users")//表名
public class User implements java.io.Serializable {
	@Id //加主键，一般写在其get方法上，或是属性上
	@GeneratedValue(strategy = GenerationType.AUTO)  //Id的生成策略javax.persistence包
	private Integer userId;			//用户编号
	private String username;		//用户名
	private String password;		//密码
	private String name;			//姓名
	private String sex;				//性别
	private String address;			//住址
	private String phone;			//联系电话
	private String post;			//邮寄地址
	private String email;			//Email地址
	
	private Double money;			//用户账户金额
	
	public User() {
	}

	public User(String username, String password, String name, String sex,
			String address, String phone, String post, String email,
			Double money) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.address = address;
		this.phone = phone;
		this.post = post;
		this.email = email;
		
		this.money=money;
		
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMoney(Double money) {
		this.money = money;
	}

	public Double getMoney() {
		return money;
	}


}
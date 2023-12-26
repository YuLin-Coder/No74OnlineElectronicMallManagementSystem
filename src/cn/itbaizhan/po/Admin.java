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
//意味着跟数据库的某张表对应是javax.persistence包，其实Hibernate是此JPA标准的实现
@Table(name="admins")//表名
public class Admin implements java.io.Serializable { // 管理员信息实体类
	@Id //加主键，一般写在其get方法上，或是属性上
	@GeneratedValue(strategy = GenerationType.AUTO)  //Id的生成策略javax.persistence包
	private Integer adminId;						//管理员编号
	private String username;						//管理员用户名
	private String password;						//管理员密码

	public Admin() {
	}

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
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

}
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
@Table(name="message")//表名
public class Message implements java.io.Serializable {
	@Id //加主键，一般写在其get方法上，或是属性上
	@GeneratedValue(strategy = GenerationType.AUTO)  //Id的生成策略javax.persistence包
	private Integer messageId;	//留言编号
	private String username;	//用户名
	
	private String messagetitle;		//留言标题
	private String messagetime;	//留言时间
	private String messagetext;//留言内容
	
	public Message(){
		
	}
	public Message(Integer messageId, String username, String messagetitle,
			String messagetime, String messagetext) {
		super();
		this.messageId = messageId;
		this.username = username;
		this.messagetitle = messagetitle;
		this.messagetime = messagetime;
		this.messagetext = messagetext;
	}

	public Integer getMessageId() {
		return messageId;
	}

	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessagetitle() {
		return messagetitle;
	}

	public void setMessagetitle(String messagetitle) {
		this.messagetitle = messagetitle;
	}

	public String getMessagetime() {
		return messagetime;
	}

	public void setMessagetime(String messagetime) {
		this.messagetime = messagetime;
	}

	public String getMessagetext() {
		return messagetext;
	}

	public void setMessagetext(String messagetext) {
		this.messagetext = messagetext;
	}

	
}
package cn.itbaizhan.action;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.mapping.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itbaizhan.po.Message;
import cn.itbaizhan.service.MessageService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("messageAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class MessageAction extends ActionSupport {
	private Message message;
	
//要调用MessageService的方法，所以要声明,让spring把其实现类注入
	@Resource(name="messageServiceImpl")
	MessageService service;
	public MessageService getService() {
		return service;
	}

	public void setService(MessageService service) {
		this.service = service;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	

	@Override
	public String execute() throws Exception {
		// 不要直接访问数据库，应该访问业务逻辑层service，而service去访问DAO，DAO去访问数据库
			this.service.save(this.message);
			System.out.println("message:"+message.getUsername());
			ActionContext.getContext().put("tijiaomessage", "您的留言已经提交！");
			return "success";
	}
	
	@SuppressWarnings("unchecked")
	public String listMessage(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("listMessages", service.findAllMessages());
		System.out.println("listMessages");
		return "listMessage";
	}
	//查询
	@SuppressWarnings("unchecked")
	public String queryMessage(){
		int messageId= message.getMessageId();
		System.out.println("messageId:"+messageId);
		String username= message.getUsername();
		System.out.println("username:"+username);
		String messagetitle= message.getMessagetitle();
		System.out.println("messagetitle:"+messagetitle);
		
		
		Message message=this.service.queryMessage(username);
		System.out.println("message:"+message);
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("queryMessage", message);

		return "queryMessage";
	}
	
	public String deleteMessage(){
		this.service.delete(message);
		return "deleteMessage";
	}
	public String findMessageById(){
		message = this.service.findMessageById(message.getMessageId());
		return "findMessage";
	}
	
		
	@SuppressWarnings("unchecked")
	public String addMessage(){
		this.service.save(this.message);
		Map request = (Map) ActionContext.getContext().get("request");
		
		return "addmessage";
	}

}

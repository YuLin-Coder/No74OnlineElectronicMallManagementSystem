package cn.itbaizhan.action;

import java.util.Collection;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itbaizhan.po.User;
import cn.itbaizhan.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import com.cds.po.Department;
//import com.cds.po.Role;

//import com.cds.service.DepartmentService;
//import com.cds.service.RoleService;

@SuppressWarnings("serial")
@Component("userAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class UserAction extends ActionSupport {
	private User user;
    //要调用UserService的方法，所以要声明,让spring把其实现类注入。@Resource 默认按 byName 自动注入
	@Resource(name="userServiceImpl")
	UserService service;
	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	@Override
	public String execute() throws Exception {
		// 不要直接访问数据库，应该访问业务逻辑层service，而service去访问DAO，dao去访问数据库
		String username= user.getUsername();
		System.out.println(username);
		
		User user = service.findUserByName(username);
		if(user==null){
			this.service.save(this.user);
			return "success";
		}
		else{
			return "error";
		}
	}
	//列表
	@SuppressWarnings("unchecked")
	public String listUser(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("listUsers", service.findAllUsers());
		System.out.println("listUsers"+service.findAllUsers().size());
		return "listUser";
	}
	
	//查询
	@SuppressWarnings("unchecked")
	public String queryUser(){
		String username= user.getUsername();
		System.out.println(username);
		String name= user.getName();
		
		User user=this.service.queryUser(username);
		System.out.println("user:"+user);
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("queryUser", user);
		//System.out.println("queryUser"+service.queryUser().size());

		return "queryUser";
	}
	
	public String deleteUser(){
		this.service.delete(user);
		return "deleteUser";
	}
	public String findUserById(){
		user = this.service.findUserById(user.getUserId());
		return "findUser";
	}
	
	public String updateUser(){
		
		this.service.update(user);
		System.out.println("user:"+user.getUserId());
		ActionContext.getContext().put("updatemessage", "您的信息已经更新！");
		return "updateUser";
	}
		
	@SuppressWarnings("unchecked")
	public String addUser(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		return "adduser";
	}
	//个人密码跳转
	/*public String updatePassword(){
		return "updatePassword";
	}
	*/
	public String findUser()
	{
		String username= user.getUsername();
		System.out.println("username:"+username);
		String name= user.getName();
		System.out.println("name:"+name);
		String sex= user.getSex();
		System.out.println("sex:"+sex);
		String post= user.getPost();
		System.out.println("post:"+post);
		String address= user.getAddress();
		System.out.println("address:"+address);
		String phone= user.getPhone();
		System.out.println("phone:"+phone);
		String email= user.getEmail();
		System.out.println("email:"+email);
		
		User user=this.service.findUserByinfo(username, name,sex,phone, post, address, email);
		System.out.println("user:"+user);

		if(user==null){
			ActionContext.getContext().put("findUsernull", "没有该用户信息！");
			return "findUsernull";
		}else{
		ActionContext.getContext().getSession().put("findUser", user);

		return "findUser";
		}
		
	}
	//修改密码
	public String upPass()
	{
		this.service.update(user);
		System.out.println("user:"+user.getUserId());
		ActionContext.getContext().put("upPass", "您的密码已经修改！");
		return "upPass";
	}
	//重设密码
	public String updatePass()
	{
		this.service.update(user);
		System.out.println("user:"+user.getUserId());
		ActionContext.getContext().put("updatePass", "您的密码已经更改！");
		return "updatePass";
	}
	//用户注册验证
	public String register()
	{
		
		String username= user.getUsername();
		System.out.println(username);
		
		User user = service.findUserByName(username);
		System.out.println("name:"+username+",user:"+user);
		if(user == null){
			ActionContext.getContext().put("regmessage", username+"可以注册");
			return "regsuccess";
		}else{
			ActionContext.getContext().put("regmessage", username+"已经被注册");
			return "regerror";
		}
	}
	//用户登录
	public String login(){
		String username= user.getUsername();
		System.out.println(username);
		String password=user.getPassword();

		User user = service.getUserByLoginNameAndPassword(username,password);
		System.out.print("name:"+username+"pass"+password+"user"+user);
		if(user == null){
			ActionContext.getContext().put("message", "用户名或密码错误");		
			return "login";
		}else{
			ActionContext.getContext().getSession().put("user", user);
			return "index";
		}
	}
	//用户退出
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
}

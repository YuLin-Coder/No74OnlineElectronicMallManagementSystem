package cn.itbaizhan.action;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.itbaizhan.action.*;
import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.OrderForm;
import cn.itbaizhan.po.User;
import cn.itbaizhan.service.OrderFormService;
import cn.itbaizhan.service.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Component("orderFormAction")
@Scope("prototype")//多例，每个请求生成一个新的action
public class OrderFormAction extends ActionSupport {
	private OrderForm orderForm;
	
//要调用OrderFormService的方法，所以要声明,让spring把其实现类注入
	@Resource(name="orderFormServiceImpl")
	OrderFormService service;
	
	private UserService userservice;
	
	public OrderFormService getService() {
		return service;
	}

	public void setService(OrderFormService service) {
		this.service = service;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}
	

	@Resource
	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}


	public UserService getUserservice() {
		return userservice;
	}

	@Override
	public String execute() throws Exception {
		// 不要直接访问数据库，应该访问业务逻辑层service，而service去访问DAO，DAO去访问数据库
			this.service.save(this.orderForm);
			System.out.println("orderForm:"+orderForm.getUsername());
			ActionContext.getContext().put("ordermessage", "您的订单已经提交！");
			return "success";
	}
	//列表
	@SuppressWarnings("unchecked")
	public String listOrderForm(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("listOrderForms", service.findAllOrderForms());
		System.out.println("listOrderForms");
		return "listOrderForm";
	}
	//查询
	@SuppressWarnings("unchecked")
	public String queryOrderForm(){
		int orderFormId= orderForm.getOrderFormId();
		System.out.println("orderFormId:"+orderFormId);
		String username= orderForm.getUsername();
		System.out.println("username:"+username);
		String submitTime= orderForm.getSubmitTime();
		System.out.println("submitTime:"+submitTime);
		String consignmentTime= orderForm.getConsignmentTime();
		System.out.println("consignmentTime:"+consignmentTime);
	
		OrderForm orderForm=this.service.queryOrderForm(orderFormId);
		Map request=(Map) ActionContext.getContext().get("request");
		
		request.put("queryOrder", orderForm);
		return "queryOrder";
	}
	

	public String deleteOrderForm(){
		this.service.delete(orderForm);
		return "deleteOrderForm";
	}
	public String findOrderFormById(){
		orderForm = this.service.findOrderFormById(orderForm.getOrderFormId());
		return "findOrderForm";
	}
	//付款
	@SuppressWarnings("unchecked")
	public String payOrderForm(){
		double totalprice=orderForm.getTotalPrice();//订单总金额
		User user=userservice.findUserByName(orderForm.getUsername());
		double money=user.getMoney();//用户所有金钱
		Map request = (Map) ActionContext.getContext().get("request");
		if(totalprice>money){		
			request.put("nowOrder", orderForm);
			ActionContext.getContext().put("payemessage", "您的金额不足！");
		}
		else
		{
		user.setMoney(money-totalprice);
		userservice.update(user);
		orderForm.setIsPayoff("是");
		this.service.update(orderForm);
		
		System.out.println("orderForm:"+orderForm.getOrderFormId());
		
		request.put("nowOrder", orderForm);
		ActionContext.getContext().put("payemessage", "付款成功！");
		}
		return "payOrderForm";
	}
	
	//订单列表付款
	@SuppressWarnings("unchecked")
	public String payOrder(){
		double totalprice=orderForm.getTotalPrice();//订单总金额
		String username=orderForm.getUsername();
		User user=userservice.findUserByName(orderForm.getUsername());
		double money=user.getMoney();//用户所有金钱
		
		Map request = (Map) ActionContext.getContext().get("request");
		
		if(totalprice>money){
	
			request.put("orderFormByUserName", service.findOrderFormByUserName(username));
			ActionContext.getContext().put("payemessage", "您的金额不足！");
		}
		else
		{
		user.setMoney(money-totalprice);
		userservice.update(user);
		orderForm.setIsPayoff("是");
		this.service.update(orderForm);
		System.out.println("orderForm:"+orderForm.getOrderFormId());
		
		request.put("orderFormByUserName", service.findOrderFormByUserName(username));
		ActionContext.getContext().put("payemessage", "付款成功！");
		}
		return "payOrder";
	}
	
	public String inputOrderForm(){
		return "input";
	}
	//发货
	@SuppressWarnings("unchecked")
	public String conOrder(){
		orderForm.setIsConsignment("是");
		this.service.update(orderForm);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("listOrderForms", service.findAllOrderForms());
		
		return "conOrder";
	}
	//提交订单
	@SuppressWarnings("unchecked")
	public String addOrderForm(){
		this.service.save(this.orderForm);
		
		Map session = ActionContext.getContext().getSession();//获得session对象
		List<Commodity> car = (List<Commodity>)session.get("car");//取得购物车
		car.clear();
		
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("nowOrder",orderForm);
		return "addOrderForm";
	}
	
	@SuppressWarnings("unchecked")
	public String findOrderFormByUserName(){
		Map request = (Map) ActionContext.getContext().get("request");
		
		request.put("orderFormByUserName",this.service.findOrderFormByUserName(orderForm.getUsername()));
		return "findOrderFormByUserName";
	}
	
}

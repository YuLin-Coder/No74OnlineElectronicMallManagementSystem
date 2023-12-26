package cn.itbaizhan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.OrderFormDao;
import cn.itbaizhan.po.OrderForm;
import cn.itbaizhan.po.User;
import cn.itbaizhan.service.OrderFormService;
//把类交给spring管理(如同配置bean节点)此类受spring事务管理
@Component("orderFormServiceImpl")
public class OrderFormServiceImpl implements OrderFormService {
	//要调用dao层代码,所以要有OrderFormDao的对象，把其实现类靠spring注入
	@Resource(name="orderFormDaoImpl")
	private OrderFormDao orderFormDao;
	public OrderFormDao getOrderFormDao() {
		return orderFormDao;
	}

	public void setOrderFormDao(OrderFormDao orderFormDao) {
		this.orderFormDao = orderFormDao;
	}

	public void delete(OrderForm orderForm) {
		this.orderFormDao.delete(orderForm);

	}
	public List<OrderForm> findAllOrderForms() {
		return this.orderFormDao.findAllOrderForms();
	}
	public OrderForm findOrderFormById(int id) {
		
		return this.orderFormDao.findOrderFormById(id);
	}

	public void save(OrderForm orderForm) {
		this.orderFormDao.save(orderForm);

	}

	public void update(OrderForm orderForm) {
		this.orderFormDao.update(orderForm);
	}

	public OrderForm queryOrderForm(int orderFormId) {
		
		return this.orderFormDao.queryOrderForm(orderFormId);
	}

	public List<OrderForm> findOrderFormByUserName(String username) {
		
		return this.orderFormDao.findOrderFormByUserName(username);
	}

	


}

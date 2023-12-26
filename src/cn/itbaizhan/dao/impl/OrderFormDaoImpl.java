package cn.itbaizhan.dao.impl;

import java.util.List;

import javax.annotation.Resource;




import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.OrderFormDao;
import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.OrderForm;
import cn.itbaizhan.po.User;
@Component("orderFormDaoImpl")
public class OrderFormDaoImpl implements OrderFormDao {
//使用spring对Hibernate的模版 HibernateTemplate
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void delete(OrderForm orderForm) {
	hibernateTemplate.delete(orderForm);
	}
	@SuppressWarnings("unchecked")
	public List<OrderForm> findAllOrderForms() {
		String hql = "from OrderForm";
		return (List<OrderForm>)hibernateTemplate.find(hql);
	}

	public OrderForm findOrderFormById(int id) {
		OrderForm orderForm = (OrderForm)hibernateTemplate.get(OrderForm.class, id);
		return orderForm;
	}

	public void save(OrderForm orderForm) {
		System.out.println(orderForm);
	 hibernateTemplate.save(orderForm);
	}

	public void update(OrderForm orderForm) {
	hibernateTemplate.update(orderForm);

	}
	public HibernateTemplate getHibernateTmeplate() {
		return hibernateTemplate;
	}
	public void setHibernateTmeplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	public OrderForm queryOrderForm(int orderFormId) {
		
		return (OrderForm)hibernateTemplate.getSessionFactory().openSession().createQuery(
		"from OrderForm o where o.orderFormId=? ").setParameter(
				0, orderFormId).uniqueResult();

	}
	@SuppressWarnings("unchecked")
	public List<OrderForm> findOrderFormByUserName(String username) {
		System.out.println("用户名:"+username);
		String hql = "from OrderForm o where o.username=?";
		
		return (List<OrderForm>)hibernateTemplate.find(hql,username);
	}
	
}

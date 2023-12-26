package cn.itbaizhan.dao.impl;

import java.util.List;

import javax.annotation.Resource;




import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.CommodityClassDao;
import cn.itbaizhan.po.Admin;
import cn.itbaizhan.po.Commodity;
import cn.itbaizhan.po.CommodityClass;

@Component("commodityClassDaoImpl")
public class CommodityClassDaoImpl implements CommodityClassDao {
//使用spring对Hibernate的模版 HibernateTemplate
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void delete(CommodityClass commodityClass) {
	hibernateTemplate.delete(commodityClass);
	}
	@SuppressWarnings("unchecked")
	public List<CommodityClass> findAllCommodityClasses() {
		String hql = "from CommodityClass";
		return (List<CommodityClass>)hibernateTemplate.find(hql);
	}

	public CommodityClass findCommodityClassById(int id) {
		CommodityClass commodityClass = (CommodityClass)hibernateTemplate.get(CommodityClass.class, id);
		return commodityClass;
	}
	
	public CommodityClass findCommodityClassBName(String name){
		
	return  (CommodityClass) hibernateTemplate.getSessionFactory().openSession().createQuery(
	"from CommodityClass c where c.commodityClassName=? ").setParameter(0, name).uniqueResult();
	}
	
	public CommodityClass findCommodityClassByName(String name) {
		System.out.println("findbyname:"+name);
		CommodityClass commodityClass = (CommodityClass)hibernateTemplate.get(CommodityClass.class, name);
		System.out.println("commodityClass:"+commodityClass);
		return commodityClass;
	
	}
	
	public void save(CommodityClass CommodityClass) {
		System.out.println(CommodityClass);
	 hibernateTemplate.save(CommodityClass);
	}

	public void update(CommodityClass CommodityClass) {
	hibernateTemplate.update(CommodityClass);

	}
	public HibernateTemplate getHibernateTmeplate() {
		return hibernateTemplate;
	}
	public void setHibernateTmeplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	

}

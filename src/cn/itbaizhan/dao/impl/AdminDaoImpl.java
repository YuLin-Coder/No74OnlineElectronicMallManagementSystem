package cn.itbaizhan.dao.impl;

import java.util.List;

import javax.annotation.Resource;




import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.AdminDao;
import cn.itbaizhan.po.Admin;
@Component("adminDaoImpl")
public class AdminDaoImpl implements AdminDao {
//使用spring对Hibernate的模版 HibernateTemplate
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void delete(Admin admin) {
	hibernateTemplate.delete(admin);
	}
	@SuppressWarnings("unchecked")
	public List<Admin> findAllAdmins() {
		String hql = "from Admin";
		return (List<Admin>)hibernateTemplate.find(hql);
	}

	public Admin findAdminById(int id) {
		Admin admin = (Admin)hibernateTemplate.get(Admin.class, id);
		return admin;
	}

	public void save(Admin admin) {
		System.out.println(admin);
	 hibernateTemplate.save(admin);
	}

	public void update(Admin admin) {
	hibernateTemplate.update(admin);

	}
	public HibernateTemplate getHibernateTmeplate() {
		return hibernateTemplate;
	}
	public void setHibernateTmeplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//获取用户
	public Admin getUserByLoginNameAndPassword(String username, String password) {
		//String[] values={username, password}; 
		//String hql = "from User u where u.username=? and u.password=?";
		//(List<User>)hibernateTemplate.find(hql, values);
		System.out.println("用户名:"+username);
		
		return  (Admin) hibernateTemplate.getSessionFactory().openSession().createQuery(
		"from Admin a where a.username=? and a.password=?").setParameter(0, username).setParameter(1, password).uniqueResult();
	}

	

}

package cn.itbaizhan.dao.impl;

import java.util.List;

import javax.annotation.Resource;




import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.UserDao;
import cn.itbaizhan.po.User;
@Component("userDaoImpl")
public class UserDaoImpl implements UserDao {
//使用spring对Hibernate的模版 HibernateTemplate
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	public void delete(User user) {
	hibernateTemplate.delete(user);
	}
	@SuppressWarnings("unchecked")//不检查，当编码可能存在警告时，比如安全警告，可以用它来消除
	public List<User> findAllUsers() {
		String hql = "from User";
		return (List<User>)hibernateTemplate.find(hql);
	}

	public User findUserById(int id) {
		User user = (User)hibernateTemplate.get(User.class, id);
		return user;
	}

	public void save(User user) {
		System.out.println(user);
	 hibernateTemplate.save(user);
	}

	public void update(User user) {
	hibernateTemplate.update(user);

	}
	public HibernateTemplate getHibernateTmeplate() {
		return hibernateTemplate;
	}
	public void setHibernateTmeplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	//获取用户
	public User getUserByLoginNameAndPassword(String username, String password) {
		
		System.out.println("用户名"+username);
		
		
		return  (User) hibernateTemplate.getSessionFactory().openSession().createQuery(
		"from User u where u.username=? and u.password=?").setParameter(0, username).setParameter(1, password).uniqueResult();
	}
	public User findUserByName(String username) {
		System.out.println("用户名:"+username);
				
		return  (User) hibernateTemplate.getSessionFactory().openSession().createQuery(
		"from User u where u.username=?").setParameter(0, username).uniqueResult();
	
		
	}

	public User queryUser(String username) {
		
		//String hql = "from User";
		return (User)hibernateTemplate.getSessionFactory().openSession().createQuery(
				"from User u where u.username=? ").setParameter(
						0, username).uniqueResult();
		
	}
	public User findUserByinfo(String username, String name, String sex,
			String phone, String post, String address, String email) {
		return (User)hibernateTemplate.getSessionFactory().openSession().createQuery(
		"from User u where u.username=? and u.name=? and u.sex=? and u.phone=? and u.post=? and u.address=? and u.email=?").setParameter(
				0, username).setParameter(1,name).setParameter(2,sex).setParameter(3,phone).setParameter(4,post).setParameter(5,address).setParameter(6,email).uniqueResult();

}

	

}

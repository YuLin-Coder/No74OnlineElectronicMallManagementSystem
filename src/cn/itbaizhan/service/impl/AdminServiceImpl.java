package cn.itbaizhan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.itbaizhan.dao.AdminDao;
import cn.itbaizhan.po.Admin;
import cn.itbaizhan.service.AdminService;
//把类交给spring管理(如同配置bean节点)此类受spring事务管理
@Component("adminServiceImpl")
public class AdminServiceImpl implements AdminService {
	//要调用dao层代码,所以要有UserDao的对象，把其实现类靠spring注入
	@Resource(name="adminDaoImpl")
	private AdminDao adminDao;
	public AdminDao getUserDao() {
		return adminDao;
	}

	public void setUserDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public void delete(Admin user) {
		this.adminDao.delete(user);

	}
	public List<Admin> findAllAdmins() {
		return this.adminDao.findAllAdmins();
	}
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		return this.adminDao.findAdminById(id);
	}

	public void save(Admin admin) {
		this.adminDao.save(admin);

	}

	public void update(Admin admin) {
		this.adminDao.update(admin);
	}


	public Admin getUserByLoginNameAndPassword(String name, String password) {
		
		return this.adminDao.getUserByLoginNameAndPassword(name,password);
	}


}

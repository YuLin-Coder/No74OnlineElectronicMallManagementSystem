package cn.itbaizhan.service;

import java.util.List;

import cn.itbaizhan.po.Admin;

public interface AdminService {
//	和AdminDao的方法一样，可以封装，因为这边只是调用
	public void save(Admin admin);
	public void delete(Admin id);
	public Admin findAdminById(int admin);
	public List<Admin> findAllAdmins();
	public void update(Admin admin); 
	//public void initPassword(User user);
	public Admin getUserByLoginNameAndPassword(String username, String password);
}

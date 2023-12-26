package cn.itbaizhan.dao;

import java.util.List;

import cn.itbaizhan.po.User;

public interface UserDao {
	public void save(User user);
	public void delete(User user);
	public User findUserById(int id);
	public User findUserByinfo(String username, String name, String sex,String phone,
			String post,String address, String email);
	public List<User> findAllUsers();
	public void update(User user);
	//public void initPassword(User user);
	public User getUserByLoginNameAndPassword(String username, String password);
	public User findUserByName(String username);
	public User queryUser(String username);
	
}

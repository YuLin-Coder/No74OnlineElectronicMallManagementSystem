package cn.itbaizhan.dao;

import java.util.Date;
import java.util.List;

import cn.itbaizhan.po.Message;

public interface MessageDao {
	public void save(Message message);
	public void delete(Message message);
	public Message findMessageById(int id);
	public List<Message> findAllMessages();
	public Message queryMessage(String username);
	
}

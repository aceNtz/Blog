package blog.main.dao;

import java.util.List;

import blog.main.entity.Message;

public interface MessageDAO {

	
	public void saveMessage(Message message);
	
	public List<Message> getMessageList();
	
	public List<Message> getUnreadMessageList();
	
	public Message getMessage(int id);	
	
	public void deleteMessage(int id);
}

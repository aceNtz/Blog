package blog.main.dao;

import java.util.List;

import blog.main.entity.Blogger;
import blog.main.entity.Role;

public interface BloggerDAO {

	
	public List<Blogger> getBloggerList();
	
	public List<Blogger> getBannedBloggerList();
	
	public void saveBlogger(Blogger blogger);
	
	public Blogger getBlogger(String username);
	
	public void banUnbanBlogger(String username);
	
	public List<Role> getRoles();
	
}

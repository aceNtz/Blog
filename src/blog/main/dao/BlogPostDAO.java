package blog.main.dao;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import blog.main.entity.BlogPost;

public interface BlogPostDAO {

	
	public List<BlogPost> getBlogPostList();
	
	public List<BlogPost> getMyBlogPostList(Principal principal);
	
	public List<BlogPost> getAllEnabledBlogPosts();
	
	public List<BlogPost> getThreeImportantBlogsForIndexPage();
	
	public List<BlogPost> getThreeRecentBlogPosts();
	
	public List<BlogPost> getThreeMostViewedBlogPostsFromLast30Days() throws ParseException;
	
	public List<BlogPost> getTwelweRecentBlogPosts();
	
	public BlogPost getBlogPostWithTagsAndComments(int id);
	
	public BlogPost getBlogPost(int id);
	
	public void saveBlogPost(BlogPost blogPost);
	
	public void updateImportantBlogPost(int id);
	
	public void deleteBlogPost(int id);
	
	
	
}

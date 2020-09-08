package blog.main.dao;

import java.util.List;

import blog.main.entity.Comment;

public interface CommentDAO {

	
	public List<Comment> getCommentList();
	
	public Comment getComment(int id);
	
	public void saveComment(Comment comment);
}

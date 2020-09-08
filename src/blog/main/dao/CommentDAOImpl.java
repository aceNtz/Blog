package blog.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Comment> getCommentList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Comment> query = session.createQuery("from Comment c order by c.id DESC");
		List<Comment> list = query.getResultList();
		
		return list;
	}


	@Transactional
	@Override
	public Comment getComment(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Comment comment = session.get(Comment.class, id);
		
		return comment;
	}


	@Transactional
	@Override
	public void saveComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(comment);
		
	}
	
	

}

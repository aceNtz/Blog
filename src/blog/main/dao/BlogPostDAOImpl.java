package blog.main.dao;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.BlogPost;

@Repository
public class BlogPostDAOImpl implements BlogPostDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	@Transactional
	@Override
	public void saveBlogPost(BlogPost blogPost) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(blogPost);
		
	}

	@Transactional
	@Override
	public List<BlogPost> getBlogPostList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("from BlogPost");
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost b : list) {
			Hibernate.initialize(b.getComments());
		}
		
		return list;
	}

	
	@Transactional
	@Override
	public List<BlogPost> getMyBlogPostList(Principal principal) {
		Session session = sessionFactory.getCurrentSession();
		
		String username = principal.getName();
		Query<BlogPost> query = session.createQuery("FROM BlogPost WHERE author.username=:username");
		query.setParameter("username", username);
		
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost b : list) {
			Hibernate.initialize(b.getComments());
		}
		
		
		return list;
	}


	@Transactional
	@Override
	public BlogPost getBlogPost(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		BlogPost post = session.get(BlogPost.class, id);
		Hibernate.initialize(post.getComments());
		
		return post;
	}




	@Transactional
	@Override
	public BlogPost getBlogPostWithTagsAndComments(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		BlogPost post = session.get(BlogPost.class, id);
		Hibernate.initialize(post.getTags());
		Hibernate.initialize(post.getComments());
		
		return post;
	}

	
	@Transactional
	@Override
	public void updateImportantBlogPost(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		BlogPost bp = session.get(BlogPost.class, id);
		
		bp.setImportant(!bp.getImportant());
		
		session.update(bp);		
	}

	
	@Transactional
	@Override
	public void deleteBlogPost(int id) {
		Session session = sessionFactory.getCurrentSession();

		BlogPost bp = session.get(BlogPost.class, id);
		
		session.delete(bp);
		
	}

	
	@Transactional
	@Override
	public List<BlogPost> getThreeImportantBlogsForIndexPage() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.important = 1 AND bp.enabled = 1 ORDER BY bp.id DESC").setMaxResults(3);
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost bp : list) {
			Hibernate.initialize(bp.getComments());
		}
		
		
		return list;
		
	}

	@Transactional
	@Override
	public List<BlogPost> getTwelweRecentBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.enabled = 1 ORDER BY bp.id DESC").setMaxResults(12);
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost bp : list) {
			Hibernate.initialize(bp.getComments());
		}
		
		return list;
	}

	
	@Transactional
	@Override
	public List<BlogPost> getThreeRecentBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.enabled = 1 ORDER BY bp.id DESC").setMaxResults(3);
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost b : list) {
			Hibernate.initialize(b.getComments());
		}
		
		return list;
	}
	
	@Transactional
	@Override
	public List<BlogPost> getThreeMostViewedBlogPostsFromLast30Days() throws ParseException {
		Session session = sessionFactory.getCurrentSession();
		
		LocalDate dateThirtyDaysBack = LocalDate.now().minusDays(30);
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.date "
							+ ">= :thirtyDays AND bp.enabled = 1 ORDER BY bp.viewCount DESC").setMaxResults(3);
		query.setParameter("thirtyDays", dateThirtyDaysBack);
		
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost bp : list) {
			Hibernate.initialize(bp.getComments());
		}
		
		return list;
	}

	
	@Transactional
	@Override
	public List<BlogPost> getAllEnabledBlogPosts() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<BlogPost> query = session.createQuery("SELECT bp FROM BlogPost bp WHERE bp.enabled = 1 ORDER BY bp.id DESC");
		List<BlogPost> list = query.getResultList();
		
		for(BlogPost bp : list) {
			Hibernate.initialize(bp.getComments());
		}
		
		
		return list;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

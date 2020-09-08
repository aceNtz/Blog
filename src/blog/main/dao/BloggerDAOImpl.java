package blog.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Blogger;
import blog.main.entity.Role;

@Repository
public class BloggerDAOImpl implements BloggerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Blogger> getBloggerList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Blogger> query = session.createQuery("select b from users b where b.enabled = 1", Blogger.class);
		List<Blogger> list = query.getResultList();
		
		return list;
	}
	
	@Transactional
	@Override
	public List<Blogger> getBannedBloggerList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Blogger> query = session.createQuery("select b from users b where b.enabled = 0", Blogger.class);
		List<Blogger> list = query.getResultList();
		
		
		return list;
	}


	@Transactional
	@Override
	public void saveBlogger(Blogger blogger) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(blogger);
	}

	
	@Transactional
	@Override
	public Blogger getBlogger(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		Blogger blogger = session.get(Blogger.class, username);
		
		return blogger;
	}


	@Transactional
	@Override
	public void banUnbanBlogger(String username) {
		Session session = sessionFactory.getCurrentSession();
		
		Blogger blogger = session.get(Blogger.class, username);
		
		blogger.setEnabled(!blogger.getEnabled());
		
		session.saveOrUpdate(blogger);
	}



	@Transactional
	@Override
	public List<Role> getRoles() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Role> query = session.createQuery("from roles", Role.class);
		List<Role> roles = query.getResultList();
		
		return roles;
	}

}

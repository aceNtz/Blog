package blog.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Category;


@Repository
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public List<Category> getCategoryList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Category> query = session.createQuery("from Category");
		List<Category> list = query.getResultList();
		
		return list;
	}


	@Transactional
	@Override
	public void saveCategory(Category category) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(category);
	}

	
	@Transactional
	@Override
	public List<Category> getFiveMostUsedCategories() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Category> query = session.createQuery("from Category c order by c.timesUsed DESC").setMaxResults(5);
		List<Category> list = query.getResultList();
		
		return list;
	}


	@Transactional
	@Override
	public Category getCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, id);
		
		return category;
	}


	@Transactional
	@Override
	public void deleteCategory(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Category category = session.get(Category.class, id);
		
		session.delete(category);
	}


	@Transactional
	@Override
	public List<Category> getCategoryListForBlogPage(int orderBy) {
		Session session = sessionFactory.getCurrentSession();
		
		List<Category> list;
		Query<Category> query;
		
		if(orderBy == 0) {
			query = session.createQuery("from Category c order by c.id").setMaxResults(6);
		}
		else if(orderBy == 1) {
			query = session.createQuery("from Category c order by c.name").setMaxResults(6);
		}
		else {
			query = session.createQuery("from Category c order by c.id").setMaxResults(6);
		}
		list = query.getResultList();
		
		return list;
	}


	@Transactional
	@Override
	public List<Category> getFourImportantCategories() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Category> query = session.createQuery("SELECT c FROM Category c WHERE c.important = 1 ORDER BY c.id DESC").setMaxResults(4);
		List<Category> list = query.getResultList();
		
		return list;
	}



	
}

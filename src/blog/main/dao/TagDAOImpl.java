package blog.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.Tag;


@Repository
public class TagDAOImpl implements TagDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public List<Tag> getTagList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Tag> query = session.createQuery("from Tag");
		List<Tag> tagList = query.getResultList();
		
		
		return tagList;
	}
	
	
	@Transactional
	@Override
	public List<Tag> getSevenMostUsedTags() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Tag> query = session.createQuery("from Tag t order by t.timesUsed DESC").setMaxResults(7);
		List<Tag> list = query.getResultList();
		
		return list;
	}
	

	@Transactional
	@Override
	public void saveTag(Tag tag) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(tag);
	}

	@Transactional
	@Override
	public Tag getTag(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Tag tag = session.get(Tag.class, id);
		
		return tag;
		}

	@Transactional
	@Override
	public void deleteTag(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Tag tag = session.get(Tag.class, id);
		
		session.delete(tag);
	}

	
	//TODO
	@Transactional
	@Override
	public List<Tag> getListOfMostFrequentlyUsedTags() {
		Session session = sessionFactory.getCurrentSession();
		
		
		return null;
	}

	
	@Transactional
	@Override
	public List<Tag> getTagsById(List<Integer> ids) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Tag> query = session.createQuery("select t from Tag t where t.id IN (:ids)");
		query.setParameter("ids", ids);
		List<Tag> list = query.getResultList();
		
		return list;
	}

	
	
	
	

}

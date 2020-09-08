package blog.main.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.SliderElement;

@Repository
public class SliderElementDAOImpl implements SliderElementDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	@Transactional
	@Override
	public SliderElement getSliderElement(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(SliderElement.class, id);
	}

	
	@Transactional
	@Override
	public List<SliderElement> getSliderElementList() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<SliderElement> query = session.createQuery("from SliderElement");
		List<SliderElement> list = query.getResultList();
		
		return list;
	}
	
	
	@Transactional
	@Override
	public List<SliderElement> getSliderElementListForIndexPage() {
		Session session = sessionFactory.getCurrentSession();
		SliderElement element = new SliderElement();
		Query<SliderElement> query;
		//TODO
//		int orderBy = element.getOrderBy(); 
//		
//		if(orderBy == 0) {
//		query = session.createQuery("select s from SliderElement s where s.showInSlider = 1 AND order by s.id");
//		}
//		else if(orderBy == 1){
//			query = session.createQuery("select s from SliderElement s where s.showInSlider = 1 AND order by s.name");
//		}
//		else {
//			query = session.createQuery("select s from SliderElement s where s.showInSlider = 1 AND order by s.buttonName");
//		}
		query = session.createQuery("select s from SliderElement s where s.showInSlider = 1");
		List<SliderElement> list = query.getResultList();
		
		return list;
	}


	@Transactional
	@Override
	public void saveSliderElement(SliderElement sliderElement) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(sliderElement);
		
	}


	@Transactional
	@Override
	public void deleteSliderElement(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		SliderElement element = session.get(SliderElement.class, id);
		session.delete(element);
		
	}

	
	


	
	
	
	

	
}

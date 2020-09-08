package blog.main.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import blog.main.entity.FrontText;

@Repository
public class FrontTextDAOImpl implements FrontTextDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Transactional
	@Override
	public FrontText getFrontText() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<FrontText> query = session.createQuery("from FrontText");
		FrontText ft = query.getSingleResult();
		
		return ft;
		
	}


	
	@Transactional
	@Override
	public void updateFrontText(FrontText frontText) {
		Session session = sessionFactory.getCurrentSession();
		
		session.update(frontText);
		
	}
	
	
	
	
	
	
}

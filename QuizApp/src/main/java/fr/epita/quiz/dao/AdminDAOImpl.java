package fr.epita.quiz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import fr.epita.quiz.model.Admin;
/**
 * this class is for checking the admin credentials with the database
 * @author Roshnee
 *
 */

public class AdminDAOImpl implements AdminDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
/**
 * Method is for validating the admin login credentials
 */
	@Override
	public Admin loginAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Admin as s where s.email= ?0 and s.password= ?1";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, admin.getEmail());
			query.setParameter(1, admin.getPassword() );
			admin = (Admin)query.uniqueResult();
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return admin;
	}




}

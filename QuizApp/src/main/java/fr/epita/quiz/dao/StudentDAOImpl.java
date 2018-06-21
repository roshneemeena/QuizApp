package fr.epita.quiz.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.model.Students;

@Repository
public class StudentDAOImpl implements StudentDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void savestudent(Students student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(student!=null) {
			try {
				session.save(student);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Students loginStudent(Students student) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Students as s where s.email= ?0 and s.password= ?1";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, student.getEmail());
			query.setParameter(1, student.getPassword() );
			student = (Students)query.uniqueResult();
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return student;
	}

}

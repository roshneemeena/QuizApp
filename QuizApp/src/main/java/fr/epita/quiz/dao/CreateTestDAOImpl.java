package fr.epita.quiz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.model.MCQChoice;

@Repository
public class CreateTestDAOImpl implements CreateTestDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void savequestion(MCQChoice MCQchoice) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(MCQchoice!=null) {
			try {
				session.save(MCQchoice);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
		
	}
		
	}



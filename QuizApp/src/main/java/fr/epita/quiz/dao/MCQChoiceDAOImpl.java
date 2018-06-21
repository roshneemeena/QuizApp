package fr.epita.quiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.model.MCQChoice;

@Repository
public class MCQChoiceDAOImpl implements MCQChoiceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	private static final int NO_OF_RESULT = 1;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<MCQChoice> loadQuestion() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<MCQChoice> questionList = null;
		String hql = "from MCQChoice as m order by m.id";
		
		try {
			
			Query query = session.createQuery(hql);
            query.setMaxResults(1);
			questionList = query.list();
			tx.commit();
			session.close();
			
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return questionList;
		
	}

	@Override
	public List<MCQChoice> loadNextQuestion(int questionId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<MCQChoice> questionList = null;
		String hql = "from MCQChoice m where m.id > "+questionId+" order by m.id ASC";
		try {
			Query query = session.createQuery(hql);
			questionList = query.list();
			tx.commit();
			session.close();
		}
		catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		
		return questionList;
	}

	@Override
	public List<MCQChoice> loadQuestion(int questionId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<MCQChoice> questionList = null;
		String hql = "from MCQChoice m  where m.id ="+questionId;
		try {
			
			Query query = session.createQuery(hql);
			 questionList = query.list();
			 tx.commit();
			 session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		   return questionList;
	}

}

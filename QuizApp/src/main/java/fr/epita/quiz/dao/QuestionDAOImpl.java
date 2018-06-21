package fr.epita.quiz.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.epita.quiz.model.MCQChoice;
import fr.epita.quiz.model.Question;

@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static final int NO_OF_RESULT = 1;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Question> loadQuestion() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Question> questionList = null;
		String hql = "from Question as q order by q.id";
		
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
	public List<Question> loadNextQuestion(int questionId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Question> questionList = null;
		String hql = "from Question q where q.id > "+questionId+" order by q.id ASC";
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
	public List<Question> loadQuestion(int questionId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Question> questionList = null;
		String hql = "from Question q  where q.id ="+questionId;
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

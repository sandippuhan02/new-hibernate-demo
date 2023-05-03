package com.mapping.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Answer;
import com.mapping.entity.Question;

public class OneToOneDemo {

	public static void main(String[] args) {
		
		Answer a1 = new Answer();
		a1.setAid(343);
		a1.setAnswer("java is a programming language");
		
		Answer a2 = new Answer();
		a1.setAid(344);
		a1.setAnswer("Collection is working with API full of class and packages ");
		
		
		Question q1 = new Question();
		q1.setQuestionId(12121);
		q1.setQuestion("What is java ?");
		q1.setAns(a1);
		
		Question q2 = new Question();
		q2.setQuestionId(242);
		q2.setQuestion("What is Collection ?");
		q2.setAns(a2);
		
		Configuration cfg = new Configuration().configure();
		SessionFactory f = cfg.buildSessionFactory();
		Session s = f.openSession();
		Transaction t = s.beginTransaction();
		s.save(q1);
		t.commit();
		s.close();

	}

}

package com.kmowers.lab24;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

@javax.persistence.Entity
@javax.persistence.Table(name = "Users")

public class DAO {
	
	private static SessionFactory factory;
	private static void setupFactory() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) { ; }

		Configuration configuration = new Configuration();
		//modify these to match your XML files
		configuration.configure("hibernate.cfg.xml");
		configuration.addResource("user.hbm.xml");
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
				applySettings(configuration.getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}
	public static int addUser(User u) {
		if (factory == null)
			setupFactory();
		
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		//save this specific record
		int i = (Integer)hibernateSession.save(u);
		hibernateSession.getTransaction().commit();
		hibernateSession.close();
		return i;
	}
	
	public static List<User> getAllUsers(){
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();

		String hql = "FROM User";
		List<User> users = hibernateSession.createQuery(hql).list();
		hibernateSession.getTransaction().commit();
		hibernateSession.close();

		return users;
	}
	
	public static void deleteUser(int id) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		String hql = "DELETE FROM User WHERE idUsers = :id";
		Query query = hibernateSession.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
		hibernateSession.close();
	}
	
	public static void changeUser(String username, String password, String email, String fullname, int id) {
		if (factory == null)
			setupFactory();
		Session hibernateSession = factory.openSession();
		hibernateSession.getTransaction().begin();
		String hql = "UPDATE User SET username= :username , password= :password , email= :email , fullname= :fullname WHERE idUsers= :id";
		Query query = hibernateSession.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		query.setParameter("email", email);
		query.setParameter("fullname", fullname);
		query.setParameter("id", id);
		query.executeUpdate();
		hibernateSession.close();
	}
}
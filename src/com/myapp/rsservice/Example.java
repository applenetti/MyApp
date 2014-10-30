package com.myapp.rsservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.myapp.model.User;
import com.myapp.util.HibernateUtil;

@Path("/example")
public class Example {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getServiceName() {
		Integer userid = 0;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			User user = new User();
			user.setName("Raja");
			user.setSex("M");
			userid = (Integer) session.save(user);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (!transaction.wasCommitted()) {
				transaction.rollback();
			}
		}
		finally {
			session.close();
		}
		return "example------>" + userid + "<-------sucess";
	}
}

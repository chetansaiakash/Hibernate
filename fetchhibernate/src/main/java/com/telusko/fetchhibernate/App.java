package com.telusko.fetchhibernate;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
    	Configuration config = new Configuration().configure().addAnnotatedClass(Laptop.class).addAnnotatedClass(Alien.class);
    	SessionFactory sf = config.buildSessionFactory();
    	Session session=sf.openSession();
    	
    	session.beginTransaction();
    	
    	Alien a1=session.get(Alien.class,1);
    	
    	System.out.println(a1.getAname());
    	Collection<Laptop> laps=a1.getLaps();
    	
    	for(Laptop la:laps) {
    		System.out.println(la);
    	}
    	
    	
    	session.getTransaction().commit();
    }
}

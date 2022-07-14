package com.telusko.DemoHib;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
       AlienName an=new AlienName();
       an.setFname("ChetanSaiAkash");
       an.setLname("Kancharla");
       an.setMname("KrishnaRao");
    	
    	
       Alien telusko = new Alien();
       telusko.setAid(101);
       telusko.setColor("Green");
       telusko.setAname(an);
       
       
    	
//      Fetching records    	
//    	Alien telusko=null;
    	
//    	 Alien telusko=new Alien();
//        to store data
//        telusko.setAid(102);
//        telusko.setAname("Sarang");
//        telusko.setColor("White");
        
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Alien.class); // configuration is an class
        
        ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        
        SessionFactory sf=con.buildSessionFactory(reg); //session factory is also an interface
        Session session=sf.openSession(); //session is an interface..
        
        //whenever we want to save data in database,we are making some changes,we have to follow ACID properties
        //to maintain all those ACID properties, all these changes should be a part of transaction
        Transaction tx=session.beginTransaction();
        
        
//        to store data in database
//        session.save(telusko);
        
       

// 		  fetch records         
//        telusko = (Alien)session.get(Alien.class,101);
        
        session.save(telusko);
        
        
        tx.commit();
        
        System.out.println(telusko);
    }
}

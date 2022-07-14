package com.telusko.HQLDemo;

import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Configuration config=new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry registry= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        SessionFactory sf=config.buildSessionFactory(registry);
        Session session=sf.openSession();
        
        session.beginTransaction();
        
//        Insert values
//        Random r=new Random();
//        
//        for(int i=1;i<=50;i++) {
//        	Student s=new Student();
//        	s.setRollno(i);
//        	s.setName("Name "+i);
//        	s.setMarks(r.nextInt(100));
//        	session.save(s);
//        }
        
        
        //Printing values
        Query<Student> q=session.createQuery("from Student where rollno=7");
        List<Student>students=q.list();
        
        for(Student s:students) {
        	System.out.println(s);
        }
        
        
        
        session.getTransaction().commit();
    }
}

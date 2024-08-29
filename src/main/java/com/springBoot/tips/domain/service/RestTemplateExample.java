package com.springBoot.tips.domain.service;

import com.springBoot.tips.models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RestTemplateExample {
    public class HibernateFirstLevelCacheExample {

        public static void main(String[] args) {
            // Step 1: Configure Hibernate and build a SessionFactory
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            SessionFactory sessionFactory = configuration.buildSessionFactory();

            // Step 2: Open a Session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // Step 3: Retrieve an entity for the first time (triggers a DB query)
            Employee emp1 = session.get(Employee.class, 1L);
            System.out.println("First retrieval from DB: " + emp1.getFirstName());

            // Step 4: Retrieve the same entity again (from the first-level cache)
            Employee emp2 = session.get(Employee.class, 1L);
            System.out.println("Second retrieval from First-Level Cache: " + emp2.getFirstName());

            // Step 5: Commit transaction and close session
            session.getTransaction().commit();
            session.close();

            // Close SessionFactory
            sessionFactory.close();
        }
    }
}

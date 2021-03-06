package com.mcg.hibernate.demo;

import com.mcg.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteHibernateCourseDemo {

    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int courseId = 1;
            Course course = session.get(Course.class, courseId);

            System.out.println("Deleting course: " + course);

            session.delete(course);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

            factory.close();
        }
    }
}

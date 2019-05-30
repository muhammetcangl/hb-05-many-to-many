package com.mcg.hibernate.demo;

import com.mcg.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCoursesForMuhammetcanDemo {

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

            int studentId = 1;
            Student student = session.get(Student.class, studentId);

            System.out.println("Loaded student: " + student);
            System.out.println("Courses: " + student.getCourses());



            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

            factory.close();
        }
    }
}

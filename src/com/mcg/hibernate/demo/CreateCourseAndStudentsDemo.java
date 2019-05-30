package com.mcg.hibernate.demo;

import com.mcg.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

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

            Course course = new Course("Hibernate Kursu");

            System.out.println("Saving the course ...");

            session.save(course);

            System.out.println("Saved the course: " + course );

            Student student1 = new Student("Muhammetcan", "Gul" , "muhammetcamgl@gmail.com");
            Student student2 = new Student("Deneme", "Deneme", "deneme@gmail.com");

            course.addStudent(student1);
            course.addStudent(student2);

            System.out.println("Saving students ...");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudents());

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {

            session.close();

            factory.close();
        }
    }
}

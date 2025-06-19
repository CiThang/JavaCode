package exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentManager {

    private final SessionFactory sessionFactory;

    public StudentManager() {
        // Create session factory from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    // Method to list all students
    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            List<Student> students = session.createQuery("FROM Student", Student.class).getResultList();
            tx.commit();
            return students;
        }
    }

    // Method to add a new student
    public void addStudent(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            session.save(student);
            tx.commit();
        }
    }

    // Method to update an existing student
    public void updateStudent(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            session.update(student);
            tx.commit();
        }
    }

    // Method to delete a student
    public void deleteStudent(Long studentId) {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction tx = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.delete(student);
            }
            tx.commit();
        }
    }

    // Close session factory
    public void close() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        // Example usage: add a student
        Student newStudent = new Student("ChiThang", 20, 3.8);
        manager.addStudent(newStudent);

        // Example usage: list all students
        List<Student> students = manager.getAllStudents();
        for (Student student : students) {
            System.out.println(student.getName() + " - Age: " + student.getAge() + " - GPA: " + student.getGpa());
        }

        // Example usage: update a student
        Student studentToUpdate = students.get(0);
        studentToUpdate.setGpa(4.0);
        manager.updateStudent(studentToUpdate);

        // Example usage: delete a student
//        Long studentIdToDelete = students.get(1).getId();
    //    manager.deleteStudent(studentIdToDelete);

        // Close the session factory
        manager.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentbasew8_ex6;
import componentbasew8_ex6.Student;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentTable {public static void insertStudent(Student emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("componentBaseW8_Ex6PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(emp);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void updateStudent(Student emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("componentBaseW8_Ex6PU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, emp.getId());
        fromDb.setName(emp.getName());
        fromDb.setGpa(emp.getGpa());
        em.getTransaction().begin();
        try {
            em.persist(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    public static void removeStudent(Student emp) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("componentBaseW8_Ex6PU");
        EntityManager em = emf.createEntityManager();
        Student fromDb = em.find(Student.class, emp.getId());
        em.getTransaction().begin();
        try {
            em.remove(fromDb);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
                
    }
    
}

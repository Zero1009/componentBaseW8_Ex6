/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package componentbasew8_ex6;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ComponentBaseW8_Ex6 {

    public static void main(String[] args) {
        Student std = new Student(1, "AUI", 4.00);
        Student std2 = new Student(1, "POND", 2.50);

        // StudentTable.insertStudent(std);
        StudentTable.updateStudent(std);
        // StudentTable.removeStudent(std);
    }

    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("componentBaseW8_Ex6PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}

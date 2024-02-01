package org.example;

import jakarta.persistence.*;
import org.example.entity.Player;

public class Main {
    public static void main(String[] args) {
        //createRecord("pruebaClave");
        //retrieveRecord(1);
        //updateRecord(1, "nuevaClave");
        //deleteRecord(1);
    }

    public static void deleteRecord (int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Long key = Long.valueOf(id);
        Player p = entityManager.find(Player.class, key);
        entityManager.remove(p);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static void updateRecord(int id, String password){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Long key = Long.valueOf(id);
        Player p = entityManager.find(Player.class, id);
        p.setPassword(password);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static void retrieveRecord(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Long key = Long.valueOf(id);
        Player p = entityManager.find(Player.class, key);

        System.out.println(p.getPassword());

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public static void createRecord(String password){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-tutorial");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Player p = new Player();
        p.setPassword(password);

        entityManager.persist(p);
        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
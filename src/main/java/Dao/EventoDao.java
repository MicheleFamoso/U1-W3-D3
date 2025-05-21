package Dao;

import entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {
    private EntityManager em;

    public EventoDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Evento evento){
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(int id){
        return em.find(Evento.class, id);
    }

    public void remove(int id){
        Evento evento = getById(id);

        if(evento!=null){
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
        }
        else{
            System.out.println("Evento con id " + id + " non trovato");
        }
    }

    public void close(){
        em.close();

    }
}

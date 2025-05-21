package Dao;

import entities.Evento;
import entities.Location;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDao {

    private EntityManager em;

    public LocationDao(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        em = emf.createEntityManager();
    }

    public void save(Location location){
        em.getTransaction().begin();
        em.persist(location);
        em.getTransaction().commit();
    }

    public Location getById(int id){
        return em.find(Location.class, id);
    }

    public void remove(int id){
        Location evento = getById(id);

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

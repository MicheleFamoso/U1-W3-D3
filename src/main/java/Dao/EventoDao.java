package Dao;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public List<Concerto> getConcertoStreaming(boolean st){
        TypedQuery<Concerto> query =   em.createQuery("select c from Concerto c where c.inStreaming =:st", Concerto.class);
      query.setParameter("inStreaming",st);
      return query.getResultList();
    }

    public List<Concerto> getGenereC (Genere genere){
        TypedQuery<Concerto> query =   em.createQuery("select c from Concerto c where c.genere =:st", Concerto.class);
        query.setParameter("st",genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVCasa (){
        TypedQuery<PartitaDiCalcio> query =   em.createNamedQuery("partiteVinteCasa", PartitaDiCalcio.class);
        return query.getResultList();}

    public List<PartitaDiCalcio> getPartiteVOspite (){
        TypedQuery<PartitaDiCalcio> query =   em.createNamedQuery("partiteVinteOspite", PartitaDiCalcio.class);
        return query.getResultList();}

    public List<GaraDiAtletica> getGaraVincitore(Persona v){

        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where g.vincitore=:vincitore ", GaraDiAtletica.class);
            query.setParameter("vincitore",v);
            return query.getResultList();
    }

    public List<GaraDiAtletica> getPartecipanti(Persona p){

        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where :part MEMBER OF g.atleti", GaraDiAtletica.class);
        query.setParameter("part",p);
        return query.getResultList();
    }





    }


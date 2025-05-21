package entities;

import Dao.EventoDao;
import Dao.LocationDao;
import Dao.PartecipazioneDao;
import Dao.PersonaDao;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Mao
        PersonaDao personaDao = new PersonaDao();
        EventoDao eventodao = new EventoDao();
        PartecipazioneDao partecipazioneDao = new PartecipazioneDao();
        LocationDao locationDao = new LocationDao();


        //Evento
        Evento e1 = new Evento("Concerto", LocalDate.of(2020,5,7),
                "Bellissimo",TipoEvento.PUBBLICO,45678);

        Evento e2 = new Evento("Concerto", LocalDate.of(2010,5,7),
                "Vuoto",TipoEvento.PUBBLICO,678);
        //salva
        eventodao.save(e1);
        eventodao.save(e2);

        //Location da assegnare
        Location l1 = new Location("Stadio","Napoli");
        Location l2 = new Location("Stadio","Napoli");
        //Salva
        locationDao.save(l1);
        locationDao.save(l2);
        //setta
        e1.setLocation(l1);
        e2.setLocation(l2);
        //Salva
        locationDao.save(l1);
        locationDao.save(l2);


        //persona
      Persona p1 = new Persona(Sesso.M,LocalDate.of(1920,3,4),"mich","ffff","Goku");
        Persona p2 = new Persona(Sesso.F,LocalDate.of(2010,3,4),"Maria","ffff","Goku");
        //Salva
        personaDao.save(p1);
        personaDao.save(p2);



        //Partecipazione
      Partecipazione partecipazione1 = new Partecipazione(Stato.CONFERMATA);
        Partecipazione partecipazione2 = new Partecipazione(Stato.CONFERMATA);
        //Salvo
        partecipazioneDao.save(partecipazione1);
        partecipazioneDao.save(partecipazione2);

        //Set persone ed eventi dal lato proprietario
        partecipazione1.setPersone(p1);
        partecipazione2.setPersone(p2);
        partecipazione1.setEventi(e1);
        partecipazione2.setEventi(e2);
        //Risalvare partecipazioni
        partecipazioneDao.save(partecipazione1);
        partecipazioneDao.save(partecipazione2);







    }
}

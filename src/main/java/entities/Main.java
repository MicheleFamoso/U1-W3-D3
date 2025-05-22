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
        PartitaDiCalcio partita = new PartitaDiCalcio(
                "Calcio",LocalDate.of(2020,4,4),
                "Finale", TipoEvento.PUBBLICO,123456,"Napoli","Inter",
                1,4);
        Concerto concerto = new Concerto(
                "COncerto",LocalDate.of(2019,4,7),
                "ConcertoCapodanno",TipoEvento.PUBBLICO,68794,false,Genere.POP
        );
        GaraDiAtletica gara = new GaraDiAtletica(
                "Maratona",LocalDate.of(2013,8,4),
                "MaratonaNewYork",TipoEvento.PUBBLICO,654564576
        );
        //salva
        eventodao.save(partita);
        eventodao.save(concerto);
        eventodao.save(gara);

        //Location da assegnare
        Location l1 = new Location("Stadio","Caserta");
        Location l2 = new Location("Stadio","Milano");
        //Salva
        locationDao.save(l1);
        locationDao.save(l2);
        //setta
        partita.setLocation(l1);
        concerto.setLocation(l2);
        gara.setLocation(l1);
        //Salva
        eventodao.save(partita);
        eventodao.save(concerto);
        eventodao.save(gara);
        //Persone
        Persona per1=new Persona(Sesso.F,LocalDate.of(1997,8,6),"email.com",
                "Gigi","topo");
        Persona per2=new Persona(Sesso.F,LocalDate.of(1995,8,5),"email.com",
                "nome","sasa");
        //SAlva
        personaDao.save(per1);
        personaDao.save(per2);
        //Part
        Partecipazione pa1 = new Partecipazione(Stato.CONFERMATA);
        Partecipazione pa2 = new Partecipazione(Stato.NON_CONFERMATA);
        Partecipazione pa3 = new Partecipazione(Stato.CONFERMATA);

        partecipazioneDao.save(pa1);
        partecipazioneDao.save(pa2);
        partecipazioneDao.save(pa3);

        pa1.setEventi((Evento) List.of(partita,concerto,gara));
        pa2.setEventi((Evento) List.of(partita,concerto,gara));
        pa3.setEventi((Evento) List.of(partita,concerto,gara));

      per1.setPartecipazioni(List.of(pa1,pa2,pa3));

        partecipazioneDao.save(pa1);
        partecipazioneDao.save(pa2);
        partecipazioneDao.save(pa3);






    }
}

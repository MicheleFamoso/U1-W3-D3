package entities;


import jakarta.persistence.*;

@Entity
@Table(name="partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persone;

    @ManyToOne
    @JoinColumn(name = "eventi_id")
    private Evento eventi;





    //Costruttori


    public Partecipazione(Stato stato) {
        this.stato = stato;
    }

    public Partecipazione() {
    }

    //Get e Set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Persona getPersone() {
        return persone;
    }

    public void setPersone(Persona persone) {
        this.persone = persone;
    }

    public Evento getEventi() {
        return eventi;
    }

    public void setEventi(Evento eventi) {
        this.eventi = eventi;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", stato=" + stato +
                ", persone=" + persone +
                ", eventi=" + eventi +
                '}';
    }
}

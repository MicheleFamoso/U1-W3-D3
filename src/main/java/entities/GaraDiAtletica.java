package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento{



    @ManyToMany
    @JoinTable(name = "gare_atleti",
    joinColumns= @JoinColumn(name = "gara_id"),
    inverseJoinColumns =  @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;

    @ManyToOne
    @JoinColumn(name = "vincitore")
    private Persona vincitore;

    public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti);

    }

    public GaraDiAtletica() {

    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                super.toString() +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}';
    }
}

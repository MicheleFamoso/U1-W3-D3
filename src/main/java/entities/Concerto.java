package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "concerti")
public class Concerto extends Evento{
    @Column(name = "in_streaming")
    private boolean inStreaming;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti, boolean inStreaming, Genere genere) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti);
        this.inStreaming = inStreaming;
        this.genere = genere;
    }

    public Concerto() {

    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                super.toString() +
                "inStreaming=" + inStreaming +
                ", genere=" + genere +
                '}';
    }
}

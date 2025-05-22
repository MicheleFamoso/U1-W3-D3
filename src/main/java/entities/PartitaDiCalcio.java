package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.time.LocalDate;
@Entity
@Table(name = "partite_di_calcio")
@NamedQuery(name = "partiteVinteCasa",query = "select p from PartitaDiCalcio p where p.golSquadraCasa>p.golSquadraOspite")
@NamedQuery(name = "partiteVinteOspite",query = "select p from PartitaDiCalcio p where p.golSquadraCasa<p.golSquadraOspite")
@NamedQuery(name = "partitePareggio",query = "select p from PartitaDiCalcio p where p.golSquadraCasa=p.golSquadraOspite")
public class PartitaDiCalcio extends Evento{
    @Column(name = "squadra_di_casa")
    private String squadraDiCasa;
    @Column(name = "squadra_ospite")
    private String squadraOspite;
    @Column(name = "squadra_vincente")
    private String squadraVincente;
    @Column(name = "gol_squadra_casa")
    private int golSquadraCasa;
    @Column(name = "gol_squadra_ospite")
    private int golSquadraOspite;

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMaxPartecipanti, String squadraDiCasa, String squadraOspite, int golSquadraCasa, int golSquadraOspite) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMaxPartecipanti);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;

        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
    }

    public PartitaDiCalcio() {

    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{"
                + super.toString()  +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraOspite=" + golSquadraOspite +
                '}';
    }
}

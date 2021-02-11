package model;

import java.time.LocalDate;

public class HistorialJugador {
    private LocalDate fechaInicioContrato;
    private LocalDate fechaFinContrato;
    private String posicion;
    private Integer cuitEquipo;
    private Integer dniJugador;

    public HistorialJugador(LocalDate fechaInicioContrato, LocalDate fechaFinContrato, String posicion, Integer cuitEquipo, Integer dniJugador) {
        this.fechaInicioContrato = fechaInicioContrato;
        this.fechaFinContrato = fechaFinContrato;
        this.posicion = posicion;
        this.cuitEquipo = cuitEquipo;
        this.dniJugador = dniJugador;
    }

    public HistorialJugador(LocalDate fechaInicioContrato, String posicion, Integer cuitEquipo, Integer dniJugador) {
        this.fechaInicioContrato = fechaInicioContrato;
        this.posicion = posicion;
        this.cuitEquipo = cuitEquipo;
        this.dniJugador = dniJugador;
    }

    public Integer getCuitEquipo() {
        return cuitEquipo;
    }

    public void setCuitEquipo(Integer cuitEquipo) {
        this.cuitEquipo = cuitEquipo;
    }

    public Integer getDniJugador() {
        return dniJugador;
    }

    public void setDniJugador(Integer dniJugador) {
        this.dniJugador = dniJugador;
    }

    public LocalDate getFechaInicioContrato() {
        return fechaInicioContrato;
    }

    public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
        this.fechaInicioContrato = fechaInicioContrato;
    }

    public LocalDate getFechaFinContrato() {
        return fechaFinContrato;
    }

    public void setFechaFinContrato(LocalDate fechaFinContrato) {
        this.fechaFinContrato = fechaFinContrato;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "HistorialJugador{" +
                "fechaInicioContrato=" + fechaInicioContrato +
                ", fechaFinContrato=" + fechaFinContrato +
                ", posicion='" + posicion + '\'' +
                ", cuitEquipo=" + cuitEquipo +
                ", dniJugador=" + dniJugador +
                '}';
    }
}

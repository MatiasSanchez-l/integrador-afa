package DTOs;

import java.time.LocalDate;

public class HistorialJugadorDTO {
    private LocalDate fechaInicioContrato;
    private LocalDate fechaFinContrato;
    private String posicion;
    private Integer cuitEquipo;
    private Integer dniJugador;

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
}

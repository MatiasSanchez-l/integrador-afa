package model;

import java.time.LocalDate;

public class Jugador extends Persona{

    private LocalDate fechaRetiro;
    private LocalDate fechaDebut;
    private LocalDate fechaNacimiento;
    private Integer cantidadPartidos;
    private Integer cantidadGoles;
    private Float peso;
    private Float altura;

    public Jugador(String nombre, String apellido, int dni, int telefono, String email, LocalDate fechaDebut, LocalDate fechaNacimiento, Integer cantidadPartidos, Integer cantidadGoles, Float peso, Float altura) {
        super(nombre, apellido, dni, telefono, email);
        this.fechaDebut = fechaDebut;
        this.fechaNacimiento = fechaNacimiento;
        this.cantidadPartidos = cantidadPartidos;
        this.cantidadGoles = cantidadGoles;
        this.peso = peso;
        this.altura = altura;
    }

    public LocalDate getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(LocalDate fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public LocalDate getFechaDebut() {
        return fechaDebut;
    }

    public void setFechaDebut(LocalDate fechaDebut) {
        this.fechaDebut = fechaDebut;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCantidadPartidos() {
        return cantidadPartidos;
    }

    public void setCantidadPartidos(Integer cantidadPartidos) {
        this.cantidadPartidos = cantidadPartidos;
    }

    public Integer getCantidadGoles() {
        return cantidadGoles;
    }

    public void setCantidadGoles(Integer cantidadGoles) {
        this.cantidadGoles = cantidadGoles;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre=" + this.getNombre()+
                ", apellido=" + this.getApellido()+
                ", dni=" + this.getDni()+
                ", fechaDebut=" + fechaDebut +
                ", fechaNacimiento=" + fechaNacimiento +
                ", cantidadPartidos=" + cantidadPartidos +
                ", cantidadGoles=" + cantidadGoles +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}

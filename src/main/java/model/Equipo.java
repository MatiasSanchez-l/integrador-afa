package model;

import java.time.LocalDate;

public class Equipo {
    private Integer cuit;
    private String nombre;
    private LocalDate fechaFundacion;
    private String presidenteNombreApellido;
    private Integer telefono;
    private String email;
    private LocalDate fechaPrimeraDivision;
    private Character categoria;

    public Equipo() {
    }

    public Equipo(Integer cuit, String nombre, LocalDate fechaFundacion, String presidenteNombreApellido, Integer telefono, String email, LocalDate fechaPrimeraDivision, Character categoria) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.presidenteNombreApellido = presidenteNombreApellido;
        this.telefono = telefono;
        this.email = email;
        this.fechaPrimeraDivision = fechaPrimeraDivision;
        this.categoria = categoria;
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getPresidenteNombreApellido() {
        return presidenteNombreApellido;
    }

    public void setPresidenteNombreApellido(String presidenteNombreApellido) {
        this.presidenteNombreApellido = presidenteNombreApellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaPrimeraDivision() {
        return fechaPrimeraDivision;
    }

    public void setFechaPrimeraDivision(LocalDate fechaPrimeraDivision) {
        this.fechaPrimeraDivision = fechaPrimeraDivision;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "cuit=" + cuit +
                ", nombre='" + nombre + '\'' +
                ", fechaFundacion=" + fechaFundacion +
                ", presidenteNombreApellido='" + presidenteNombreApellido + '\'' +
                ", telefono=" + telefono +
                ", email='" + email + '\'' +
                ", fechaPrimeraDivision=" + fechaPrimeraDivision +
                ", categoria=" + categoria +
                '}';
    }
}

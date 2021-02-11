package services;

import DTOs.DireccionDTO;
import DTOs.EquipoDTO;
import exceptions.ServiceException;
import model.Equipo;

import java.time.LocalDate;
import java.util.List;

public interface EquipoServicio {
    public void insert(EquipoDTO equipoDto) throws ServiceException;
    public void insertEquipoConDireccion(EquipoDTO equipoDto, DireccionDTO direccionDto) throws ServiceException;
    public void update(EquipoDTO equipoDto, Integer cuit) throws ServiceException;
    public List<Equipo> read() throws ServiceException;
    public void delete(Integer cuit) throws ServiceException;

    public void mostrarCantidadDeJugadoresActuales() throws ServiceException;
    public void mostrarCantidadDeDefensoresActuales() throws ServiceException;

    public void mostrarCantidadDeJugadoresEnUnaFecha(LocalDate fecha) throws ServiceException;

    public Equipo convertirEquipoDtoAModel(EquipoDTO equipoDto);
    public EquipoDTO convertirEquipoModelADTO(Equipo equipo);
}

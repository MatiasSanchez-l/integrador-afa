package services;

import DTOs.HistorialJugadorDTO;
import exceptions.ServiceException;
import model.HistorialJugador;

import java.util.List;

public interface HistorialJugadorServicio {
    public void insert(HistorialJugadorDTO historialDto) throws ServiceException;
    public void insertListaHistoriales(List<HistorialJugadorDTO> historialesDto) throws ServiceException;
    public void update(HistorialJugadorDTO historialDto) throws ServiceException;
    public void read() throws ServiceException;
    public void delete(HistorialJugadorDTO historialDto) throws ServiceException;

    public Integer obtenerIdHistorial(HistorialJugadorDTO historialJugadorDto) throws ServiceException;
    public HistorialJugador convertirHistorialJugadorDtoAModel(HistorialJugadorDTO historialDto);
    public HistorialJugadorDTO convertirHistorialJugadorModelADto(HistorialJugador historial);
    public List<HistorialJugador> convertirListaHistorialJugadorDtoAModel(List<HistorialJugadorDTO> historialesDto);
}

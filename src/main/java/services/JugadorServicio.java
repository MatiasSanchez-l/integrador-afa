package services;

import DTOs.DireccionDTO;
import DTOs.JugadorDTO;
import exceptions.ServiceException;
import model.Jugador;

import java.util.List;

public interface JugadorServicio {
    public void insert(JugadorDTO jugadorDto) throws ServiceException;
    public void insertJugadorConDireccion(JugadorDTO jugadorDto, DireccionDTO direccionDto) throws ServiceException;
    public void update(JugadorDTO jugadorDto, Integer dni) throws ServiceException;
    public List<Jugador> read() throws ServiceException;
    public void delete(Integer dni) throws ServiceException;

    public Jugador convertirJugadorDtoAModel(JugadorDTO jugadorDto);
    public JugadorDTO convertirJugadorModelADTO(Jugador jugador);
}

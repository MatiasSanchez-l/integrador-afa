package DAOs;

import exceptions.DAOException;
import model.Direccion;
import model.Jugador;

import java.util.List;

public interface JugadorDAO {
    public void insert(Jugador jugador) throws DAOException;
    public void insertJugadorConDireccion(Jugador jugador, Direccion direccion) throws DAOException;
    public void update(Jugador jugador, Integer dni) throws DAOException;
    public List<Jugador> read() throws DAOException;
    public void delete(Integer dni) throws DAOException;
}

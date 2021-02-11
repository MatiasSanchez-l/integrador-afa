package DAOs;

import exceptions.DAOException;
import model.HistorialJugador;

import java.util.List;

public interface HistorialJugadorDAO {
    public void insert(HistorialJugador historial) throws DAOException;
    public void insertListaHistoriales(List<HistorialJugador> historiales) throws DAOException;
    public void insertHistorialSinFechaFin(HistorialJugador historial) throws DAOException;
    public void update(HistorialJugador historial) throws DAOException;
    public void read() throws DAOException;
    public void delete(Integer id) throws DAOException;
    public Integer obtenerIdHistorial(HistorialJugador historialJugador) throws DAOException;
    public void insertHistorialConFechaFin(HistorialJugador historial) throws DAOException;
}

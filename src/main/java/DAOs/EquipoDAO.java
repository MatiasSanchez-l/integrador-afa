package DAOs;

import exceptions.DAOException;
import model.Direccion;
import model.Equipo;

import java.time.LocalDate;
import java.util.List;

public interface EquipoDAO {
    public void insert(Equipo equipo) throws DAOException;
    public void insertEquipoConDireccion(Equipo equipo, Direccion direccion) throws DAOException;
    public void update(Equipo equipo, Integer cuit) throws DAOException;
    public List<Equipo> read() throws DAOException;
    public void delete(Integer cuit) throws DAOException;

    public void mostrarCantidadDeJugadoresActuales() throws DAOException;
    public void mostrarCantidadDeDefensoresActuales() throws DAOException;

    public void mostrarCantidadDeJugadoresEnUnaFecha(LocalDate fecha) throws DAOException;
}

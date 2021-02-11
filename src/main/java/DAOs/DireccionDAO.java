package DAOs;

import exceptions.DAOException;
import model.Direccion;

import java.util.List;

public interface DireccionDAO {
    public Integer insert(Direccion direccion) throws DAOException;
    public void update(Direccion direccion) throws DAOException;
    public List<Direccion> read() throws DAOException;
    public void delete(Integer id) throws DAOException;

    public Integer obtenerIdDireccion(Direccion direccion) throws DAOException;
}

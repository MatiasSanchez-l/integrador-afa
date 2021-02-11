package services;

import DAOs.EquipoDAO;
import DAOs.EquipoDAOImpl;
import DTOs.DireccionDTO;
import DTOs.EquipoDTO;
import exceptions.DAOException;
import exceptions.ServiceException;
import model.Direccion;
import model.Equipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipoServicioImpl implements EquipoServicio{
    private EquipoDAO equipoDao = new EquipoDAOImpl();
    private DireccionServicio direccionServicio = new DireccionServicioImpl();

    @Override
    public void insert(EquipoDTO equipoDto) throws ServiceException {
        Equipo equipo = this.convertirEquipoDtoAModel(equipoDto);

        try {
            equipoDao.insert(equipo);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en insert " + e.getCause());
        }
    }

    @Override
    public void insertEquipoConDireccion(EquipoDTO equipoDto, DireccionDTO direccionDto) throws ServiceException {
        Equipo equipo = this.convertirEquipoDtoAModel(equipoDto);
        Direccion direccion = direccionServicio.convertirDireccionDtoAModel(direccionDto);

        try {
            equipoDao.insertEquipoConDireccion(equipo, direccion);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en insertEquipoConDireccion " + e.getCause());
        }
    }

    @Override
    public void update(EquipoDTO equipoDto, Integer cuit) throws ServiceException {
        Equipo equipo = this.convertirEquipoDtoAModel(equipoDto);

        try {
            equipoDao.update(equipo, cuit);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en update " + e.getCause());
        }
    }

    @Override
    public List<Equipo> read() throws ServiceException {
        List<Equipo> listaEquipos = new ArrayList<>();
        try {
            listaEquipos = equipoDao.read();
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en read " + e.getCause());
        }
        return listaEquipos;
    }

    @Override
    public void delete(Integer cuit) throws ServiceException {
        try {
            equipoDao.delete(cuit);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en delete " + e.getCause());
        }
    }

    @Override
    public void mostrarCantidadDeJugadoresActuales() throws ServiceException {
        try {
            equipoDao.mostrarCantidadDeJugadoresActuales();
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en mostrarCantidadDeJugadoresActuales " + e.getCause());
        }
    }

    @Override
    public void mostrarCantidadDeDefensoresActuales() throws ServiceException {
        try {
            equipoDao.mostrarCantidadDeDefensoresActuales();
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en mostrarCantidadDeDefensoresActuales " + e.getCause());
        }
    }

    @Override
    public void mostrarCantidadDeJugadoresEnUnaFecha(LocalDate fecha) throws ServiceException {
        try {
            equipoDao.mostrarCantidadDeJugadoresEnUnaFecha(fecha);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en mostrarCantidadDeJugadoresEnUnaFecha " + e.getCause());
        }
    }

    @Override
    public Equipo convertirEquipoDtoAModel(EquipoDTO equipoDto) {

        Equipo equipo = new Equipo();
        equipo.setCuit(equipoDto.getCuit());
        equipo.setNombre(equipoDto.getNombre());
        equipo.setFechaFundacion(equipoDto.getFechaFundacion());
        equipo.setPresidenteNombreApellido(equipoDto.getPresidenteNombreApellido());
        equipo.setTelefono(equipoDto.getTelefono());
        equipo.setEmail(equipoDto.getEmail());
        equipo.setFechaPrimeraDivision(equipoDto.getFechaPrimeraDivision());
        equipo.setCategoria(equipoDto.getCategoria());

        return equipo;
    }

    @Override
    public EquipoDTO convertirEquipoModelADTO(Equipo equipo) {

        EquipoDTO equipoDto = new EquipoDTO();
        equipoDto.setCuit(equipo.getCuit());
        equipoDto.setNombre(equipo.getNombre());
        equipoDto.setFechaFundacion(equipo.getFechaFundacion());
        equipoDto.setPresidenteNombreApellido(equipo.getPresidenteNombreApellido());
        equipoDto.setTelefono(equipo.getTelefono());
        equipoDto.setEmail(equipo.getEmail());
        equipoDto.setFechaPrimeraDivision(equipo.getFechaPrimeraDivision());
        equipoDto.setCategoria(equipo.getCategoria());

        return equipoDto;
    }
}

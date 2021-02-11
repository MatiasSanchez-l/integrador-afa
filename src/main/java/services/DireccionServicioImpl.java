package services;

import DAOs.DireccionDAO;
import DAOs.DireccionDAOImpl;
import DTOs.DireccionDTO;
import exceptions.DAOException;
import exceptions.ServiceException;
import model.Direccion;

import java.util.ArrayList;
import java.util.List;

public class DireccionServicioImpl implements DireccionServicio{
    DireccionDAO direccionDao = new DireccionDAOImpl();

    @Override
    public Integer insert(DireccionDTO direccionDto) throws ServiceException {
        Direccion direccion = this.convertirDireccionDtoAModel(direccionDto);
        Integer resultado = 0;

        try {
            resultado = direccionDao.insert(direccion);
        }catch (DAOException e){
            throw new ServiceException("DireccionService Error: Error en insert " + e.getCause());
        }
        return  resultado;
    }

    @Override
    public void update(DireccionDTO direccionDto) throws ServiceException {
        Direccion direccion = this.convertirDireccionDtoAModel(direccionDto);
        try {
            direccionDao.update(direccion);
        }catch (DAOException e){
            throw new ServiceException("DireccionService Error: Error en update " + e.getCause());
        }
    }

    @Override
    public List<Direccion> read() throws ServiceException {
        List<Direccion> direcciones= new ArrayList<>();
        try {
            direcciones = direccionDao.read();
        }catch (DAOException e){
            throw new ServiceException("DireccionService Error: Error en update " + e.getCause());
        }
        return direcciones;
    }

    @Override
    public void delete(DireccionDTO direccionDto) throws ServiceException {
        Direccion direccion = this.convertirDireccionDtoAModel(direccionDto);
        try {
            Integer id = direccionDao.obtenerIdDireccion(direccion);

            direccionDao.delete(id);
        }catch (DAOException e){
            throw new ServiceException("DireccionService Error: Error en delete " + e.getCause());
        }


    }

    @Override
    public Integer obtenerIdDireccion(DireccionDTO direccionDto) throws ServiceException {
        Direccion direccion = this.convertirDireccionDtoAModel(direccionDto);
        Integer resultado = 0;

        try {
            resultado = direccionDao.obtenerIdDireccion(direccion);
        }catch (DAOException e){
            throw new ServiceException("DireccionService Error: Error en obtenerIdDireccion " + e.getCause());
        }
        return  resultado;
    }

    @Override
    public Direccion convertirDireccionDtoAModel(DireccionDTO direccionDto) {
        String calle = direccionDto.getCalle();
        Integer numero = direccionDto.getNumero();
        String localidad = direccionDto.getLocalidad();
        String provincia = direccionDto.getProvincia();

        Direccion direccion = new Direccion(calle, numero, localidad, provincia);

        return direccion;

    }

    @Override
    public DireccionDTO convertirDireccionModelADto(Direccion direccion) {

        String calle = direccion.getCalle();
        Integer numero = direccion.getNumero();
        String localidad = direccion.getLocalidad();
        String provincia = direccion.getProvincia();

        DireccionDTO direccionDto = new DireccionDTO();

        direccionDto.setCalle(calle);
        direccionDto.setNumero(numero);
        direccionDto.setLocalidad(localidad);
        direccionDto.setProvincia(provincia);

        return direccionDto;
    }
}

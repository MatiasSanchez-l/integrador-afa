package services;

import DTOs.DireccionDTO;
import exceptions.ServiceException;
import model.Direccion;

import java.util.List;

public interface DireccionServicio {
    public Integer insert(DireccionDTO direccionDto) throws ServiceException;
    public void update(DireccionDTO direccionDto) throws ServiceException;
    public List<Direccion> read() throws ServiceException;
    public void delete(DireccionDTO direccionDto) throws ServiceException;

    public Integer obtenerIdDireccion(DireccionDTO direccionDto) throws ServiceException;

    public Direccion convertirDireccionDtoAModel(DireccionDTO direccionDto);
    public DireccionDTO convertirDireccionModelADto(Direccion direccion);
}

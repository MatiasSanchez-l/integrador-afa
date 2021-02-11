package services;

import DAOs.HistorialJugadorDAO;
import DAOs.HistorialJugadorDAOImpl;
import DTOs.HistorialJugadorDTO;
import exceptions.DAOException;
import exceptions.ServiceException;
import model.HistorialJugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistorialJugadorServicioImpl implements HistorialJugadorServicio{
    HistorialJugadorDAO historialJugadorDao = new HistorialJugadorDAOImpl();

    @Override
    public void insert(HistorialJugadorDTO historialDto) throws ServiceException {
        HistorialJugador historialJugador = this.convertirHistorialJugadorDtoAModel(historialDto);

        try {
            historialJugadorDao.insert(historialJugador);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en insert " + e.getCause());
        }
    }

    @Override
    public void insertListaHistoriales(List<HistorialJugadorDTO> historialesDto) throws ServiceException {
        List<HistorialJugador> historialesJugador = this.convertirListaHistorialJugadorDtoAModel(historialesDto);

        try {
            historialJugadorDao.insertListaHistoriales(historialesJugador);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en insertListaHistoriales " + e.getCause());
        }
    }


    @Override
    public void update(HistorialJugadorDTO historialDto) throws ServiceException {
        HistorialJugador historialJugador = this.convertirHistorialJugadorDtoAModel(historialDto);

        try {
            historialJugadorDao.update(historialJugador);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en update " + e.getCause());
        }
    }

    @Override
    public void read() throws ServiceException {
        try {
            historialJugadorDao.read();
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en read " + e.getCause());
        }
    }

    @Override
    public void delete(HistorialJugadorDTO historialDto) throws ServiceException {
        Integer id = obtenerIdHistorial(historialDto);
        try {
            historialJugadorDao.delete(id);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en delete " + e.getCause());
        }
    }

    @Override
    public Integer obtenerIdHistorial(HistorialJugadorDTO historialJugadorDto) throws ServiceException {
        HistorialJugador historialJugador = this.convertirHistorialJugadorDtoAModel(historialJugadorDto);
        Integer id = 0;
        try {
            id = historialJugadorDao.obtenerIdHistorial(historialJugador);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en obtenerIdHistorial " + e.getCause());
        }
        return  id;
    }


    @Override
    public HistorialJugador convertirHistorialJugadorDtoAModel(HistorialJugadorDTO historialDto) {
        LocalDate fechaInicioContrato = historialDto.getFechaInicioContrato();
        LocalDate fechaFinContrato = historialDto.getFechaFinContrato();
        String posicion = historialDto.getPosicion();
        Integer cuitEquipo = historialDto.getCuitEquipo();
        Integer dniJugador = historialDto.getDniJugador();
        HistorialJugador historialJugador = new HistorialJugador(fechaInicioContrato, posicion, cuitEquipo,dniJugador);

        if(fechaFinContrato != null){
            historialJugador.setFechaFinContrato(fechaFinContrato);
        }

        return historialJugador;
    }

    @Override
    public HistorialJugadorDTO convertirHistorialJugadorModelADto(HistorialJugador historial) {

        HistorialJugadorDTO historialJugadorDto = new HistorialJugadorDTO();
        historialJugadorDto.setFechaInicioContrato(historial.getFechaInicioContrato());
        historialJugadorDto.setPosicion(historial.getPosicion());
        historialJugadorDto.setCuitEquipo(historial.getCuitEquipo());
        historialJugadorDto.setDniJugador(historial.getDniJugador());

        if(historial.getFechaFinContrato() != null){
            historialJugadorDto.setFechaFinContrato(historial.getFechaFinContrato());
        }

        return historialJugadorDto;
    }

    @Override
    public List<HistorialJugador> convertirListaHistorialJugadorDtoAModel(List<HistorialJugadorDTO> historialesJugadorDto) {
        List<HistorialJugador> historialesJugador = new ArrayList<>();

        for (HistorialJugadorDTO historialDto: historialesJugadorDto) {

            LocalDate fechaInicioContrato = historialDto.getFechaInicioContrato();
            LocalDate fechaFinContrato = historialDto.getFechaFinContrato();
            String posicion = historialDto.getPosicion();
            Integer cuitEquipo = historialDto.getCuitEquipo();
            Integer dniJugador = historialDto.getDniJugador();
            HistorialJugador historialJugador = new HistorialJugador(fechaInicioContrato, posicion, cuitEquipo,dniJugador);

            if(fechaFinContrato != null){
                historialJugador.setFechaFinContrato(fechaFinContrato);
            }

            historialesJugador.add(historialJugador);
        }

        return historialesJugador;
    }
}

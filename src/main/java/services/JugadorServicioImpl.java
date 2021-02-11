package services;

import DAOs.JugadorDAO;
import DAOs.JugadorDAOImpl;
import DTOs.DireccionDTO;
import DTOs.JugadorDTO;
import exceptions.DAOException;
import exceptions.ServiceException;
import model.Direccion;
import model.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JugadorServicioImpl implements JugadorServicio{
    private JugadorDAO jugadorDao = new JugadorDAOImpl();
    private DireccionServicio direccionServicio = new DireccionServicioImpl();

    @Override
    public void insert(JugadorDTO jugadorDto) throws ServiceException {
        Jugador jugador = this.convertirJugadorDtoAModel(jugadorDto);

        try {
            jugadorDao.insert(jugador);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en insert " + e.getCause());
        }
    }

    @Override
    public void insertJugadorConDireccion(JugadorDTO jugadorDto, DireccionDTO direccionDto) throws ServiceException {
        Jugador jugador = this.convertirJugadorDtoAModel(jugadorDto);
        Direccion direccion = direccionServicio.convertirDireccionDtoAModel(direccionDto);

        try {
            jugadorDao.insertJugadorConDireccion(jugador, direccion);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en insertJugadorConDireccion " + e.getCause());
        }
    }

    @Override
    public void update(JugadorDTO jugadorDto, Integer dni) throws ServiceException {
        Jugador jugador = this.convertirJugadorDtoAModel(jugadorDto);
        try {
            jugadorDao.update(jugador, dni);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en update " + e.getCause());
        }
    }

    @Override
    public List<Jugador> read() throws ServiceException {
        List<Jugador> listaJugadores = new ArrayList<>();
        try {
            listaJugadores=jugadorDao.read();
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en read " + e.getCause());
        }
        return listaJugadores;
    }

    @Override
    public void delete(Integer dni) throws ServiceException {
        try {
            jugadorDao.delete(dni);
        }catch (DAOException e){
            throw new ServiceException("EquipoServicio Error: Error en delete " + e.getCause());
        }
    }

    @Override
    public Jugador convertirJugadorDtoAModel(JugadorDTO jugadorDto) {

        String nombre = jugadorDto.getNombre();
        String apellido = jugadorDto.getApellido();
        Integer dni = jugadorDto.getDni();
        Integer telefono = jugadorDto.getTelefono();
        String email = jugadorDto.getEmail();
        LocalDate fechaDebut = jugadorDto.getFechaDebut();
        LocalDate fechaNacimiento = jugadorDto.getFechaNacimiento();
        Integer cantidadPartidos = jugadorDto.getCantidadPartidos();
        Integer cantidadGoles = jugadorDto.getCantidadGoles();
        Float peso = jugadorDto.getPeso();
        Float altura = jugadorDto.getAltura();

        Jugador jugador = new Jugador(nombre, apellido, dni, telefono, email, fechaDebut, fechaNacimiento,
                cantidadPartidos,cantidadGoles,peso,altura);

        return jugador;
    }

    @Override
    public JugadorDTO convertirJugadorModelADTO(Jugador jugador) {

        JugadorDTO jugadorDto = new JugadorDTO();

        jugadorDto.setNombre(jugador.getNombre());
        jugadorDto.setApellido(jugador.getApellido());
        jugadorDto.setDni(jugador.getDni());
        jugadorDto.setTelefono(jugador.getTelefono());
        jugadorDto.setEmail(jugador.getEmail());
        jugadorDto.setFechaDebut(jugador.getFechaDebut());
        jugadorDto.setFechaNacimiento(jugador.getFechaNacimiento());
        jugadorDto.setCantidadPartidos(jugador.getCantidadPartidos());
        jugadorDto.setCantidadGoles(jugador.getCantidadGoles());
        jugadorDto.setPeso(jugador.getPeso());
        jugadorDto.setAltura(jugador.getAltura());

        return jugadorDto;
    }
}

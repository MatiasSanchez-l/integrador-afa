package DAOs;

import conexion.Conexion;
import exceptions.DAOException;
import model.Direccion;
import model.Jugador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAOImpl implements JugadorDAO{
    private Conexion conection = new Conexion();

    @Override
    public void insert(Jugador jugador) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                Integer dniJugador = jugador.getDni();
                String nombreJugador = jugador.getNombre();
                String apellidoJugador = jugador.getApellido();
                String emailJugador = jugador.getEmail();
                Integer telefonoJugador = jugador.getTelefono();

                String sqlPersona = "INSERT INTO persona(dni, apellido, nombre, email, telefono)" +
                        "VALUES("+dniJugador+",'"+apellidoJugador+"','"+nombreJugador+"','"+emailJugador+"',"+telefonoJugador+");";
                instruccion.execute(sqlPersona);

                LocalDate fechaDebutJugador = jugador.getFechaDebut();
                Integer cantidadPartidosJugador = jugador.getCantidadPartidos();
                LocalDate fechaNacimientoJugador= jugador.getFechaNacimiento();
                Integer cantidadGolesJugador = jugador.getCantidadGoles();
                Float pesoJugador = jugador.getPeso();
                Float alturaJugador = jugador.getAltura();

                String sqlJugador = "INSERT INTO jugador(dni, fecha_debut, cant_partidos, fecha_nacimiento, " +
                        "cant_goles, peso, altura)" +
                        "VALUES("+dniJugador+",'"+fechaDebutJugador+"',"+cantidadPartidosJugador+",'"+fechaNacimientoJugador+"',"
                        +cantidadGolesJugador+","+pesoJugador+","+alturaJugador+");";
                instruccion.execute(sqlJugador);
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en insert ", e);
            }

        }catch (Exception e){
            throw new DAOException("JugadorDAO Error: Error en conexion insert", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void insertJugadorConDireccion(Jugador jugador, Direccion direccion) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                DireccionDAO direccionDao = new DireccionDAOImpl();

                Integer dniJugador = jugador.getDni();
                String nombreJugador = jugador.getNombre();
                String apellidoJugador = jugador.getApellido();
                String emailJugador = jugador.getEmail();
                Integer telefonoJugador = jugador.getTelefono();
                Integer idDireccion = direccionDao.obtenerIdDireccion(direccion);

                String sqlPersona = "INSERT INTO persona(dni, apellido, nombre, email, telefono, id_direccion)" +
                        "VALUES("+dniJugador+",'"+apellidoJugador+"','"+nombreJugador+"','"+emailJugador+"',"+telefonoJugador+","
                        +idDireccion+");";
                instruccion.execute(sqlPersona);

                LocalDate fechaDebutJugador = jugador.getFechaDebut();
                Integer cantidadPartidosJugador = jugador.getCantidadPartidos();
                LocalDate fechaNacimientoJugador= jugador.getFechaNacimiento();
                Integer cantidadGolesJugador = jugador.getCantidadGoles();
                Float pesoJugador = jugador.getPeso();
                Float alturaJugador = jugador.getAltura();

                String sqlJugador = "INSERT INTO jugador(dni, fecha_debut, cant_partidos, fecha_nacimiento, " +
                        "cant_goles, peso, altura)" +
                        "VALUES("+dniJugador+",'"+fechaDebutJugador+"',"+cantidadPartidosJugador+",'"+fechaNacimientoJugador+"',"
                        +cantidadGolesJugador+","+pesoJugador+","+alturaJugador+");";
                instruccion.execute(sqlJugador);
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en insertJugadorConDireccion ", e);
            }

        }catch (Exception e){
            throw new DAOException("JugadorDAO Error: Error en conexion insertJugadorConDireccion", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void update(Jugador jugador, Integer dni) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){

                Integer dniJugador = jugador.getDni();
                String nombreJugador = jugador.getNombre();
                String apellidoJugador = jugador.getApellido();
                String emailJugador = jugador.getEmail();
                Integer telefonoJugador = jugador.getTelefono();

                String sqlPersona = "UPDATE persona SET dni = " + dniJugador +
                        " , nombre = '" + nombreJugador +
                        "' , apellido = '" + apellidoJugador +
                        "' , email = '" + emailJugador +
                        "' , telefono = " + telefonoJugador +
                        " WHERE dni = " + dni;

                instruccion.execute(sqlPersona);

                LocalDate fechaDebutJugador = jugador.getFechaDebut();
                Integer cantidadPartidosJugador = jugador.getCantidadPartidos();
                LocalDate fechaNacimientoJugador= jugador.getFechaNacimiento();
                Integer cantidadGolesJugador = jugador.getCantidadGoles();
                Float pesoJugador = jugador.getPeso();
                Float alturaJugador = jugador.getAltura();

                String sqlJugador = "UPDATE jugador SET dni = " + dniJugador +
                        " , fecha_debut = '" + fechaDebutJugador +
                        "' , cant_partidos = " + cantidadPartidosJugador +
                        " , fecha_nacimiento = '" + fechaNacimientoJugador +
                        "' , cant_goles = " + cantidadGolesJugador +
                        " , peso = " + pesoJugador +
                        " , altura = " + alturaJugador +
                        " WHERE dni = " + dni;

                instruccion.execute(sqlJugador);

            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en update ", e);
            }

        }catch (Exception e){
            throw new DAOException("JugadorDAO Error: Error en conexion update", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public List<Jugador> read() throws DAOException {
        Connection conneccion = null;
        List<Jugador> listaJugadores = new ArrayList<>();
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                ResultSet resultado = instruccion.executeQuery("SELECT * " +
                        "FROM jugador j JOIN persona p ON p.dni = j.dni;");

                while (resultado.next()){
                    String nombreJg = resultado.getString("nombre");
                    String apellidoJg = resultado.getString("apellido");
                    Integer dniJg = resultado.getInt("dni");
                    Integer telefonoJg = resultado.getInt("telefono");
                    String emailJg = resultado.getString("email");
                    LocalDate fechaDebutJg = resultado.getDate("fecha_debut").toLocalDate();
                    LocalDate fechaNacimientoJg = resultado.getDate("fecha_nacimiento").toLocalDate();
                    Integer cantidadPartidosJg = resultado.getInt("cant_partidos");
                    Integer cantidadGolesJg = resultado.getInt("cant_goles");
                    Float pesoJg = resultado.getFloat("peso");
                    Float alturaJg = resultado.getFloat("altura");

                    Jugador jugador = new Jugador(nombreJg, apellidoJg, dniJg, telefonoJg, emailJg, fechaDebutJg,
                            fechaNacimientoJg, cantidadPartidosJg, cantidadGolesJg, pesoJg, alturaJg);

                    listaJugadores.add(jugador);
                }

            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en read ", e);
            }

        }catch (Exception e){
            throw new DAOException("JugadorDAO Error: Error en conexion read ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en cierre conexion ", e);
            }
        }
        return listaJugadores;
    }

    @Override
    public void delete(Integer dni) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){

                String sqlJugador =   "DELETE FROM jugador WHERE jugador.dni = "+ dni +";";
                instruccion.execute(sqlJugador);

                String sqlPersona =   "DELETE FROM persona WHERE persona.dni = "+ dni +";";
                instruccion.execute(sqlPersona);

            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en delete ", e);
            }

        }catch (Exception e){
            throw new DAOException("JugadorDAO Error: Error en conexion delete ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("JugadorDAO Error: Error en cierre conexion ", e);
            }
        }
    }
}

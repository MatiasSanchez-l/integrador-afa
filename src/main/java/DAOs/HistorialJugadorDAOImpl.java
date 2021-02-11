package DAOs;

import conexion.Conexion;
import exceptions.DAOException;
import model.HistorialJugador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistorialJugadorDAOImpl implements HistorialJugadorDAO{
    private Conexion conection = new Conexion();

    @Override
    public void insertListaHistoriales(List<HistorialJugador> historiales) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                for (HistorialJugador historial : historiales) {
                    LocalDate fechaFin = historial.getFechaFinContrato();
                    LocalDate fechaInicio = historial.getFechaInicioContrato();
                    String posicion = historial.getPosicion();
                    Integer jugadorDni = historial.getDniJugador();
                    Integer equipoCuit = historial.getCuitEquipo();

                    String sql = "INSERT INTO historial(fecha_fin, fecha_inicio, posicion, jugador_dni, cuit_equipo)" +
                            "VALUES('"+fechaFin+"','"+fechaInicio+"','"+posicion+"',"+jugadorDni+","+equipoCuit+");";
                    instruccion.execute(sql);
                }
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en insertListaHistoriales ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion insertListaHistoriales ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void insertHistorialSinFechaFin(HistorialJugador historial) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                LocalDate fechaInicio = historial.getFechaInicioContrato();
                String posicion = historial.getPosicion();
                Integer jugadorDni = historial.getDniJugador();
                Integer equipoCuit = historial.getCuitEquipo();

                String sql = "INSERT INTO historial(fecha_inicio, posicion, jugador_dni, cuit_equipo)" +
                        "VALUES('"+fechaInicio+"','"+posicion+"',"+jugadorDni+","+equipoCuit+");";
                instruccion.execute(sql);
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en insertHistorialSinFechaFin ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion insertHistorialSinFechaFin ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void insertHistorialConFechaFin(HistorialJugador historial) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                LocalDate fechaFin = historial.getFechaFinContrato();
                LocalDate fechaInicio = historial.getFechaInicioContrato();
                String posicion = historial.getPosicion();
                Integer jugadorDni = historial.getDniJugador();
                Integer equipoCuit = historial.getCuitEquipo();

                String sql = "INSERT INTO historial(fecha_fin, fecha_inicio, posicion, jugador_dni, cuit_equipo)" +
                        "VALUES('"+fechaFin+"','"+fechaInicio+"','"+posicion+"',"+jugadorDni+","+equipoCuit+");";
                instruccion.execute(sql);
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en insertHistorialConFechaFin ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion insertHistorialConFechaFin ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void insert(HistorialJugador historial) throws DAOException {
        if(historial.getFechaFinContrato() == null){
            this.insertHistorialSinFechaFin(historial);
        }else{
            this.insertHistorialConFechaFin(historial);
        }
    }

    @Override
    public void update(HistorialJugador historial) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                LocalDate fechaFin = historial.getFechaFinContrato();
                LocalDate fechaInicio = historial.getFechaInicioContrato();
                String posicion = historial.getPosicion();
                Integer jugadorDni = historial.getDniJugador();
                Integer equipoCuit = historial.getCuitEquipo();
                Integer id = this.obtenerIdHistorial(historial);
                String sql = "";

                if(fechaFin != null){
                    sql = "UPDATE historial SET fecha_inicio = '" + fechaInicio +
                            "' , fecha_fin = '" + fechaFin +
                            "' , posicion = '" + posicion +
                            "' , jugador_dni = " + jugadorDni +
                            " , cuit_equipo = " + equipoCuit +
                            " WHERE id_direccion = " + id;
                }else{
                    sql = "UPDATE historial SET fecha_inicio = '" + fechaInicio +
                            "' , posicion = '" + posicion +
                            "' , jugador_dni = " + jugadorDni +
                            " , cuit_equipo = " + equipoCuit +
                            " WHERE id_direccion = " + id;
                }
                instruccion.execute(sql);

            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en update ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion update ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void read() throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                ResultSet resultado = instruccion.executeQuery("SELECT * FROM historial;");
                List<HistorialJugador> listaHistoriales = new ArrayList<>();
                while (resultado.next()){
                    LocalDate fechaInicioContrato = resultado.getDate("fecha_inicio").toLocalDate();
                    String posicionJg = resultado.getString("posicion");
                    Integer cuitEq = resultado.getInt("cuit_equipo");
                    Integer dniJg = resultado.getInt("jugador_dni");

                    try {
                        LocalDate fechaFinContrato =  resultado.getDate("fecha_fin").toLocalDate();

                        HistorialJugador historial = new HistorialJugador(fechaInicioContrato,fechaFinContrato,
                                posicionJg, cuitEq, dniJg);

                        listaHistoriales.add(historial);
                    }catch(Exception e){
                        HistorialJugador historial = new HistorialJugador(fechaInicioContrato, posicionJg,
                                cuitEq, dniJg);

                        listaHistoriales.add(historial);
                    }
                }

                for (HistorialJugador historial: listaHistoriales) {
                    System.out.println(historial.toString());
                }

            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en read ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion read ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
    }

    @Override
    public void delete(Integer id) throws DAOException {
        Connection conneccion = null;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){

                String sql =  "DELETE FROM historial WHERE historial.id_historial = "+ id +";";
                instruccion.execute(sql);

            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en delete ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion delete ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
    }


    @Override
    public Integer obtenerIdHistorial(HistorialJugador historialJugador) throws DAOException {
        Connection conneccion = null;
        Integer resultado=0;
        try{
            conneccion = conection.conection();

            try (Statement instruccion = conneccion.createStatement()){
                LocalDate fechaInicio = historialJugador.getFechaInicioContrato();
                String posicion = historialJugador.getPosicion();
                Integer dniJugador = historialJugador.getDniJugador();
                Integer cuitEquipo = historialJugador.getCuitEquipo();

                String sql = "SELECT id_historial FROM historial WHERE fecha_inicio = '"+fechaInicio+"' AND posicion LIKE '"+posicion+"' " +
                        " AND jugador_dni LIKE "+dniJugador+" AND cuit_equipo LIKE "+cuitEquipo+";";
                ResultSet resultSet = instruccion.executeQuery(sql);

                if(resultSet.next()){
                    resultado = resultSet.getInt("id_historial");
                }

            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en obtenerIdHistorial ", e);
            }

        }catch (Exception e){
            throw new DAOException("HistorialJugadorDao Error: Error en conexion obtenerIdHistorial ", e);
        }

        if(conneccion != null){
            try{
                conneccion.close();
            }catch (Exception e){
                throw new DAOException("HistorialJugadorDao Error: Error en cierre conexion ", e);
            }
        }
        return resultado;
    }
}

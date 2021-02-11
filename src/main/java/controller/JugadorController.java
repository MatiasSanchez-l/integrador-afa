package controller;

import DTOs.JugadorDTO;
import exceptions.ServiceException;
import model.Jugador;
import services.JugadorServicio;
import services.JugadorServicioImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JugadorController extends HttpServlet {
    JugadorServicio jugadorServicio = new JugadorServicioImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Jugador> listaJugadores = new ArrayList<>();
        try {
            listaJugadores = jugadorServicio.read();

            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();

            for (Jugador jugador:listaJugadores) {
                pw.println("<html><head>");
                pw.println("</head><body>");
                pw.println("<p>nombre: " + jugador.getNombre() + "</p>" );
                pw.println("<p>Apellido: " + jugador.getApellido() + "</p>" );
                pw.println("<p> dni: " + jugador.getDni() + "</p>" );
                pw.println("</body>");
            }
            pw.close();
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en consutlar " + e.getCause());
        }
    }

    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        JugadorDTO jugadorDto = new JugadorDTO();

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        Integer dni = Integer.parseInt(req.getParameter("dni"));
        Integer telefono = Integer.parseInt(req.getParameter("telefono"));
        String email = req.getParameter("email");
        LocalDate fechaDebut = LocalDate.parse(req.getParameter("fecha_debut"));
        LocalDate fechaNacimiento = LocalDate.parse(req.getParameter("fecha_nacimiento"));
        Integer cantidadPartidos = Integer.parseInt(req.getParameter("cantidad_partidos"));
        Integer cantidadGoles = Integer.parseInt(req.getParameter("cantidad_goles"));
        Float peso = Float.parseFloat(req.getParameter("peso"));
        Float altura = Float.parseFloat(req.getParameter("altura"));
        Integer dniJugadorAUpdate = Integer.parseInt(req.getParameter("dni_original"));

        jugadorDto.setNombre(nombre);
        jugadorDto.setApellido(apellido);
        jugadorDto.setDni(dni);
        jugadorDto.setTelefono(telefono);
        jugadorDto.setEmail(email);
        jugadorDto.setFechaDebut(fechaDebut);
        jugadorDto.setFechaNacimiento(fechaNacimiento);
        jugadorDto.setCantidadPartidos(cantidadPartidos);
        jugadorDto.setCantidadGoles(cantidadGoles);
        jugadorDto.setPeso(peso);
        jugadorDto.setAltura(altura);

        try {
           jugadorServicio.update(jugadorDto, dniJugadorAUpdate);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en update " + e.getCause());
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Put</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Update de jugador correcto </p>");
        pw.println("</body>");
        pw.close();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        JugadorDTO jugadorDto = new JugadorDTO();

        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        Integer dni = Integer.parseInt(req.getParameter("dni"));
        Integer telefono = Integer.parseInt(req.getParameter("telefono"));
        String email = req.getParameter("email");
        LocalDate fechaDebut = LocalDate.parse(req.getParameter("fecha_debut"));
        LocalDate fechaNacimiento = LocalDate.parse(req.getParameter("fecha_nacimiento"));
        Integer cantidadPartidos = Integer.parseInt(req.getParameter("cantidad_partidos"));
        Integer cantidadGoles = Integer.parseInt(req.getParameter("cantidad_goles"));
        Float peso = Float.parseFloat(req.getParameter("peso"));
        Float altura = Float.parseFloat(req.getParameter("altura"));

        jugadorDto.setNombre(nombre);
        jugadorDto.setApellido(apellido);
        jugadorDto.setDni(dni);
        jugadorDto.setTelefono(telefono);
        jugadorDto.setEmail(email);
        jugadorDto.setFechaDebut(fechaDebut);
        jugadorDto.setFechaNacimiento(fechaNacimiento);
        jugadorDto.setCantidadPartidos(cantidadPartidos);
        jugadorDto.setCantidadGoles(cantidadGoles);
        jugadorDto.setPeso(peso);
        jugadorDto.setAltura(altura);

        try {
            jugadorServicio.insert(jugadorDto);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en insert " + e.getCause());
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Persistencia del Recurso Jugador </p>");
        pw.println("</body>");
        pw.close();

    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        try {
            jugadorServicio.delete(Integer.parseInt(req.getParameter("id")));
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }

    }


}

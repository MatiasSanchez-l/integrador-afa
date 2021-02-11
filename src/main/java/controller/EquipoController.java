package controller;

import DTOs.EquipoDTO;
import exceptions.ServiceException;
import model.Equipo;
import services.EquipoServicio;
import services.EquipoServicioImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EquipoController extends HttpServlet {
    EquipoServicio equipoServicio = new EquipoServicioImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Equipo> listaEquipos = new ArrayList<>();
        try {
            listaEquipos = equipoServicio.read();

            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();

            for (Equipo equipo:listaEquipos) {
                pw.println("<html><head>");
                pw.println("</head><body>");
                pw.println("<p>nombre: " + equipo.getNombre() + "</p>" );
                pw.println("<p>email: " + equipo.getEmail() + "</p>" );
                pw.println("<p> presidente: " + equipo.getPresidenteNombreApellido() + "</p>" );
                pw.println("</body>");
            }
            pw.close();
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en consutlar " + e.getCause());
        }
    }

    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        EquipoDTO equipoDTO = new EquipoDTO();

        Integer cuitOriginal =Integer.parseInt(req.getParameter("cuit_original"));
        Integer cuit =Integer.parseInt(req.getParameter("cuit"));
        String nombre = req.getParameter("nombre");
        LocalDate fechaFundacion = LocalDate.parse(req.getParameter("fecha_fundacion"));
        String presidenteNombreApellido = req.getParameter("presidente_nombre_apellido");
        Integer telefono = Integer.parseInt(req.getParameter("telefono"));
        String email = req.getParameter("email");
        LocalDate fechaPrimeraDivision = LocalDate.parse(req.getParameter("fecha_primera_division"));
        Character categoria = req.getParameter("categoria").charAt(0);


        equipoDTO.setCuit(cuit);
        equipoDTO.setNombre(nombre);
        equipoDTO.setFechaFundacion(fechaFundacion);
        equipoDTO.setPresidenteNombreApellido(presidenteNombreApellido);
        equipoDTO.setTelefono(telefono);
        equipoDTO.setEmail(email);
        equipoDTO.setFechaPrimeraDivision(fechaPrimeraDivision);
        equipoDTO.setCategoria(categoria);

        try {
            equipoServicio.update(equipoDTO, cuitOriginal);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en update " + e.getCause());
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Put</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Update de equipo correcto </p>");
        pw.println("</body>");
        pw.close();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        EquipoDTO equipoDTO = new EquipoDTO();

        Integer cuit =Integer.parseInt(req.getParameter("cuit"));
        String nombre = req.getParameter("nombre");
        LocalDate fechaFundacion = LocalDate.parse(req.getParameter("fecha_fundacion"));
        String presidenteNombreApellido = req.getParameter("presidente_nombre_apellido");
        Integer telefono = Integer.parseInt(req.getParameter("telefono"));
        String email = req.getParameter("email");
        LocalDate fechaPrimeraDivision = LocalDate.parse(req.getParameter("fecha_primera_division"));
        Character categoria = req.getParameter("categoria").charAt(0);


        equipoDTO.setCuit(cuit);
        equipoDTO.setNombre(nombre);
        equipoDTO.setFechaFundacion(fechaFundacion);
        equipoDTO.setPresidenteNombreApellido(presidenteNombreApellido);
        equipoDTO.setTelefono(telefono);
        equipoDTO.setEmail(email);
        equipoDTO.setFechaPrimeraDivision(fechaPrimeraDivision);
        equipoDTO.setCategoria(categoria);

        try {
            equipoServicio.insert(equipoDTO);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en update " + e.getCause());
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Persistencia del Recurso equipo </p>");
        pw.println("</body>");
        pw.close();
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        try {
            equipoServicio.delete(Integer.parseInt(req.getParameter("id")));
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }
    }
}

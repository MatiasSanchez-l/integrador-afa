package controller;

import DTOs.DireccionDTO;
import exceptions.ServiceException;
import model.Direccion;
import services.DireccionServicio;
import services.DireccionServicioImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DireccionController extends HttpServlet {
    DireccionServicio direccionServicio = new DireccionServicioImpl();

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Direccion> listaDirecciones = new ArrayList<>();
        try {
            listaDirecciones = direccionServicio.read();

            res.setContentType("text/html");
            PrintWriter pw = res.getWriter();

            for (Direccion direccion:listaDirecciones) {
                pw.println("<html><head>");
                pw.println("</head><body>");
                pw.println("<p>calle: " + direccion.getCalle() + "</p>" );
                pw.println("<p>numero: " + direccion.getNumero() + "</p>" );
                pw.println("<p> localidad: " + direccion.getLocalidad() + "</p>" );
                pw.println("</body>");
            }
            pw.close();
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en consutlar " + e.getCause());
        }
    }


    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        DireccionDTO direccionDTO = new DireccionDTO();

        String calle = req.getParameter("calle");
        Integer numero =Integer.parseInt(req.getParameter("numero"));
        String localidad = req.getParameter("localidad");
        String provincia = req.getParameter("provincia");

        direccionDTO.setCalle(calle);
        direccionDTO.setNumero(numero);
        direccionDTO.setLocalidad(localidad);
        direccionDTO.setProvincia(provincia);

        try {
            direccionServicio.update(direccionDTO);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en update " + e.getCause());
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Put</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Update de direccion correcto </p>");
        pw.println("</body>");
        pw.close();

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DireccionDTO direccionDTO = new DireccionDTO();

        String calle = req.getParameter("calle");
        Integer numero =Integer.parseInt(req.getParameter("numero"));
        String localidad = req.getParameter("localidad");
        String provincia = req.getParameter("provincia");

        direccionDTO.setCalle(calle);
        direccionDTO.setNumero(numero);
        direccionDTO.setLocalidad(localidad);
        direccionDTO.setProvincia(provincia);

        try {
            direccionServicio.insert(direccionDTO);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en insert " + e.getCause());
        }

        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        pw.println("<html><head>");
        pw.println("<TITLE>Servlet Curso Java Método Post</TITLE>");
        pw.println("</head><body>");
        pw.println("<p>Persistencia del Recurso direccion </p>");
        pw.println("</body>");
        pw.close();
    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException {

        DireccionDTO direccionDTO = new DireccionDTO();
        String calle = req.getParameter("calle");
        Integer numero =Integer.parseInt(req.getParameter("numero"));
        String localidad = req.getParameter("localidad");
        String provincia = req.getParameter("provincia");

        direccionDTO.setCalle(calle);
        direccionDTO.setNumero(numero);
        direccionDTO.setLocalidad(localidad);
        direccionDTO.setProvincia(provincia);

        try {
            direccionServicio.delete(direccionDTO);
        }
        catch (ServiceException e) {
            throw new ServletException("Servlet Error: Error en delete " + e.getCause());
        }
    }
}

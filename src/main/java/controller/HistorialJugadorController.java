package controller;

import services.HistorialJugadorServicio;
import services.HistorialJugadorServicioImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistorialJugadorController extends HttpServlet {
    HistorialJugadorServicio historialJugadorServicio = new HistorialJugadorServicioImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException {

    }

    public void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException {


    }

    public void doPut(HttpServletRequest req, HttpServletResponse res) throws ServletException{


    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException{


    }
}

package com.udea.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.udea.dao.ClienteInmoDao;
import com.udea.dao.OfertasDAO;
import com.udea.model.Ofertas  ;
import com.udea.model.Cliente;
import com.udea.model.ClienteInmo;

@WebServlet("/subasta")
public class PublicarSubastaServlet extends HttpServlet {
    private final OfertasDAO propDao = new OfertasDAO();
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String fechaLimite = request.getParameter("fechaLimite");
        LocalDate localDate = LocalDate.parse(fechaLimite);
        LocalDateTime localDateTime = localDate.atStartOfDay();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        String desc = request.getParameter("desc");
        String metrosCuadrados = request.getParameter("mts");
        Long precio = Long.parseLong(request.getParameter("monto"));
        String pais = request.getParameter("pais");
        String ciudad = request.getParameter("ciudad");
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        

       
        propDao.InsertarPropiedad(cliente.getId(), desc ,pais, ciudad,metrosCuadrados, precio, timestamp);

        response.sendRedirect("subastaCreada.jsp");
    }
}
package com.udea.servlets;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;

@WebServlet("/sesion")
public class SesionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClienteBancoDAO clienteDao;

    public SesionServlet() {
        this.clienteDao = new ClienteBancoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String idString = request.getParameter("id1");
        String contrasena = request.getParameter("contrasena1");
        String pais = request.getParameter("pais1");

        if (idString != null && contrasena != null && pais != null) {
            int id = Integer.parseInt(idString);
            Cliente cliente = clienteDao.seleccionarCliente(pais, id, contrasena);

            if (cliente != null) {
                request.setAttribute("clienteNombres", cliente.getNombres());
                request.setAttribute("clienteApellidos", cliente.getApellidos());
                session.setAttribute("cliente", cliente);
                request.getRequestDispatcher("/menu.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/sesion.jsp").forward(request, response);
            }

        } else {
            request.getRequestDispatcher("/sesion.jsp").forward(request, response);
        }

    }
}

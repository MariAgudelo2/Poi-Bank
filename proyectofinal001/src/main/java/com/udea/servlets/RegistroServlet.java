package com.udea.servlets;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;

    public RegistroServlet() {
        this.clienteDao = new ClienteBancoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        String pais = request.getParameter("pais");

        Cliente nuevoCliente = new Cliente(id, nombres, apellidos, email, pais, contrasena);
        clienteDao.insertarCliente(nuevoCliente);

        response.sendRedirect("index.jsp");
    }
}

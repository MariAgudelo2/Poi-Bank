package com.udea.servlets;

import java.io.IOException;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/tuCuenta")
public class MostrarCuentaServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;

    public MostrarCuentaServlet() {
        this.clienteDao = new ClienteBancoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        request.setAttribute("cliente1", cliente);
    }
}

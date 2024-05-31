package com.udea.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;

@WebServlet("/crearCuenta")
public class CrearCuentaServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;

    public CrearCuentaServlet() {
        this.clienteDao = new ClienteBancoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String tipoCuenta = request.getParameter("tipoCuenta");
        int nroCuenta = (int) (Math.random() * 1000000000);
        Cuenta cuenta = clienteDao.seleccionarCuenta(cliente, tipoCuenta);

        if (cuenta == null || !cuenta.getEstado().equals("activa")) {
            Cuenta nuevaCuenta = new Cuenta(nroCuenta, cliente, tipoCuenta);
            clienteDao.crearCuenta(nuevaCuenta);

            response.sendRedirect("cuentaCreada.jsp");
        } else {
            response.sendRedirect("cuentaExistente.jsp");
        }

    }

}

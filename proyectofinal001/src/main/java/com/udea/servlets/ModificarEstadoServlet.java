package com.udea.servlets;

import java.io.IOException;
import java.util.List;

import com.udea.dao.ClienteBancoDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/modificarEstado")
public class ModificarEstadoServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;

    public ModificarEstadoServlet() {
        this.clienteDao = new ClienteBancoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<Cuenta> cuentas = clienteDao.mostrarCuentas(cliente);

        request.setAttribute("cuentas", cuentas);
        request.getRequestDispatcher("/cancelarCuenta.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");

        String tipoCuenta = request.getParameter("tipoCuenta");

        Cuenta cuenta = clienteDao.seleccionarCuenta(cliente, tipoCuenta);
        clienteDao.cancelarCuenta(cuenta);
        request.getRequestDispatcher("/cuentaEstado.jsp").forward(request, response);
    }

}

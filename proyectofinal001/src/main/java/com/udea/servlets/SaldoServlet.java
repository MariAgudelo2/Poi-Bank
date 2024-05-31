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

@WebServlet("/saldo")
public class SaldoServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;

    public SaldoServlet() {
        this.clienteDao = new ClienteBancoDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<Cuenta> cuentas = clienteDao.mostrarCuentas(cliente);

        request.setAttribute("cuentas", cuentas);
        request.getRequestDispatcher("/consultarSaldo.jsp").forward(request, response);
    }
}

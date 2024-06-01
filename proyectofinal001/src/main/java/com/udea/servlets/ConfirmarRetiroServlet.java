package com.udea.servlets;

import java.io.IOException;
import java.util.List;

import com.udea.dao.ClienteBancoDAO;
import com.udea.dao.TransaccionesDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/confirmarRetiro")
public class ConfirmarRetiroServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;
    private TransaccionesDAO transDao;

    public ConfirmarRetiroServlet() {
        this.clienteDao = new ClienteBancoDAO();
        this.transDao = new TransaccionesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String tipoCuenta = request.getParameter("tipoCuenta");
        Cuenta cuenta = clienteDao.seleccionarCuenta(cliente, tipoCuenta);
        double monto = Double.parseDouble(request.getParameter("monto"));
        String confirmar = request.getParameter("confirmar");

        boolean transaccion = transDao.retirar(cuenta, monto);
        transDao.actualizarSaldo(cuenta.getSaldo(), cuenta.getNroCuenta());
        if (confirmar.equals("Continuar")) {
            if (transaccion == false) {
                request.getRequestDispatcher("/transaccionFallida.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/transaccionExitosa.jsp").forward(request, response);
            }
        }

    }
}

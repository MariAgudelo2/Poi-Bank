package com.udea.servlets;

import java.io.IOException;
import java.util.List;

import com.udea.dao.ClienteBancoDAO;
import com.udea.dao.TransaccionesDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/retirar")
public class RetirarServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;
    private TransaccionesDAO transDao;

    public RetirarServlet() {
        this.clienteDao = new ClienteBancoDAO();
        this.transDao = new TransaccionesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<Cuenta> cuentas = clienteDao.mostrarCuentas(cliente);

        request.setAttribute("cuentas", cuentas);
        request.getRequestDispatcher("/retirar.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String tipoCuenta = request.getParameter("tipoCuenta");
        Cuenta cuenta = clienteDao.seleccionarCuenta(cliente, tipoCuenta);
        double monto = Double.parseDouble(request.getParameter("monto"));

        if (monto > 20000000) {
            request.getRequestDispatcher("/confirmacionRetiro.jsp").forward(request, response);
        } else {
            boolean transaccion = transDao.retirar(cuenta, monto);
            transDao.actualizarSaldo(cuenta.getSaldo(), cuenta.getNroCuenta());
            if (transaccion == false) {
                request.getRequestDispatcher("/transaccionFallida.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/transaccionExitosa.jsp").forward(request, response);
            }
        }

    }
}

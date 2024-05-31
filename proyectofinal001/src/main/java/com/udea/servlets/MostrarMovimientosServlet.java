package com.udea.servlets;

import java.io.IOException;
import java.util.List;

import com.udea.dao.ClienteBancoDAO;
import com.udea.dao.TransaccionesDAO;
import com.udea.model.Cliente;
import com.udea.model.Cuenta;
import com.udea.model.Transacciones;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/mostrarMovimientos")
public class MostrarMovimientosServlet extends HttpServlet {
    private ClienteBancoDAO clienteDao;
    private TransaccionesDAO transDao;

    public MostrarMovimientosServlet() {
        this.clienteDao = new ClienteBancoDAO();
        this.transDao = new TransaccionesDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        String tipoCuenta = request.getParameter("tipoCuenta");
        Cuenta cuenta = clienteDao.seleccionarCuenta(cliente, tipoCuenta);
        List<Transacciones> transacciones = transDao.mostrarMovimientos(cuenta);

        request.setAttribute("movimientos", transacciones);
        request.getRequestDispatcher("/movimientos.jsp").forward(request, response);
    }

}

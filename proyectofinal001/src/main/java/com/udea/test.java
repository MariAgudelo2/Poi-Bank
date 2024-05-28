package com.udea;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.udea.model.Cliente;
import com.udea.model.ClienteInmo;
import com.udea.model.MatriculaInmo;
import com.udea.dao.ClienteInmoDao;
public class test {
    
    static ClienteInmo clienteInmo = new ClienteInmo();
    static ClienteInmo clienteInmo2 = new ClienteInmo();
    static ClienteInmoDao clienteInmoDao = new ClienteInmoDao();

    
    public static void main(String[] args) {
        
        mostrarDaticos();

        ClienteInmo cliente = clienteInmoDao.SeleccionarProp(1, "Mi casita");
        MatriculaInmo matriculaInmo = new MatriculaInmo();
        matriculaInmo.validOfrecer(cliente);
    }

    public static void modificarDaticos(){
        clienteInmo = clienteInmoDao.SeleccionarProp(2, "Mi casita");
        System.out.println("soy " + clienteInmo.getIdCliente());
        //Datos quemados para prueba unicamente
        clienteInmo2 = clienteInmoDao.SeleccionarProp(1, "Inmueble");
        System.out.println("pero yo soy " + clienteInmo2.getIdCliente());
        //Datos quemados para prueba unicamente
        clienteInmoDao.ModificarDueño(clienteInmo, clienteInmo2);
    }
    public static void daticosInsert(){
        
        //Datos quemados para prueba unicamente
    clienteInmo.setIdCliente(123456789);
    clienteInmo.setDescrip("Mi casita");
    clienteInmo.setTipo("Propiedad");
    clienteInmo.setPais("colombia");
    clienteInmo.setCiudad("codazzi");
    clienteInmo.setMtsCua("2949");
    clienteInmo.setPrecio((long) 30000000);
    clienteInmo.setTimeStamp(null);
        
        ClienteInmoDao clienteInmoDao = new ClienteInmoDao();
        clienteInmoDao.InsertarCasa(clienteInmo);
    }
   
    public static void mostrarDaticos(){
        List<ClienteInmo> casasClienteInmoDaos = clienteInmoDao.MostrarSubastas(); 
       
       for (ClienteInmo clienteInmo : casasClienteInmoDaos) {
        System.out.println("------------------");
        System.out.println("Descripción: " + clienteInmo.getDescrip());    
        System.out.println("Tipo: " + clienteInmo.getTipo());
        System.out.println("País: " + clienteInmo.getPais());
        System.out.println("Ciudad: " + clienteInmo.getCiudad());
        System.out.println("Metros Cuadrados: " + clienteInmo.getMtsCua());
        System.out.println("Precio: " + clienteInmo.getPrecio());
        System.out.println("Fecha Límite: " + clienteInmo.getTimeStamp());
       }
       System.out.println("A todas las tengo ardidas");
    }

    public static void eliminarDaticos(){
         //Este método se espera que se complemente con el método para acceder al consecutivo_cliente del banco
        //La utilidad de este método es para que si el cliente desea retirar una subasta o una venta lo pueda hacer
       clienteInmoDao.eliminarPropiedad(2,"ApartaEstudio");
    }
}

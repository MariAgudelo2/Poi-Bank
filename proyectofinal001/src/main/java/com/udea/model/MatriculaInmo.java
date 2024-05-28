package com.udea.model;

import java.util.Date;
import java.sql.Timestamp;
import java.util.Scanner;

import com.udea.dao.ClienteInmoDao;


public class MatriculaInmo {

    public void validOfrecer(ClienteInmo propiedad)
    {
        
        Timestamp fechaLim = propiedad.getTimeStamp();
        Date date = new Date();
        Timestamp fechaActual = new Timestamp(date.getTime());
        
        if (fechaActual.after(fechaLim))
        {
            System.out.println("La subasta se acabó");

        }
        else {
            System.out.println("Puedes hacer tu oferta");
            Ofrecer(propiedad.getPrecio(), propiedad);

        }

    }
    public void Ofrecer(Long valorActual, ClienteInmo propiedad)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu oferta: ");
        Long Oferta = scanner.nextLong();
        scanner.close();

        if (valorActual < Oferta)
        {
            ClienteInmoDao clienteInmoDao = new ClienteInmoDao();
            clienteInmoDao.ModificarPrecio(Oferta, propiedad);
            System.out.println("Su oferta se ha establecido como el nuevo precio de la propiedad, usted va liderando la subasta" );
        }

    }
}

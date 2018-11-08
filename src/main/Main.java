/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import hilos.Cajero;
import hilos.ProveedorUsuario;
import modelo.Banco;

/**
 *
 * @author ProgramacionColombia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Banco.getInstancia().setEnServicio(true);

        ProveedorUsuario proveedorUsuario = new ProveedorUsuario();

        Cajero cajero1 = new Cajero();
        cajero1.setNombre("Cajero 1");
        Cajero cajero2 = new Cajero();
        cajero2.setNombre("Cajero 2");

        cajero1.start();
        cajero2.start();
        proveedorUsuario.start();

    }

}

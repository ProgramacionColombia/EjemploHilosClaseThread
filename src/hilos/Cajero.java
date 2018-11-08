/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import modelo.Banco;
import modelo.Usuario;

/**
 *
 * @author ProgramacionColombia
 */
public class Cajero extends Thread {

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void pausar(long tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            System.err.println("Error al pausar el hilo");
        }
    }

    @Override
    public void run() {
        while (Banco.getInstancia().isEnServicio()) {
            Usuario usuarioParaAtender = Banco.getInstancia().pasarUsuarioAlCajero();

            if (usuarioParaAtender == null) {
                System.out.println(this + " - CAJERO " + nombre + ": esperando usuarios");
                pausar(1000);
                continue;
            }

            System.out.println("CAJERO" + nombre + ": atendiendo  al usuario con"
                    + "identificacion: " + usuarioParaAtender.getIdentificacion());
            pausar(5000);

        }

    }

}

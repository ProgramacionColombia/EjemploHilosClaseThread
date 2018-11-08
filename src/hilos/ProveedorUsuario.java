/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.util.Random;
import modelo.Banco;
import modelo.Usuario;

/**
 *
 * @author ProgramacionColombia
 */
public class ProveedorUsuario extends Thread {

    @Override
    public void run() {
        while (Banco.getInstancia().isEnServicio()) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.err.println("Error al pausar el hilo");
            }
            Usuario usuarioParaEntrarAlBanco = new Usuario();
            usuarioParaEntrarAlBanco.setIdentificacion(new Random().nextInt(100));

            System.out.println(this+ " - El usuario con id: " + usuarioParaEntrarAlBanco.getIdentificacion()
                    + " esta está entrando al banco");

            Banco.getInstancia().agregarUsuarioAFila(usuarioParaEntrarAlBanco);

        }

    }

}

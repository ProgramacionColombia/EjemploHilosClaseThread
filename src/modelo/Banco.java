/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author ProgramacionColombia
 */
public class Banco {

    private static Banco instancia;
    private ConcurrentLinkedQueue<Usuario> usuarios;
    private boolean enServicio;

    private Banco() {
        usuarios = new ConcurrentLinkedQueue<>();
    }

    public static Banco getInstancia() {
        if (instancia == null) {
            instancia = new Banco();
        }
        return instancia;
    }

    public boolean isEnServicio() {
        return enServicio;
    }

    public void setEnServicio(boolean enServicio) {
        this.enServicio = enServicio;
    }

    public Usuario pasarUsuarioAlCajero() {
        Usuario usuario = null;
        try {
            System.out.println("La longitud de la fila es de: " + usuarios.size()
                    + " usuarios");
            usuario = usuarios.remove();
        } catch (NoSuchElementException e) {
            System.err.println("La fila se encuentra vacia");
        }
        return usuario;
    }

    public void agregarUsuarioAFila(Usuario usuario) {
        System.out.println("Ha llegado un usuario al banco");
        usuarios.add(usuario);
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.nuevo.controlador;

import ec.edu.ups.nuevo.dao.ILibroDAO;
import ec.edu.ups.nuevo.dao.IPrestamoDAO;
import ec.edu.ups.nuevo.dao.IUsuarioDAO;
import ec.edu.ups.nuevo.modelo.Usuario;
import ec.edu.ups.nuevo.modelo.Libro;
import ec.edu.ups.nuevo.modelo.Prestamo;

/**
 *
 * @author davidvargas
 */
public class Biblioteca_Controlador {
    private ILibroDAO libroDAO;
    private IUsuarioDAO usuarioDAO;
    private IPrestamoDAO prestamoDAO;

    public Biblioteca_Controlador(ILibroDAO libroDAO, IUsuarioDAO usuarioDAO, IPrestamoDAO prestamoDAO) {
        this.libroDAO = libroDAO;
        this.usuarioDAO = usuarioDAO;
        this.prestamoDAO = prestamoDAO;
    }
   
    public void agregarLibro(Libro libro) {
        libroDAO.agregarLibro(libro);
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }

    public Libro buscarLibro(String titulo) {
        return libroDAO.buscarLibro(titulo);
    }

    public void prestarLibro(Libro libro, Usuario usuario) {
        if (libro.isDisponible()) {
            Prestamo prestamo = new Prestamo(libro, usuario);
            prestamoDAO.agregarPrestamo(prestamo);
            libro.prestar();
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }
}

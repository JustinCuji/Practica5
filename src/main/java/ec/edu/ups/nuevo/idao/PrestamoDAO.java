/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.nuevo.idao;

import ec.edu.ups.nuevo.dao.IPrestamoDAO;
import ec.edu.ups.nuevo.modelo.Libro;
import ec.edu.ups.nuevo.modelo.Prestamo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class PrestamoDAO implements IPrestamoDAO {

    private List<Prestamo> listaPrestamos;  // Almacenamiento simulado en memoria

    public PrestamoDAO() {
        this.listaPrestamos = new ArrayList<>();
    }

    @Override
    public void agregarPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    @Override
    public void actualizarPrestamo(Prestamo prestamo) {
        int index = listaPrestamos.indexOf(prestamo);
        if (index != -1) {
            listaPrestamos.set(index, prestamo);
        }
    }

    @Override
    public void eliminarPrestamo(String idUsuario, String tituloLibro) {
        for (int i = 0; i < listaPrestamos.size(); i++) {
            Prestamo prestamoGuardado = listaPrestamos.get(i);
            if (prestamoGuardado.getLibro().getTitulo().equals(tituloLibro)
                    && prestamoGuardado.getUsuario().getIdentificacion().equals(idUsuario)) {
                listaPrestamos.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Prestamo> obtenerTodosPrestamos() {
        return new ArrayList<>(listaPrestamos);
    }

    @Override
    public Prestamo buscarPrestamo(Libro libro, String idUsuario) {
        for (Prestamo prestamo : listaPrestamos) {
            if (prestamo.getLibro().equals(libro) && prestamo.getUsuario().getIdentificacion().equals(idUsuario)) {
                return prestamo;
            }
        }
        return null;
    }
}

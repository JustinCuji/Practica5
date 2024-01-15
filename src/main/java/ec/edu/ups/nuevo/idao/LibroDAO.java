/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.nuevo.idao;

import ec.edu.ups.nuevo.dao.ILibroDAO;
import ec.edu.ups.nuevo.modelo.Libro;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class LibroDAO implements ILibroDAO {

    private List<Libro> listaLibros;  // Almacenamiento simulado en memoria

    public LibroDAO() {
        this.listaLibros = new ArrayList<>();
    }

    @Override
    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    @Override
    public void actualizarLibro(Libro libro) {
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libroGuardado = listaLibros.get(i);
            if (libroGuardado.getTitulo().equals(libro.getTitulo())) {
                listaLibros.set(i, libro);
                break;
            }
        }
    }

    @Override
    public void eliminarLibro(Libro libro) {
        Iterator<Libro> iter = listaLibros.iterator();
        while (iter.hasNext()) {
            Libro libroGuardado = iter.next();
            if (libroGuardado.getTitulo().equals(libro.getTitulo())) {
                iter.remove(); // Utiliza el iterador para eliminar el libro de la lista
                break;
            }
        }
    }

    @Override
    public Libro buscarLibro(String titulo) {
    for (Libro libro : listaLibros) {
        if (libro.getTitulo().equalsIgnoreCase(titulo)) {
            return libro;
        }
    }
    return null;
}

    @Override
    public List<Libro> obtenerTodosLibros() {
        return new ArrayList<>(listaLibros);
    }

}

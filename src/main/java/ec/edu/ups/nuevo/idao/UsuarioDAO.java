/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.nuevo.idao;

import ec.edu.ups.nuevo.dao.IUsuarioDAO;
import ec.edu.ups.nuevo.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author davidvargas
 */
public class UsuarioDAO implements IUsuarioDAO {

    private static List<Usuario> listaUsuarios = new ArrayList<>();

    @Override
    public void agregarUsuario(Usuario usuario) {
        listaUsuarios.add(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario personaGuardada = listaUsuarios.get(i);
            if(personaGuardada.getIdentificacion().equals(usuario.getIdentificacion())){
                listaUsuarios.set(i, usuario);
                break;
            }                        
        }
        
    }

    @Override
    public void eliminarUsuario(String identificacion) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Usuario usuario = listaUsuarios.get(i);
            if(usuario.getIdentificacion().equals(identificacion)){
                listaUsuarios.remove(i);
                break;
            }                        
        }
    }

    @Override
public Usuario buscarUsuarioPorId(String id) {
    for(Usuario persona : listaUsuarios){
            if(persona.getIdentificacion().equals(id))
                return persona;
        }
        return null;
}

    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        // Mostrará los usuarios creados y guardados en la base de datos con sus respectivos datos
        return listaUsuarios;
    }
}

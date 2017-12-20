package model.interfaces;

import model.Usuario;

public interface UsuarioDAO extends InterfaceDAO<Usuario> {
    boolean logar (String login, String senha);
}

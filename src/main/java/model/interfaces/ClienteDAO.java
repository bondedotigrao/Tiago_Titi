
package model.interfaces;

import model.Cliente;

public interface ClienteDAO extends InterfaceDAO<Cliente> {
    boolean logar(String login,String senha);
}

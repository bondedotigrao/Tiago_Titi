/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cliente;

/**
 *
 * @author Tiago Titi
 */
@ManagedBean
@SessionScoped
public class LoginClienteClontroller {
    
    private Cliente clienteLogado = null;
    

    public LoginClienteClontroller() {
    }

    public Cliente getCliente() {
        return clienteLogado;
    }

    public void setCliente(Cliente cliente) {
        this.clienteLogado = cliente;
    }
    
    public String loginCliente(String login,String senha){
        List<Cliente> clientes = new ClienteController().recuperarTodos();
        
        for(Cliente c: clientes){
            if(c.getLogin().equals(login)){
                if(c.getLogin().equals(senha)){
                    this.clienteLogado = c;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", c);
                    return "apresentaUsuario.xhtml";
                }
            }
            
        }
        return "index.xhtml";
    }
    
    public String logout(){
    
        this.clienteLogado = null;
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
       return "apresentaUsuario.xhtml";
    }
    
}

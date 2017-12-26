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
public class LoginClienteController {
    
    private Cliente clienteLogado = null;
    

    public LoginClienteController() {
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public String loginCliente(String login,String senha){
        List<Cliente> clientes = new ClienteController().recuperarTodos();
        
        for(Cliente c: clientes){
            if(c.getLogin().equals(login)){
                if(c.getLogin().equals(senha)){
                    this.clienteLogado = c;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", c);
                    return "perfilCliente.xhtml";
                }
            }
            
        }
        return "index.xhtml";
    }
    
    public String logout(){
    
        this.clienteLogado = null;
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
       return "index.xhtml";
    }
    
}

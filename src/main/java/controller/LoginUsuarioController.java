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
import model.Usuario;

/**
 *
 * @author Tiago Titi
 */
@ManagedBean
@SessionScoped
public class LoginUsuarioController {
     private Usuario usuarioLogado = null;

    public LoginUsuarioController() {
    }

    public Usuario getClienteLogado() {
        return usuarioLogado;
    }

    public void setClienteLogado(Usuario clienteLogado) {
        this.usuarioLogado = usuarioLogado;
    }
    
    public String loginUsuario(String login,String senha){
        List<Usuario> usuarios = new UsuarioController().recuperarTodos();
        
        for(Usuario c: usuarios){
            if(c.getLogin().equals(login)){
                if(c.getSenha().equals(senha)){
                    this.usuarioLogado = c;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioLogado", c);
                    return "apresentaUsuario.xhtml";
                }
            }
            
        }
        return "index.xhtml";
    }
    
        public String logout(){
    
        this.usuarioLogado = null;
        
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
       return "index.xhtml";
        }
}
    




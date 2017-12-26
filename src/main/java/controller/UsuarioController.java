
package controller;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import model.Usuario;
import model.implementacoes.UsuarioHibernate;

@ManagedBean
@ViewScoped
public class UsuarioController {
    private UsuarioHibernate instance;
    private Usuario cadUsuario;
    private Usuario selectedUsuario;

    public UsuarioController() {
        this.instance = UsuarioHibernate.getinstanceUsuario();
        this.cadUsuario = new Usuario();
    }
    
    public String cadastrar(){
        this.instance.criar(this.cadUsuario);
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuário cadastrado com sucesso!"));
        
        return "index.xhtml";
    }
    
     public void alterar(){
        instance.alterar(this.cadUsuario);
    }
    
    public void deletar(Usuario usuario){
        instance.deletar(usuario);
    }
    
    public Usuario recuperar(int codigo){
       return instance.recuperar(codigo);
    }
    
    public List<Usuario> recuperarTodos(){
        return instance.recuperarTodos();
    }

    public UsuarioHibernate getInstance() {
        return instance;
    }

    public void setInstance(UsuarioHibernate instance) {
        this.instance = instance;
    }

    public Usuario getCadUsuario() {
        return cadUsuario;
    }

    public void setCadUsuario(Usuario cadUsuario) {
        this.cadUsuario = cadUsuario;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    
 
    
    
}

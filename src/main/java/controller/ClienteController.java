package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cliente;
import model.implementacoes.ClienteHibernate;

@ManagedBean
@SessionScoped
public class ClienteController {
    private  ClienteHibernate instance = null;
    private Cliente cadCliente;
    private Cliente selectedCliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clienteLogado");
   
    
    public ClienteController() {
        this.instance = ClienteHibernate.getinstanceClienteH();
        this.cadCliente = new Cliente();
       
    }
 
    public String inserir(){
        instance.criar(this.cadCliente);
        this.cadCliente = new Cliente();
        return"index.xhtml";
    }
    
    public void alterar(){
        instance.alterar(this.cadCliente);
    }
    
    public void deletar(){
        instance.deletar(this.cadCliente);
    }
    
    public Cliente recuperar(int codigo){
       return instance.recuperar(codigo);
    }
    
    public List<Cliente> recuperarTodos(){
        return instance.recuperarTodos();
    }

    public Cliente getCadCliente() {
        return cadCliente;
    }

    public void setCadCliente(Cliente cadCliente) {
        this.cadCliente = cadCliente;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
    
    
}
package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Cliente;
import model.implementacoes.ClienteHibernate;

@ManagedBean
@SessionScoped
public class ClienteController {
    private  ClienteHibernate instance = null;
    private Cliente cadCliente;
    private Cliente selectedCliente;
    
    public ClienteController() {
        this.instance = ClienteHibernate.getinstanceClienteH();
        this.cadCliente = new Cliente();
        this.selectedCliente = new Cliente();
    }
 
    public void inserir(){
        instance.criar(this.cadCliente);
    }
    
    public void alterar(){
        instance.alterar(this.selectedCliente);
    }
    
    public void deletar(){
        instance.deletar(this.selectedCliente);
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
    
    
}
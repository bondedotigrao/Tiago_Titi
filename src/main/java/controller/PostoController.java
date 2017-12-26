package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import model.Cliente;
import model.Posto;
import model.implementacoes.PostoHibernate;

@ManagedBean
@SessionScoped
public class PostoController {
    private PostoHibernate instance;
    private Posto cadPosto;
    private Posto selectedPosto;

    public PostoController() {
        this.instance = PostoHibernate.getinstancePostoP();
        this.cadPosto = new Posto();
    }
    
    public String inserir(){
        Cliente cliente = (Cliente) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("clienteLogado");
        this.cadPosto.setCliente(cliente);
        instance.criar(this.cadPosto);
        
        return "perfilCliente.xhtml";
    }
    
    public void deletar(Posto posto){
        instance.deletar(posto);
    }
    
    public Posto recuperar(int id_posto){
        return instance.recuperar(id_posto);
    }
    
    public List<Posto> recuperarTodos(){
        return instance.recuperarTodos();
    }
    
    public List<Posto> recuperarPorCliente(Cliente cliente){
        return this.instance.recuperarPorCliente(cliente);
    }

    public Posto getCadPosto() {
        return cadPosto;
    }

    public void setCadPosto(Posto cadPosto) {
        this.cadPosto = cadPosto;
    }

    public Posto getSelectedPosto() {
        return selectedPosto;
    }

    public void setSelectedPosto(Posto selectedPosto) {
        this.selectedPosto = selectedPosto;
    }
    
    
}

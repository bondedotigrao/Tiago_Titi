
package controller;

import java.util.List;
import model.Frentista;
import model.implementacoes.FrentistaHibernate;


public class FrentistaController {
    private FrentistaHibernate instance;

    public FrentistaController() {
        this.instance = FrentistaHibernate.getinstanceFrentista();
    }
    
    public void inserir(Frentista frentista){
        instance.criar(frentista);
    }
    
    public void deletar(Frentista frentista){
        instance.deletar(frentista);
    }
    
    public void recuperar(int idFrentista){
        instance.recuperar(idFrentista);
    }
    
    public List<Frentista> recuperarTodos(){
        return instance.recuperarTodos();
    }
}

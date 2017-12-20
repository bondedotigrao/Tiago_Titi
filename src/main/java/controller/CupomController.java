
package controller;

import java.util.List;
import model.Cupom;
import model.implementacoes.CupomHibernate;


public class CupomController {
    
    private CupomHibernate instance ;
 
    public CupomController() {
        this.instance = CupomHibernate.getinstanceCupomH();
    }
    
    
    
    public void inserir(Cupom cupom){
        instance.criar(cupom);
    }
    
    public void deletar(Cupom cupom){
        instance.deletar(cupom);
    }
    
    public Cupom recuperar(int id){
      return  instance.recuperar(id);
    }
    
    public List<Cupom>recuperarTodos(){
        return instance.recuperarTodos();
    }
}

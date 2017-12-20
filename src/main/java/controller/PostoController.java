package controller;

import java.util.List;
import model.Posto;
import model.implementacoes.PostoHibernate;

public class PostoController {
    private static PostoHibernate instance;

    public PostoController() {
        this.instance = PostoHibernate.getinstancePostoP();
    }
    
    public void inserir(Posto posto){
        instance.criar(posto);
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
}

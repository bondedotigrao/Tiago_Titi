package model.interfaces;

import java.util.List;

public interface InterfaceDAO <T> {
    
    public void criar(T t);
    public void deletar(T t);
    public void alterar(T t);
    public T recuperar(int codigo);
    public List<T> recuperarTodos();
}

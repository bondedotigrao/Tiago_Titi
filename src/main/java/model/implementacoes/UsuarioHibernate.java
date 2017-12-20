
package model.implementacoes;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import model.interfaces.UsuarioDAO;

public class UsuarioHibernate implements UsuarioDAO{
    private final SessionFactory session;
    private static UsuarioHibernate instanceUsuarioU = null;
    
    public static UsuarioHibernate getinstanceUsuario(){
         if(instanceUsuarioU == null){
           instanceUsuarioU = new UsuarioHibernate();
       }
         return instanceUsuarioU;
    }
    
    private UsuarioHibernate(){
      Configuration cfg = new Configuration().configure();
        this.session = cfg.buildSessionFactory();  
    }

    @Override
    public boolean logar(String login, String senha) {
       
        List<Usuario> usuarios = recuperarTodos();
        
        for(Usuario usuario : usuarios){
            if(usuario.getLogin().equals(login)
                    && usuario.getSenha().equals(senha)){
                return true;
            }  
        }
       return false;
    }

    @Override
    public void criar(Usuario usuario) {
        Session session = this.session.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.persist(usuario);
            t.commit();
        }catch (Exception e){
            t.rollback();
        }finally{
            session.close();
        }
        
    }

    @Override
    public void deletar(Usuario usuario) {
       Session session = this.session.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(usuario);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }    
    }
        
    @Override
    public void alterar(Usuario usuario) {
Session session = this.session.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(usuario);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }     }

    @Override
    public Usuario recuperar(int codigo) {
        Session session = this.session.openSession();
        
        try{
            
            return (Usuario)session.getSession().createQuery("From Usuario Where id_usuario=" + codigo).getResultList().get(0);
        }finally{
            session.close();
        }
    }

    @Override
    public List<Usuario> recuperarTodos() {
         Session session = this.session.openSession();
       
        List<Usuario> listaUsuario = new ArrayList();
        
        try{
            listaUsuario = session.createQuery("FROM Usuario").list();
        }catch(Exception e){
            System.out.println("deu merda");
        }finally{
            session.close();
        }
        
        return listaUsuario;
    }
    
}

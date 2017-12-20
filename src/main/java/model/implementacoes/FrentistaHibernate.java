
package model.implementacoes;

import java.util.ArrayList;
import java.util.List;
import model.Frentista;
import model.interfaces.FrentistaDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class FrentistaHibernate implements FrentistaDAO{
    private final SessionFactory sessions;
    private static FrentistaHibernate instanceFrentista = null;
    
    public static FrentistaHibernate getinstanceFrentista(){
        if(instanceFrentista == null){
            instanceFrentista = new FrentistaHibernate();
        }
        
        return instanceFrentista;
    }
    
    private  FrentistaHibernate(){
         Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }
    
    @Override
    public void criar(Frentista frentista) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(frentista);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }
    public void deletar(Frentista frentista) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(frentista);
            t.commit();
        } catch (Exception e){
            t.rollback();

        } finally {
            session.close();
        }    
    }
    

    @Override
    public void alterar(Frentista frentista) {
  Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();
        
        try{
            session.update(frentista);
            t.commit();
        } catch(Exception e){
            t.rollback();
        } finally{
            session.close();
        }
    }

    @Override
    public Frentista recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try{
            return (Frentista) session.getSession().createQuery("From Frentista Where id_frentista=" + codigo).getResultList().get(0);
        }finally{
            //fechamos a sessão
            session.close();
        }
            
    }
    @Override
    public List<Frentista> recuperarTodos() {
        Session session = this.sessions.openSession();
        
        List<Frentista> listaFrentista = new ArrayList();
    
            try{
                
            listaFrentista = session.createQuery("FROM Frentista").list();
            
            }catch(Exception e){
                System.out.println("Está Errado");
            }
            
            finally{
                session.close();
            }
            
            return listaFrentista;
        
    }


}
        


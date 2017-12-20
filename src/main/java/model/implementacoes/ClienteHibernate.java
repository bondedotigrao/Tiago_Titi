package model.implementacoes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import model.Cliente;

import model.interfaces.ClienteDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClienteHibernate implements ClienteDAO {

    private EntityManager entitiyManager;
    private SessionFactory sessions;
    private static ClienteHibernate instanceClienteH = null;

    public static ClienteHibernate getinstanceClienteH() {
        if (instanceClienteH == null) {
            instanceClienteH = new ClienteHibernate();
        }

        return instanceClienteH;

    }

    private ClienteHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();

    }

    @Override
    public void criar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(cliente);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Cliente recuperar(int codigo) {
        Session session = this.sessions.openSession();
        try {

            return (Cliente) session.getSession().createQuery("From Cliente Where id_cliente=" + codigo).getResultList().get(0);

        } catch (Exception e) {
            System.out.println("Error");

        } finally {
            //Fechamos a sessão
            session.close();

        }
        return null;

    }

    @Override
    public List<Cliente> recuperarTodos() {
        Session session = this.sessions.openSession();

        List<Cliente> listaCliente = new ArrayList();

        try {

            listaCliente = session.createQuery("FROM Cliente").list();
        } catch (Exception e) {
            System.out.println("deu merda");
        } finally {
            session.close();
        }

        return listaCliente;
    }

    @Override
    public boolean logar(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package model.implementacoes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import model.Posto;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import model.interfaces.PostoDAO;
import org.hibernate.cfg.Configuration;

public class PostoHibernate implements PostoDAO {

    private final SessionFactory sessions;
    private static PostoHibernate instancePostoP = null;

    public static PostoHibernate getinstancePostoP() {
        if (instancePostoP == null) {
            instancePostoP = new PostoHibernate();
        }

        return instancePostoP;
    }

    private PostoHibernate() {
        Configuration cfg = new Configuration().configure();
        this.sessions = cfg.buildSessionFactory();
    }

    @Override
    public void criar(Posto posto) {
        Session session = this.sessions.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.persist(posto);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Posto posto) {
        Session session = this.sessions.openSession();
        Transaction p = session.beginTransaction();

        try {
            session.delete(posto);
            p.commit();
        } catch (Exception e) {
            p.rollback();
        } finally {
            session.close();

        }
    }

    @Override
    public void alterar(Posto posto) {
        Session session = this.sessions.openSession();
        Transaction p = session.beginTransaction();

        try {
            session.update(posto);
            p.commit();
        } catch (Exception e) {
            p.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Posto recuperar(int codigo) {
        Session session = this.sessions.openSession();

        try {

            return (Posto) session.getSession().createQuery("From Posto Where id_posto=" + codigo).getResultList().get(0);
        }  finally {
            session.close();
        }

    }

    @Override
    public List<Posto> recuperarTodos() {
        Session session = this.sessions.openSession();

        List<Posto> listaPosto = new ArrayList();

        try {

            listaPosto = session.createQuery("From Posto").list();
        } catch (Exception e) {
            System.out.print("esta errado");
        } finally {
            session.close();
        }
        return null;
    }

}

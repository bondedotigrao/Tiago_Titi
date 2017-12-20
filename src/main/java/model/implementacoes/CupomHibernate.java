package model.implementacoes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import model.Cupom;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.interfaces.CupomDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CupomHibernate implements CupomDAO {

    private EntityManager entitiyManager;
    private SessionFactory session;
    private static CupomHibernate instanceCupomH = null;

    public static CupomHibernate getinstanceCupomH() {
        if (instanceCupomH == null) {
            instanceCupomH = new CupomHibernate();
        }

        return instanceCupomH;
    }

    private CupomHibernate() {
        Configuration cfg = new Configuration().configure();
        this.session = cfg.buildSessionFactory();

    }

    @Override
    public void criar(Cupom cupom) {
        Session secao = session.openSession();
        Transaction t = secao.beginTransaction();

        try {
            secao.persist(cupom);
            t.commit();
        } catch (Exception criaCupomError) {
            System.out.println("Ocorreu um erro ao adicionar um cupom"
                    + "\n" + criaCupomError.getCause());
            t.rollback();
        } finally {
            secao.close();
        }
    }

    @Override
    public void deletar(Cupom cupom) {
        Session session = this.session.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.delete(cupom);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Cupom cupom) {
        Session session = this.session.openSession();
        Transaction t = session.beginTransaction();

        try {
            session.update(cupom);
            t.commit();
        } catch (Exception e) {
            t.rollback();

        } finally {
            session.close();
        }
    }

    @Override
    public Cupom recuperar(int codigo) {
        Session session = this.session.openSession();

        try {

            return (Cupom) session.getSession().createQuery("From Cupom Where id_cupom=" + codigo).getResultList().get(0);
        } finally {
            session.close();
        }
    }

    @Override
    public List<Cupom> recuperarTodos() {
        Session session = this.session.openSession();

        List<Cupom> listaCupom = new ArrayList();

        try {
            listaCupom = session.createQuery("FROM Cupom").list();
        } catch (Exception e) {
            System.out.println("deu merda");
        } finally {
            session.close();
        }

        return listaCupom;
    }
}

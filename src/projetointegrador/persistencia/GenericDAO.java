package projetointegrador.persistencia;



import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import projetointegrador.HibernateUtil;

/**
 *
 * @author Felipe Ferreira
 */

public class GenericDAO<T> {

    private final Session session = (Session) HibernateUtil.getSessionFactory().openSession();


    public Boolean inserir(T obj) {
        try {
            session.beginTransaction();
            session.persist(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public Boolean atualizar(T obj) {
        try {
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public Boolean apagar(T obj) {
        try {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }


    public List<T> consultar(T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        return c.list();
    }


    public T consultar(String campo, Long valor, T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        c.add(Restrictions.eq(campo, valor));
        if (c.list() == null) {
            return null;
        } else {
            return (T) c.uniqueResult();
        }
    }


    public T consultar(String campo1, String valor1, String campo2, String valor2, T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        c.add(Restrictions.eq(campo1, valor1));
        c.add(Restrictions.eq(campo2, valor2));
        if (c.list() == null) {
            return null;
        } else {
            return (T) c.uniqueResult();
        }
    }

 
    public T consultar(String campo, T obj) {
        Criteria c = session.createCriteria(obj.getClass());
        c.addOrder(Order.desc(campo));
        c.setMaxResults(1);
        session.close();
        if (c.list() == null) {
            return null;
        } else {
            return (T) c.uniqueResult();
        }
    }
}



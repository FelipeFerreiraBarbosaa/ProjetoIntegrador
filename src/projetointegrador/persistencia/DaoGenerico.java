
package projetointegrador.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projetointegrador.HibernateUtil;

public class DaoGenerico <T> {
    
    public List<T> read (Object T, String sql) {
        
        //Método que retorna todos os objetos de uma tabela
        
        List<T> resultado = new ArrayList();

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }
        
        return resultado;
        
    }
    
    public void create (Object T) {
        
        //Método para inserir um objeto no banco de dados
        
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            sessao.save(T);
            transacao.commit();
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
    public void delete(Object T, String sql) {
        
        //Método para deletar um objeto -- sql exemplo: FROM Emprego WHERE id = " + id
        
        List<T> resultado = null;
        Session sessao = null;
        
        try {            
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            
            for (Object obj : resultado) {
                T emp = (T) obj;
                sessao.delete(emp);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro excluído com sucesso!");
            }
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }
    }
}


package projetointegrador.persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projetointegrador.HibernateUtil;

// Essa classe é o unico DAO necessário, com todos os métodos utilizando Hibernate para se comunicar com o BD
// Autor: Enzo

public class DaoGenerico <T> {
    
    public List<T> read (Object T, String sql) {
        
        //Método que retorna todos os objetos de uma tabela em uma Lista.
        
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
    
    public void edit(Object T, String sql) {
        
        //Classe usada para editar um objeto
        //Exemplo de sql: FROM Usuario WHERE id = 1
        
        List resultado = null;
        Session sessao = null;
        try {
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction transacao = sessao.beginTransaction();
            org.hibernate.Query query = sessao.createQuery(sql);
            resultado = query.list();
            
            for (Object obj : resultado) {
                T emp = (T) obj;
                sessao.update(T);
                transacao.commit();
                JOptionPane.showMessageDialog(null, "Cadastro editado com sucesso!");
            }
                
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }
    }
    
    public void insert(String sql) {
        
        //Não está funcionando eu acho
        
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            org.hibernate.Query query = sessao.getNamedQuery(sql);
            System.out.println("Inserido com sucesso");
            
        } catch (HibernateException hibEx) {
            hibEx.printStackTrace();
        }
        
    }
}

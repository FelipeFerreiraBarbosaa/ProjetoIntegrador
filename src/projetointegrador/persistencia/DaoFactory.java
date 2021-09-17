
package projetointegrador.persistencia;

import projetointegrador.persistencia.ProdutoDAO;
import projetointegrador.persistencia.DataBaseException;





public class DaoFactory
{

      public static ProdutoDAO newProdutoDAO() throws DataBaseException
    {
        return new ProdutoDAO();       
    }

}


package projetointegrador;



public class DaoFactory
{

      public static ProdutoDAO newProdutoDAO() throws DataBaseException
    {
        return new ProdutoDAO();       
    }

}

package projetointegrador.persistencia;

import projetointegrador.persistencia.DataBaseConnectionManager;
import projetointegrador.persistencia.DataBaseException;
import projetointegrador.negocio.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projetointegrador.negocio.Produto;



public class ProdutoDAO 
{

    private DataBaseConnectionManager conexao;

    public ProdutoDAO() throws DataBaseException
    {
        try
        {
            conexao = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL, "Projeto", "postgres", "240297FE.");
        } catch (DataBaseException ex)
        {
            System.out.println("aqui 1" + ex.getMessage());
        }
    }

    public ArrayList<Produto> readAll() throws DataBaseException
    {
        ArrayList<Produto> x = new ArrayList();

        // criar SQL string
        String sql = "select * from produto;";

        // executar SQL
        ResultSet rs = conexao.runQuerySQL(sql);

        try
        {
            if (rs.isBeforeFirst())
            {
                while (rs.next())
                {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id"));
                    p.setName(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setpCusto(rs.getDouble("pCusto"));
                    p.setpVenda(rs.getDouble("pVenda"));
                    p.setQuantidade(rs.getInt("quantidade"));
                    
                    //int cod = rs.getInt("Id");
                    //String nome = rs.getString("Nome");
                    //String desc = rs.getString("descricao");
                    //Double PrecoCompra = rs.getDouble("pCusto");
                    //Double PrecoVenda = rs.getDouble("pVenda");
                    //int qtde = rs.getInt("quantidade");

                    //Produto p = new Produto(cod, nome,PrecoCompra, PrecoVenda, qtde, desc);
                    
                    x.add(p);
                }
            }
        } catch (SQLException ex)
        {
            throw new DataBaseException("Erro com o ResultSet");
        }
        conexao.closeConnection();
        return x;
    }
    public void entradaEstoque (int Codigo, int Qtde) throws DataBaseException{
        String sql ="update produto set quantidade=qtdeEstoque+'"+Qtde+"' where Id="+Codigo+";";
        conexao.runSQL(sql);
    }
    public void saidaEstoque (int Codigo, int Qtde) throws DataBaseException{
        String sql ="update produto set quantidade=quantidade-'"+Qtde+"' where Id="+Codigo+";";
        conexao.runSQL(sql);
    }
    public Produto recuperar(int codigo) throws Exception {
        String sql = "select * from produto where Codigo="+codigo+";";
        ResultSet rs = conexao.executeQuerySQL(sql);

        Produto produto = new Produto();
        if (rs.next()) {
            produto.setId(rs.getInt("Id"));
            produto.setName(rs.getString("Nome"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setpCusto(rs.getDouble("pCusto"));
            produto.setpVenda(rs.getDouble("pVenda"));
            produto.setQuantidade(rs.getInt("quantidade"));
        }

        return produto;
    }
    public void delete( Produto produto ) throws DataBaseException
    {
        if (produto != null)
        {
            // criar SQL string
            String sql = "delete from produto where id="+produto.getId()+";";
                
            conexao.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Produto nulo");
        }
    }
    public void edit( Produto produto ) throws DataBaseException
    {
        if (produto != null)
        {
            // criar SQL string
            String sql = "update produto set nome='"+produto.getName()+"', descricao='"+produto.getDescricao()+"', pCusto='"+produto.getpCusto()+"', pVenda='"+produto.getpVenda()+"', quantidade='"+produto.getQuantidade()+"' where id="+produto.getId()+";";

            conexao.runSQL(sql);
        }
        else
        {
            throw new DataBaseException("Produto nulo");
        }
    }

}
